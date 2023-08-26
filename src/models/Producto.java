package models;

public abstract class Producto {

    public static int LONGITUD_IDENTIFICADOR = 5;

    private String identificador = new String(new char[LONGITUD_IDENTIFICADOR]);
    private String descripcion;

    private Float precio;
    private Float costoPorUnidad;
    private Integer cantidad;
    private Float descuento;

    /*
     * En el constructor Producto no se setea el campo identificador ya que lo setea
     * las clases hijas(ProductoEnvasado, ProductoBebida,
     * ProductoLimpieza)
     * Setea los campos descripcion que sera el nombre del producto con el detalle
     * precio con el precio que va a tener el producto a la venta
     * costoPorUnidad que sera el costo que se pago el producto
     * Recibe como parametros un Integer, String, Float, Float, Integer
     * No retorna ningun tipo
     */
    public Producto(Integer numero, String descripcion, Float precio, Float costoPorUnidad,
            Integer cantidad) {

        this.descripcion = descripcion;
        this.precio = precio;
        this.costoPorUnidad = costoPorUnidad;
        this.cantidad = cantidad;
    }

    public Producto() {
    }

    public String getIdentificadorAbstracto() {
        return identificador;
    }

    /*
     * Funcion setIdentificadorAbstracto va a setear el identificador(va a ser
     * obligatorio que contenga 2caracteres y 3 numeros).
     * Tomando como argumentos un String que va a ser el tipo de la categoria del
     * producto es decir, AB, AC, AZ
     * Y un numero que va a ser el numero del producto
     * El numero debe ser un numero de 3 digitos, obligatorio
     * Recibe como argumentos un String y un Integer
     * No retorna ningun tipo
     */

    public void setIdentificadorAbstracto(String identificador, Integer numeroId) {

        if (numeroId >= 0 && numeroId <= 999) {
            String nuevoNumero = String.format("%03d", numeroId);
            this.identificador = identificador.concat(nuevoNumero);
        } else {
            System.out.println(
                    "\n\n\nERROR el numero del identificador del producto. Debe ser un numero entre 0 y 999\n\n");
        }
    }

    public Float getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public void setCostoPorUnidad(Float costoPorUnidad) {
        this.costoPorUnidad = costoPorUnidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
     * Funcion setearGanacia setea el precio del producto respecto el precio que se
     * compro el producto
     * Es decir yo compro un producto a 100 y quiero tener de ganancia el 10%.
     * Entonces a la funcion setearGanacia le paso el "precioProducto"=100 y le paso
     * el porcentaje "porcentaje"=10
     * Y esto setea el campo "precio" con el precio que pague el producto + el
     * porcentaje que quiero tener de ganacia
     * Recibe como argemento dos Float, el precio que se pago el producto y el
     * aumento que quiere tener de ganancia
     * No retorna ningun tipo
     */
    public void setearGanacia(Float precioProducto, Float porcentaje) {
        Float ganancia = precioProducto * (porcentaje / 100); // Calcula la ganancia en base al porcentaje
        this.precio = precioProducto + ganancia; // Suma la ganancia al precio original
    }
}
