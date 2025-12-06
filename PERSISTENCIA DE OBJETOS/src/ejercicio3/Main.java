package ejercicio3;

public class Main {
    public static void main(String[] args) {
        
        ArchivoProducto gestor = new ArchivoProducto("productos.json");
        gestor.listarProductos();

        System.out.println("\n--- PRUEBA DE GUARDAR PRODUCTOS (b) ---");
        try {
            gestor.guardarProducto(new Producto(10, "Leche Entera", 1.25f));
            gestor.guardarProducto(new Producto(20, "Pan Integral", 2.50f));
            gestor.guardarProducto(new Producto(30, "Mermelada Fresa", 3.00f));
            gestor.guardarProducto(new Producto(40, "Queso Fresco", 4.75f));
            
        } catch (Exception e) {
            System.err.println("ERROR en guardarProducto: " + e.getMessage());
        }
        
        gestor.listarProductos();

        System.out.println("\n--- PRUEBA DE BUSCAR PRODUCTO (c) ---");
        try {
            Producto p1 = gestor.buscaProducto(30);
            System.out.println("Producto encontrado (Cód. 30): " + p1);
             
        } catch (Exception e) {
            System.err.println("ERROR en buscaProducto: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA DE CALCULAR PROMEDIO (d) ---");
        try {
            double promedio = gestor.calcularPromedioPrecios();
            System.out.printf("El promedio de precios es: %.2f\n", promedio);
        } catch (Exception e) {
            System.err.println("ERROR en calcularPromedioPrecios: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA DE MOSTRAR PRODUCTO MÁS CARO (e) ---");
        try {
            Producto masCaro = gestor.mostrarProductoMasCaro();
            System.out.println("El producto más caro es: " + masCaro);
        } catch (Exception e) {
            System.err.println("ERROR en mostrarProductoMasCaro: " + e.getMessage());
        }
    }
}