package ejercicio6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchPrestamo {
    private ArrayList<Prestamo> prestamos;
    private final String nomArch; 
    private final Gson g = new Gson();
    
    private ArchCliente archCliente; 

    public ArchPrestamo(String nomArch) {
        this.nomArch = nomArch;
        this.prestamos = new ArrayList<>();
        cargarArchivo();
    }
    
    public void setArchCliente(ArchCliente archCliente) {
        this.archCliente = archCliente;
    }
    
    private void cargarArchivo() {  }
    public void guardarArchivo() {  }

    public void adicionar(Prestamo p) { 
        this.prestamos.add(p);
        guardarArchivo();
    }
    
    public ArrayList<Prestamo> getPrestamos() { 
        return prestamos; 
    }
    public ArrayList<Prestamo> buscarPrestamosPorLibro(int codLibro) {
        ArrayList<Prestamo> resultado = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (p.getCodLibro() == codLibro) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    public boolean existePrestamoParaLibro(int codLibro) {
        for (Prestamo p : prestamos) {
            if (p.getCodLibro() == codLibro) {
                return true;
            }
        }
        return false;
    }

    public int definirLibroMasPrestado() throws Exception {
        if (prestamos.isEmpty()) throw new Exception("No hay préstamos registrados.");

        int libroMasPrestado = 0;
        int maxCantidad = -1;
        
        ArrayList<Integer> codigos = new ArrayList<>();
        ArrayList<Integer> totales = new ArrayList<>();
        
        for (Prestamo p : prestamos) {
            int index = codigos.indexOf(p.getCodLibro());
            if (index == -1) {
                codigos.add(p.getCodLibro());
                totales.add(p.getCantidad());
            } else {
                totales.set(index, totales.get(index) + p.getCantidad());
            }
        }

        for (int i = 0; i < totales.size(); i++) {
            if (totales.get(i) > maxCantidad) {
                maxCantidad = totales.get(i);
                libroMasPrestado = codigos.get(i);
            }
        }
        
        return libroMasPrestado;
    }

    public int mostrarClienteConMasPrestamos() throws Exception {
        if (prestamos.isEmpty()) throw new Exception("No hay préstamos registrados.");

        int clienteMasPrestamos = 0;
        int maxTransacciones = -1;
        
        ArrayList<Integer> codigos = new ArrayList<>();
        ArrayList<Integer> totales = new ArrayList<>();
        
        for (Prestamo p : prestamos) {
            int index = codigos.indexOf(p.getCodCliente());
            if (index == -1) {
                codigos.add(p.getCodCliente());
                totales.add(1); 
            } else {
                totales.set(index, totales.get(index) + 1); 
            }
        }
        
        for (int i = 0; i < totales.size(); i++) {
            if (totales.get(i) > maxTransacciones) {
                maxTransacciones = totales.get(i);
                clienteMasPrestamos = codigos.get(i);
            }
        }        
        return clienteMasPrestamos;
    }
}