package Tienda.Operaciones;

import java.util.Map;

import models.Producto;

public interface InterfaceVenta {

    public void verVenta();

    public void verDetalleDeLaVenta();

    public void verProductos();

    public void agregarUnProductoALaVenta(Producto p1, Map<String, Producto> inventario);

    public void agregarProducto_A_Productos(Producto producto);

    public Producto buscarProductoEnInventario(Producto p1, Map<String, Producto> inventario);

}
