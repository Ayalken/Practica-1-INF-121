package ejercicio10;

import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final GestionEmpresas gestionEmpresas = new GestionEmpresas();
    private static List<Empresa> empresas;

    public static void main(String[] args) {
        empresas = gestionEmpresas.cargarEmpresas();
        
        System.out.println("📊 Sistema de Gestión de Empresas e Instituciones 📊");
        int opcion = -1;
        
        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                ejecutarOpcion(opcion);
            } else {
                System.out.println("\n🚫 Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); 
                opcion = -1;
            }
        } while (opcion != 0);        
        System.out.println("\n👋 Programa finalizado. ¡Hasta pronto!");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión ---");
        System.out.println("1. Agregar nueva empresa");
        System.out.println("2. Mostrar todas las empresas");
        System.out.println("3. Buscar empresa por nombre");
        System.out.println("0. Salir y Guardar");
        System.out.print("Seleccione una opción: ");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarEmpresa();
                break;
            case 2:
                mostrarEmpresas();
                break;
            case 3:
                buscarEmpresa();
                break;
            case 0:
                gestionEmpresas.guardarEmpresas(empresas);
                break;
            default:
                System.out.println("Opción no reconocida. Intente de nuevo.");
                break;
        }
    }

    private static void agregarEmpresa() {
        System.out.println("\n--- Agregar Empresa ---");
        System.out.print("Nombre de la Empresa: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Rubro (Ej: Tecnología, Retail, Educación): ");
        String rubro = scanner.nextLine();

        int numEmpleados = -1;
        while (numEmpleados < 0) {
            System.out.print("Número de Empleados: ");
            if (scanner.hasNextInt()) {
                numEmpleados = scanner.nextInt();
            } else {
                System.out.println("Número de empleados inválido. Debe ser un número entero.");
            }
            scanner.nextLine(); 
        }
        Empresa nuevaEmpresa = new Empresa(nombre, rubro, numEmpleados);
        empresas.add(nuevaEmpresa);
        System.out.println("✅ Empresa '" + nombre + "' añadida con éxito.");
    }

    private static void mostrarEmpresas() {
        System.out.println("\n--- Listado de Empresas (" + empresas.size() + ") ---");
        if (empresas.isEmpty()) {
            System.out.println("No hay empresas registradas.");
            return;
        }
        for (Empresa empresa : empresas) {
            System.out.println(empresa);
        }
    }

    private static void buscarEmpresa() {
        System.out.println("\n--- Buscar Empresa ---");
        if (empresas.isEmpty()) {
            System.out.println("No hay empresas registradas para buscar.");
            return;
        }
        System.out.print("Ingrese el nombre de la empresa a buscar: ");
        String nombreBusqueda = scanner.nextLine();

        Empresa encontrada = gestionEmpresas.buscarEmpresa(nombreBusqueda, empresas);

        if (encontrada != null) {
            System.out.println("⭐ Empresa Encontrada:");
            System.out.println(encontrada);
        } else {
            System.out.println("❌ Empresa con nombre '" + nombreBusqueda + "' no encontrada.");
        }
    }
}