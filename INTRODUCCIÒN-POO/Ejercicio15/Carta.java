package Introduccion_a_POO.Ejercicio15;
public class Carta {
    String codigo;
    String descripcion;

    public Carta(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean contienePalabra(String palabra) {
        if (descripcion == null) return false;
        return descripcion.toLowerCase().contains(palabra.toLowerCase());
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Descripcion: " + descripcion;
    }
}