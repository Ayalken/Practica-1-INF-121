package ejercicio9;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArchZoo gestor = new ArchZoo("zoos.json");
        
        Zoologico z1 = new Zoologico(1, "Zoo Metropolitano"); 
        Zoologico z2 = new Zoologico(2, "Zoo Regional"); 
        Zoologico z3 = new Zoologico(3, "Zoo Vacío"); 
        
        Animal a1 = new Animal("Felino", "León", 5);
        Animal a2 = new Animal("Ave", "Loro", 10);
        Animal a3 = new Animal("Reptil", "Serpiente", 3);
        Animal a4 = new Animal("Felino", "Tigre", 2); 

        z1.adicionarAnimal(a1); 
        z1.adicionarAnimal(a4); 
        
        z2.adicionarAnimal(a2); 
        z2.adicionarAnimal(a3); 
        z2.adicionarAnimal(new Animal("Mamífero", "Mono", 7)); 
        
        try {
            gestor.adicionar(z1);
            gestor.adicionar(z2);
            gestor.adicionar(z3); 
        } catch (Exception e) {
            System.err.println("ERROR al añadir zoológicos: " + e.getMessage());
        }
        
        gestor.listar();

        System.out.println("\n--- PRUEBA b) Mayor Variedad de Animales ---");
        try {
            ArrayList<Zoologico> mayores = gestor.listarZoosMayorVariedad();
            System.out.println("b) Zoológico(s) con mayor variedad (" + mayores.get(0).getNroVariedades() + "):");
            mayores.forEach(z -> System.out.println("- " + z.getNombre())); 
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("\n--- PRUEBA d) Mostrar Animales de Especie 'Felino' ---");
        gestor.mostrarAnimalesPorEspecie("Felino");
        
        System.out.println("\n--- PRUEBA c) Listar y Eliminar Zoológicos Vacíos ---");
        ArrayList<Zoologico> eliminados = gestor.listarZoosVaciosYEliminar();
        System.out.println("c) Zoológicos eliminados por estar vacíos:");
        
        gestor.listar();

        System.out.println("\n--- PRUEBA e) Mover animales de Z1 a Z2 ---");
        try {
            gestor.moverAnimales(1, 2);
        } catch (Exception e) {
            System.err.println("ERROR al mover: " + e.getMessage());
        }
        
        gestor.listar(); 
    }
}