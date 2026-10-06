package Ejercicio1;

import java.util.List;
import java.util.Scanner;

public class VistaCompras implements AutoCloseable {

    private Scanner scanner;

    public VistaCompras() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("opciones");
        System.out.println("1 listar productos");
        System.out.println("2 agregar producto al carrito");
        System.out.println("3 ver carrito");
        System.out.println("4 eliminar producto del carrito");
        System.out.println("5 aplicar descuento");
        System.out.println("6 calcular envio");
        System.out.println("7 ver historial de compras");
        System.out.println("8 realizar compra");
        System.out.println("9 salir");
    }

    public String solicitarOpcion() {
        System.out.print("seleccione una opcion ");
        return scanner.nextLine();
    }

    public int solicitarNumeroProducto() {
        System.out.print("ingrese el numero del producto ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int solicitarNumeroCarrito() {
        System.out.print("ingrese el numero del producto del carrito ");
        return Integer.parseInt(scanner.nextLine());
    }

    public double solicitarDescuento() {
        System.out.print("ingrese el porcentaje de descuento ");
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("lista de productos");

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + " " + producto.getNombre() + " " + producto.getPrecio());
        }
    }

    public void mostrarCarrito(CarritoCompras carrito) {
        if (carrito.estaVacio()) {
            System.out.println("el carrito esta vacio");
        } else {
            System.out.println("productos del carrito");

            List<Producto> productos = carrito.obtenerProductos();

            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                System.out.println((i + 1) + " " + producto.getNombre() + " " + producto.getPrecio());
            }

            System.out.println("subtotal " + carrito.calcularSubtotal());
            System.out.println("descuento " + carrito.getDescuento());
            System.out.println("envio " + carrito.getEnvio());
            System.out.println("total " + carrito.calcularTotal());
        }
    }

    public void mostrarHistorial(List<String> compras) {
        if (compras.isEmpty()) {
            System.out.println("no hay compras en el historial");
        } else {
            System.out.println("historial de compras");

            for (String compra : compras) {
                System.out.println(compra);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void close() {
        scanner.close();
    }
}