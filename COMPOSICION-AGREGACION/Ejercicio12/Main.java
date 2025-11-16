package Ejercicio12;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Ana Gómez", "Cardióloga");
        Doctor d2 = new Doctor("Luis Pérez", "Pediatra");
        Doctor d3 = new Doctor("Marco Ruiz", "Dermatólogo");

        ArrayList<Doctor> lista1 = new ArrayList<>();
        lista1.add(d1);
        lista1.add(d2);

        ArrayList<Doctor> lista2 = new ArrayList<>();
        lista2.add(d1);  
        lista2.add(d3);

        Hospital h1 = new Hospital("Hospital Central", lista1);
        Hospital h2 = new Hospital("Hospital del Sur", lista2);

        h1.mostrarDoctores();
        h2.mostrarDoctores();
    }
}