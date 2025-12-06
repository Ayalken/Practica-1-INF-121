package ejercicio7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArchNiño gestor = new ArchNiño("ninos.json");
        
        System.out.println("\n--- PRUEBA a) ADICIONAR NIÑOS ---");
        
        Niño n1 = new Niño("Ana", "García", "López", 111, 5, 18.5, 106.0); 
        Niño n2 = new Niño("Luis", "Pérez", "Molina", 222, 7, 16.0, 114.0);
        Niño n3 = new Niño("Marta", "Ruiz", "Velasco", 333, 5, 19.0, 120.0); 
        Niño n4 = new Niño("Carlos", "Díaz", "Roca", 444, 10, 27.5, 132.0); 
        
        gestor.adicionar(n1);
        gestor.adicionar(n2);
        gestor.adicionar(n3);
        gestor.adicionar(n4);
        
        gestor.listar();

        System.out.println("\n--- PRUEBA b) Contar Niños con Peso Adecuado ---");
        int countAdecuados = gestor.contarNiñosConPesoAdecuado();
        System.out.println("b) Cantidad de niños con peso adecuado: " + countAdecuados); 
        
        System.out.println("\n--- PRUEBA c) Mostrar Niños Inadecuados (Peso O Talla) ---");
        ArrayList<Niño> inadecuados = gestor.mostrarNiñosInadecuados();
        System.out.println("c) Niños que NO tienen peso o talla adecuada (o ambos):");
        inadecuados.forEach(System.out::println); 

        System.out.println("\n--- PRUEBA d) Promedio de Edad ---");
        try {
            double promedioEdad = gestor.determinarPromedioEdad();
            System.out.printf("d) Promedio de edad de los niños: %.2f años\n", promedioEdad);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        int ciBuscado = 222;
        System.out.println("\n--- PRUEBA e) Buscar Niño por Carnet (CI: " + ciBuscado + ") ---");
        try {
            Niño niñoEncontrado = gestor.buscarNiñoPorCarnet(ciBuscado);
            System.out.println("e) Niño encontrado: " + niñoEncontrado);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA f) Niños con la Talla Más Alta ---");
        try {
            ArrayList<Niño> masAltos = gestor.mostrarNiñosTallaMasAlta();
            System.out.println("f) Niño(s) con la talla más alta (" + masAltos.get(0).getTalla() + " cm):");
            masAltos.forEach(n -> System.out.println("- " + n.getNombreCompleto())); 
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}