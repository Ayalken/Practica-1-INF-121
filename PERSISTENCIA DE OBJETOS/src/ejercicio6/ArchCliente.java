package ejercicio6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchCliente {
    private ArrayList<Cliente> clientes;
    private final String nomArch; 
    private final Gson g = new Gson();

    private ArchPrestamo archPrestamo;
    private ArchLibro archLibro;

    public ArchCliente(String nomArch, ArchPrestamo archPrestamo, ArchLibro archLibro) {
        this.nomArch = nomArch;
        this.clientes = new ArrayList<>();
        this.archPrestamo = archPrestamo;
        this.archLibro = archLibro;
        cargarArchivo();
    }
    
    private void cargarArchivo() { }
    public void guardarArchivo() { }
    
    public void adicionar(Cliente c) { 
        this.clientes.add(c);
        guardarArchivo();
    }
    public Cliente buscaCliente(int cod) throws Exception {
        for (Cliente c : clientes) {
            if (c.getCodCliente() == cod) return c;
        }
        throw new Exception("Cliente con código " + cod + " no encontrado.");
    }
    
    public ArrayList<Cliente> mostrarClientesPorLibro(int codLibro) throws Exception {
        archLibro.buscaLibro(codLibro); 
        
        ArrayList<Cliente> clientesResultado = new ArrayList<>();
        ArrayList<Integer> codigosProcesados = new ArrayList<>();
        
        // 1. Obtener todos los préstamos para ese libro
        ArrayList<Prestamo> prestamosLibro = archPrestamo.buscarPrestamosPorLibro(codLibro);
        
        for (Prestamo p : prestamosLibro) {
            int codCliente = p.getCodCliente();
            
            if (!codigosProcesados.contains(codCliente)) {
                Cliente c = buscaCliente(codCliente);
                clientesResultado.add(c);
                codigosProcesados.add(codCliente);
            }
        }
        
        return clientesResultado;
    }
}