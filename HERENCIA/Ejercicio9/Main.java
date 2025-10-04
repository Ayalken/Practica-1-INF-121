package Herencia.Ejercicio9;
public class Main {
    public static void main(String[] args) {
        // b) Instanciar de dos formas diferentes a un presidente
        Presidente p1 = new Presidente("Luis", "Perez", "Abogado", 15, "Partido A", "Líder");
        Presidente p2 = new Presidente("Maria", "Lopez", "Economista", 10, "Partido B", "Vocero");

        // c) Crear un vector con mínimo 3 presidentes
        Presidente[] presidentes = new Presidente[3];
        presidentes[0] = p1;
        presidentes[1] = p2;
        presidentes[2] = new Presidente("Juan", "Garcia", "Ingeniero", 20, "Partido C", "Secretario");

        String nombreBuscado = "Maria";
        for (Presidente p : presidentes) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Presidente encontrado: " + p.getNombre() + " " + p.getApellido());
                System.out.println("Partido: " + p.getPartido().getNombreP());
                System.out.println("Profesión: " + p.getProfesion());
            }
        }
    }
}