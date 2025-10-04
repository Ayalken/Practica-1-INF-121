package Herencia.Ejercicio9;
public class Politico {
    private String profesion;
    private int añosExp;

    public Politico(String profesion, int añosExp) {
        this.profesion = profesion;
        this.añosExp = añosExp;
    }

    public String getProfesion() {
        return profesion;
    }

    public int getAñosExp() {
        return añosExp;
    }
}