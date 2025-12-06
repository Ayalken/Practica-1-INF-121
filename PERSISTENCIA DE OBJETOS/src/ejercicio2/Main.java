package ejercicio2;

public class Main {
    public static void main(String[] args) {
        ArchivoTrabajador gestor = new ArchivoTrabajador();
        gestor.listarTrabajadores();

        System.out.println("\n--- PRUEBA DE AGREGAR TRABAJADORES ---");
        try {
            gestor.guardarTrabajador(new Trabajador("Ana Lopez", 101, 3000.0));
            gestor.guardarTrabajador(new Trabajador("Luis Perez", 102, 5500.0));
            gestor.guardarTrabajador(new Trabajador("Carlos M.", 103, 4000.0));

        } catch (Exception e) {
            System.err.println("ERROR en guardarTrabajador: " + e.getMessage());
        }
        
        gestor.listarTrabajadores();

        System.out.println("\n--- PRUEBA DE AUMENTAR SALARIO (aumentaSalario) ---");
        try {
            gestor.aumentaSalario(500, 101);
        } catch (Exception e) {
            System.err.println("ERROR en aumentaSalario: " + e.getMessage());
        }
        
        gestor.listarTrabajadores();

        System.out.println("\n--- PRUEBA DE BUSCAR MAYOR SALARIO (buscarMayorSalario) ---");
        try {
            Trabajador mayor = gestor.buscarMayorSalario();
            System.out.println("El trabajador con mayor salario es: " + mayor);
        } catch (Exception e) {
            System.err.println("ERROR en buscarMayorSalario: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA DE ORDENAR POR SALARIO (ordenarPorSalario) ---");
        try {
            gestor.ordenarPorSalario();
        } catch (Exception e) {
            System.err.println("ERROR en ordenarPorSalario: " + e.getMessage());
        }
    }
}