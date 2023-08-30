package models;

import java.sql.Date;
import java.util.Scanner;

import funcionesProductos.InterfaceFuncionesProductos;

public class ProductoEnvasado extends Producto implements InterfaceFuncionesProductos {

    public static String NOMBRE_CATEGORIA_ENVASADO = "AB";
    public static String[] TIPO_DE_ENVASE = { "PLASTICO", "VIDRIO", "LATA", };
    public static Float GANANCIA_PORCENTAJE_MAXIMO_DE_ENVASADO = 20.0f;
    public static Float DESCUENTO_MAXIMO_PRODT_ENVASADO = 20.0f;

    private String tipoEnvase;
    private Boolean importado;
    private Date fechaVencimiento;
    private Integer calorias;

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }

    /*
     * Constructor ProductoEnvasado setea los campos correspondientes
     * Setea el campo identificador de la clase Heredada Producto con el nombre de
     * la categoria "AB" y con el numero de producto
     * Ademas setea el tipo de envase a String
     * Para setear el tipo de envase se recibe un Byte que corresponde al tipo de
     * envase
     * Si es 0 ==> PLASTICO
     * 1 ==> VIDRIO
     * 2 ==> LATA
     * Los nombre "PLASTICO", VIDRIO, LATA se almacenan en una
     * constante "TIPO_DE_ENVASE"
     * Y el campo importado que es un True si el producto es importado
     * O False si el producto NO es importado
     * Recibe como parametros Integer, String, Float, Float, Integer, String,
     * Boolean
     * No retorna ningun tipo
     */
    public ProductoEnvasado(Integer numero, String descripcion,
            Float precio, Float costoPorUnidad, Integer cantidad, byte tipoEnvaseNum, Boolean importado,
            Date fechaVencimiento, Integer calorias) {

        super(numero, descripcion, precio, costoPorUnidad, cantidad);
        this.importado = importado;
        this.tipoEnvase = TIPO_DE_ENVASE[tipoEnvaseNum];
        this.fechaVencimiento = fechaVencimiento;
        this.calorias = calorias;

        setIdentificadorAbstracto(NOMBRE_CATEGORIA_ENVASADO, numero);

    }

    public ProductoEnvasado() {

    }

    @Override
    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
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
    public void verProduto(Producto p) {
        ProductoEnvasado productoEnvasado = (ProductoEnvasado) p;

        System.out.println("\nViendo producto\n"
                + "id: " + productoEnvasado.getIdentificadorAbstracto()
                + ",   " + productoEnvasado.getDescripcion()
                + ",  precio: " + productoEnvasado.getPrecio()
                + ",  costoPorUnidad: " + productoEnvasado.getCostoPorUnidad()
                + ", cant: " + productoEnvasado.getCantidad()
                + ",  tipoEn: " + productoEnvasado.getTipoEnvase()
                + ", importado: " + productoEnvasado.getImportado()
                + ", fecha: " + productoEnvasado.getFechaVencimiento()
                + ",  descuentoEn%: " + productoEnvasado.getDescuento()

        );

    }

    @Override
    public void setearGanacia(Float precioProducto, Float porcentaje) {
        if (porcentaje < GANANCIA_PORCENTAJE_MAXIMO_DE_ENVASADO) {

            Float porcent = precioProducto * (porcentaje / 100);// Calcula la ganancia en base al porcentaje
            Float gananc = porcent + precioProducto;
            setPrecio(gananc); // Suma la ganancia al precio original
            System.out.println("precio con ganancia: " + getPrecio());
            if (getImportado()) {
                porcentaje = 10f;
            }

        } else {
            System.out
                    .println("El porcentaje de ganacia no puede ser mayor a " + GANANCIA_PORCENTAJE_MAXIMO_DE_ENVASADO);
        }
    }

    /*
     * funcion productoEsProductoEnvasado
     * Recibe un Producto y verifica si el producto es un producto Envasado
     * Hace esto verificando el tipo de identificador
     * Recibe como parametro un Producto
     * Retorna True si es un productoEnvasado
     */
    public static Boolean productoEsProductoEnvasado(Producto producto) {
        char[] clave1 = producto.getIdentificadorAbstracto().toCharArray();
        char[] claveProducto = ProductoEnvasado.NOMBRE_CATEGORIA_ENVASADO.toCharArray();
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
    public static ProductoEnvasado ingresarDatosProductosEnvasado(ProductoEnvasado p) {
        Scanner scanner = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);

        System.out.println(
                "Ingrese un numero de producto, un numero como maximo de 3 cifras:    ");

        int idNum = scanner.nextInt();
        p.setIdentificadorAbstracto(NOMBRE_CATEGORIA_ENVASADO, idNum);
        System.out.println("Ingrese nombre y descripcion");
        String descripcion = entrada.nextLine();
        p.setDescripcion(descripcion);

        System.out.println("Ingrese si el producto es importado o no: 1-si, 2-no: ");
        int idNum2 = scanner.nextInt();
        if (idNum2 == 1) {
            p.setImportado(true);
        } else {
            p.setImportado(false);
        }

        System.out.println("Ingrese un numero el precio de costo: ");
        Float idNum_ = scanner.nextFloat();
        p.setCostoPorUnidad(idNum_);

        System.out.println("ingrese el porcentaje de ganacia al producto:");
        idNum_ = entrada.nextFloat();
        p.setearGanacia(p.getCostoPorUnidad(), idNum_);

        System.out.println("Ingrese la cantidad:");
        idNum2 = scanner.nextInt();
        p.setCantidad(idNum2);

        System.out.println("Ingrese el tipo de aplicacion1Cocina, 0-Plastico, 1-Vidrio, 2-Lata: Ingrese una opcion:");
        idNum2 = scanner.nextByte();
        p.setTipoEnvase(TIPO_DE_ENVASE[idNum2]);
        System.out.println("Ingrese la calorias del producto: ");
        idNum2 = scanner.nextInt();
        p.setCalorias(idNum2);

        return p;
    }
}