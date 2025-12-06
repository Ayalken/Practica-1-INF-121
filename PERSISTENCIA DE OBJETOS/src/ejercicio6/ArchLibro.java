package ejercicio6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchLibro {
    private ArrayList<Libro> libros;
    private final String nomArch; 
    private final Gson g = new Gson();
    
    private ArchPrestamo archPrestamo;

    public ArchLibro(String nomArch, ArchPrestamo archPrestamo) {
        this.nomArch = nomArch;
        this.libros = new ArrayList<>();
        this.archPrestamo = archPrestamo;
        cargarArchivo();
    }
    
    private void cargarArchivo() {}
    public void guardarArchivo() {}
    public void adicionar(Libro l) { 
        this.libros.add(l);
        guardarArchivo();
    }
    public Libro buscaLibro(int cod) throws Exception {
        for (Libro l : libros) {
            if (l.getCodLibro() == cod) return l;
        }
        throw new Exception("Libro con código " + cod + " no encontrado.");
    }
    public ArrayList<Libro> getLibros() { 
        return libros; 
    }

    public ArrayList<Libro> listarLibrosPorRangoPrecio(double x, double y) {
        ArrayList<Libro> resultado = new ArrayList<>();
        // Aseguramos que x sea el valor menor
        double min = Math.min(x, y); 
        double max = Math.max(x, y);
        
        System.out.println("\n--- Listando libros entre " + min + " y " + max + " ---");
        for (Libro l : libros) {
            if (l.getPrecio() >= min && l.getPrecio() <= max) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public double calcularIngresoTotalLibro(int codLibro) throws Exception {
        Libro libro = buscaLibro(codLibro); 
        double ingreso = 0.0;
        ArrayList<Prestamo> prestamos = archPrestamo.buscarPrestamosPorLibro(codLibro);        
        for (Prestamo p : prestamos) {
            ingreso += libro.getPrecio() * p.getCantidad();
        }
        return ingreso;
    }

    public ArrayList<Libro> mostrarLibrosNoVendidos() {
        ArrayList<Libro> noVendidos = new ArrayList<>();
        
        for (Libro l : libros) {
            if (!archPrestamo.existePrestamoParaLibro(l.getCodLibro())) {
                noVendidos.add(l);
            }
        }
        return noVendidos;
    }
}
