package Ejercicio4;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;
    private int capacidadMaxima;

    public Inventario(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) throws Exception {

        if (productos.size() >= capacidadMaxima) {
            throw new Exception("Inventario lleno. Máxima capacidad: " + capacidadMaxima);
        }

        if (p.getPrecio() < 0 || p.getStock() < 0) {
            throw new Exception("Precio o stock no pueden ser negativos.");
        }

        for (Producto prod : productos) {
            if (prod.getCodigo().equals(p.getCodigo())) {
                throw new Exception("El código '" + p.getCodigo() + "' ya existe.");
            }
        }

        productos.add(p);
    }

    public Producto buscarProducto(String codigo)
            throws ProductoNoEncontradoException {

        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }

        throw new ProductoNoEncontradoException("Producto con código " + codigo + " no encontrado.");
    }

    public void venderProducto(String codigo, int cantidad)
            throws ProductoNoEncontradoException, StockInsuficienteException {

        Producto p = buscarProducto(codigo);

        if (cantidad <= p.getStock()) {
            p.reducirStock(cantidad);
        } else {
            throw new StockInsuficienteException(
                    "Stock insuficiente. Disponible: " + p.getStock() + ", solicitado: " + cantidad);
        }
    }
}
