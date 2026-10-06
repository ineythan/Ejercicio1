package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class CatalogoProductos {

    private List<Producto> productos;

    public CatalogoProductos() {
        productos = new ArrayList<>();
        productos.add(new Producto("harrison diaz luque", 25.50));
        productos.add(new Producto("yoseph flores durand", 18.00));
        productos.add(new Producto("sonia alexandra valeriano flores", 32.50));
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public Producto buscarProducto(int numero) {
        if (numero >= 1 && numero <= productos.size()) {
            return productos.get(numero - 1);
        }

        return null;
    }
}