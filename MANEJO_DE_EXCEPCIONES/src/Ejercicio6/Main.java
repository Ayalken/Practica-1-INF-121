package Ejercicio6;

public class Main {

    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria("12345", "Juan Pérez", 1000);

        cuenta.mostrarInfo();

        System.out.println("\nDEPÓSITOS:");
        try {
            cuenta.depositar(500); 
            System.out.println("Depósito exitoso.");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            cuenta.depositar(-200);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        cuenta.mostrarInfo();

        System.out.println("\nRETIROS:");
        try {
            cuenta.retirar(300);   
            System.out.println("Retiro exitoso.");
        } catch (FondosInsuficientesException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            cuenta.retirar(2000);  
        } catch (FondosInsuficientesException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        cuenta.mostrarInfo();
    }
}

