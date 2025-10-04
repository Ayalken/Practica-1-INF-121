package Herencia.Ejercicio5;

class Vehiculo {
    protected String conductor;
    protected String placa;
    protected int id;

    public Vehiculo(String conductor, String placa, int id) {
        this.conductor = conductor;
        this.placa = placa;
        this.id = id;
    }

    public void mostrarInfo() {
        System.out.println("Placa: " + placa + ", Conductor: " + conductor);
    }

    public void cambiarConductor(String nuevoConductor) {
        this.conductor = nuevoConductor;
    }
}