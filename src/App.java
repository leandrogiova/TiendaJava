
import models.ProductoEnvasado;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        System.out.println("Creando clase ProductoEnvasado...");

        ProductoEnvasado product1 = new ProductoEnvasado(10, "Cafe 120gr", 12.5f, 10.5f, 10, (byte) 1, true);
        System.out.println("Producto: \nidentificador:" + product1.getIdentificadorABstracto() + ",  descripcion:"
                + product1.getDescripcion() + ",  precio: " + product1.getPrecio() + ", costoPorUnidad:"
                + product1.getCostoPorUnidad() + ",  cantiddad: " + product1.getCantidad() + ", tipoEnvase:  "
                + product1.getTipoEnvase() + ", importado: " + product1.getImportado() + "\n\n\n");

        /*
         * System.out.println("Ingrese un numero");
         * Scanner entrada = new Scanner(System.in);
         * entrada.nextInt();
         */
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
