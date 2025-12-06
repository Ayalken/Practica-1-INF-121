package ejercicio1;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestionCharango gc = new GestionCharango();
        
        List<Charango> charangos = gc.cargarCharangos();

        if (charangos.isEmpty()) {
            System.out.println("\nCreando datos de prueba...");
            
            boolean[] c1 = {true, true, true, true, true, true, true, true, true, false};  
            charangos.add(new Charango("Nogal", 10, c1));

            boolean[] c2 = {false, false, true, false, false, false, false, false, true, true}; 
            charangos.add(new Charango("Palisandro", 10, c2));

            boolean[] c3 = {true, true, true, true, true, true, true, true, true, true};  
            charangos.add(new Charango("Nogal", 8, c3));

            boolean[] c4 = {false, false, false, false, false, false, false, false, false, true};  
            charangos.add(new Charango("Koa", 12, c4));

            boolean[] c5 = {true, false, false, true, false, false, false, false, true, true};  
            charangos.add(new Charango("Palisandro", 10, c5));

            boolean[] c6 = {true, true, true, true, true, true, true, true, true, true};  
            charangos.add(new Charango("Ébano", 10, c6));
            
            gc.guardarCharangos(charangos);
            System.out.println("\n--- Lista Inicial ---");
            charangos.forEach(System.out::println);
        } else {
             System.out.println("\n--- Lista Cargada Desde Archivo ---");
             charangos.forEach(System.out::println);
        }

        System.out.println("\n\n--- b) Eliminando Charangos con más de 6 Cuerdas Malas ---");
        gc.eliminarCharangosMalos(charangos);
        
        System.out.println("\n--- Lista después de la eliminación ---");
        charangos.forEach(System.out::println);
        gc.guardarCharangos(charangos); 
        
        String materialBuscado = "Nogal";
        System.out.println("\n\n--- c) Charangos de Material: " + materialBuscado + " ---");
        List<Charango> charangosNogal = gc.listarPorMaterial(charangos, materialBuscado);
        if (charangosNogal.isEmpty()) {
            System.out.println("No se encontraron charangos de material " + materialBuscado);
        } else {
            charangosNogal.forEach(System.out::println);
        }

        System.out.println("\n\n--- d) Charangos con 10 Cuerdas ---");
        List<Charango> charangos10Cuerdas = gc.buscarPorNroCuerdas(charangos);
        if (charangos10Cuerdas.isEmpty()) {
            System.out.println("No se encontraron charangos con 10 cuerdas.");
        } else {
            charangos10Cuerdas.forEach(System.out::println);
        }
        
        System.out.println("\n\n--- e) Ordenando Charangos por Material ---");
        gc.ordenarPorMaterial(charangos);
        
        System.out.println("\n--- Lista Ordenada ---");
        charangos.forEach(System.out::println);
        gc.guardarCharangos(charangos); 
    }
}