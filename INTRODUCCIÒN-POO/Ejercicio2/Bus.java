package Introduccion_a_POO.Ejercicio2;

public class Bus {
    private int pasajeros;
    private int asientos;
    private double costo;

    public Bus(int asientos) {
        this.asientos = asientos;
        this.pasajeros = 0;
        this.costo = 1.50;
    }

    // (a) Subir pasajeros
    public void subirPasajeros(int cantidad) {
        if (cantidad <= (asientos - pasajeros)) {
            pasajeros += cantidad;
            System.out.println(cantidad + " pasajeros subieron al bus.");
        } else {
            System.out.println("No hay suficientes asientos disponibles.");
        }
    }

    // (b) Cobrar pasaje
    public void cobrarPasaje() {
        double total = pasajeros * costo;
        System.out.println("El costo total del pasaje es: " + total);
    }

    // (c) Mostrar asientos disponibles
    public void mostrarAsientosDisponibles() {
        System.out.println("Asientos disponibles: " + (asientos - pasajeros));
    }
}