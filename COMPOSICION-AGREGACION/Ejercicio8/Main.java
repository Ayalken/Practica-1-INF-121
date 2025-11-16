package Ejercicio8;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Facultad f1 = new Facultad("Ciencias Puras y Naturales");
        Facultad f2 = new Facultad("Arquitectura");

        ArrayList<Facultad> facultades = new ArrayList<>();
        facultades.add(f1);
        facultades.add(f2);

        Fraternidad frat1 = new Fraternidad("Caporales Central", "Juan Pérez", new ArrayList<>());
        Fraternidad frat2 = new Fraternidad("Tobas UMSA", "Ana López", new ArrayList<>());

        ArrayList<Fraternidad> fraternidades = new ArrayList<>();
        fraternidades.add(frat1);
        fraternidades.add(frat2);

        ArrayList<Bailarin> bailarines = new ArrayList<>();

        Bailarin b1 = new Bailarin("Carlos", 20, f1, frat1);
        Bailarin b2 = new Bailarin("María", 22, f2, frat2);
        Bailarin b3 = new Bailarin("Luis", 21, f1, frat1);
        Bailarin b4 = new Bailarin("Sofía", 19, f2, frat2);
        Bailarin b5 = new Bailarin("Carlos", 20, f2, frat2);//auxi esta repetido a proposito

        bailarines.add(b1);
        bailarines.add(b2);
        bailarines.add(b3);
        bailarines.add(b4);

        Sistema sistema = new Sistema(facultades, fraternidades, bailarines);

        sistema.registrarBailarin(b5); 

        sistema.mostrarFraternidades();
        sistema.mostrarBailarines();
        sistema.mostrarEdades();
    }
}
