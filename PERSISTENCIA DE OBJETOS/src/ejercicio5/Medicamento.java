package ejercicio5;

public class Medicamento {
    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;

    public Medicamento(String nombre, int codMedicamento, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = codMedicamento;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Medicamento() {
        nombre = "";
        codMedicamento = 0;
        tipo = "";
        precio = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getCodMedicamento() {
        return codMedicamento;
    }

    @Override
    public String toString() {
        return "Med [Cod=" + codMedicamento + ", Nombre=" + nombre + ", Tipo=" + tipo + ", Precio=" + precio + "]";
    }
}