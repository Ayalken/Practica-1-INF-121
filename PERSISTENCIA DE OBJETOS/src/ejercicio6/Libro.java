package ejercicio6;

public class Libro {
    private int codLibro;
    private String titulo;
    private double precio;

    public Libro(int codLibro, String titulo, double precio) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.precio = precio;
    }

    public Libro() {
        this(0, "", 0.0);
    }

    public int getCodLibro() {
        return codLibro;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Libro [Cod=" + codLibro + ", Título='" + titulo + "', Precio=" + precio + "]";
    }
}