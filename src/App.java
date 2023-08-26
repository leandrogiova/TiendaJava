
import java.sql.Date;
import java.util.Map;
import java.util.Scanner;

import Tienda.Tienda;
import Tienda.Operaciones.Venta;
import models.Producto;
import models.ProductoBebida;
import models.ProductoEnvasado;
import models.ProductoLimpieza;

public class App {
        public static void main(String[] args) throws Exception {

                Scanner entrada = new Scanner(System.in);
                Scanner entrada2 = new Scanner(System.in);
                Scanner scanner = new Scanner(System.in);
                Tienda nuevaTienda2 = new Tienda();
                Venta nuevaVenta_ = new Venta();
                int opcion;
                int contadorVentas = 0;

                System.out.println("Creando clase Productos...");

                Date fecha1 = new Date(123, 10, 1);
                ProductoBebida productoB1 = new ProductoBebida(001, "Coca-Cola 500ml", 20.0f, 500.0f, 50, false, 0f,
                                true, fecha1, 1500);

                ProductoBebida productoB2 = new ProductoBebida(002, "Coca-Cola 1l", 30.0f, 28.0f, 50, false, 0f, true,
                                fecha1, 3000);
                ProductoBebida productoB3 = new ProductoBebida(003, "Sprite 500ml", 20.0f, 18.0f, 20, false, 0f, true,
                                fecha1, 1500);
                ProductoBebida productoB4 = new ProductoBebida(004, "Sprite 1l", 30.0f, 28.0f, 20, false, 0f, true,
                                fecha1, 3000);
                ProductoBebida productoB5 = new ProductoBebida(005, "Cerveza Corona 300ml", 40.0f, 35.0f, 60, true, 10f,
                                true, fecha1, 800);
                ProductoBebida productoB6 = new ProductoBebida(006, "Cerveza Corona 750ml", 20.0f, 18.0f, 50, false,
                                10f,
                                true, fecha1, 1600);
                ProductoBebida productoB7 = new ProductoBebida(007, "VinoTinto Malbec 1l", 80.0f, 65.0f, 10, true, 040f,
                                false, fecha1, 700);
                ProductoBebida productoB8 = new ProductoBebida(8, "Fanta", 20.0f, 18.0f, 10, false, 0f, false, fecha1,
                                1500);

                /*
                 * 
                 * 
                 * 
                 * 
                 */
                // Probando funcion setearGanancia

                productoB1.setCostoPorUnidad(100f);
                productoB1.setearGanacia(productoB1.getCostoPorUnidad(), 50f);

                System.out.println("Probando clases de setearGanancia");
                ProductoBebida productoB20 = new ProductoBebida(8, "Fanta", 20.0f, 0f, 10, false, 0f, false, fecha1,
                                1500);
                productoB20.setearGanacia(productoB20.getCostoPorUnidad(), 10f);

                System.out.println("Producto: \nidentificador:" +
                                productoB1.getIdentificadorAbstracto()
                                + ",  descripcion:" + productoB1.getDescripcion()
                                + ",  precio: " + productoB1.getPrecio()
                                + ", costoPorUnidad:" + productoB1.getCostoPorUnidad() +
                                ",  cantiddad: " + productoB1.getCantidad()
                                + ", porcentajeDeAlcohol:  " + productoB1.getPorcentajeDeAlcohol()
                                + ", importado: " + productoB1.getImportado() + "\n\n\n");

                ProductoEnvasado productoE1 = new ProductoEnvasado(001, "Arroz 1kg", 12.4f, 10.0f, 5, (byte) 1, true,
                                fecha1, 1500);
                ProductoEnvasado productoE2 = new ProductoEnvasado(002, "Fideo Largos 1kg", 8.4f, 7f, 10, (byte) 1,
                                false, fecha1, 1500);
                ProductoEnvasado productoE3 = new ProductoEnvasado(003, "Fideo Spagetti 1kg", 13f, 10.0f, 10, (byte) 1,
                                false, fecha1, 1500);
                ProductoEnvasado productoE4 = new ProductoEnvasado(004, "Cafe Capsulas 10u", 25f, 1022f, 10, (byte) 1,
                                true, fecha1, 1500);
                ProductoEnvasado productoE5 = new ProductoEnvasado(005, "Aceite 1l", 21f, 20.5f, 5, (byte) 1, true,
                                fecha1, 1500);
                ProductoEnvasado productoE6 = new ProductoEnvasado(006, "Dulce de Leche 1kg", 35.7f, 30f, 20, (byte) 1,
                                false, fecha1, 1500);
                ProductoEnvasado productoE7 = new ProductoEnvasado(007, "Zanahorias 1kg", 0.50f, 0.02f, 2, (byte) 1,
                                false, fecha1, 1500);
                ProductoEnvasado productoE8 = new ProductoEnvasado(8, "Asado 3kg", 75f, 65f, 6, (byte) 0, false, fecha1,
                                1500);

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

                Tienda nuevaTienda = new Tienda();
                nuevaTienda.setNombre("TiendaLeandrooooou");
                nuevaTienda.setCantidad(1500l);
                nuevaTienda.setSaldoEnCaja(150d);

                nuevaTienda.getInventario().put(productoB1.getIdentificadorAbstracto(), productoB1);
                nuevaTienda.getInventario().put(productoB2.getIdentificadorAbstracto(), productoB2);
                nuevaTienda.getInventario().put(productoB3.getIdentificadorAbstracto(), productoB3);
                nuevaTienda.getInventario().put(productoB4.getIdentificadorAbstracto(), productoB4);
                nuevaTienda.getInventario().put(productoB5.getIdentificadorAbstracto(), productoB5);
                nuevaTienda.getInventario().put(productoB6.getIdentificadorAbstracto(), productoB6);
                nuevaTienda.getInventario().put(productoB7.getIdentificadorAbstracto(), productoB7);
                nuevaTienda.getInventario().put(productoB8.getIdentificadorAbstracto(), productoB8);

                nuevaTienda.getInventario().put(productoE1.getIdentificadorAbstracto(), productoE1);
                nuevaTienda.getInventario().put(productoE2.getIdentificadorAbstracto(), productoE2);
                nuevaTienda.getInventario().put(productoE3.getIdentificadorAbstracto(), productoE3);
                nuevaTienda.getInventario().put(productoE4.getIdentificadorAbstracto(), productoE4);
                nuevaTienda.getInventario().put(productoE5.getIdentificadorAbstracto(), productoE5);
                nuevaTienda.getInventario().put(productoE6.getIdentificadorAbstracto(), productoE6);
                nuevaTienda.getInventario().put(productoE7.getIdentificadorAbstracto(), productoE7);
                nuevaTienda.getInventario().put(productoE8.getIdentificadorAbstracto(), productoE8);

                nuevaTienda.getInventario().put(productoL1.getIdentificadorAbstracto(), productoL1);
                nuevaTienda.getInventario().put(productoL2.getIdentificadorAbstracto(), productoL2);
                nuevaTienda.getInventario().put(productoL3.getIdentificadorAbstracto(), productoL3);
                nuevaTienda.getInventario().put(productoL4.getIdentificadorAbstracto(), productoL4);
                nuevaTienda.getInventario().put(productoL5.getIdentificadorAbstracto(), productoL5);
                nuevaTienda.getInventario().put(productoL6.getIdentificadorAbstracto(), productoL6);
                nuevaTienda.getInventario().put(productoL7.getIdentificadorAbstracto(), productoL7);
                nuevaTienda.getInventario().put(productoL8.getIdentificadorAbstracto(), productoL8);

                /*
                 * 
                 * 
                 * 
                 * 
                 * 
                 * 
                 */

                ProductoLimpieza productoL20 = new ProductoLimpieza(8, "Detergente para la ropa 1l", 900000f, 99999f, 2,
                                (byte) 2);
                System.out.println("\n\nComprando productos...");
                nuevaTienda.comprarProducto(productoL20);

                do {
                        System.out.println("\n\nMenu para compras:");
                        System.out.println("1 - Ingresar un producto para comprar");
                        System.out.println("2 - Para terminar");
                        System.out.print("Ingrese una opcion: ");

                        opcion = scanner.nextInt();

                        switch (opcion) {
                                case 1:
                                        System.out.println("Ingresando nuevo producto");
                                        System.out.print("Ingrese el tipo de producto:"
                                                        + "\n1-Producto Envasado(arroz, fideos, servilletas ,cafe ,aceite...)"
                                                        + "\n2-Producto Bebidas(Agua,CocaCola, Vino, Cerveza...)"
                                                        + "\n3-Producto Limpieza(detergente)");

                                        int num = scanner.nextInt();
                                        if (num == 1) {
                                                System.out.println("Ingrese un numero de producto");
                                                int idNum = scanner.nextInt();
                                                productoE1.setIdentificadorAbstracto("AB", idNum);
                                        }
                                        if (num == 2) {
                                                System.out.println("Ingrese un numero de producto");
                                                int idNum = scanner.nextInt();
                                                productoE1.setIdentificadorAbstracto("AC", idNum);
                                        }
                                        if (num == 3) {
                                                System.out.println("Ingrese un numero de producto");
                                                int idNum = scanner.nextInt();
                                                productoE1.setIdentificadorAbstracto("AZ", idNum);

                                        }

                                        System.out.println("Ingrese nombre y descripcion");
                                        String descripcion = entrada.nextLine();
                                        productoE1.setDescripcion(descripcion);

                                        System.out.println("Ingrese un numero el precio de costo: ");
                                        Float idNum_ = scanner.nextFloat();
                                        productoE1.setCostoPorUnidad(idNum_);

                                        System.out.println("ingrese el porcentaje de ganacia al producto:");
                                        idNum_ = entrada.nextFloat();
                                        productoE1.setearGanacia(productoE1.getCostoPorUnidad(), idNum_);

                                        System.out.println("Ingrese la cantidad:");
                                        int idNum2 = scanner.nextInt();
                                        productoE1.setCantidad(idNum2);

                                        nuevaTienda.comprarProducto(productoE1);

                                        break;
                                case 2:

                                        System.out.println("Cerrando venta y terminando...");
                                        break;
                                default:
                                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                                        break;
                        }
                } while (opcion != 2);

                System.out.println("\n\n\n\n\n\n\n\n\n\nSe creara una nueva tiendan\n");

                nuevaTienda2.setNombre("Tienda2");
                nuevaTienda2.setCantidad(50l);
                nuevaTienda2.setSaldoEnCaja(1000d);

                ProductoBebida productoB10 = new ProductoBebida(8, "Fanta", 20.0f, 18.0f, 10, false, 0f, false, fecha1,
                                1500);
                ProductoLimpieza productoL10 = new ProductoLimpieza(001, "Lavandina 1L", 8.50f, 7.50f, 5, (byte) 3);

                ProductoEnvasado productoE10 = new ProductoEnvasado(001, "Arroz 1kg", 12.4f, 10.0f, 17, (byte) 1, true,
                                fecha1, 1500);

                nuevaTienda2.getInventario().put(productoB10.getIdentificadorAbstracto(), productoB10);
                nuevaTienda2.getInventario().put(productoL10.getIdentificadorAbstracto(), productoL10);
                nuevaTienda2.getInventario().put(productoE10.getIdentificadorAbstracto(), productoE10);
                /*
                 * 
                 * Probando Ventas
                 * 
                 */
                System.out.println(
                                "\n\n\n\nComenzando pruebas.\nIngrese un numero para continuar y proceder a realizar una venta");

                entrada.nextInt();
                System.out.println("\n\n");
                nuevaTienda2.verTienda();

                nuevaTienda2.setNuevaVenta(nuevaVenta_);

                do {
                        System.out.println("\n\nMenu para ventas:");
                        System.out.println("1 - Ingresar un producto a la venta");
                        System.out.println("2 - Cerrar Venta y terminar");
                        System.out.print("Ingrese una opcion: ");

                        opcion = scanner.nextInt();

                        switch (opcion) {
                                case 1:
                                        if (contadorVentas < 3) {
                                                // Lógica para ingresar un producto a la venta
                                                System.out.println("Ingresando producto a la venta...");
                                                nuevaTienda2.verInventario();
                                                System.out.print(
                                                                "Ingrese el identificador del producto: EXACTAMENTE IGUAL(por ejemplo: 'AB001'):     ");
                                                String nuevoIdem = entrada2.nextLine();

                                                System.out.println(
                                                                "Ingrese la cantidad de producto que quiere comprar(maximo 10 producto): ");
                                                Integer cant55 = entrada.nextInt();
                                                Producto producto_A_Vender = nuevaTienda2.encontrarProducto(nuevoIdem);

                                                if (producto_A_Vender == null) {
                                                        System.out.println("No se encontro al producto");
                                                } else {
                                                        producto_A_Vender.setCantidad(cant55);

                                                        nuevaTienda2.realizarVenta(producto_A_Vender);

                                                        nuevaTienda2.getNuevaVenta().verDetalleDeLaVenta();
                                                        contadorVentas++;
                                                }

                                        } else {
                                                System.out.println("No puedes ingresar más productos a la venta.");
                                                System.out.println("Cerrando venta y terminando...");
                                                nuevaTienda2.cerrarVenta(nuevaVenta_);

                                        }
                                        break;
                                case 2:
                                        nuevaTienda2.cerrarVenta(nuevaVenta_);

                                        System.out.println("Cerrando venta y terminando...");
                                        break;
                                default:
                                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                                        break;
                        }
                } while (opcion != 2);
                entrada.close();
                entrada2.close();
                scanner.close();
        }

}