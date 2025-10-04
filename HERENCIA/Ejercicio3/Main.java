package Herencia.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Animal[] animales = new Animal[3];

        Leon leon = new Leon();
        leon.nombre = "Simba";
        leon.edad = 5;

        Pinguino pinguino = new Pinguino();
        pinguino.nombre = "Pingu";
        pinguino.edad = 3;

        Canguro canguro = new Canguro();
        canguro.nombre = "Jack";
        canguro.edad = 6;

        animales[0] = leon;
        animales[1] = pinguino;
        animales[2] = canguro;

        for (Animal a : animales) {
            a.desplazarse();
        }
    }
}