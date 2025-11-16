package Ejercicio12;

import java.util.ArrayList;

class Hospital {
    private String nombre;
    private ArrayList<Doctor> doctores;
    public Hospital(String nombre, ArrayList<Doctor> doctores) {
        this.nombre = nombre;
        this.doctores = doctores;
    }

    public void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public void mostrarDoctores() {
        System.out.println("Doctores del Hospital " + nombre + ":");
        for (Doctor d : doctores) {
            System.out.println(" - " + d);
        }
    }
}
