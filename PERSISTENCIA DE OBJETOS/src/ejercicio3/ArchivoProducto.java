package ejercicio3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoProducto {

    private final String nombreArch; 
    private ArrayList<Producto> productos;
    private final Gson g = new Gson();

    public ArchivoProducto(String n) {
        this.nombreArch = n;
        this.productos = new ArrayList<>();
        crearArchivo();
    }

    public void crearArchivo() {
        try (FileReader reader = new FileReader(nombreArch)) {
            productos = g.fromJson(reader, new TypeToken<ArrayList<Producto>>(){}.getType());
            if (productos == null) {
                productos = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Archivo " + nombreArch + " no encontrado o vacío. Se crea una lista de productos vacía.");
            productos = new ArrayList<>();
        }
    }
    
    private void guardarCambios() {
        try (FileWriter writer = new FileWriter(nombreArch)) {
            g.toJson(productos, writer);
            System.out.println("Cambios guardados en " + nombreArch);
        } catch (IOException e) {
            System.err.println("Error guardando el archivo: " + e.getMessage());
        }
    }
    
    private boolean existeCodigo(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public void guardarProducto(Producto p) throws Exception {
        if (p == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        if (existeCodigo(p.getCodigo())) {
            throw new Exception("Error: Ya existe un producto con el código " + p.getCodigo());
        }
        
        this.productos.add(p);
        guardarCambios(); 
    }

    public Producto buscaProducto(int c) throws Exception {
        for (Producto p : productos) {
            if (p.getCodigo() == c) {
                return p;
            }
        }
        throw new Exception("No existe el producto con código: " + c);
    }

    public double calcularPromedioPrecios() throws Exception {
        if (productos.isEmpty()) {
            throw new Exception("No hay productos para calcular el promedio.");
        }
        
        double sumaPrecios = 0;
        for (Producto p : productos) {
            sumaPrecios += p.getPrecio();
        }
        return sumaPrecios / productos.size();
    }

    public Producto mostrarProductoMasCaro() throws Exception {
        if (productos.isEmpty()) {
            throw new Exception("La lista de productos está vacía.");
        }
        
        Producto masCaro = productos.get(0);
        
        for (int i = 1; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getPrecio() > masCaro.getPrecio()) {
                masCaro = p;
            }
        }
        return masCaro;
    }
    
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("Lista de productos vacía.");
            return;
        }
        System.out.println("\n--- Lista Actual de Productos ---");
        for (Producto p : productos) {
            System.out.println(p);
        }
        System.out.println("------------------------------------");
    }
}