package Ejercicio10;

import java.util.ArrayList;
import java.util.Collections;

public class Evento {
    private String nombre;
    private ArrayList<Charla> charlas;

    public Evento(String nombre) {
        this.nombre = nombre;
        this.charlas = new ArrayList<>();
    }

    public void agregarCharla(Charla c) {
        charlas.add(c);
    }

    public double edadPromedio() {
        int suma = 0;
        int total = 0;

        for (Charla c : charlas) {
            for (Participante p : c.getParticipantes()) {
                suma += p.getEdad();
                total++;
            }
        }
        return total == 0 ? 0 : (double) suma / total;
    }

    public boolean estaEnEvento(String nombre, String apellido) {
        for (Charla c : charlas) {

            Speaker s = c.getSpeaker();
            if (s.getNombre().equals(nombre) && s.getApellido().equals(apellido))
                return true;

            for (Participante p : c.getParticipantes()) {
                if (p.getNombre().equals(nombre) && p.getApellido().equals(apellido))
                    return true;
            }
        }
        return false;
    }

    public void eliminarCharlasDeSpeaker(int ci) {
        charlas.removeIf(c -> c.getSpeaker().getCi() == ci);
    }

    public void ordenarPorParticipantes() {
        Collections.sort(charlas,
            (a, b) -> b.getNumParticipantes() - a.getNumParticipantes()
        );
    }

    public void mostrarCharlas() {
        for (Charla c : charlas) {
            System.out.println(
                c.getNombreCharla() + " | Participantes: " + c.getNumParticipantes()
            );
        }
    }
}
