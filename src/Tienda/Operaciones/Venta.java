package Tienda.Operaciones;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import models.Producto;
import models.ProductoBebida;
import models.ProductoEnvasado;
import models.ProductoLimpieza;

public class Venta implements InterfaceVenta {

    public static int CANTIDAD_PRODUCTOS_A_VENDER = 3;
    public static int CANTIDAD_DE_PRODUCTOS_EL_MISMO_TIPO = 10;
    public static Float IMPUESTO_PRODUCTO_IMPORTADO = 10.0f;

    private Long id;
    private Producto[] productos = new Producto[CANTIDAD_PRODUCTOS_A_VENDER];
    private Date fecha;
    private Float precio;
    private Float porcentajeGanancia;
    private Float porcentajeDescuento;

    public Venta(Long id, Producto[] productos, Date fecha) {
        this.id = id;
        this.productos = productos;
        this.fecha = fecha;

    }

    public Venta() {
        this.precio = 0f;
        this.porcentajeDescuento = 0f;
        this.porcentajeGanancia = 0f;

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

    public Float getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(Float porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public Float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    /*
     * Funcion agregarUnProductoALaVenta
     */
    public void agregarUnProductoALaVenta(Producto p1, Map<String, Producto> inventario, Float descuento) {

        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacio");
        } else {
            // valido que no se compren mas de 10 productos
            if (p1.getCantidad() <= CANTIDAD_DE_PRODUCTOS_EL_MISMO_TIPO) {
                Producto p2 = buscarProductoEnInventario(p1, inventario);
                if (p2 == null) {
                    System.out.println("El producto no existe en el inventario");
                }
                if (p2 != null) {
                    // verifica el descuento y lo setea a Producto.setDescuento
                    agregarDescuento2(p2, descuento);
                    agregarProducto_A_Productos(p2);// agega un producto a this.productos en la posicion que corresponde

                    calcularPrecioVenta();

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
     * calcula el precio de la venta
     * Con los descuentos incluidos
     */
    public void calcularPrecioVenta() {
        this.precio = 0f;
        for (int i = 0; i < CANTIDAD_PRODUCTOS_A_VENDER; i++) {
            Producto producto = getProductos()[i];
            if (producto != null) {
                if (producto.getDescuento() != null) {

                    Float precioTemp = calcularDescuento(producto.getPrecio(), producto.getDescuento());
                    if (ProductoEnvasado.productoEsProductoEnvasado(producto)
                            && ((ProductoEnvasado) producto).getImportado()) {
                        precioTemp = precioTemp + (precioTemp * (IMPUESTO_PRODUCTO_IMPORTADO)) / 100;
                    }
                    if (ProductoBebida.productoEsProductoBebida(producto)
                            && ((ProductoBebida) producto).getImportado()) {
                        precioTemp = precioTemp + (precioTemp * (IMPUESTO_PRODUCTO_IMPORTADO)) / 100;
                    }
                    this.precio += precioTemp;
                } else {
                    this.precio += (producto.getPrecio() * producto.getCantidad());
                }
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

                    System.out.println("El Producto " + p1.getIdentificadorAbstracto() +
                            p1.getDescripcion()
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
                "El producto " + p1.getIdentificadorAbstracto() + p1.getDescripcion() +
                        "no se encuentra disponible");
        return null;
    }

    /*
     * Funcion agregarDescueto
     * Recibe un Producto y setea el descuento(this.porcentajeDescuento = descuento)
     * Dependiedo de los tipos de productos se hacen uno u otros descuentos
     * Recibe un Producto y calcula el decuento.
     * Retorna el precio CON EL DESCUENTO YA CALCULADO
     */
    public Float agregarDescuento(Producto p1, Float descuento) {

        if (ProductoEnvasado.productoEsProductoEnvasado(p1)) {
            if (descuento > ProductoEnvasado.DESCUENTO_MAXIMO_PRODT_ENVASADO) {
                Float desc = calcularDescuento(p1.getPrecio(), descuento);
                if (p1.getCostoPorUnidad() > desc) {
                    System.out.println("El descuento registrado para el producto " + p1.getIdentificadorAbstracto()
                            + " no pudo ser aplicacdo");// producto.PrecioPorUnidad = 50 precioFInal = 45
                    return 0f;
                } else {
                    System.out.println("Descuento aplicado correctamente");
                    this.porcentajeDescuento = descuento;
                    return desc;
                }
            }
        }
        if (ProductoBebida.productoEsProductoBebida(p1)) {
            if (descuento > ProductoBebida.DESCUENTO_MAXIMO_PRODT_BEBIDA) {
                Float desc = calcularDescuento(p1.getPrecio(), descuento);
                if (p1.getCostoPorUnidad() > desc) {
                    System.out.println("El descuento registrado para el producto " + p1.getIdentificadorAbstracto()
                            + " no pudo ser aplicacdo");// producto.PrecioPorUnidad = 50 precioFInal = 45
                    return 0f;
                } else {
                    System.out.println("Descuento aplicado correctamente");
                    this.porcentajeDescuento = descuento;
                    return desc;
                }
            }
        }
        if (ProductoLimpieza.productoEsProductoLimpieza(p1)) {
            if (descuento > ProductoLimpieza.DESCUENTO_MAXIMO_PRODT_LIMPI) {
                Float desc = calcularDescuento(p1.getPrecio(), descuento);
                if (p1.getCostoPorUnidad() > desc) {
                    System.out.println("El descuento registrado para el producto " + p1.getIdentificadorAbstracto()
                            + " no pudo ser aplicacdo");// producto.PrecioPorUnidad = 50 precioFInal = 45
                    return 0f;
                } else {
                    System.out.println("Descuento aplicado correctamente");
                    this.porcentajeDescuento = descuento;
                    return desc;
                }

            }
        }
        return 0f;
    }

    /*
     * 
     * 
     * 
     * 
     * 
     */
    public void agregarDescuento2(Producto p1, Float descuento) {

        if (ProductoEnvasado.productoEsProductoEnvasado(p1)) {
            if (descuento > ProductoEnvasado.DESCUENTO_MAXIMO_PRODT_ENVASADO) {
                Float desc = calcularDescuento(p1.getPrecio(), descuento);
                if (p1.getCostoPorUnidad() > desc) {
                    System.out.println("El descuento registrado para el producto " + p1.getIdentificadorAbstracto()
                            + " no pudo ser aplicacdo");// producto.PrecioPorUnidad = 50 precioFInal = 45
                } else {
                    System.out.println("Descuento aplicado correctamente");
                    p1.setDescuento(descuento);
                }
            }
        }
        if (ProductoBebida.productoEsProductoBebida(p1)) {
            if (descuento > ProductoBebida.DESCUENTO_MAXIMO_PRODT_BEBIDA) {
                Float desc = calcularDescuento(p1.getPrecio(), descuento);
                if (p1.getCostoPorUnidad() > desc) {
                    System.out.println("El descuento registrado para el producto " + p1.getIdentificadorAbstracto()
                            + " no pudo ser aplicacdo");// producto.PrecioPorUnidad = 50 precioFInal = 45
                } else {
                    System.out.println("Descuento aplicado correctamente");
                    p1.setDescuento(descuento);
                }
            }
        }
        if (ProductoLimpieza.productoEsProductoLimpieza(p1)) {
            if (descuento > ProductoLimpieza.DESCUENTO_MAXIMO_PRODT_LIMPI) {
                Float desc = calcularDescuento(p1.getPrecio(), descuento);
                if (p1.getCostoPorUnidad() > desc) {
                    System.out.println("El descuento registrado para el producto " + p1.getIdentificadorAbstracto()
                            + " no pudo ser aplicacdo");// producto.PrecioPorUnidad = 50 precioFInal = 45
                } else {
                    System.out.println("Descuento aplicado correctamente");
                    p1.setDescuento(descuento);
                }

            }
        }
    }

    /*
     * Calcula el descuento que se quiere hacer
     * Recibe un precio y un descuento en porcentaje.
     * Por eejemplo, el precio=150 y el descuento es del 15% => precio final =
     * 127.50
     * Recibe como parametro un Float y un Float descuento
     * Retorna el precio con el descuento
     * // 100 10% ==> 100 - ((100*10)/100) => 90, precioP = 100, descuento = 10
     * // 155 17% == 155 - ((155*¨17)/100) => 128.65, preicioP = 155, descuento = 17
     */
    public Float calcularDescuento(Float precioP, Float descuento) {
        return precioP = precioP - ((precioP * descuento) / 100);
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
     * Muestra los productos almacenados en this.productos del campo Venta
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

}