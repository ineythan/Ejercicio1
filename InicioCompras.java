package Ejercicio1;
public class InicioCompras {

    public static void main(String[] args) {

        CatalogoProductos catalogo = new CatalogoProductos();
        CarritoCompras carrito = new CarritoCompras();
        HistorialCompras historial = new HistorialCompras();

        try (VistaCompras vista = new VistaCompras()) {
            ControladorCompras controlador =
                    new ControladorCompras(catalogo, carrito, historial, vista);

            controlador.iniciar();
        }
    }
}