package Introduccion_a_POO.Ejercicio5;

public class Main {
    public static void main(String[] args) {
        // (a) Instanciar dos personas
        Persona p1 = new Persona("Juan", "Perez", "Lopez", 20);
        Persona p2 = new Persona("Ana", "Sanchez", "Torrez", 15);

        // (e) Usar métodos
        p1.mostrarDatos();
        System.out.println("¿Mayor de edad? " + p1.mayorDeEdad());

        p2.mostrarDatos();
        System.out.println("¿Mayor de edad? " + p2.mayorDeEdad());

        p2.modificarEdad(19);
        p2.mostrarDatos();
    }
}