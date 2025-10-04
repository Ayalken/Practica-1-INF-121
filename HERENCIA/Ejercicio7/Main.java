package Herencia.Ejercicio7;

public class Main {
    public static void main(String[] args) {
        // a) Instanciar dos estudiantes y un docente
        Estudiante est1 = new Estudiante("Ana", "Gómez", "López", 20, "RU123", "MAT001");
        Estudiante est2 = new Estudiante("Luis", "Fernández", "Pérez", 22, "RU456", "MAT002");
        Docente doc = new Docente("Carlos", "Ramírez", "Torres", 22, 3500.0, "REG789");

        // b) Mostrar datos
        System.out.println("\n--- Datos Estudiantes y Docente ---");
        est1.mostrar();
        est2.mostrar();
        doc.mostrar();

        // c) Promedio edad estudiantes
        double promedio = (est1.getEdad() + est2.getEdad()) / 2.0;
        System.out.println("\nPromedio edad estudiantes: " + promedio);

        // d) Modificar edad estudiante
        est1.modificarEdad(23);
        System.out.println("\nDespués de modificar edad:");
        est1.mostrar();

        // e) Verificar si algún estudiante tiene la misma edad que el docente
        if (est1.getEdad() == doc.getEdad() || est2.getEdad() == doc.getEdad()) {
            System.out.println("\nUn estudiante tiene la misma edad que el docente.");
        } else {
            System.out.println("\nNingún estudiante tiene la misma edad que el docente.");
        }
    }
}