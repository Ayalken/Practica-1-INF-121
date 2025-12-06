package ejercicio10;

public class Empresa {
    private String nombre;
    private String rubro;
    private int numeroEmpleados;

    public Empresa(String nombre, String rubro, int numeroEmpleados) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Rubro: " + rubro + " | Empleados: " + numeroEmpleados;
    }
}