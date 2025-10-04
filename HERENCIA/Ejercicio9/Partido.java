package Herencia.Ejercicio9;
public class Partido {
    private String nombreP;
    private String rol;

    public Partido(String nombreP, String rol) {
        this.nombreP = nombreP;
        this.rol = rol;
    }

    public String getNombreP() {
        return nombreP;
    }

    public String getRol() {
        return rol;
    }
}