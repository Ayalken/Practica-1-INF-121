package ejercicio4;

public class Nota {
    private String materia;
    private double notaFinal;
    private Estudiante estudiante; 
    
    public Nota(String materia, double notaFinal, Estudiante estudiante) {
        this.materia = materia;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }

    public Nota() {
        this.materia = "";
        this.notaFinal = 0.0;
        this.estudiante = new Estudiante();
    }

    public String getMateria() {
        return materia;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    @Override
    public String toString() {
        return "Nota{" + "materia=" + materia + ", notaFinal=" + notaFinal + ", estudiante=" + estudiante + '}';
    }    
}