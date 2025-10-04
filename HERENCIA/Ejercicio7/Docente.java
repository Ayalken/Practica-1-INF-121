package Herencia.Ejercicio7;

public class Docente extends Persona {
    private double sueldo;
    private String regProfesional;

    public Docente(String nombre, String paterno, String materno, int edad, double sueldo, String regProfesional) {
        super(nombre, paterno, materno, edad);
        this.sueldo = sueldo;
        this.regProfesional = regProfesional;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Sueldo: " + sueldo + ", Reg. Profesional: " + regProfesional);
    }
}