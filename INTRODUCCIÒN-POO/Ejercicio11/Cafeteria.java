package Introduccion_a_POO.Ejercicio11;

public class Cafeteria {
    public static void main(String[] args) {
        Producto p1 = new Producto("Café Americano", 25.5);
        Pedido ped1 = new Pedido(1, "Registrado");

        p1.mostrarInfo();
        ped1.mostrarInfo();
    }
}