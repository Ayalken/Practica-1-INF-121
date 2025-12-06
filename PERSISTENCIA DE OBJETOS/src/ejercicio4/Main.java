package ejercicio4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Estudiante e1 = new Estudiante("101", "Ana", "García", "López", 20);
        Estudiante e2 = new Estudiante("102", "Luis", "Pérez", "Molina", 21);
        Estudiante e3 = new Estudiante("103", "Marta", "Ruiz", "Velasco", 20);
        
        ArchiNota gestor = new ArchiNota("notas.json");
        gestor.listarNotas();

        System.out.println("\n--- PRUEBA DE AGREGAR VARIAS NOTAS (b) ---");
        try {
            ArrayList<Nota> nuevasNotas = new ArrayList<>();
            nuevasNotas.add(new Nota("Matematicas", 95.0, e1)); 
            nuevasNotas.add(new Nota("Fisica", 88.0, e1));     
            
            nuevasNotas.add(new Nota("Matematicas", 70.0, e2));
            nuevasNotas.add(new Nota("Historia", 95.0, e2)); 
            
            nuevasNotas.add(new Nota("Fisica", 85.0, e3));
            nuevasNotas.add(new Nota("Historia", 80.0, e3)); 

            gestor.agregarVariasNotas(nuevasNotas);
        } catch (Exception e) {
            System.err.println("ERROR en agregarVariasNotas: " + e.getMessage());
        }
        
        gestor.listarNotas();

        System.out.println("\n--- PRUEBA DE OBTENER PROMEDIO (c) ---");
        try {
            double promedio = gestor.obtenerPromedioNotas();
            System.out.printf("El promedio de todas las notas es: %.2f\n", promedio);
        } catch (Exception e) {
            System.err.println("ERROR en obtenerPromedioNotas: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA DE BUSCAR MEJOR NOTA (d) ---");
        try {
            ArrayList<Estudiante> mejores = gestor.buscarMejorNota();
            
            double notaMax = 95.0; 
            
            System.out.println("Estudiantes con la mejor nota (" + notaMax + "):"); 
            
            for (Estudiante e : mejores) {
                System.out.println("- " + e.getNombreCompleto() + " (RU: " + e.getRu() + ")");
            }
        } catch (Exception e) {
            System.err.println("ERROR en buscarMejorNota: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA DE ELIMINAR NOTAS POR MATERIA (e) ---");
        try {
            gestor.eliminarNotasPorMateria("Fisica");
        } catch (Exception e) {
            System.err.println("ERROR en eliminarNotasPorMateria: " + e.getMessage());
        }
        
        gestor.listarNotas();
    }
}