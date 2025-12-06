package ejercicio8;

import java.util.ArrayList;

public class Main {
    
    private static final String FECHA_ACTUAL_MANUAL = "2025-12-05"; 
    public static void main(String[] args) {
        
        ArchRefri gestor = new ArchRefri("refriManual.json");
        
        System.out.println("\n[Fecha de referencia actual: " + FECHA_ACTUAL_MANUAL + "]");
        System.out.println("--- PRUEBA a) ADICIONAR ALIMENTOS ---");

        String vencidoAyer = "2025-12-04"; 
        String venceManana = "2025-12-06"; 
        String pasado = "2025-01-01"; 
        String lejano = "2026-10-01"; 
        String cero = "2026-01-01"; 

        try {
            gestor.adicionar(new Alimento("Leche", vencidoAyer, 5)); 
            gestor.adicionar(new Alimento("Pan", venceManana, 10)); 
            gestor.adicionar(new Alimento("Queso", lejano, 25)); 
            gestor.adicionar(new Alimento("Yogur", pasado, 2)); 
            gestor.adicionar(new Alimento("Huevo", cero, 0)); 
        } catch (Exception e) {
            System.err.println("ERROR al adicionar: " + e.getMessage());
        }
        
        gestor.listar();

        System.out.println("\n--- PRUEBA a) MODIFICAR (Huevo: Cantidad 0 a 1) ---");
        try {
            gestor.modificarCantidadPorNombre("Huevo", 1);
        } catch (Exception e) {
            System.err.println("ERROR al modificar: " + e.getMessage());
        }
        
        String fechaLimite = "2026-01-01"; 
        System.out.println("\n--- PRUEBA b) Caducados Antes de " + fechaLimite + " ---");
        ArrayList<Alimento> caducados = gestor.mostrarCaducadosAntesDe(fechaLimite);
        System.out.println("b) Alimentos caducados antes de " + fechaLimite + ":");
        caducados.forEach(System.out::println); 
        
        System.out.println("\n--- PRUEBA d) Alimentos Vencidos (al día de " + FECHA_ACTUAL_MANUAL + ") ---");
        ArrayList<Alimento> vencidos = gestor.buscarAlimentosVencidos(FECHA_ACTUAL_MANUAL);
        System.out.println("d) Alimentos ya vencidos:");
        vencidos.forEach(System.out::println); 
        
        System.out.println("\n--- PRUEBA e) Alimento con Más Cantidad ---");
        try {
            Alimento masCantidad = gestor.mostrarAlimentoConMasCantidad();
            System.out.println("e) Alimento con más cantidad: " + masCantidad);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- -.................. c) Eliminar Alimentos Cantidad 0 ---");
        try {
             gestor.modificarCantidadPorNombre("Huevo", 0);
        } catch (Exception e) {
            System.err.println("ERROR: no se agrego producto" );
        }

        int eliminados = gestor.eliminarAlimentosCantidadCero();
        System.out.println("c) Se eliminaron " + eliminados + " alimentos con cantidad 0.");
        gestor.listar(); 
        
        System.out.println("\n--- PRUEBA a) ELIMINAR (Pan) ---");
        try {
            gestor.eliminarPorNombre("Pan");
        } catch (Exception e) {
            System.err.println("ERROR al eliminar: " + e.getMessage());
        }
        gestor.listar();
    }
}