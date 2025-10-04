package Herencia.Ejercicio11;

public class Main {
    public static void main(String[] args) {
        // a) Crear 2 objetos de la clase hija y mostrar sus datos
        JefePolicia jefe1 = new JefePolicia("Carlos", 45, 5000, 20, "Capitán", "Operativo", "Seguridad", "La Paz");
        JefePolicia jefe2 = new JefePolicia("Ana", 38, 5500, 15, "Capitán", "Administrativo", "Investigaciones", "Cochabamba");

        System.out.println("Datos de los jefes de policía:");
        jefe1.mostrarDatos();
        jefe2.mostrarDatos();

        // b) Mostrar el nombre del que tiene mayor sueldo
        JefePolicia mayorSueldo = jefe1.compararSueldo(jefe1, jefe2);
        System.out.println("El jefe con mayor sueldo es: " + mayorSueldo.getNombre());

        // c) Comparar si ambos tienen el mismo grado
        boolean mismoGrado = jefe1.compararGrado(jefe1, jefe2);
        System.out.println("¿Ambos tienen el mismo grado?: " + (mismoGrado ? "Sí" : "No"));
    }
}