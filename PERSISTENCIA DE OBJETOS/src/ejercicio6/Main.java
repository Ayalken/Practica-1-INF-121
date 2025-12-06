package ejercicio6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArchPrestamo archPrestamo = new ArchPrestamo("prestamos.json");
        ArchLibro archLibro = new ArchLibro("libros.json", archPrestamo);
        ArchCliente archCliente = new ArchCliente("clientes.json", archPrestamo, archLibro);

        archPrestamo.setArchCliente(archCliente); 

        Libro l1 = new Libro(1, "El Código Da Vinci", 15.0);
        Libro l2 = new Libro(2, "Cien Años de Soledad", 25.0);
        Libro l3 = new Libro(3, "Patrones de Diseño", 40.0);
        Libro l4 = new Libro(4, "Libro Sin Venta", 10.0);
        archLibro.adicionar(l1); 
        archLibro.adicionar(l2); 
        archLibro.adicionar(l3); 
        archLibro.adicionar(l4); 
        
        Cliente c1 = new Cliente(10, "111", "Ana", "Gómez");
        Cliente c2 = new Cliente(20, "222", "Carlos", "Pérez");
        Cliente c3 = new Cliente(30, "333", "Laura", "Díaz");
        archCliente.adicionar(c1);
        archCliente.adicionar(c2);
        archCliente.adicionar(c3);
        
        archPrestamo.adicionar(new Prestamo(10, 1, "2023-01-01", 2)); 
        archPrestamo.adicionar(new Prestamo(10, 2, "2023-01-05", 1)); 
        archPrestamo.adicionar(new Prestamo(20, 1, "2023-02-10", 1)); 
        archPrestamo.adicionar(new Prestamo(20, 3, "2023-02-15", 3));
        archPrestamo.adicionar(new Prestamo(30, 2, "2023-03-20", 1)); 

        double precioMin = 10.0;
        double precioMax = 30.0;
        ArrayList<Libro> librosRango = archLibro.listarLibrosPorRangoPrecio(precioMin, precioMax);
        System.out.println("a) Libros con precio entre " + precioMin + " y " + precioMax + ":");
        librosRango.forEach(System.out::println);
        System.out.println("----------------------------------------------\n");

        int codL1 = 1;
        try {
            double ingreso = archLibro.calcularIngresoTotalLibro(codL1);
            System.out.printf("b) Ingreso total generado por Libro %d ('%s'): %.2f\n", codL1, l1.getTitulo(), ingreso);
        } catch (Exception e) {
            System.err.println("ERROR b: " + e.getMessage());
        }
        System.out.println("----------------------------------------------\n");

        ArrayList<Libro> noVendidos = archLibro.mostrarLibrosNoVendidos();
        System.out.println("c) Libros que nunca fueron vendidos/prestados:");
        noVendidos.forEach(System.out::println);
        System.out.println("----------------------------------------------\n");

        int codL2 = 2;
        try {
            ArrayList<Cliente> clientesL2 = archCliente.mostrarClientesPorLibro(codL2);
            System.out.println("d) Clientes que compraron Libro %d ('%s'):".formatted(codL2, l2.getTitulo()));
            clientesL2.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("ERROR d: " + e.getMessage());
        }
        System.out.println("----------------------------------------------\n");

        // e) Definir el libro más prestado.
        try {
            int codMasPrestado = archPrestamo.definirLibroMasPrestado();
            Libro libroMasPrestado = archLibro.buscaLibro(codMasPrestado);
            System.out.println("e) El libro más prestado es: " + libroMasPrestado.getTitulo() + " (Cod: " + codMasPrestado + ")");
        } catch (Exception e) {
            System.err.println("ERROR e: " + e.getMessage());
        }
        System.out.println("----------------------------------------------\n");

        try {
            int codClienteMasPrestamos = archPrestamo.mostrarClienteConMasPrestamos();
            Cliente clienteMasPrestamos = archCliente.buscaCliente(codClienteMasPrestamos);
            System.out.println("f) El cliente con más préstamos (transacciones) es: " + clienteMasPrestamos.getNombreCompleto() + " (Cod: " + codClienteMasPrestamos + ")");
        } catch (Exception e) {
            System.err.println("ERROR f: " + e.getMessage());
        }
        System.out.println("----------------------------------------------\n");
    }
}