package Introduccion_a_POO.Ejercicio7;
public class Main {
    public static void main(String[] args) {
        Mascota m1 = new Mascota("Firulais", "Perro");
        Mascota m2 = new Mascota("Michi", "Gato");

        m1.alimentar();
        m1.jugar();
        m1.mostrar();

        m2.jugar();
        m2.alimentar();
        m2.mostrar();
    }
}