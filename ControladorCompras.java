package Ejercicio1;
public class ControladorCompras {

    private CatalogoProductos catalogo;
    private CarritoCompras carrito;
    private HistorialCompras historial;
    private VistaCompras vista;

    public ControladorCompras(CatalogoProductos catalogo, CarritoCompras carrito,
                              HistorialCompras historial, VistaCompras vista) {
        this.catalogo = catalogo;
        this.carrito = carrito;
        this.historial = historial;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();

            switch (opcion) {
                case "1":
                    vista.mostrarProductos(catalogo.obtenerProductos());
                    break;

                case "2":
                    agregarProducto();
                    break;

                case "3":
                    carrito.calcularEnvio();
                    vista.mostrarCarrito(carrito);
                    break;

                case "4":
                    eliminarProducto();
                    break;

                case "5":
                    double descuento = vista.solicitarDescuento();
                    carrito.aplicarDescuento(descuento);
                    vista.mostrarMensaje("descuento aplicado");
                    break;

                case "6":
                    carrito.calcularEnvio();
                    vista.mostrarMensaje("costo de envio " + carrito.getEnvio());
                    break;

                case "7":
                    vista.mostrarHistorial(historial.obtenerCompras());
                    break;

                case "8":
                    realizarCompra();
                    break;

                case "9":
                    vista.mostrarMensaje("saliendo");
                    break;

                default:
                    vista.mostrarMensaje("opcion no valida");
            }

        } while (!opcion.equals("9"));
    }

    private void agregarProducto() {
        int numero = vista.solicitarNumeroProducto();
        Producto producto = catalogo.buscarProducto(numero);

        if (producto != null) {
            carrito.agregarProducto(producto);
            vista.mostrarMensaje("producto agregado al carrito");
        } else {
            vista.mostrarMensaje("producto no valido");
        }
    }

    private void eliminarProducto() {
        int numero = vista.solicitarNumeroCarrito();

        if (carrito.eliminarProducto(numero)) {
            vista.mostrarMensaje("producto eliminado del carrito");
        } else {
            vista.mostrarMensaje("producto no valido");
        }
    }

    private void realizarCompra() {
        if (carrito.estaVacio()) {
            vista.mostrarMensaje("el carrito esta vacio");
        } else {
            double total = carrito.calcularTotal();
            historial.registrarCompra(total);
            carrito.vaciarCarrito();
            vista.mostrarMensaje("compra realizada");
            vista.mostrarMensaje("total pagado " + total);
        }
    }
}