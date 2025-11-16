package Ejercicio8;

import java.util.ArrayList;

public class Fraternidad {

    private String nombre;
    private String encargado;
    private ArrayList<Bailarin> bailarines;

    public Fraternidad(String nombre, String encargado, ArrayList<Bailarin> bailarines) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.bailarines = bailarines;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEncargado() {
        return encargado;
    }
    public ArrayList<Bailarin> getBailarines() {
        return bailarines;
    }
    public void agregarBailarin(Bailarin b) {
        bailarines.add(b);
    }
    @Override
    public String toString() {
        return nombre + " (Encargado: " + encargado + ")";
    }
}
