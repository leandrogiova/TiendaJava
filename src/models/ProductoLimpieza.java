package models;

public class ProductoLimpieza extends Producto {
    private String TipoDeAplicacion;

    public String getTipoDeAplicacion() {
        return TipoDeAplicacion;
    }

    public void setTipoDeAplicacion(String tipoDeAplicacion) {
        TipoDeAplicacion = tipoDeAplicacion;
    }

    public ProductoLimpieza(String identificador, String descripcion, Float precio, Float costoPorUnidad,
            Integer cantidad, String tipoDeAplicacion) {
        super(identificador, descripcion, precio, costoPorUnidad, cantidad);
        TipoDeAplicacion = tipoDeAplicacion;
    }

}
