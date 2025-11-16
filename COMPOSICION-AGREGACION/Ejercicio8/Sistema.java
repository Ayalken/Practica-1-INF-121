package Ejercicio8;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Facultad> facultades;
    private ArrayList<Fraternidad> fraternidades;
    private ArrayList<Bailarin> bailarines;

    public Sistema(ArrayList<Facultad> facultades, ArrayList<Fraternidad> fraternidades, ArrayList<Bailarin> bailarines) {
        this.facultades = facultades;
        this.fraternidades = fraternidades;
        this.bailarines = bailarines;
    }

    public void registrarFacultad(Facultad f) {
        facultades.add(f);
    }

    public void registrarFraternidad(Fraternidad fr) {
        fraternidades.add(fr);
    }

    public void registrarBailarin(Bailarin b) {
        boolean repetido = false;

        for (Bailarin x : bailarines) {
            if (x.getNombre().equalsIgnoreCase(b.getNombre())) {
                repetido = true;
                break;
            }
        }if(repetido) {
            System.out.println("El bailarín " + b.getNombre() + " ya está registrado en otra fraternidad.");
            return;
        }

        bailarines.add(b);
        b.getFraternidad().agregarBailarin(b);
        System.out.println("Bailarín registrado: " + b.getNombre());
    }

    public void mostrarBailarines() {
        System.out.println("\n:"
        		+ "Lista de bailarines:");
        for (Bailarin b : bailarines) {
            System.out.println(b);
        }
    }

    public void mostrarFraternidades() {
        System.out.println("\nFraternidades:");
        for (Fraternidad f : fraternidades) {
            System.out.println(f);
            for (Bailarin b : f.getBailarines()) {
                System.out.println("   - " + b.getNombre() + " (" + b.getFacultad().getNombre() + ")");
            }
        }
    }

    public void mostrarEdades() {
        System.out.println("\nEdades de los bailarines:");
        for (Bailarin b : bailarines) {
            System.out.println(b.getNombre() + ": " + b.getEdad() + " años");
        }
    }
}
