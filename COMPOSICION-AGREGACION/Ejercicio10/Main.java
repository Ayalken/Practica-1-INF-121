package Ejercicio10;

public class Main {
    public static void main(String[] args) {

        Speaker sp1 = new Speaker("Juan", "Perez", 40, 123, "IA");
        Speaker sp2 = new Speaker("Maria", "Lopez", 35, 456, "Ciberseguridad");

        Charla ch1 = new Charla("Aula 1", "Introducción a IA", sp1);
        Charla ch2 = new Charla("Aula 2", "Seguridad Informática", sp2);

        Participante p1 = new Participante("Ana", "Mendez", 20, 777, 1);
        Participante p2 = new Participante("Luis", "Rojas", 22, 888, 2);
        Participante p3 = new Participante("Carla", "Diaz", 25, 999, 3);

        ch1.agregarParticipante(p1);
        ch1.agregarParticipante(p2);

        ch2.agregarParticipante(p3);

        Evento evento = new Evento("Tech 2025");
        evento.agregarCharla(ch1);
        evento.agregarCharla(ch2);

        System.out.println("Edad promedio: " + evento.edadPromedio());

        System.out.println("¿Está Ana Mendez? " +
            evento.estaEnEvento("Ana", "Mendez"));

        System.out.println("¿Está un tal Pepe Garcia? " +
            evento.estaEnEvento("Pepe", "Garcia"));

        System.out.println("\nEliminando charlas del speaker con CI=123...");
        evento.eliminarCharlasDeSpeaker(123);

        System.out.println("Charlas después de eliminar:");
        evento.mostrarCharlas();

        System.out.println("\nOrdenando por número de participantes...");
        evento.ordenarPorParticipantes();
        evento.mostrarCharlas();
    }
}

