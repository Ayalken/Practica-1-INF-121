package Introduccion_a_POO.Ejercicio5;

public class Persona {
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;

    public Persona(String nombre, String paterno, String materno, int edad) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    // (b) Mostrar datos
    public void mostrarDatos() {
        System.out.println(nombre + " " + paterno + " " + materno + ", Edad: " + edad);
    }

    // (c) Mayor de edad
    public boolean mayorDeEdad() {
        return edad >= 18;
    }

    // (d) Modificar edad
    public void modificarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }
}