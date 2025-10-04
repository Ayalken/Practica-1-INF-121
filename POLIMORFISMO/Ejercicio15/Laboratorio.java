package Ejercicio15;

public class Laboratorio {
    private String nombre;
    private int capacidad;
    private int cantidad;
    private Ordenador[] ordenadores;

    public Laboratorio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.cantidad = 0;
        this.ordenadores = new Ordenador[capacidad];
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarOrdenador(String codigoSerial, int numero, int ram, String procesador, String estado) {
        if (cantidad < capacidad) {
            ordenadores[cantidad] = new Ordenador(codigoSerial, numero, ram, procesador, estado);
            cantidad++;
        }
    }

    public void informacionPorEstado(String estado) {
        System.out.println("Ordenadores en estado " + estado + " en " + nombre + ":");
        for (int i = 0; i < cantidad; i++) {
            if (ordenadores[i].getEstado().equalsIgnoreCase(estado)) {
                System.out.println(ordenadores[i].getInfo());
            }
        }
    }

    public void informacionPorLaboratorio(Laboratorio lab) {
        System.out.println("Ordenadores del laboratorio " + lab.getNombre() + ":");
        for (int i = 0; i < lab.cantidad; i++) {
            System.out.println(lab.ordenadores[i].getInfo());
        }
    }

    public void informacionPorRam(int ramMinima) {
        System.out.println("Ordenadores con más de " + ramMinima + "GB de RAM en " + nombre + ":");
        for (int i = 0; i < cantidad; i++) {
            if (ordenadores[i].getRam() > ramMinima) {
                System.out.println(ordenadores[i].getInfo());
            }
        }
    }

    public Ordenador[] getOrdenadores() {
        Ordenador[] copia = new Ordenador[cantidad];
        for (int i = 0; i < cantidad; i++) {
            copia[i] = ordenadores[i];
        }
        return copia;
    }

    public void eliminarOrdenador(String codigoSerial) {
        for (int i = 0; i < cantidad; i++) {
            if (ordenadores[i].getCodigoSerial().equalsIgnoreCase(codigoSerial)) {
                for (int j = i; j < cantidad - 1; j++) {
                    ordenadores[j] = ordenadores[j + 1];
                }
                cantidad--;
                break;
            }
        }
    }
}
