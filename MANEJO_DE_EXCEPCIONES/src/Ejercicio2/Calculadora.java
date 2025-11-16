package Ejercicio2;

public class Calculadora {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Error: No se puede dividir entre cero.");
        }
        return a / b;
    }

    public static int convertirAEntero(String valor) throws NumeroInvalidoException {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            throw new NumeroInvalidoException("El valor '" + valor + "' no es un número entero válido.");
        }
    }
}
