package Ejercicio6;

public class FondosInsuficientesException extends Exception {
    private static final long serialVersionUID = 1L;

    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}

