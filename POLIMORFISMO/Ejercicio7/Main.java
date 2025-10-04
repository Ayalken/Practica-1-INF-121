package Ejercicio7;

public class Main {
    public static void main(String[] args) {
        Parada p1 = new Parada();
        p1.adicionar("Carlos");
        p1.adicionar("Toyota Corolla", "Juan Pérez", "123-ABC");
        p1.mostrar();

        System.out.println("\n-------------------\n");

        Parada p2 = new Parada("Parada Central");
        p2.adicionar("María");
        p2.adicionar("Nissan Sentra", "Luis Gómez", "XYZ-999");
        p2.adicionar("Hyundai Accent", "Ana López", "PPP-111");

        p2.setNombreP("Parada Principal");
        p2.mostrar();
    }
}

