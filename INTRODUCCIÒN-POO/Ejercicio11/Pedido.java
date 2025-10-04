package Introduccion_a_POO.Ejercicio11;
public class Pedido {
    private int idPedido;
    private String estado;

    public Pedido(int idPedido, String estado) {
        this.idPedido = idPedido;
        this.estado = estado;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Objeto Pedido destruido");
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void mostrarInfo() {
        System.out.println("Pedido ID: " + idPedido + " | Estado: " + estado);
    }
}