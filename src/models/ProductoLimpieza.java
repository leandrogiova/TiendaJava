package models;

import java.sql.Date;

import funcionesProductos.FuncionesDescuento;
import funcionesProductos.InterfaceFuncionesProductos;

public class ProductoLimpieza extends Producto implements FuncionesDescuento, InterfaceFuncionesProductos {

    public static String NOMBRE_CATEGORIA_LIMPIEZA = "AZ";
    public static Float PORCENTAJE_MAXIMO_DE_LIMPIEZA = 25f;
    public static Float PORCENTAJE_MINIMO_DE_LIMPIEZA = 10f;
    public static String[] TIPO_DE_APLICACION = { "COCINA", "PISOS", "ROPA", "MULTIUSO" };

    private String TipoDeAplicacion;

    /*
     * Constructor ProductoLimpieza setea los campos correspondientes
     * Setea el campo identificador de la clase Heredada Producto con el nombre de
     * la categoria "AZ" y con el numero de producto
     * Ademas setea el tipo de aplicacion a String Para setear el tipo de aplicacion
     * se recibe un Byte que corresponde al tipo de aplicacion
     * Si es 0 ==> COCINA
     * 1 ==> PISOS
     * 2 ==> ROPA
     * 3 ==> MULTIUSO
     * Los nombre "CICINA", "PISOS", "ROPA", "MULTIUSO" se almacenan en una
     * constante "TIPO_DE_APLICACION"
     * Recibe como parametros Integer, String, Float, Float, Integer, Boolean,
     * Boolean, Float, Boolean
     * No retorna ningun tipo
     */
    public ProductoLimpieza(Integer numero, String descripcion, Float precio,
            Float costoPorUnidad,
            Integer cantidad, Byte tipoDeAplicacion) {
        super(numero, descripcion, precio, costoPorUnidad, cantidad);

        this.TipoDeAplicacion = TIPO_DE_APLICACION[tipoDeAplicacion];

        setIdentificadorAbstracto(NOMBRE_CATEGORIA_LIMPIEZA, numero);
    }

    public String getTipoDeAplicacion() {
        return TipoDeAplicacion;
    }

    public void setTipoDeAplicacion(String tipoDeAplicacion) {
        TipoDeAplicacion = tipoDeAplicacion;
    }

    @Override
    public Float getDescuento() {
        return null;
    }

    @Override
    public void setDescuento(Integer descuento) {

    }

    @Override
    public Integer getCalorias() {

        return null;
    }

    @Override
    public Date getFechaVencimiento() {

        return null;
    }

    @Override
    public void setCalorias(Integer calorias) {

    }

    @Override
    public void setFechaVencimiento(Date fechaVencimiento) {

    }

    /*
     * Setea el precio de venta de un producto
     * Recibe el precio del proveedor del producto y el porcentaje de ganacia
     * Calcula el porcentaje del producto y lo setea a precio
     * Recibe un Float precio y un Float porcentaje
     * No tiene ningun retorno
     */
    @Override
    public void setearGanacia(Float precioProducto, Float porcentaje) {
        if (porcentaje < PORCENTAJE_MAXIMO_DE_LIMPIEZA) {
            if (getTipoDeAplicacion() != TIPO_DE_APLICACION[2] || getTipoDeAplicacion() != TIPO_DE_APLICACION[3]) {
                if (porcentaje > PORCENTAJE_MINIMO_DE_LIMPIEZA) {
                    setPrecio(calculoGanancias(precioProducto, porcentaje));
                } else {
                    setPrecio(calculoGanancias(precioProducto, porcentaje));
                }
            }

        } else {
            System.out.println("El porcentaje de ganacia no puede ser mayor a " + PORCENTAJE_MAXIMO_DE_LIMPIEZA);
        }
    }

    /*
     * Hace el calculo de la ganacia
     */
    public Float calculoGanancias(Float precioProducto, Float porcentaje) {
        Float porcent = precioProducto * (porcentaje / 100);// Calcula la ganancia en base al porcentaje
        Float gananc = porcent + precioProducto;// Suma la ganancia al precio original

        System.out.println("precio con ganancia: " + getPrecio());
        return gananc;
    }

    @Override
    public void verProduto(Producto p) {
        ProductoLimpieza producto = (ProductoLimpieza) p;

        System.out.println("\nViendo producto\n"
                + "id: " + producto.getIdentificadorAbstracto()
                + ",   " + producto.getDescripcion()
                + ",  precio: " + producto.getPrecio()
                + ",  costoPorUnidad: " + producto.getCostoPorUnidad()
                + ", cant: " + producto.getCantidad()
                + ", fecha: " + producto.getFechaVencimiento()
                + ",  descuentoEn%: " + producto.getDescuento()
                + ", tipo: " + producto.getTipoDeAplicacion());

    }

}
