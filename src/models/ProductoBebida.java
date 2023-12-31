package models;

import java.sql.Date;
import java.util.Scanner;

import funcionesProductos.InterfaceFuncionesProductos;

public class ProductoBebida extends Producto implements InterfaceFuncionesProductos {

    public static String NOMBRE_CATEGORIA_BEBIDA = "AC";
    public static Float GANANCIA_PORCENTAJE_MAXIMO_DE_BEBIDA = 15.0f;
    public static Float DESCUENTO_MAXIMO_PRODT_BEBIDA = 20.0f;

    private Boolean alcoholica;
    private Float porcentajeDeAlcohol;
    private Boolean importado;
    private Date fechaVencimiento;
    private Integer calorias;

    /*
     * Constructor ProductoBebida setea los campos correspondientes
     * Setea el campo identificador de la clase Heredada Producto con el nombre de
     * la categoria "AC" y con el numero de producto
     * Ademas setea el tipo de bebida Alcoholica en True si la bebida es alcoholica
     * O False si la bebida NO contiene alcohol. Y su graduacion Alcoholica en forma
     * de porcentaje con el tipo "Float"
     * Y el campo importado que es un True si el producto es importado
     * O False si el producto NO es importado
     * Recibe como parametros Integer, String, Float, Float, Integer, Boolean,
     * Boolean, Float, Boolean
     * No retorna ningun tipo
     */
    public ProductoBebida(Integer numero, String descripcion,
            Float precio, Float costoPorUnidad, Integer cantidad, Boolean alcoholica, Float porcentajeDeAlcohol,
            Boolean importado, Date fechaVencimiento, Integer calorias) {

        super(numero, descripcion, precio, costoPorUnidad, cantidad);
        this.alcoholica = alcoholica;
        this.porcentajeDeAlcohol = porcentajeDeAlcohol;
        this.importado = importado;
        this.fechaVencimiento = fechaVencimiento;
        this.calorias = calorias;

        setIdentificadorAbstracto(NOMBRE_CATEGORIA_BEBIDA, numero);

    }

    public ProductoBebida() {

    }

    public Boolean getAlcoholica() {
        return alcoholica;
    }

    public void setAlcoholica(Boolean alcoholica) {
        this.alcoholica = alcoholica;
    }

    public Float getPorcentajeDeAlcohol() {
        return porcentajeDeAlcohol;
    }

    public void setPorcentajeDeAlcohol(Float porcentajeDeAlcohol) {
        if (alcoholica) {
            this.porcentajeDeAlcohol = porcentajeDeAlcohol;
        } else {
            System.out.println("ERROR! Al setear el porcentaje de alcohol en el producto.\n\n");
        }
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }

    @Override
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public Integer getCalorias() {
        return this.calorias;
    }

    @Override
    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    @Override
    public void setearGanacia(Float precioProducto, Float porcentaje) {
        if (porcentaje <= GANANCIA_PORCENTAJE_MAXIMO_DE_BEBIDA) {

            Float porcent = precioProducto * (porcentaje / 100);// Calcula la ganancia en base al porcentaje
            Float gananc = porcent + precioProducto;
            setPrecio(gananc); // Suma la ganancia al precio original

        } else {
            System.out.println("El porcentaje de ganacia no puede ser mayor a " + GANANCIA_PORCENTAJE_MAXIMO_DE_BEBIDA);
        }
    }

    @Override
    public void verProduto(Producto p) {
        ProductoBebida producto = (ProductoBebida) p;

        System.out.println("\nViendo producto\n"
                + "id: " + producto.getIdentificadorAbstracto()
                + ",   " + producto.getDescripcion()
                + ",  precio: " + producto.getPrecio()
                + ",  costoPorUnidad: " + producto.getCostoPorUnidad()
                + ", cant: " + producto.getCantidad()
                + ", fecha: " + producto.getFechaVencimiento()
                + ",  descuentoEn%: " + producto.getDescuento()
                + ", importado: " + producto.getImportado()
                + ", alcoholica: " + producto.getAlcoholica()
                + ",  porcentajeAlcohol%: " + producto.getPorcentajeDeAlcohol());
    }

    /*
     * funcion productoEsProductobebida
     * Recibe un Producto y verifica si el producto es un producto bebida
     * Hace esto verificando el tipo de identificador
     * Recibe como parametro un Producto
     * Retorna True si es un productoBebida
     */
    public static Boolean productoEsProductoBebida(Producto producto) {
        char[] clave1 = producto.getIdentificadorAbstracto().toCharArray();
        char[] claveProducto = ProductoBebida.NOMBRE_CATEGORIA_BEBIDA.toCharArray();
        Boolean sonIguales = true;
        for (int i = 0; i < claveProducto.length; i++) {
            if (clave1.length <= i || clave1[i] != claveProducto[i]) {
                sonIguales = false;
                break;
            }
        }
        if (sonIguales) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Funcion para setear un producto por consola
     */
    public static ProductoBebida ingresarDatosProductosBebida(ProductoBebida p) {
        Scanner scanner = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);

        System.out.println(
                "Ingrese un numero de producto, un numero como maximo de 3 cifras:    ");

        int idNum = scanner.nextInt();
        p.setIdentificadorAbstracto(NOMBRE_CATEGORIA_BEBIDA, idNum);
        System.out.println("Ingrese nombre y descripcion");
        String descripcion = entrada.nextLine();
        p.setDescripcion(descripcion);

        System.out.println("Ingrese si el producto es importado o no: 1-si, 2-no: ");
        int idNum2 = scanner.nextInt();
        if (idNum2 == 1) {
            p.setImportado(true);

        }

        System.out.println("Ingrese un numero el precio de costo: ");
        Float idNum_ = scanner.nextFloat();
        p.setCostoPorUnidad(idNum_);

        System.out.println("Ingrese el porcentaje de ganacia al producto:");
        idNum_ = entrada.nextFloat();
        p.setearGanacia(p.getCostoPorUnidad(), idNum_);

        System.out.println("Ingrese la cantidad:");
        idNum2 = scanner.nextInt();
        p.setCantidad(idNum2);

        System.out.println("Ingrese si el producto contiene alcohol: 1-Si, 2-No: ");
        idNum2 = scanner.nextInt();
        if (idNum2 == 1) {
            p.setAlcoholica(true);
        } else {
            p.setAlcoholica(false);
        }

        System.out.println("Ingrese un numero de porcentaje de alcohol: ");
        idNum_ = scanner.nextFloat();
        p.setPorcentajeDeAlcohol(idNum_);

        System.out.println("Ingrese la calorias del producto: ");
        idNum2 = scanner.nextInt();
        p.setCalorias(idNum2);

        return p;
    }
}
