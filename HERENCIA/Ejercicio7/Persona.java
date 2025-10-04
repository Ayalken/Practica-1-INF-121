package Herencia.Ejercicio7;

public class Persona {
    protected String nombre;
    protected String paterno;
    protected String materno;
    protected int edad;

    public Persona(String nombre, String paterno, String materno, int edad) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + " " + paterno + " " + materno + ", Edad: " + edad);
    }

    public int getEdad() {
        return edad;
    }
}