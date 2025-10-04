package Herencia.Ejercicio3;

class Leon extends Animal {
    @Override
    public void desplazarse() {
        System.out.println(nombre + " camina y corre.");
    }
}