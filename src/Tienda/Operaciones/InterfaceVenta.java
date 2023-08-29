package Tienda.Operaciones;

import java.util.Map;

import models.Producto;

public interface InterfaceVenta {

    public void verVenta();

    public void verDetalleDeLaVenta();

    public void verProductos();

    public void agregarUnProductoALaVenta(Producto p1, Map<String, Producto> inventario, Float descuento);

    public void agregarProducto_A_Productos(Producto producto);

    public Producto buscarProductoEnInventario(Producto p1, Map<String, Producto> inventario);

    public Float agregarDescuento(Producto p1, Float descuento); // retorna 0 si no hay descuento

}
