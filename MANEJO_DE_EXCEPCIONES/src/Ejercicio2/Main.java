package Ejercicio2;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== PRUEBAS CORRECTAS ===");
        System.out.println("5 + 3 = " + Calculadora.sumar(5, 3));
        System.out.println("10 - 4 = " + Calculadora.restar(10, 4));
        System.out.println("6 * 7 = " + Calculadora.multiplicar(6, 7));

        try {
            System.out.println("20 / 4 = " + Calculadora.dividir(20, 4));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            int numero = Calculadora.convertirAEntero("123");
            System.out.println("Conversión exitosa: " + numero);
        } catch (NumeroInvalidoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== PRUEBAS CON ERRORES ===");

        try {
            Calculadora.dividir(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error al dividir: " + e.getMessage());
        }

        try {
            Calculadora.convertirAEntero("ABC123");
        } catch (NumeroInvalidoException e) {
            System.out.println("Error de conversión: " + e.getMessage());
        }
    }
}
