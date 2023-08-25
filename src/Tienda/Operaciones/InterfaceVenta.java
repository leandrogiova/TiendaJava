package Tienda.Operaciones;

import java.util.Map;

import models.Producto;

public interface InterfaceVenta {

    public void realizarVenta(Producto[] productos, Map<String, Producto> inventario);

}
