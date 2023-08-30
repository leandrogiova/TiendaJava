
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
                Scanner scanner = new Scanner(System.in);
                int opcion;

                System.out.println("Comenzando pruebas ... ");
                System.out.println("Creando clase Productos...");

                Date fecha1 = new Date(123, 10, 1);
                ProductoBebida productoB1 = new ProductoBebida(001, "Coca-Cola 500ml", 20666.0f, 5.0f, 50, false, 0f,
                                true, fecha1, 1500);

                //
                System.out.println("Probando clase seteando producto, viendo al producto ");
                productoB1.verProduto(productoB1);
                System.out.println("Seteando el precio de costo del producto en 100f para la prueba");
                productoB1.setCostoPorUnidad(100f);

                System.out.println("Seteando ganancias del 50%...");
                productoB1.setearGanacia(productoB1.getCostoPorUnidad(), 50f);

                System.out.println("Mismo producto: ");
                productoB1.verProduto(productoB1);

                System.out.println("Seteando ganancias al 10%.... ");
                productoB1.setearGanacia(productoB1.getCostoPorUnidad(), 10f);
                productoB1.verProduto(productoB1);

                System.out.println(
                                "Mismo producto ahora el precio por unidad es 150 y el porcentaje de ganancias es del 15%");
                productoB1.setCostoPorUnidad(150f);
                productoB1.setearGanacia(productoB1.getCostoPorUnidad(), 15f);
                productoB1.verProduto(productoB1);

                System.out.println(
                                "\n\n\nIngrese un numero para continuar y proceder a realizar mas pruebas.");
                entrada.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                ProductoBebida productoB20 = new ProductoBebida(8, "Fanta", 20.0f, 15f, 10, false, 0f, false, fecha1,
                                1500);
                System.out.println("ProductoB20: \nidentificador:" +
                                productoB20.getIdentificadorAbstracto()
                                + ",  descripcion:" + productoB20.getDescripcion()
                                + ",  precio: " + productoB20.getPrecio()
                                + ", costoPorUnidad:" + productoB20.getCostoPorUnidad() +
                                ",  cantiddad: " + productoB20.getCantidad()
                                + ", porcentajeDeAlcohol:  " + productoB20.getPorcentajeDeAlcohol()
                                + ", importado: " + productoB20.getImportado() + "\n\n\n");

                System.out.println("Producto: \nidentificador:" +
                                productoB1.getIdentificadorAbstracto()
                                + ",  descripcion:" + productoB1.getDescripcion()
                                + ",  precio: " + productoB1.getPrecio()
                                + ", costoPorUnidad:" + productoB1.getCostoPorUnidad() +
                                ",  cantiddad: " + productoB1.getCantidad()
                                + ", porcentajeDeAlcohol:  " + productoB1.getPorcentajeDeAlcohol()
                                + ", importado: " + productoB1.getImportado() + "\n\n\n");

                System.out.println(
                                "\n\n\nIngrese un numero para continuar y proceder a realizar mas pruebas");
                entrada.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                ProductoBebida productoB2 = new ProductoBebida(002, "Coca-Cola 1l", 970.0f, 28.0f, 50, false, 0f, true,
                                fecha1, 3000);
                ProductoBebida productoB3 = new ProductoBebida(003, "Sprite 500ml", 3.0f, 5.0f, 20, false, 0f, true,
                                fecha1, 1500);
                ProductoBebida productoB4 = new ProductoBebida(004, "Sprite 1l", 30.0f, 28.0f, 20, false, 0f, true,
                                fecha1, 3000);
                ProductoBebida productoB5 = new ProductoBebida(005, "Cerveza Corona 300ml", 900.0f, 4f, 60,
                                true, 10f,
                                true, fecha1, 800);

                ProductoBebida productoB6 = new ProductoBebida(006, "Cerveza Corona 750ml", 20.0f, 18.0f, 50, false,
                                10f,
                                true, fecha1, 1600);
                ProductoBebida productoB7 = new ProductoBebida(007, "VinoTinto Malbec 1l", 80.0f, 65.0f, 10, true, 040f,
                                false, fecha1, 700);
                ProductoBebida productoB8 = new ProductoBebida(8, "Fanta", 20.0f, 18.0f, 10, false, 0f, false, fecha1,
                                1500);

                //
                ProductoEnvasado productoE1 = new ProductoEnvasado(001, "Arroz 1kg", 12.4f, 10.0f, 5, (byte) 1, true,
                                fecha1, 1500);
                ProductoEnvasado productoE2 = new ProductoEnvasado(002, "Fideo Largos 1kg", 8.4f, 7f, 10, (byte) 1,
                                false, fecha1, 1500);
                ProductoEnvasado productoE3 = new ProductoEnvasado(003, "Fideo Spagetti 1kg", 13f, 10.0f, 10, (byte) 1,
                                false, fecha1, 1500);
                ProductoEnvasado productoE4 = new ProductoEnvasado(004, "Cafe Capsulas 10u", 25555f, 1022f, 10,
                                (byte) 1,
                                true, fecha1, 1500);
                ProductoEnvasado productoE5 = new ProductoEnvasado(005, "Aceite 1l", 21566f, 20.5f, 5, (byte) 1, true,
                                fecha1, 1500);
                ProductoEnvasado productoE6 = new ProductoEnvasado(006, "Dulce de Leche 1kg", 35.7f, 30f, 20, (byte) 1,
                                false, fecha1, 1500);
                ProductoEnvasado productoE7 = new ProductoEnvasado(007, "Zanahorias 1kg", 0.50f, 0.02f, 2, (byte) 1,
                                false, fecha1, 1500);
                ProductoEnvasado productoE8 = new ProductoEnvasado(8, "Asado 3kg", 90f, 56f, 6, (byte) 0, false, fecha1,
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
                ProductoLimpieza productoL8 = new ProductoLimpieza(8, "Detergente para la ropa 1l", 100f, 50f, 3,
                                (byte) 2);
                //
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

                nuevaTienda.verTienda();
                System.out.println("\n\n\n\nViendo inventario desde main");
                nuevaTienda.verInventario();

                System.out.println(
                                "\n\n\n\n\n\n\n\n\n\n\n\nProbando funcion de actualizar inventario con productos vendidos");
                ProductoLimpieza productvoL88 = new ProductoLimpieza(8, "Detergente para la ropa 1l", 40f, 38f, 999999,
                                (byte) 2);
                Producto[] productos = new Producto[1];

                productos[0] = productvoL88;
                nuevaTienda.actualizarInventarioConProductoVendido(productos);
                nuevaTienda.verTienda();
                System.out.println("Misma actualizacion de inverntario pero ahora una cantidad logica");
                productvoL88.setCantidad(2);
                productos[0] = productvoL88;

                nuevaTienda.actualizarInventarioConProductoVendido(productos);
                nuevaTienda.verTienda();

                System.out.println(
                                "\n\n\nIngrese un numero para continuar las pruebas.");
                entrada.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                Tienda tienda_ = new Tienda();
                tienda_.setCantidad(15000l);
                tienda_.setSaldoEnCaja(500000d);

                do {
                        System.out.println("\n\nMenu para compras:");
                        System.out.println("1 - Ingresar un producto para comprar");
                        System.out.println("2 - Para terminar");
                        System.out.print("Ingrese una opcion: ");

                        opcion = scanner.nextInt();

                        switch (opcion) {
                                case 1:
                                        tienda_.verTienda();
                                        System.out.println("Ingresando nuevo producto");
                                        System.out.print("Ingrese el tipo de producto:"
                                                        + "\n1-Producto Envasado(arroz, fideos, servilletas ,cafe ,aceite...)"
                                                        + "\n2-Producto Bebidas(Agua,CocaCola, Vino, Cerveza...)"
                                                        + "\n3-Producto Limpieza(detergente)");

                                        int num = scanner.nextInt();
                                        if (num == 1) {

                                                ProductoEnvasado producto = new ProductoEnvasado();
                                                ProductoEnvasado.ingresarDatosProductosEnvasado(producto);
                                                producto.setFechaVencimiento(fecha1);
                                                tienda_.comprarProducto(producto);
                                        }
                                        if (num == 2) {
                                                ProductoBebida producto = new ProductoBebida();
                                                ProductoBebida.ingresarDatosProductosBebida(producto);

                                                tienda_.comprarProducto(producto);
                                        }
                                        if (num == 3) {
                                                ProductoLimpieza productoLimpieza = new ProductoLimpieza();
                                                ProductoLimpieza.ingresarDatosProductosLimpieza(productoLimpieza);

                                                tienda_.comprarProducto(productoLimpieza);
                                        }

                                        tienda_.verTienda();
                                        break;
                                case 2:
                                        tienda_.verTienda();
                                        System.out.println("Cerrando venta y terminando...");
                                        break;
                                default:
                                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                                        break;
                        }
                } while (opcion != 2);

                System.out.println(
                                "\n\n\nIngrese un numero para continuar y proceder a realizar mas pruebas");
                entrada.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                System.out.println("\nPruebas de ventas...");
                System.out.println("Se va a vender 1 producto: " + productoL8.getIdentificadorAbstracto()
                                + " " + productoL8.getDescripcion() + " cantidad: " + productoL8.getCantidad());
                nuevaTienda.verTienda();
                System.out.println("\n\nRealiando venta....");
                nuevaTienda.realizarVenta(productoL8, 0f);
                nuevaTienda.getNuevaVenta().verVenta();
                nuevaTienda.verTienda();
                nuevaTienda.getNuevaVenta().verDetalleDeLaVenta();

                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println(
                                "\n\n\nIngrese un numero para continuar y proceder a realizar mas pruebas");
                entrada.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                System.out.println(
                                "Realizand pruebas de la funcion actualizarInventarioConProductoVendido. Se va realizar las pruebas sobre una nueva tienda nuevatienda");
                nuevaTienda.verTienda();

                Tienda nuevaTiendaParte3 = new Tienda();
                ProductoEnvasado productoE111 = new ProductoEnvasado(001, "Arroz 1kg", 12.4f, 10.0f, 5, (byte) 1, false,
                                fecha1, 1500);
                productoE111.setDescuento(5f);
                nuevaTiendaParte3.getInventario().put(productoE111.getIdentificadorAbstracto(), productoE111);
                System.out.println(
                                "Las pruebas se realizan sobre una tienda con un producto, posteriormente se hac hechos todas las pruebas posibles sobre todos los casos!");
                nuevaTienda.verTienda();
                System.out.println("funcion: listarProductosConUtilidadesInferiores(20)");
                nuevaTienda.listarProductosConUtilidadesInferiores(20f);

                System.out.println(
                                "\n\n\nIngrese un numero para continuar y proceder a realizar mas pruebas");
                entrada.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println(
                                "Viendo pruebas de la funcion obtenerComestiblesConMenorDescuento(90), se le va a pasar una tienda con un solo producto");
                nuevaTiendaParte3.verTienda();
                nuevaTiendaParte3.obtenerComestiblesConMenorDescuento(90f);
                System.out.println("\nPrueba 3. Con muchos productos...");
                nuevaTienda.verTienda();
                nuevaTienda.obtenerComestiblesConMenorDescuento(90f);
        }

}
