package Introduccion_a_POO.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("Galleta", 2, 10);
        p1.vender(3);
        p1.mostrarStock();
        p1.reabastecer(5);
        p1.mostrarStock();
    }
}