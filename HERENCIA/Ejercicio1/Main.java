package Herencia.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.nombre = "Juan";
        c.apellido = "Perez";
        c.ci = "12345";
        c.nroCompra = "001";
        c.idCliente = "C-101";
        c.mostrarInfo();

        System.out.println("----------------");

        Jefe j = new Jefe();
        j.nombre = "Maria";
        j.apellido = "Lopez";
        j.ci = "67890";
        j.sucursal = "Central";
        j.tipo = "General";
        j.mostrarInfo();
    }
}