package Ejercicio11;

public class Main {
    public static void main(String[] args) {

        String[][] pasajerosCrucero1 = {
                {"Juan Vargas", "Martina Vasques", "Wilmer Montero"},
                {"502", "603", "401"},
                {"500", "1000", "925"}
        };
        Crucero crucero1 = new Crucero("Crucero A", "Bolivia", "Brasil", pasajerosCrucero1, 3);

        String[][] pasajerosCrucero2 = {
                {"Ana Lopez", "Pedro Gomez"},
                {"701", "702"},
                {"800", "600"}
        };
        Crucero crucero2 = new Crucero("Crucero B", "Peru", "Chile", pasajerosCrucero2, 2);

        Pasajero p1 = new Pasajero("Juan Vargas", 25, "M");
        Pasajero p2 = new Pasajero("Martina Vasques", 30, "F");
        Pasajero p3 = new Pasajero("Wilmer Montero", 40, "M");
        Pasajero p4 = new Pasajero("Ana Lopez", 28, "F");
        Pasajero p5 = new Pasajero("Pedro Gomez", 35, "M");

        crucero1.mostrar();
        crucero2.mostrar();

        p1.mostrar();
        p2.mostrar();
        p3.mostrar();
        p4.mostrar();
        p5.mostrar();

        System.out.println("\nTotal pasajes Crucero 1: " + crucero1.igualIgual());
        System.out.println("\nTotal pasajes Crucero 2: " + crucero2.igualIgual());

        System.out.println("\n¿Crucero A y Crucero B tiene la misma cantidad de pasajeros? " + crucero1.mas(crucero2));
        System.out.println("Crucero A:");
        String[] generosCrucero1 = {"M", "F", "M"};
        crucero1.menos(generosCrucero1);
        System.out.println("Crucero A:");
        String[] generosCrucero2 = {"F", "M"};
        crucero2.menos(generosCrucero2);

        p1.mostrar();
        p1.menosMenos();
        p1.mostrar();
    }
}
