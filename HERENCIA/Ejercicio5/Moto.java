package Herencia.Ejercicio5;

class Moto extends Vehiculo {
    int cilindrada;
    boolean casco;

    public Moto(String conductor, String placa, int id, int cilindrada, boolean casco) {
        super(conductor, placa, id);
        this.cilindrada = cilindrada;
        this.casco = casco;
    }
}