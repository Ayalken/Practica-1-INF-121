package Herencia.Ejercicio5;

public class Main {
    public static void main(String[] args) {
        // a) Instanciar un vehículo de cada tipo
        Bus bus = new Bus("Carlos", "BUS-123", 1, 50, "Sindicato A");
        Auto auto = new Auto("Ana", "AUTO-456", 2, 120, true);
        Moto moto = new Moto("Luis", "MOTO-789", 3, 250, true);

        // b) Mostrar placa y conductor de cada vehículo
        System.out.println("=== Información de Vehículos ===");
        bus.mostrarInfo();
        auto.mostrarInfo();
        moto.mostrarInfo();

        // c) Cambiar el conductor de un vehículo
        System.out.println("\n--- Cambiando conductor del Bus ---");
        bus.cambiarConductor("Pedro");
        bus.mostrarInfo();
    }
}