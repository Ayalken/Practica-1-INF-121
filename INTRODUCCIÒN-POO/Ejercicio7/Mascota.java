package Introduccion_a_POO.Ejercicio7;

public class Mascota {
    private String nombre;
    private String tipo;
    private int energia;

    public Mascota(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.energia = 50;
    }

    // (a) Alimentar
    public void alimentar() {
        energia += 20;
        if (energia > 100) energia = 100;
        System.out.println(nombre + " fue alimentado. Energía: " + energia);
    }

    // (b) Jugar
    public void jugar() {
        energia -= 15;
        if (energia < 0) energia = 0;
        System.out.println(nombre + " jugó. Energía: " + energia);
    }

    // (c) Mostrar datos
    public void mostrar() {
        System.out.println("Nombre: " + nombre + ", Tipo: " + tipo + ", Energía: " + energia);
    }
}