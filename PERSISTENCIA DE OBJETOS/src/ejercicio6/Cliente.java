package ejercicio6;

public class Cliente {
    private int codCliente;
    private String ci;
    private String nombre;
    private String apellido;

    public Cliente(int codCliente, String ci, String nombre, String apellido) {
        this.codCliente = codCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente() {
        this(0, "", "", "");
    }

    public int getCodCliente() {
        return codCliente;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "Cliente [Cod=" + codCliente + ", Nombre=" + getNombreCompleto() + ", CI=" + ci + "]";
    }
}