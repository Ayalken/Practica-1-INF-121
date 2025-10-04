package Ejercicio13;

public class Main{
    public static void main(String[] args) {
        Chef chef1 = new Chef("pikachu", 5000, 20, "Francés", 50);
        Mesero mesero1 = new Mesero("Agumon", 2500, 300, 15, 20);
        Mesero mesero2 = new Mesero("Dedenei", 2800, 500, 10, 25);
        Administrativo admin1 = new Administrativo("Skipper", 4000, "Gerente");
        Administrativo admin2 = new Administrativo("Gojo", 3500, "Contador");

        Empleado[] empleados = {chef1, mesero1, mesero2, admin1, admin2};

        float X = 2500;
        System.out.println("\nEmpleados con sueldo base igual a " + X + ":");
        for (Empleado e : empleados) {
            if (e.getSueldoMes() == X) {
                System.out.println(e.getNombre() + " -> Sueldo Base: " + e.getSueldoMes());
            }
        }

        System.out.println("\nSueldo total de todos los empleados:");
        for (Empleado e : empleados) {
            System.out.println(e.toString());
        }
    }
}

