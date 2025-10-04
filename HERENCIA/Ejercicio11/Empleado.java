package Herencia.Ejercicio11;

public class Empleado {
    private double sueldo;
    private int aniosExp;

    public Empleado(double sueldo, int aniosExp) {
        this.sueldo = sueldo;
        this.aniosExp = aniosExp;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getAniosExp() {
        return aniosExp;
    }
}