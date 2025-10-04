package Herencia.Ejercicio1;

class Jefe extends Persona {
    String sucursal;
    String tipo;

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Sucursal: " + sucursal + ", Tipo: " + tipo);
    }
}