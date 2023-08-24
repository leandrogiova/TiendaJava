package models;

import java.sql.Date;

import funcionesProductos.FuncionesDescuento;
import funcionesProductos.FuncionesProductos;

public class ProductoEnvasado extends Producto implements FuncionesProductos, FuncionesDescuento {

    public static String NOMBRE_CATEGORIA_ENVASADO = "AB";
    public static String[] TIPO_DE_ENVASE = { "PLASTICO", "VIDRIO", "LATA", };

    private String tipoEnvase;
    private Boolean importado;
    private Date fechaVencimiento;
    private Integer calorias;

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }

    /*
     * Constructor ProductoEnvasado setea los campos correspondientes
     * Setea el campo identificador de la clase Heredada Producto con el nombre de
     * la categoria "AB" y con el numero de producto
     * Ademas setea el tipo de envase a String
     * Para setear el tipo de envase se recibe un Byte que corresponde al tipo de
     * envase
     * Si es 0 ==> PLASTICO
     * 1 ==> VIDRIO
     * 2 ==> LATA
     * Los nombre "PLASTICO", VIDRIO, LATA se almacenan en una
     * constante "TIPO_DE_ENVASE"
     * Y el campo importado que es un True si el producto es importado
     * O False si el producto NO es importado
     * Recibe como parametros Integer, String, Float, Float, Integer, String,
     * Boolean
     * No retorna ningun tipo
     */
    public ProductoEnvasado(Integer numero, String descripcion,
            Float precio, Float costoPorUnidad, Integer cantidad, byte tipoEnvaseNum, Boolean importado,
            Date fechaVencimiento, Integer calorias) {

        super(numero, descripcion, precio, costoPorUnidad, cantidad);
        this.importado = importado;
        this.tipoEnvase = TIPO_DE_ENVASE[tipoEnvaseNum];
        this.fechaVencimiento = fechaVencimiento;
        this.calorias = calorias;

        setIdentificadorAbstracto(NOMBRE_CATEGORIA_ENVASADO, numero);

    }

    @Override
    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    @Override
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public Integer getCalorias() {
        return this.calorias;
    }

    @Override
    public void setCalorias(Integer calorias) {
        this.calorias = calorias;

    }

    @Override
    public Integer getDescuento() {
        return null;
    }

    @Override
    public void setDescuento(Integer descuento) {

    }

}