package ejercicio7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchNiño {
    private ArrayList<Niño> ninos;
    private final String nomArch; 
    private final Gson g = new Gson();

    public ArchNiño(String na) {
        this.nomArch = na;
        this.ninos = new ArrayList<>();
        cargarArchivo();
    }
    
    private void cargarArchivo() {
        try (FileReader reader = new FileReader(nomArch)) {
            ninos = g.fromJson(reader, new TypeToken<ArrayList<Niño>>(){}.getType());
            if (ninos == null) {
                ninos = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Archivo " + nomArch + " no encontrado. Se crea una lista de niños vacía.");
            ninos = new ArrayList<>();
        }
    }
    
    private void guardarCambios() {
        try (FileWriter writer = new FileWriter(nomArch)) {
            g.toJson(ninos, writer);
            System.out.println("Cambios guardados en " + nomArch);
        } catch (IOException e) {
            System.err.println("Error guardando el archivo: " + e.getMessage());
        }
    }
    
    public void adicionar(Niño n) {
        this.ninos.add(n);
        guardarCambios();
    }
    
    public void listar() {
        if (ninos.isEmpty()) {
            System.out.println("Lista de niños vacía.");
            return;
        }
        System.out.println("\n--- LISTA ACTUAL DE NIÑOS ---");
        for (Niño n : ninos) {
            System.out.println(n);
        }
        System.out.println("-----------------------------");
    }

    public int contarNiñosConPesoAdecuado() {
        int contador = 0;
        for (Niño n : ninos) {
            if (n.tienePesoAdecuado()) {
                contador++;
            }
        }
        return contador;
    }

    public ArrayList<Niño> mostrarNiñosInadecuados() {
        ArrayList<Niño> inadecuados = new ArrayList<>();
        for (Niño n : ninos) {
            if (!n.tienePesoAdecuado() || !n.tieneTallaAdecuada()) {
                inadecuados.add(n);
            }
        }
        return inadecuados;
    }

    public double determinarPromedioEdad() throws Exception {
        if (ninos.isEmpty()) {
            throw new Exception("No hay niños para calcular el promedio de edad.");
        }        
        int sumaEdades = 0;
        for (Niño n : ninos) {
            sumaEdades += n.getEdad();
        }        
        return (double) sumaEdades / ninos.size();
    }

    public Niño buscarNiñoPorCarnet(int ci) throws Exception {
        for (Niño n : ninos) {
            if (n.getCi() == ci) {
                return n;
            }
        }
        throw new Exception("Niño con Carnet de Identidad (CI) " + ci + " no encontrado.");
    }

    public ArrayList<Niño> mostrarNiñosTallaMasAlta() throws Exception {
        if (ninos.isEmpty()) {
            throw new Exception("No hay niños registrados.");
        }
        
        double tallaMaxima = 0.0;
        for (Niño n : ninos) {
            if (n.getTalla() > tallaMaxima) {
                tallaMaxima = n.getTalla();
            }
        }
        
        ArrayList<Niño> masAltos = new ArrayList<>();
        for (Niño n : ninos) {
            if (n.getTalla() == tallaMaxima) {
                masAltos.add(n);
            }
        }
        
        return masAltos;
    }
}