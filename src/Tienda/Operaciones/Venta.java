package Tienda.Operaciones;

import java.sql.Date;
import java.util.Map;

import models.Producto;
import models.ProductoBebida;
import models.ProductoEnvasado;
import models.ProductoLimpieza;

public class Venta implements InterfaceVenta {

    public static int CANTIDAD_PRODUCTOS_A_VENDER = 3;
    public static int CANTIDAD_DE_PRODUCTOS_EL_MISMO_TIPO = 10;

    private Long id;
    private Producto[] productos = new Producto[CANTIDAD_PRODUCTOS_A_VENDER];
    private Date fecha;
    private Float precio;

    public Venta(Long id, Producto[] productos, Date fecha) {
        this.id = id;
        this.productos = productos;
        this.fecha = fecha;

    }

    public Venta() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /*
     * 
     * El producto estara habilitado a la venta si el proudto que esta almacenado en
     * this.inventario posee alguna cantidad.
     * Si la cantidad de dicho producto esta en 0, el producto no esta a la venta
     */
    public void realizarVenta(Producto[] productos, Map<String, Producto> inventario) {

        // reviso que el producto este en el inventaio
        // if (this.productoVenderInventario(productos[0], inventario)) { }
    }

    /*
     * 
     * 
     * Esta funcion seria esta lleno
     */
    public Boolean productosIsEmpty() {
        for (int i = 0; i < CANTIDAD_PRODUCTOS_A_VENDER; i++) {
            if (this.productos[i] == null) {
                if (i == CANTIDAD_PRODUCTOS_A_VENDER) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /*
     * Agrega un producto que se quiere vender
     */
    public void agregarUnProductoALaVenta(Producto productoAVender, Map<String, Producto> inventario) {

        if (productosIsEmpty()) {
            System.out.println("No se puede comprar mas productos");
        } else {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa se puede comprar mas productos");
            for (int i = 0; i < CANTIDAD_PRODUCTOS_A_VENDER; i++) {
                if (productos[i] == null) {
                    System.out.println("bbbbbbbbbbbbbbbbbbbb --- i : " + i);
                    productoAVender = productoVenderInventario(productoAVender, inventario);
                    System.out.println("productoAVender.getDescripcion():" + productoAVender.getDescripcion());
                    this.productos[i] = productoAVender;
                    this.precio += (this.productos[i].getPrecio() * (int) this.productos[i].getCantidad());

                    verVenta();

                }
            }

        }

        // TODO VER
        /*
         * 
         * 
         * 
         * if (productoIsLimpieza(productoAVender)) {
         * ProductoLimpieza productoL = (ProductoLimpieza) productoAVender;
         * }
         * 
         * if (productoIsBebida(productoAVender)) {
         * ProductoBebida productoB = (ProductoBebida) productoAVender;
         * }
         * if (productoIsEnvasado(productoAVender)) {
         * ProductoEnvasado productoB = (ProductoEnvasado) productoAVender;
         * }
         */
    }

    /*
     * funcion productoIsBebida recibe un producto y retorna true si es un tipo
     * bebida
     * Hace eso revisando si los dos primeros campos del identificador del producto
     * son AC que representan a los productosBebidas
     * Recibe como parametro un producto
     * Retorna true si es un productoBebida
     */
    public Boolean productoIsBebida(Producto producto) {
        String clave = producto.getIdentificadorAbstracto();

        char[] chars = clave.toCharArray();
        if (chars[0] == 'A' && chars[1] == 'C') {
            return true;
        } else
            return false;
    }

    /*
     * funcion productoIsBebida recibe un producto y retorna true si es un tipo
     * Limpieza
     * Hace eso revisando si los dos primeros campos del identificador del producto
     * son AZ que representan a los productosLimpieza
     * Recibe como parametro un producto
     * Retorna true si es un productoLimpieza
     */
    public Boolean productoIsLimpieza(Producto producto) {
        String clave = producto.getIdentificadorAbstracto();

        char[] chars = clave.toCharArray();
        if (chars[0] == 'A' && chars[1] == 'Z') {
            return true;
        } else
            return false;
    }

    /*
     * funcion productoIsBebida recibe un producto y retorna true si es un tipo
     * Envasado
     * Hace eso revisando si los dos primeros campos del identificador del producto
     * son AB que representan a los productosLimpieza
     * Recibe como parametro un producto
     * Retorna true si es un productoEnvasado
     */
    public Boolean productoIsEnvasado(Producto producto) {
        String clave = producto.getIdentificadorAbstracto();

        char[] chars = clave.toCharArray();
        if (chars[0] == 'A' && chars[1] == 'B') {
            return true;
        } else
            return false;
    }

    /*
     * funcion productoVenderInventario
     * va a revisar si un producto se encuentra en stock. Y si esta en stock va a
     * revisar si el producto tiene alguna cantidad.
     * Si el producto esta en stock pero no tiene cantidad el producto no esta a la
     * venta, ya que no hay ninguna unidad para vender.
     * Recibe como parametro el producto
     * Retorna true si el producto esta a la venta y tiene alguna cantidad de ese
     * producto
     */
    public Producto productoVenderInventario(Producto p1, Map<String, Producto> inventario) {
        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacio");
            return null;

        } else {
            for (Map.Entry<String, Producto> entry : inventario.entrySet()) {
                String clave = entry.getKey();
                Producto producto = entry.getValue();

                if (clave.equals(p1.getIdentificadorAbstracto())) {
                    System.out.println("El producto que se quiere comprar esta en el inventario");
                    // el producto esta en el inventario
                    if (p1.getCantidad() <= CANTIDAD_DE_PRODUCTOS_EL_MISMO_TIPO) {

                        if (producto.getCantidad() == 0) {
                            System.out.println("El Producto " + p1.getIdentificadorAbstracto() + p1.getDescripcion()
                                    + "no se encuentra disponible");
                            return null;
                        } else {
                            if (p1.getCantidad() <= producto.getCantidad()) {
                                System.out.println("se puede vender");
                                return p1;
                            } else {

                                System.out.println("Hay productos con stock disponible menor al solicitado");

                                p1.setCantidad(producto.getCantidad());
                                return p1;
                            }
                        }
                    } else {
                        System.out.println(
                                "\n\nERROR! La tienda puede vender hasta " + CANTIDAD_DE_PRODUCTOS_EL_MISMO_TIPO
                                        + " productos del mismo tipo\n\n");
                        return null;
                    }

                }
            }
        }
        return p1;
    }

    /*
     * 
     */
    public void verVenta() {
        System.out.println("Viendo venta... "
                + "id: " + this.id + "fecha: " + this.fecha
                + "precio: " + this.precio);
        for (int i = 0; i < CANTIDAD_PRODUCTOS_A_VENDER; i++) {
            if (this.productos[i] != null) {
                System.out.println("\nProductos: "
                        + "identificador: " + this.productos[i].getIdentificadorAbstracto()
                        + ", descripcion: " + this.productos[i].getDescripcion()
                        + ", precio: " + this.productos[i].getPrecio()
                        + ", costopor unidad:" + this.productos[i].getCostoPorUnidad()
                        + ", cantidad:  " + this.productos[i].getCantidad());
            }
        }
    }

}