
import models.ProductoBebida;
import models.ProductoEnvasado;
import models.ProductoLimpieza;

public class App {
        public static void main(String[] args) throws Exception {

                System.out.println("Creando clase Productos...");
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

                ProductoBebida productoB1 = new ProductoBebida(001, "Coca-Cola 500ml", 20.0f, 500.0f, 50, false, 0f,
                                true);
                ProductoBebida productoB2 = new ProductoBebida(002, "Coca-Cola 1l", 30.0f, 28.0f, 50, false, 0f, true);
                ProductoBebida productoB3 = new ProductoBebida(003, "Sprite 500ml", 20.0f, 18.0f, 20, false, 0f, true);
                ProductoBebida productoB4 = new ProductoBebida(004, "Sprite 1l", 30.0f, 28.0f, 20, false, 0f, true);
                ProductoBebida productoB5 = new ProductoBebida(005, "Cerveza Corona 300ml", 40.0f, 35.0f, 60, true, 10f,
                                true);
                ProductoBebida productoB6 = new ProductoBebida(006, "Cerveza Corona 750ml", 20.0f, 18.0f, 50, false,
                                10f,
                                true);
                ProductoBebida productoB7 = new ProductoBebida(007, "VinoTinto Malbec 1l", 80.0f, 65.0f, 10, true, 040f,
                                false);
                ProductoBebida productoB8 = new ProductoBebida(8, "Fanta", 20.0f, 18.0f, 10, false, 0f, false);

                // Probando funcion setearGanancia
                productoB1.setearGanacia(productoB1.getCostoPorUnidad(), 50f);

                System.out.println("Producto: \nidentificador:" +
                                productoB1.getIdentificadorABstracto()
                                + ",  descripcion:" + productoB1.getDescripcion()
                                + ",  precio: " + productoB1.getPrecio()
                                + ", costoPorUnidad:" + productoB1.getCostoPorUnidad() +
                                ",  cantiddad: " + productoB1.getCantidad()
                                + ", porcentajeDeAlcohol:  " + productoB1.getPorcentajeDeAlcohol()
                                + ", importado: " + productoB1.getImportado() + "\n\n\n");

                /////////////////////////////////////////
                ProductoEnvasado productoE1 = new ProductoEnvasado(001, "Arroz 1kg", 12.4f, 10.0f, 5, (byte) 1, true);
                ProductoEnvasado productoE2 = new ProductoEnvasado(002, "Fideo Largos 1kg", 8.4f, 7f, 10, (byte) 1,
                                false);
                ProductoEnvasado productoE3 = new ProductoEnvasado(003, "Fideo Spagetti 1kg", 13f, 10.0f, 10, (byte) 1,
                                false);
                ProductoEnvasado productoE4 = new ProductoEnvasado(004, "Cafe Capsulas 10u", 25f, 1022f, 10, (byte) 1,
                                true);
                ProductoEnvasado productoE5 = new ProductoEnvasado(005, "Aceite 1l", 21f, 20.5f, 5, (byte) 1, true);
                ProductoEnvasado productoE6 = new ProductoEnvasado(006, "Dulce de Leche 1kg", 35.7f, 30f, 20, (byte) 1,
                                false);
                ProductoEnvasado productoE7 = new ProductoEnvasado(007, "Zanahorias 1kg", 0.50f, 0.02f, 2, (byte) 1,
                                false);
                ProductoEnvasado productoE8 = new ProductoEnvasado(8, "Asado 3kg", 75f, 65f, 6, (byte) 1, false);

                ProductoLimpieza productoL1 = new ProductoLimpieza(001, "Lavandina 1L", 8.50f, 7.50f, 5, (byte) 3);
                ProductoLimpieza productoL2 = new ProductoLimpieza(002, "Perfumina 1L", 5.25f, 4f, 5, (byte) 1);
                ProductoLimpieza productoL3 = new ProductoLimpieza(003, "Detergente 200ml", 12.25f, 10f, 10, (byte) 3);
                ProductoLimpieza productoL4 = new ProductoLimpieza(004, "Cera Para el Piso 1kg", 20.0f, 18.0f, 5,
                                (byte) 1);
                ProductoLimpieza productoL5 = new ProductoLimpieza(005, "Desengrasante Para la cocina", 30f, 25f, 5,
                                (byte) 0);
                ProductoLimpieza productoL6 = new ProductoLimpieza(006, "Suavizante para la ropa", 40f, 30f, 5,
                                (byte) 2);

                ProductoLimpieza productoL7 = new ProductoLimpieza(007, "Espongita acero", 0.20f, 0.10f, 25,
                                (byte) 3);
                ProductoLimpieza productoL8 = new ProductoLimpieza(8, "Detergente para la ropa 1l", 40f, 38f, 2,
                                (byte) 2);

                // Al agregar un producto al Map revisar que ni haya un identificador igual al
                // otro

        }
}
