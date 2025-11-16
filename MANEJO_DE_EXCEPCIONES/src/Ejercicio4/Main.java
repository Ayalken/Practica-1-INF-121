package Ejercicio4;

public class Main {

    public static void main(String[] args) {

        Inventario inv = new Inventario(3); 

        System.out.println("=== AGREGAR PRODUCTOS ===");
        try {
            inv.agregarProducto(new Producto("P01", "Monitor", 700, 10));
            inv.agregarProducto(new Producto("P02", "Teclado", 150, 20));
            inv.agregarProducto(new Producto("P03", "Mouse", 50, 15));

            inv.agregarProducto(new Producto("P04", "USB", 20, 5));

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n=== BUSCAR PRODUCTO ===");

        try {
            Producto p = inv.buscarProducto("P02");
            System.out.println("Encontrado: " + p.getNombre());
        } catch (ProductoNoEncontradoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            inv.buscarProducto("P99");
        } catch (ProductoNoEncontradoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n=== VENDER PRODUCTO ===");

        try {
            inv.venderProducto("P01", 5);
            System.out.println("Venta realizada");

            inv.venderProducto("P01", 100);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
