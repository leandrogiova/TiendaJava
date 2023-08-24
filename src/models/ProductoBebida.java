package models;

import java.sql.Date;

import funcionesProductos.FuncionesDescuento;
import funcionesProductos.FuncionesProductos;

public class ProductoBebida extends Producto implements FuncionesProductos, FuncionesDescuento {

    public static String NOMBRE_CATEGORIA_BEBIDA = "AC";

    private Boolean alcoholica;
    private Float porcentajeDeAlcohol;
    private Boolean importado;
    private Date fechaVencimiento;
    private Integer calorias;

    /*
     * Constructor ProductoBebida setea los campos correspondientes
     * Setea el campo identificador de la clase Heredada Producto con el nombre de
     * la categoria "AC" y con el numero de producto
     * Ademas setea el tipo de bebida Alcoholica en True si la bebida es alcoholica
     * O False si la bebida NO contiene alcohol. Y su graduacion Alcoholica en forma
     * de porcentaje con el tipo "Float"
     * Y el campo importado que es un True si el producto es importado
     * O False si el producto NO es importado
     * Recibe como parametros Integer, String, Float, Float, Integer, Boolean,
     * Boolean, Float, Boolean
     * No retorna ningun tipo
     */
    public ProductoBebida(Integer numero, String descripcion,
            Float precio, Float costoPorUnidad, Integer cantidad, Boolean alcoholica, Float porcentajeDeAlcohol,
            Boolean importado, Date fechaVencimiento, Integer calorias) {

        super(numero, descripcion, precio, costoPorUnidad, cantidad);
        this.alcoholica = alcoholica;
        this.porcentajeDeAlcohol = porcentajeDeAlcohol;
        this.importado = importado;
        this.fechaVencimiento = fechaVencimiento;
        this.calorias = calorias;

        setIdentificadorAbstracto(NOMBRE_CATEGORIA_BEBIDA, numero);

    }

    public Boolean getAlcoholica() {
        return alcoholica;
    }

    public void setAlcoholica(Boolean alcoholica) {
        this.alcoholica = alcoholica;
    }

    public Float getPorcentajeDeAlcohol() {
        return porcentajeDeAlcohol;
    }

    public void setPorcentajeDeAlcohol(Float porcentajeDeAlcohol) {
        if (alcoholica) {
            this.porcentajeDeAlcohol = porcentajeDeAlcohol;
        } else {
            System.out.println("ERROR! Al setear el porcentaje de alcohol en el producto.\n\n");
        }
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }

    @Override
    public Date getFechaVencimiento() {
        return fechaVencimiento;
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
