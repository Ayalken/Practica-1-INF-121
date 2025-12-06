package ejercicio6;

public class Prestamo {
    private int codCliente;
    private int codLibro;
    private String fechaPrestamo; 
    private int cantidad;

    public Prestamo(int codCliente, int codLibro, String fechaPrestamo, int cantidad) {
        this.codCliente = codCliente;
        this.codLibro = codLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.cantidad = cantidad;
    }

    public Prestamo() {
        this(0, 0, "", 0);
    }

    public int getCodCliente() {
        return codCliente;
    }

    public int getCodLibro() {
        return codLibro;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Préstamo [CodCliente=" + codCliente + ", CodLibro=" + codLibro + ", Cantidad=" + cantidad + "]";
    }
}