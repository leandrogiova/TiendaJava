package Tienda.Operaciones;

import java.util.ArrayList;

import models.Producto;
import models.ProductoEnvasado;

public interface InterfaceTienda {

    public void verInventario();

    public void comprarProducto(Producto producto);

    public void verTienda();

    public void realizarVenta(Producto producto, Float Descuento);

    public void cerrarVenta();

    public void actualizarInventarioConProductoVendido(Producto[] productosVenta);

    public Producto encontrarProducto(String identificador);

    public ArrayList<String> obtenerComestiblesConMenorDescuento(Float porcentajeDescuento);

    public ArrayList<Producto> listarProductosConUtilidadesInferiores(Float porcentaje_utilidad);
}
