package Ejercicio15;

public class Ordenador {
    private String codigoSerial;
    private int numero;
    private int ram;
    private String procesador;
    private String estado;

    public Ordenador(String codigoSerial, int numero, int ram, String procesador, String estado) {
        this.codigoSerial = codigoSerial;
        this.numero = numero;
        this.ram = ram;
        this.procesador = procesador;
        this.estado = estado;
    }

    public String getCodigoSerial() { return codigoSerial; }
    public int getNumero() { return numero; }
    public int getRam() { return ram; }
    public String getProcesador() { return procesador; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getInfo() {
        return "Codigo: " + codigoSerial + ", Nº: " + numero + ", RAM: " + ram + "GB, CPU: " + procesador + ", Estado: " + estado;
    }
}
