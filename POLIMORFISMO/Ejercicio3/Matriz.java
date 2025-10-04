package Ejercicio3;

public class Matriz {
    public float[][] matriz;

    public Matriz() {
        matriz = new float[10][10];
        for (int i = 0; i < 10; i++) {
            matriz[i][i] = 1;
        }
    }

    public Matriz(float[][] matriz) {
        this.matriz = new float[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.matriz[i][j] = matriz[i][j];
            }
        }
    }

    public void sumar(Matriz matriz) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.matriz[i][j] += matriz.matriz[i][j];
            }
        }
    }

    public void restar(Matriz matriz) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.matriz[i][j] -= matriz.matriz[i][j];
            }
        }
    }

    public boolean igual(Matriz matriz) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.matriz[i][j] != matriz.matriz[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    
}
}