package Ejercicio14;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Empleado> lista = new ArrayList<>();

        Empresa emp = new Empresa("TechCorp", lista);

        emp.agregarEmpleado(new Empleado("Ana", "Programadora", 4000));
        emp.agregarEmpleado(new Empleado("Luis", "Diseñador", 3500));
        emp.agregarEmpleado(new Empleado("Carla", "Gerente", 6000));

        emp.mostrarEmpresa();

        System.out.println("\nBuscando empleado 'Luis':");
        System.out.println(emp.buscarEmpleado("Luis"));

        System.out.println("\nEliminando 'Ana':");
        emp.eliminarEmpleado("Ana");

        emp.mostrarEmpresa();

        System.out.println("\nPromedio salarial: " + emp.promedioSalarios());

        System.out.println("\nEmpleados con salario mayor a 3800:");
        emp.empleadosConSalarioMayorA(3800);
    }
}