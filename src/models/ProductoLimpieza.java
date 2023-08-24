package models;

import funcionesProductos.FuncionesDescuento;

public class ProductoLimpieza extends Producto implements FuncionesDescuento {

    public static String NOMBRE_CATEGORIA_LIMPIEZA = "AZ";
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
    public Integer getDescuento() {
        return null;
    }

    @Override
    public void setDescuento(Integer descuento) {

    }

}
