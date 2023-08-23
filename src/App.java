
import models.ProductoBebida;
import models.ProductoEnvasado;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        System.out.println("Creando clase ProductoEnvasado...");
        /*
         * ProductoEnvasado product1 = new ProductoEnvasado(10, "Cafe 120gr", 12.5f,
         * 10.5f, 10, (byte) 1, true);
         * System.out.println("Producto: \nidentificador:" +
         * product1.getIdentificadorABstracto() + ",  descripcion:"
         * + product1.getDescripcion() + ",  precio: " + product1.getPrecio() +
         * ", costoPorUnidad:"
         * + product1.getCostoPorUnidad() + ",  cantiddad: " + product1.getCantidad() +
         * ", tipoEnvase:  "
         * + product1.getTipoEnvase() + ", importado: " + product1.getImportado() +
         * "\n\n\n");
         */

        /*
         * System.out.println("Ingrese un numero");
         * Scanner entrada = new Scanner(System.in);
         * entrada.nextInt();
         */

        /*
         * ProductoBebida product2 = new ProductoBebida(05, "Coca-Cola 500ml", 2.50f,
         * 2.00f, 50, false, 0f, true);
         * System.out.println("Producto: \nidentificador:" +
         * product2.getIdentificadorABstracto()
         * + ",  descripcion:" + product2.getDescripcion()
         * + ",  precio: " + product2.getPrecio()
         * + ", costoPorUnidad:" + product2.getCostoPorUnidad() +
         * ",  cantiddad: " + product2.getCantidad()
         * + ", porcentajeDeAlcohol:  " + product2.getPorcentajeDeAlcohol()
         * + ", importado: " + product2.getImportado() + "\n\n\n");
         */

        // RESISAR TODO ESTO DE ABAJO

        ProductoBebida productoB1 = new ProductoBebida(001, "Coca-Cola 500ml", 20.0f, 18.0f, 50, false, 0f, true);
        ProductoBebida productoB2 = new ProductoBebida(002, "Coca-Cola 1l", 30.0f, 28.0f, 50, false, 0f, true);
        ProductoBebida productoB3 = new ProductoBebida(003, "Sprite 500ml", 20.0f, 18.0f, 20, false, 0f, true);
        ProductoBebida productoB4 = new ProductoBebida(004, "Sprite 1l", 30.0f, 28.0f, 20, false, 0f, true);
        ProductoBebida productoB5 = new ProductoBebida(005, "Cerveza Corona 300ml", 40.0f, 35.0f, 60, true, 10f,
                true);
        ProductoBebida productoB6 = new ProductoBebida(006, "Cerveza Corona 750ml", 20.0f, 18.0f, 50, false, 10f,
                true);
        ProductoBebida productoB7 = new ProductoBebida(007, "VinoTinto Malbec 1l", 80.0f, 65.0f, 10, true, 040f,
                false);
        ProductoBebida productoB8 = new ProductoBebida(8, "Fanta", 20.0f, 18.0f, 10, false, 0f, false);

        /////////////////////////////////////////
        ProductoEnvasado productoE1 = new ProductoEnvasado(001, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE2 = new ProductoEnvasado(002, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE3 = new ProductoEnvasado(003, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE4 = new ProductoEnvasado(004, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE5 = new ProductoEnvasado(005, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE6 = new ProductoEnvasado(006, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE7 = new ProductoEnvasado(007, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE8 = new ProductoEnvasado(8, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE9 = new ProductoEnvasado(9, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        ProductoEnvasado productoE10 = new ProductoEnvasado(10, "Arroz 1kg", 12.4f, 10.0f, 10, (byte) 1, true);
        /*
         * ProductoBebida product2 = new ProductoBebida("fc456", "Coca-Cola 500ml",
         * 2.50f, 2.00f, 100, false, 0f, true);
         * System.out.println("Producto: \nidentificador:" + product2.getIdentificador()
         * + ",  descripcion:"
         * + product2.getDescripcion() + ",  precio: "
         * + product2.getPrecio() + ", costoPorUnidad:" + product2.getCostoPorUnidad() +
         * ",  cantiddad: "
         * + product2.getCantidad() + ", porcentajeDeAlcohol:  " +
         * product2.getPorcentajeDeAlcohol()
         * + ", importado: "
         * + product2.getImportado() + "\n\n\n");
         */
        // CREAR SIGUIENTE CLASE
    }
}
