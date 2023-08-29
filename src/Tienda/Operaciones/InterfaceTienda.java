package Tienda.Operaciones;

import models.Producto;

public interface InterfaceTienda {

    public void verInventario();

    public void comprarProducto(Producto producto);

    public void verTienda();

    public void realizarVenta(Producto producto);

    public void cerrarVenta(Venta venta);

    public void actualizarInventarioConProductoVendido(Producto[] productosVenta);

    public Producto encontrarProducto(String identificador);
}
