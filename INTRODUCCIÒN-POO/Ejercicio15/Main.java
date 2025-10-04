package Introduccion_a_POO.Ejercicio15;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // a) Instanciar 3 buzones diferentes, cada uno con al menos 3 cartas
        Buzon b1 = new Buzon(1);
        Buzon b2 = new Buzon(2);
        Buzon b3 = new Buzon(3);

        b1.agregarCarta("C123", "Juan Álvarez", "Peter Chaves");
        b1.agregarCarta("C456", "Pepe Mujica", "Wilmer Pérez");
        b1.agregarCarta("C789", "Paty Vasques", "Pepe Mujica");

        b2.agregarCarta("C101", "Ana Lopez", "Carlos Perez");
        b2.agregarCarta("C102", "María Gómez", "Ana Lopez");
        b2.agregarCarta("C103", "Pepe Mujica", "Juan Álvarez");

        b3.agregarCarta("C201", "Luis Suárez", "María Gómez");
        b3.agregarCarta("C202", "Carlos Perez", "Paty Vasques");
        b3.agregarCarta("C203", "Peter Chaves", "Luis Suárez");

        // b) Instanciar 3 cartas con sus descripciones
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta("C123", "Saludos rápidos desde la ciudad."));
        cartas.add(new Carta("C456", "Querido amigo, te escribo porque siento un gran amor y confusión."));
        cartas.add(new Carta("C789", "Aviso importante: reunión el lunes."));

        System.out.println("=== Buzones ===");
        b1.mostrarCartas();
        b2.mostrarCartas();
        b3.mostrarCartas();

        System.out.println("=== Cartas ===");
        for (Carta ct : cartas) System.out.println(ct);

        // c) Verificar cuántas cartas recibió destinatario "Pepe Mujica"
        String destinatarioX = "Pepe Mujica";
        int total = b1.contarCartasDestinatario(destinatarioX)
                + b2.contarCartasDestinatario(destinatarioX)
                + b3.contarCartasDestinatario(destinatarioX);
        System.out.println("Pepe Mujica recibió " + total + " cartas.");

        // d) Eliminar carta con código "C456"
        boolean eliminado = b1.eliminarCarta("C456") || b2.eliminarCarta("C456") || b3.eliminarCarta("C456");
        System.out.println("Carta C456 eliminada: " + eliminado);

        // e) Verificar si un remitente ha sido destinatario
        List<Buzon> buzones = Arrays.asList(b1, b2, b3);
        Set<String> remitentes = new HashSet<>();
        Map<String, List<String>> recibidasPor = new HashMap<>();
        for (Buzon bz : buzones) {
            for (int i = 0; i < bz.nroC; i++) {
                remitentes.add(bz.c[i][1]);
                recibidasPor.computeIfAbsent(bz.c[i][2], k -> new ArrayList<>()).add(bz.c[i][1]);
            }
        }
        System.out.println("=== Remitentes que también son destinatarios ===");
        for (String persona : remitentes) {
            if (recibidasPor.containsKey(persona)) {
                System.out.println(persona + " recibió cartas de: " + recibidasPor.get(persona));
            }
        }

        // f) Buscar palabra clave en descripciones
        String palabra = "amor";
        List<String> codigosCoinciden = new ArrayList<>();
        for (Carta ct : cartas) {
            if (ct.contienePalabra(palabra)) {
                codigosCoinciden.add(ct.getCodigo());
            }
        }

        // g) Mostrar coincidencias
        System.out.println("=== Coincidencias con la palabra \"" + palabra + "\" ===");
        for (String cod : codigosCoinciden) {
            for (Buzon bz : buzones) {
                String[] fila = bz.buscarPorCodigo(cod);
                if (fila != null) {
                    System.out.println("Codigo: " + fila[0] + " | Remitente: " + fila[1] + " | Destinatario: " + fila[2]);
                }
            }
        }
    }
}