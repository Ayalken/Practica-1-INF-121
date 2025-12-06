package ejercicio2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoTrabajador {

    private ArrayList<Trabajador> trabajadores;
    private final Gson g = new Gson();
    private final String nombreArch = "trabajadores.json";

    public ArchivoTrabajador() {
        trabajadores = new ArrayList<>();
        cargarArchivo();
    }
    
    private void cargarArchivo() {
        try (FileReader reader = new FileReader(nombreArch)) {
            trabajadores = g.fromJson(reader, new TypeToken<ArrayList<Trabajador>>(){}.getType());
            if (trabajadores == null) {
                trabajadores = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("El archivo no existe o no se pudo leer. Se crea una lista vacía.");
            trabajadores = new ArrayList<>();
        }
    }
    
    private Trabajador buscarPorCarnet(int carnet) throws Exception {
        for (Trabajador t : trabajadores) {
            if (t.getCarnet() == carnet) {
                return t;
            }
        }
        throw new Exception("No existe el trabajador con carnet: " + carnet);
    }
    
    private boolean existeCarnet(int carnet) {
        for (Trabajador t : trabajadores) {
            if (t.getCarnet() == carnet) {
                return true;
            }
        }
        return false;
    }
    
    public void guardarArchivo() {
        try (FileWriter writer = new FileWriter(nombreArch)) {
            g.toJson(trabajadores, writer);
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error guardando el archivo: " + e.getMessage());
        }
    }

    public void guardarTrabajador(Trabajador t) throws Exception {
        if (t == null) {
            throw new IllegalArgumentException("El trabajador no puede ser nulo.");
        }
        if (existeCarnet(t.getCarnet())) {
             throw new Exception("Error: Ya existe un trabajador con el carnet " + t.getCarnet());
        }
        
        this.trabajadores.add(t);
        guardarArchivo(); 
    }

    public void aumentaSalario(int aumento, int carnet) throws Exception {
        Trabajador t = buscarPorCarnet(carnet);
        double nuevoSalario = t.getSalario() + aumento;
        t.setSalario(nuevoSalario);
        System.out.println("Salario de " + t.getNombre() + " (Carnet: " + carnet + ") aumentado a: " + t.getSalario());
        guardarArchivo(); 
    }

    public Trabajador buscarMayorSalario() throws Exception {
        if (trabajadores.isEmpty()) {
            throw new Exception("La lista de trabajadores está vacía.");
        }
        
        Trabajador mayorSalario = trabajadores.get(0);
        
        for (int i = 1; i < trabajadores.size(); i++) {
            Trabajador t = trabajadores.get(i);
            if (t.getSalario() > mayorSalario.getSalario()) {
                mayorSalario = t;
            }
        }
        
        return mayorSalario;
    }

    public void ordenarPorSalario() throws Exception {
        if (trabajadores.isEmpty()) {
            throw new Exception("No hay trabajadores para ordenar.");
        }
        
        int n = trabajadores.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (trabajadores.get(j).getSalario() > trabajadores.get(j + 1).getSalario()) {
                    // Intercambiar elementos
                    Trabajador temp = trabajadores.get(j);
                    trabajadores.set(j, trabajadores.get(j + 1));
                    trabajadores.set(j + 1, temp);
                }
            }
        }
        
        System.out.println("\n--- Trabajadores ordenados por salario (Ascendente) ---");
        for (Trabajador t : trabajadores) {
            System.out.println(t);
        }
        System.out.println("------------------------------------------------------");
    }
    
    public void listarTrabajadores() {
        if (trabajadores.isEmpty()) {
            System.out.println("Lista de trabajadores vacía.");
            return;
        }
        System.out.println("\n--- Lista Actual de Trabajadores ---");
        for (Trabajador t : trabajadores) {
            System.out.println(t);
        }
        System.out.println("------------------------------------");
    }
}