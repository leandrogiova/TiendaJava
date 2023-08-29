package Tienda;

import java.util.HashMap;
import java.util.Map;

import Tienda.Operaciones.InterfaceTienda;
import Tienda.Operaciones.Venta;
import models.Producto;
import models.ProductoBebida;
import models.ProductoEnvasado;
import models.ProductoLimpieza;

public class Tienda implements InterfaceTienda {

    private String nombre;
    private Long cantidad;
    private Double saldoEnCaja;
    // private Venta[] nuevaVenta;
    private Venta nuevaVenta;

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

    public Venta getNuevaVenta() {
        return nuevaVenta;
    }

    public void setNuevaVenta(Venta nuevaVenta) {
        this.nuevaVenta = nuevaVenta;
    }

    public Map<String, Producto> getInventario() {
        return inventario;
    }

    public void setInventario(Map<String, Producto> inventario) {
        this.inventario = inventario;
    }

    /*
     * Constructor Tienda
     * Construye un objeto de la clase tienda
     * Primero se debera instanciar un objeto del tipo HasMap para almacenar el
     * inventario
     * No recibe parametros
     * No retorna ningun tipo
     */
    public Tienda(String nombre, Long cantidad, Double saldoEnCaja, Map<String, Producto> inventario) {
        this.inventario = new HashMap<>();
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.saldoEnCaja = saldoEnCaja;
        this.inventario = inventario;
    }

    public Tienda() {
        this.inventario = new HashMap<>();
    }

    /*
     * funcion verInventario
     * Recorre el Map de Producto que es "Map<String, Producto> inventario;"
     * Va a recorrer el inventario de la clase, es decir, "this.inventario"
     * Mostrando cada campo del producto
     * No recibe argumentos
     * No retorna ningun tipo
     */
    public void verInventario() {
        System.out.println("Viendo inventario...");
        for (Map.Entry<String, Producto> entry : this.inventario.entrySet()) {
            String clave = entry.getKey();
            Producto producto = entry.getValue();

            System.out.println("\n\n--->" +
                    producto.getIdentificadorAbstracto() + "  "
                    + producto.getDescripcion() + "  "
                    + ",  precio: " + producto.getPrecio()
                    + ",  cant: " + producto.getCantidad());

            char[] chars = clave.toCharArray();
            if (chars[0] == 'A' && chars[1] == 'B') {
                ProductoEnvasado a = (ProductoEnvasado) producto;
                System.out.print("T.Env:" + a.getTipoEnvase()
                        + ",  importado: " + a.getImportado()
                        + ",  fecVenc: " + a.getFechaVencimiento()
                        + ",  cal: " + a.getCalorias());
            }
            if (chars[0] == 'A' && chars[1] == 'C') {
                ProductoBebida a = (ProductoBebida) producto;
                System.out.print("Alcoholica:" + a.getAlcoholica()
                        + ", %Alcohol: " + a.getPorcentajeDeAlcohol()
                        + ",  importado: " + a.getImportado()
                        + ",  fecVenc:" + a.getFechaVencimiento()
                        + ",  cal: " + a.getCalorias());
            }
            if (chars[0] == 'A' && chars[1] == 'Z') {
                ProductoLimpieza a = (ProductoLimpieza) producto;
                System.out.println("TipoDeAplicacion: " + a.getTipoDeAplicacion());
            }
        }
    }

    /*
     * Funcion maximoStock setea la cantidad de productosMaximo que puede
     * haber en Stock.
     * Setea la variable "this.cantidad"
     * No recibe argumentos
     * Retorna un Long con la cantidad de productos que tengo en stock al momento de
     * llamar a la funcion
     */
    public Long cantidadProductosStock() {
        Long cantQueTengoEnStock = 0l;
        for (Map.Entry<String, Producto> entry : this.inventario.entrySet()) {
            Producto producto = entry.getValue();
            cantQueTengoEnStock += producto.getCantidad();
        }
        return cantQueTengoEnStock;
    }

    /*
     * funcion comprarProducto
     * Se agraga un producto a la tienda, con todos los campos que tiene un producto
     * El producto puede ser "productoEnvasado", "ProductoBebida",
     * "ProductoLimpieza". Se va a restar el precio del producto * cantidad al
     * precio "saldoEnCaja" de
     * la tienda
     * Si el saldo alcanza, se agregaran los productos al inventario.
     * Ademas la tienda tiene una cantidad de productos maxima que es el campo
     * "this.cantidad"
     * Si esta cantidad es menor a los productos que se quieren comprar se podra
     * agregar al inventario
     * Al final, se agregaran los productos al inventario.
     * No recibe argumentos
     * No retorna ningun tipo
     */
    public void comprarProducto(Producto producto) {

        Float valor = producto.getCantidad() * producto.getCostoPorUnidad();
        Long cantidadQueTengoEnStock = cantidadProductosStock();

        Long cantidadTotal = ((this.cantidad - cantidadQueTengoEnStock) - producto.getCantidad());

        if (cantidadTotal >= 0) {

            if (this.saldoEnCaja < valor) { // precio
                System.out.println("El producto no podra ser agregado a la tienda por saldo insuficiente en la caja");

                System.out.println("El saldo en la caja es de: " + this.saldoEnCaja
                        + "  El valor de la compra de productos es de: " + valor);

            } else {

                this.inventario.put(producto.getIdentificadorAbstracto(), producto);
                this.saldoEnCaja = this.saldoEnCaja - (producto.getCantidad() * producto.getCostoPorUnidad());

                System.out.println("La compra se realizo con exito, el producto se cargo al invenario\n"
                        + "El saldo de la caja actual es de " + this.saldoEnCaja);
            }

        } else {
            System.out.println("Se alcanzo el numero maximo de stock de la tienda\n");
        }

    }

    /*
     * Funcion para mostar todos los campos de la tienda
     */
    public void verTienda() {

        System.out.println("\n viendo la tienda...");
        System.out.println("nombre: " + this.nombre + ",   cantidad: " + this.cantidad + ",  saldoEnCaja: "
                + this.saldoEnCaja + "\n");

        verInventario();
    }

    /*
     * Realiza una venta, agregando un producto a la lista de productos de una venta
     * Recibe como parametro
     */
    public void realizarVenta(Producto producto) {
        this.nuevaVenta.setId(1l);

        nuevaVenta.agregarUnProductoALaVenta(producto, getInventario());
        actualizarInventarioConProductoVendido(nuevaVenta.getProductos());
    }

    /*
     * 
     */
    public void cerrarVenta(Venta venta) {
        this.saldoEnCaja = this.saldoEnCaja + venta.getPrecio();

        actualizarInventarioConProductoVendido(venta.getProductos());

        verInventario();
        venta.verVenta();

    }

    /*
     * 
     */
    public void actualizarInventarioConProductoVendido(Producto[] productosVenta) {

        for (Map.Entry<String, Producto> entry : this.inventario.entrySet()) {
            String clave = entry.getKey();
            Producto producto = entry.getValue();

            for (int i = 0; i < productosVenta.length; i++) {

                if (productosVenta[i] != null) {
                    if (productosVenta[i].getIdentificadorAbstracto().equals(clave)) {

                        int cantidad = entry.getValue().getCantidad();
                        cantidad = cantidad - productosVenta[i].getCantidad();
                        entry.getValue().setCantidad(cantidad);
                        System.out.println("\n-123-Productos de la venta: " + entry.getValue().getCantidad());
                    }
                }

            }

        }

    }

    /*
     * recibe un identificador de producto
     * Y retorna el producto almacenado en el identificador
     */
    public Producto encontrarProducto(String identificador) {

        for (Map.Entry<String, Producto> entry : this.inventario.entrySet()) {
            String clave = entry.getKey();
            Producto producto = entry.getValue();

            if (clave.equals(identificador)) {
                return producto;
            }
        }
        return null;
    }

}
