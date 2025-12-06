package ejercicio7;

public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int ci;

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int ci) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ci = ci;
    }

    public Persona() {
        nombre = "";
        apellidoPaterno = "";
        apellidoMaterno = "";
        ci = 0;
    }

    public int getCi() {
        return ci;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }
    
    public void setCi(int ci) {
        this.ci = ci;
    }
}