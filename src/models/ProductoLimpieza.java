package models;

import funcionesProductos.FuncionesDescuento;

public class ProductoLimpieza extends Producto implements FuncionesDescuento {

    public final static String NOMBRE_CATEGORIA_LIMPIEZA = "AZ";

    private String TipoDeAplicacion;

    public String getTipoDeAplicacion() {
        return TipoDeAplicacion;
    }

    public void setTipoDeAplicacion(String tipoDeAplicacion) {
        TipoDeAplicacion = tipoDeAplicacion;
    }

    public ProductoLimpieza(Integer numero, String descripcion, Float precio,
            Float costoPorUnidad,
            Integer cantidad, String tipoDeAplicacion) {
        super(numero, descripcion, precio, costoPorUnidad, cantidad);
        TipoDeAplicacion = tipoDeAplicacion;

        setIdentificadorAbstracto(NOMBRE_CATEGORIA_LIMPIEZA, numero);
    }

    @Override
    public Integer getDescuento() {
        return null;
    }

    @Override
    public void setDescuento(Integer descuento) {

    }

}
