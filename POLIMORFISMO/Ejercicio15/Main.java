package Ejercicio15;

public class Main {
    public static void main(String[] args) {
        Laboratorio lab1 = new Laboratorio("Lasin 1", 5);
        Laboratorio lab2 = new Laboratorio("Lasin 2", 5);

        lab1.agregarOrdenador("S001", 1, 8, "Intel i5", "activo");
        lab1.agregarOrdenador("S002", 2, 16, "Intel i7", "activo");
        lab1.agregarOrdenador("S003", 3, 4, "AMD Ryzen 3", "inactivo");

        lab2.agregarOrdenador("S004", 4, 12, "Intel i5", "activo");
        lab2.agregarOrdenador("S005", 5, 8, "AMD Ryzen 5", "inactivo");
        lab2.agregarOrdenador("S006", 6, 16, "Intel i9", "activo");

        System.out.println("=== Ordenadores activos en Lasin 1 ===");
        lab1.informacionPorEstado("activo");

        System.out.println("\n=== Ordenadores con más de 8GB de RAM en Lasin 2 ===");
        lab2.informacionPorRam(8);

        System.out.println("\n=== Estado antes del traslado ===");
        lab1.informacionPorLaboratorio(lab1);
        lab2.informacionPorLaboratorio(lab2);

     // Trasladar dos ordenadores de Lasin 1 a Lasin 2
        Ordenador[] aTrasladar = lab1.getOrdenadores();
        for (int i = 0; i < 2 && i < aTrasladar.length; i++) {
            Ordenador o = aTrasladar[i];
            lab2.agregarOrdenador(o.getCodigoSerial(), o.getNumero(), o.getRam(), o.getProcesador(), o.getEstado());
            lab1.eliminarOrdenador(o.getCodigoSerial());
        }


        System.out.println("\n=== Estado después del traslado ===");
        lab1.informacionPorLaboratorio(lab1);
        lab2.informacionPorLaboratorio(lab2);
    }
}
