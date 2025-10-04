package Ejercicio11;

public class Crucero {
    private String nombre;
    private String paisOrigen;
    private String paisDestino;
    private int nroPasajeros;
    private String[][] pasajeros; 

    public Crucero(String nombre, String origen, String destino, String[][] pasajeros, int nroPasajeros) {
        this.nombre = nombre;
        this.paisOrigen = origen;
        this.paisDestino = destino;
        this.pasajeros = pasajeros;
        this.nroPasajeros = nroPasajeros;
    }

    public void masMas() { 
        this.nroPasajeros++;
    }

    public void menosMenos() { 
        if (this.nroPasajeros > 0) {
            this.nroPasajeros--;
        }
    }

    public void mostrar() {
        System.out.println("Crucero: " + nombre + ", Origen: " + paisOrigen + ", Destino: " + paisDestino + ", Nro Pasajeros: " + nroPasajeros);
        for (int i = 0; i < nroPasajeros; i++) {
            System.out.println("Pasajero: " + pasajeros[0][i] + ", Habitación: " + pasajeros[1][i] + ", Costo: " + pasajeros[2][i]);
        }
    }

    public int igualIgual() {
        int total = 0;
        for (int i = 0; i < nroPasajeros; i++) {
            total += Integer.parseInt(pasajeros[2][i]);
        }
        return total;
    }

    public boolean mas(Crucero otro) {
        return this.nroPasajeros == otro.nroPasajeros;
    }

    public void menos(String[] generos) {
        int hombres = 0, mujeres = 0;
        for (String g : generos) {
            if (g.equalsIgnoreCase("M")) {
                hombres++;
            } else if (g.equalsIgnoreCase("F")) {
                mujeres++;
            }
        }
        System.out.println("Hombres: " + hombres + ", Mujeres: " + mujeres);
    }
}
