package Ejercicio11;

public class Pasajero {
    private String nombre;
    private int edad;
    private String genero;

    public Pasajero(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public void masMas() { 
        this.edad++;
    }

    public void menosMenos() { 
        this.edad--;
    }

    public void mostrar() {
        System.out.println("Pasajero: " + this.nombre + ", Edad: " + this.edad + ", Género: " + this.genero);
    }

    public String getGenero() {
        return this.genero;
    }
}
