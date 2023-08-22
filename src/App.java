import models.ProductoBebida;
import models.ProductoEnvasado;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        System.out.println("Creando clase ProductoEnvasado...");

        ProductoEnvasado product1 = new ProductoEnvasado("ab456", "Cafe 120gr", 1.20f, 0.90f, 10,
                "Plastico", true);
        System.out.println("Producto: \nidentificador:" + product1.getIdentificador() + ",  descripcion:"
                + product1.getDescripcion() + ",  precio: "
                + product1.getPrecio() + ", costoPorUnidad:" + product1.getCostoPorUnidad() + ",  cantiddad: "
                + product1.getCantidad() + ", tipoEnvase:  " + product1.getTipoEnvase() + ", importado: "
                + product1.getImportado() + "\n\n\n");

        ProductoBebida product2 = new ProductoBebida("ac456", "Coca-Cola 500ml", 2.50f, 2.00f, 100, false, 0f, true);
        System.out.println("Producto: \nidentificador:" + product2.getIdentificador() + ",  descripcion:"
                + product2.getDescripcion() + ",  precio: "
                + product2.getPrecio() + ", costoPorUnidad:" + product2.getCostoPorUnidad() + ",  cantiddad: "
                + product2.getCantidad() + ", porcentajeDeAlcohol:  " + product2.getPorcentajeDeAlcohol()
                + ", importado: "
                + product2.getImportado() + "\n\n\n");

    }
}
