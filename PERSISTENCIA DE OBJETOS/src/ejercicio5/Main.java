package ejercicio5;

public class Main {
    public static void main(String[] args) {
        
        ArchFarmacia gestor = new ArchFarmacia("farmacias.json");
        
        Medicamento m1 = new Medicamento("Paracetamol", 1, "Dolor", 2.5);
        Medicamento m2 = new Medicamento("Vick", 2, "Tos", 5.0);
        Medicamento m3 = new Medicamento("Tapsin", 3, "Resfrios", 3.5);
        Medicamento m4 = new Medicamento("Amoxicilina", 4, "Antibiotico", 10.0);
        Medicamento m5 = new Medicamento("MielToss", 5, "Tos", 4.0);
        Medicamento m6 = new Medicamento("Ibuprofeno", 6, "Dolor", 3.0);
        
        Farmacia fA = new Farmacia("Farmacia A", 1, "Av. Siempre Viva 100"); 
        fA.adicionarMedicamento(m1);
        fA.adicionarMedicamento(m2);
        fA.adicionarMedicamento(m3); 
        
        Farmacia fB = new Farmacia("Farmacia B", 2, "Calle Bicentenario 50"); 
        fB.adicionarMedicamento(m4);
        fB.adicionarMedicamento(m5); 
        fB.adicionarMedicamento(m3); 
        
        Farmacia fZ = new Farmacia("Farmacia C", 3, "Pza. Murillo 20"); 
        fB.adicionarMedicamento(m6);
        
        try {
            gestor.adicionar(fA);
            gestor.adicionar(fB);
            gestor.adicionar(fZ);
        } catch (Exception e) {
            System.err.println("ERROR al añadir farmacias: " + e.getMessage());
        }
        gestor.listar();

        
        System.out.println("\n--- PRUEBA a) Mostrar medicamentos para 'Tos' en Sucursal 1 ---");
        try {
            gestor.mostrarMedicamentosTos(1);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("\n--- PRUEBA b) Sucursales con 'Tapsin' ---");
        gestor.mostrarSucursalesConMedicamento("Tapsin");
        
        System.out.println("\n--- PRUEBA c) Buscar medicamentos por tipo 'Dolor' ---");
        gestor.buscarMedicamentosPorTipo("Dolor");
        
        System.out.println("\n--- PRUEBA d) Ordenar farmacias por dirección ---");
        try {
            gestor.ordenarFarmaciasPorDireccion();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("\n--- PRUEBA e) Mover medicamentos 'Tos' de Sucursal 1 a Sucursal 3 ---");
        try {
            gestor.moverMedicamentosPorTipo("Tos", 1, 3);
        } catch (Exception e) {
            System.err.println("ERROR al mover: " + e.getMessage());
        }
    }
}