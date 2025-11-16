package Ejercicio14;

import java.util.ArrayList;

class Empresa {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Empresa(String nombre, ArrayList<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void mostrarEmpresa() {
        System.out.println("Empresa: " + nombre);
        System.out.println("Empleados:");
        for (Empleado e : empleados) {
            System.out.println(" - " + e);
        }
    }

    public Empleado buscarEmpleado(String nombre) {
        for (Empleado e : empleados) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public void eliminarEmpleado(String nombre) {
        Empleado encontrado = buscarEmpleado(nombre);
        if (encontrado != null) {
            empleados.remove(encontrado);
            System.out.println("Empleado eliminado: " + nombre);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public double promedioSalarios() {
        if (empleados.isEmpty()) return 0;

        double suma = 0;
        for (Empleado e : empleados) {
            suma += e.getSalario();
        }
        return suma / empleados.size();
    }

    public void empleadosConSalarioMayorA(double valor) {
        System.out.println("Empleados con salario mayor a " + valor + ":");
        for (Empleado e : empleados) {
            if (e.getSalario() > valor) {
                System.out.println(" - " + e);
            }
        }
    }
}