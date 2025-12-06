package ejercicio8;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchRefri {
    private ArrayList<Alimento> alimentos;
    private final String nomArch; 
    private final Gson g = new Gson();

    public ArchRefri(String nombre) {
        this.nomArch = nombre;
        this.alimentos = new ArrayList<>();
        cargarArchivo();
    }
    
    private void cargarArchivo() {
        try (FileReader reader = new FileReader(nomArch)) {
            alimentos = g.fromJson(reader, new TypeToken<ArrayList<Alimento>>(){}.getType());
            if (alimentos == null) {
                alimentos = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Archivo " + nomArch + " no encontrado. Se crea una lista de alimentos vacía.");
            alimentos = new ArrayList<>();
        }
    }
    
    private void guardarCambios() {
        try (FileWriter writer = new FileWriter(nomArch)) {
            g.toJson(alimentos, writer);
            System.out.println("Cambios guardados en " + nomArch);
        } catch (IOException e) {
            System.err.println("Error guardando el archivo: " + e.getMessage());
        }
    }
    
    private Alimento buscarAlimentoPorNombre(String nombre) {
        for (Alimento a : alimentos) {
            if (a.getNombre().equalsIgnoreCase(nombre.trim())) {
                return a;
            }
        }
        return null; 
    }
    
    public void adicionar(Alimento a) throws Exception {
        if (buscarAlimentoPorNombre(a.getNombre()) != null) {
            throw new Exception("Ya existe un alimento con el nombre: " + a.getNombre());
        }
        this.alimentos.add(a);
        guardarCambios();
    }
    
    public void modificarCantidadPorNombre(String nombre, int nuevaCantidad) throws Exception {
        Alimento a = buscarAlimentoPorNombre(nombre);
        if (a == null) {
            throw new Exception("Alimento '" + nombre + "' no encontrado para modificar.");
        }
        a.setCantidad(nuevaCantidad);
        System.out.println("Alimento '" + nombre + "' modificado. Nueva Cantidad: " + nuevaCantidad);
        guardarCambios();
    }

    public void eliminarPorNombre(String nombre) throws Exception {
        Alimento a = buscarAlimentoPorNombre(nombre);
        if (a == null) {
            throw new Exception("Alimento '" + nombre + "' no encontrado para eliminar.");
        }
        this.alimentos.remove(a);
        System.out.println("Alimento '" + nombre + "' eliminado correctamente.");
        guardarCambios();
    }

    public ArrayList<Alimento> mostrarCaducadosAntesDe(String fechaX) {
        ArrayList<Alimento> resultado = new ArrayList<>();
        
        for (Alimento a : alimentos) {
            if (a.isVencidoAntesDe(fechaX)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public int eliminarAlimentosCantidadCero() {
        int eliminados = 0;
        for (int i = alimentos.size() - 1; i >= 0; i--) {
            if (alimentos.get(i).getCantidad() == 0) {
                alimentos.remove(i);
                eliminados++;
            }
        }
        if (eliminados > 0) {
            guardarCambios();
        }
        return eliminados;
    }

    public ArrayList<Alimento> buscarAlimentosVencidos(String fechaActual) {
        ArrayList<Alimento> vencidos = new ArrayList<>();
        
        for (Alimento a : alimentos) {
            if (a.isVencidoAntesDe(fechaActual)) {
                vencidos.add(a);
            }
        }
        return vencidos;
    }

    public Alimento mostrarAlimentoConMasCantidad() throws Exception {
        if (alimentos.isEmpty()) {
            throw new Exception("El refrigerador está vacío.");
        }
        
        Alimento masCantidad = alimentos.get(0);
        
        for (int i = 1; i < alimentos.size(); i++) {
            Alimento a = alimentos.get(i);
            if (a.getCantidad() > masCantidad.getCantidad()) {
                masCantidad = a;
            }
        }        
        return masCantidad;
    }
    
    public void listar() {
        if (alimentos.isEmpty()) {
            System.out.println("El refrigerador está vacío.");
            return;
        }
        System.out.println("\n--- CONTENIDO ACTUAL DEL REFRIGERADOR ---");
        for (Alimento a : alimentos) {
            System.out.println(a);
        }
        System.out.println("----------------------------------------");
    }
}