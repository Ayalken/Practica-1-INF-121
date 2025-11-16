package Ejercicio10;

public class Participante extends Persona {
    private int nroTicket;

    public Participante(String nombre, String apellido, int edad, int ci, int nroTicket) {
        super(nombre, apellido, edad, ci);
        this.nroTicket = nroTicket;
    }

    public int getNroTicket() {
        return nroTicket;
    }
}
