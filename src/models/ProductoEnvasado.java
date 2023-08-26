package models;

import java.sql.Date;

import funcionesProductos.FuncionesDescuento;
import funcionesProductos.InterfaceFuncionesProductos;

public class ProductoEnvasado extends Producto implements InterfaceFuncionesProductos, FuncionesDescuento {

    public static String NOMBRE_CATEGORIA_ENVASADO = "AB";
    public static String[] TIPO_DE_ENVASE = { "PLASTICO", "VIDRIO", "LATA", };
    public static Float PORCENTAJE_MAXIMO_DE_ENVASADO = 20.0f;

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
    public Float getDescuento() {
        return null;
    }

    @Override
    public void setDescuento(Integer descuento) {

    }

    @Override
    public void verProduto(Producto p) {
        ProductoEnvasado productoEnvasado = (ProductoEnvasado) p;

        System.out.println("\nViendo producto\n"
                + "id: " + productoEnvasado.getIdentificadorAbstracto()
                + ",   " + productoEnvasado.getDescripcion()
                + ",  precio: " + productoEnvasado.getPrecio()
                + ",  costoPorUnidad: " + productoEnvasado.getCostoPorUnidad()
                + ", cant: " + productoEnvasado.getCantidad()
                + ",  tipoEn: " + productoEnvasado.getTipoEnvase()
                + ", importado: " + productoEnvasado.getImportado()
                + ", fecha: " + productoEnvasado.getFechaVencimiento()
                + ",  descuentoEn%: " + productoEnvasado.getDescuento()

        );

    }

    @Override
    public void setearGanacia(Float precioProducto, Float porcentaje) {
        if (porcentaje < PORCENTAJE_MAXIMO_DE_ENVASADO) {

            Float porcent = precioProducto * (porcentaje / 100);// Calcula la ganancia en base al porcentaje
            Float gananc = porcent + precioProducto;
            setPrecio(gananc); // Suma la ganancia al precio original
            System.out.println("precio con ganancia: " + getPrecio());
            if (getImportado()) {
                porcentaje = 10f;
            }

        } else {
            System.out.println("El porcentaje de ganacia no puede ser mayor a " + PORCENTAJE_MAXIMO_DE_ENVASADO);
        }
    }

}