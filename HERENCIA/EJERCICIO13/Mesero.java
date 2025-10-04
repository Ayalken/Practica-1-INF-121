package Ejercicio13;

public class Mesero extends Empleado {
    private double propina;
    private int horaExtra;
    private float sueldoHora;

    public Mesero(String nombre, float sueldoMes, double propina, int horaExtra, float sueldoHora) {
        super(nombre, sueldoMes);
        this.propina = propina;
        this.horaExtra = horaExtra;
        this.sueldoHora = sueldoHora;
    }

    @Override
    public float sueldoTotal() {
        return (float)(sueldoMes + (horaExtra * sueldoHora) + propina);
    }

    @Override
    public String toString() {
        return "Mesero: " + nombre + " | Sueldo Total: " + sueldoTotal();
    }
}

