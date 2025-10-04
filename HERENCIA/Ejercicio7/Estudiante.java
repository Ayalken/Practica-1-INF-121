package Herencia.Ejercicio7;

public class Estudiante extends Persona {
    private String ru;
    private String matricula;

    public Estudiante(String nombre, String paterno, String materno, int edad, String ru, String matricula) {
        super(nombre, paterno, materno, edad);
        this.ru = ru;
        this.matricula = matricula;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("RU: " + ru + ", Matrícula: " + matricula);
    }

    public void modificarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }
}