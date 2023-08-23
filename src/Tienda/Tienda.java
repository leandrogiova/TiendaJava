package Tienda;

import java.util.Map;

import models.Producto;

public class Tienda {

    private String nombre;
    private Long cantidad;
    private Double saldoEnCaja;

    private Map<String, Producto> inventario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSaldoEnCaja() {
        return saldoEnCaja;
    }

    public void setSaldoEnCaja(Double saldoEnCaja) {
        this.saldoEnCaja = saldoEnCaja;
    }

    public Map<String, Producto> getInventario() {
        return inventario;
    }

    public void setInventario(Map<String, Producto> inventario) {
        this.inventario = inventario;
    }

    public Tienda(String nombre, Long cantidad, Double saldoEnCaja, Map<String, Producto> inventario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.saldoEnCaja = saldoEnCaja;
        this.inventario = inventario;
    }

}
