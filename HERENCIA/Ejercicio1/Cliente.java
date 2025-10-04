package Herencia.Ejercicio1;
class Cliente extends Persona {
    String nroCompra;
    String idCliente;

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Nro de Compra: " + nroCompra + ", ID Cliente: " + idCliente);
    }
}