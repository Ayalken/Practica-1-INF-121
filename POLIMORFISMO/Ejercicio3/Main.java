package Ejercicio3;

public class Main {
    public static void main(String[] args) {
    	
        Matriz identidad = new Matriz();
        System.out.println("Matriz identidad(m1):");
        identidad.mostrar();

        float[][] datos = new float[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                datos[i][j] = i + j; 
            }
        }
        Matriz m2 = new Matriz(datos);
        System.out.println("\nMatriz m2:");
        m2.mostrar();

        m2.sumar(identidad);
        System.out.println("\nMatriz m2 + m1:");
        m2.mostrar();

        m2.restar(identidad);
        System.out.println("\nMatriz m2 + m1:");
        m2.mostrar();

        System.out.println("\n¿m1 igual a m2? " + identidad.igual(m2));
    }
}
