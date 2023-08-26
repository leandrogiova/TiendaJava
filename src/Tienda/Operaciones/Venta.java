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
        this.precio = 0f;

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
     * Muestra todos los campos para controlar el estado de la venta
     */
    public void verVenta() {
        System.out.println("\n\nViendo venta... "
                + "id: " + this.id + "fecha: " + this.fecha
                + "precio: " + this.precio);
        System.out.println("\nProductos: ");
        for (int i = 0; i < CANTIDAD_PRODUCTOS_A_VENDER; i++) {

            if (this.productos[i] != null) {
                System.out.println("identificador: " + this.productos[i].getIdentificadorAbstracto()
                        + ", descripcion: " + this.productos[i].getDescripcion()
                        + ", precio: " + this.productos[i].getPrecio()
                        + ", costopor unidad:" + this.productos[i].getCostoPorUnidad()
                        + ", cantidad:  " + this.productos[i].getCantidad());
            }
        }
    }

    /*
     * Muestra los campos importantes de la manera solicitada
     */
    public void verDetalleDeLaVenta() {
        System.out.println("Detalle de la venta:");
        for (int i = 0; i < CANTIDAD_PRODUCTOS_A_VENDER; i++) {

            if (this.productos[i] != null) {
                System.out.println(this.productos[i].getIdentificadorAbstracto() + " "
                        + this.productos[i].getDescripcion() + " " + this.productos[i].getCantidad()
                        + " x " + this.productos[i].getPrecio());
            }
        }
        System.out.println("\nTOTAL VENTA: " + getPrecio());
    }

    /*
     * 
     */
    public void verProductos() {
        System.out.println("\nProductos: ");
        for (int i = 0; i < CANTIDAD_PRODUCTOS_A_VENDER; i++) {

            if (this.productos[i] != null) {
                System.out.println("identificador: " + this.productos[i].getIdentificadorAbstracto()
                        + ", descripcion: " + this.productos[i].getDescripcion()
                        + ", precio: " + this.productos[i].getPrecio()
                        + ", costopor unidad:" + this.productos[i].getCostoPorUnidad()
                        + ", cantidad:  " + this.productos[i].getCantidad());
            }
        }
    }

    /*
     * Funcion agregarUnProductoALaVenta
     */
    public void agregarUnProductoALaVenta(Producto p1, Map<String, Producto> inventario) {

        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacio");
        } else {
            // valido que no se compren mas de 10 productos
            if (p1.getCantidad() <= CANTIDAD_DE_PRODUCTOS_EL_MISMO_TIPO) {
                Producto p2 = buscarProductoEnInventario(p1, inventario);
                if (p2 != null) {
                    agregarProducto_A_Productos(p2);// agega un producto a this.productos en la posicion que corresponde
                    this.precio = this.precio + (p2.getPrecio() * p2.getCantidad());
                }
            } else {
                System.out.println("No se pueden comprar mas de " + CANTIDAD_DE_PRODUCTOS_EL_MISMO_TIPO + " productos");
            }
        }

    }

    /*
     * Funcion agregarProducto_A_Productos recibe un producto y lo agrega
     * al array de productos de la venta.
     * Es decir, la clase venta tiene el campo "Producto[] productos"
     * Esta función agrega ese producto a la lista
     * Recibe como atributo un Producto
     * No tiene ningun tipo de retorno
     */
    public void agregarProducto_A_Productos(Producto producto) {
        for (int i = 0; i < CANTIDAD_PRODUCTOS_A_VENDER; i++) {
            if (getProductos()[i] == null) {
                getProductos()[i] = producto;

                break;
            }
        }

    }

    /*
     * funcion buscarProductoEnInventario
     * Recibe un producto y un inventario de tipo Map
     * va a buscar a ese producto y va a corroborar que el producto exista en el
     * inventario.
     * Que el producto den inventario NO este en 0, si esta en 0 significa que el
     * producto no se va a poder
     * vender ya que no hay stock de ese producto.
     * Y va a revisar que si se quiere comprar mas productos de los que hay en stock
     * se van a vender todos los productos
     * que haya en stock. Al tener que setear este campo de cantidad al producto que
     * se va a vender la funcion
     * retorna el producto
     * Recibe un Producto y un Map<Strin, Producto>
     * Retorna el Producto que se quiera vender
     */
    public Producto buscarProductoEnInventario(Producto p1, Map<String, Producto> inventario) {

        // valido que no quiera comprar mas de los productos que haya en stock
        for (Map.Entry<String, Producto> entry : inventario.entrySet()) {

            String clave = entry.getKey();
            Producto producto = entry.getValue();

            if (clave.equals(p1.getIdentificadorAbstracto())) {

                // encontre mi producto en el inventario
                if ((producto.getCantidad()) == 0) {

                    System.out.println("El Producto " + p1.getIdentificadorAbstracto() + p1.getDescripcion()
                            + " no se encuentra disponible");
                    return null;
                } else {
                    if ((p1.getCantidad()) < (entry.getValue().getCantidad())) {
                        System.out.println("Hay productos con stock disponible menor al solicitado");

                        p1.setCantidad(producto.getCantidad());
                        return p1;
                    } else {

                        return p1;
                    }
                }

            }
        }
        System.out.println(
                "El producto " + p1.getIdentificadorAbstracto() + p1.getDescripcion() + "no se encuentra disponible");
        return null;

    }

}