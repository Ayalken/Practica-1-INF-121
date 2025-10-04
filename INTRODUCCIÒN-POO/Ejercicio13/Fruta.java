package Introduccion_a_POO.Ejercicio13;
import java.util.Arrays;

public class Fruta {
    private String nombre;
    private String tipo;
    private int nroVitaminas;
    private String[] v = new String[30]; 

    public Fruta(String nombre, String tipo, String[] vitaminas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nroVitaminas = vitaminas.length;
        for (int i = 0; i < vitaminas.length; i++) {
            v[i] = vitaminas[i];
        }
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getNroVitaminas() { return nroVitaminas; }
    public String[] getVitaminas() { return Arrays.copyOf(v, nroVitaminas); }

    public void mostrarVitaminas() {
        System.out.println("Fruta: " + nombre + " (" + tipo + ") - Vitaminas: " + Arrays.toString(getVitaminas()));
    }
}