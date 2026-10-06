package Ejercicio1;
import java.util.ArrayList;
import java.util.List;

public class HistorialCompras {

    private List<String> compras;

    public HistorialCompras() {
        compras = new ArrayList<>();
    }

    public void registrarCompra(double total) {
        compras.add("compra realizada total " + total);
    }

    public List<String> obtenerCompras() {
        return compras;
    }
}