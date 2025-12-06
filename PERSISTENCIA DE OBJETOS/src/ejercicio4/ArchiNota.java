package ejercicio4;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchiNota {

    private final String nombreArch; 
    private ArrayList<Nota> notas;
    private final Gson g = new Gson();

    public ArchiNota(String nombreArchi) {
        this.nombreArch = nombreArchi;
        this.notas = new ArrayList<>();
        crearArchivo();
    }
    
    public void crearArchivo() {
        try (FileReader reader = new FileReader(nombreArch)) {
            notas = g.fromJson(reader, new TypeToken<ArrayList<Nota>>(){}.getType());
            if (notas == null) {
                notas = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Archivo " + nombreArch + " no encontrado o vacío. Se crea una lista de notas vacía.");
            notas = new ArrayList<>();
        }
    }
    
    private void guardarCambios() {
        try (FileWriter writer = new FileWriter(nombreArch)) {
            g.toJson(notas, writer);
            System.out.println("Cambios guardados en " + nombreArch);
        } catch (IOException e) {
            System.err.println("Error guardando el archivo: " + e.getMessage());
        }
    }

    public void agregarVariasNotas(ArrayList<Nota> nuevasNotas) throws Exception {
        if (nuevasNotas == null || nuevasNotas.isEmpty()) {
            throw new Exception("La lista de notas a agregar no puede estar vacía.");
        }
        this.notas.addAll(nuevasNotas);
        guardarCambios(); 
    }

    public double obtenerPromedioNotas() throws Exception {
        if (notas.isEmpty()) {
            throw new Exception("No hay notas para calcular el promedio.");
        }
        
        double sumaNotas = 0.0;
        for (Nota n : notas) {
            sumaNotas += n.getNotaFinal();
        }
        
        return sumaNotas / notas.size();
    }

    public ArrayList<Estudiante> buscarMejorNota() throws Exception {
        if (notas.isEmpty()) {
            throw new Exception("No hay notas registradas.");
        }
        
        double notaMaxima = 0.0;
        for (Nota n : notas) {
            if (n.getNotaFinal() > notaMaxima) {
                notaMaxima = n.getNotaFinal();
            }
        }
        
        ArrayList<Estudiante> mejoresEstudiantes = new ArrayList<>();
        for (Nota n : notas) {
            if (n.getNotaFinal() == notaMaxima) {
                boolean existe = false;
                for (Estudiante e : mejoresEstudiantes) {
                    if (e.getRu().equals(n.getEstudiante().getRu())) {
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    mejoresEstudiantes.add(n.getEstudiante());
                }
            }
        }
        
        return mejoresEstudiantes;
    }

    public void eliminarNotasPorMateria(String materia) throws Exception {
        if (materia == null || materia.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la materia no puede estar vacío.");
        }
        
        ArrayList<Nota> notasAEliminar = new ArrayList<>();
        int notasEliminadas = 0;
        
        for (Nota n : notas) {
            if (n.getMateria().equalsIgnoreCase(materia.trim())) {
                notasAEliminar.add(n);
                notasEliminadas++;
            }
        }
        
        if (notasEliminadas == 0) {
            throw new Exception("No se encontraron notas para la materia: " + materia);
        }
        
        this.notas.removeAll(notasAEliminar);
        System.out.println("Se eliminaron " + notasEliminadas + " notas de la materia: " + materia);
        guardarCambios(); 
    }
    
    public void listarNotas() {
        if (notas.isEmpty()) {
            System.out.println("Lista de notas vacía.");
            return;
        }
        System.out.println("\n--- Lista Actual de Notas ---");
        for (Nota n : notas) {
            System.out.println(n);
        }
        System.out.println("------------------------------------");
    }
}