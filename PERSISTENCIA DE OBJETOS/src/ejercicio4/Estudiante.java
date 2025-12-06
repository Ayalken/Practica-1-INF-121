package ejercicio4;

public class Estudiante {
    private String ru;
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;
    
    public Estudiante(String ru, String nombre, String paterno, String materno, int edad) {
        this.ru = ru;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    public Estudiante() {
        ru = "";
        nombre = "";
        paterno = "";
        materno = "";
        edad = 0;
    }

    public String getRu() {
        return ru;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + paterno + " " + materno;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "ru=" + ru + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", edad=" + edad + '}';
    }

    
}