package ejercicio2;

public class Trabajador {
    private String nombre;
    private int carnet;
    private double salario;

    public Trabajador(String nombre, int carnet, double salario) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.salario = salario;
    }

    public Trabajador() {
        nombre = "";
        carnet = 0;
        salario = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCarnet() {
        return carnet;
    }

    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", carnet=" + carnet + ", salario=" + salario + '}';
    }
}