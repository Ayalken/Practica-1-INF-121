package Herencia.Ejercicio3;

class Pinguino extends Animal {
    @Override
    public void desplazarse() {
        System.out.println(nombre + " nada y camina torpemente.");
    }
}