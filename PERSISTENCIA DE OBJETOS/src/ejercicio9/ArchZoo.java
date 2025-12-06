package ejercicio9;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchZoo {

    private ArrayList<Zoologico> zoos;
    private final String nombreArch; 
    private final Gson g = new Gson();

    public ArchZoo(String na) {
        this.nombreArch = na;
        this.zoos = new ArrayList<>();
        cargarArchivo();
    }
    
    private void cargarArchivo() {
        try (FileReader reader = new FileReader(nombreArch)) {
            zoos = g.fromJson(reader, new TypeToken<ArrayList<Zoologico>>(){}.getType());
            if (zoos == null) {
                zoos = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Archivo " + nombreArch + " no encontrado. Se crea una lista de zoológicos vacía.");
            zoos = new ArrayList<>();
        }
    }
    
    private void guardarCambios() {
        try (FileWriter writer = new FileWriter(nombreArch)) {
            g.toJson(zoos, writer);
            System.out.println("Cambios guardados en " + nombreArch);
        } catch (IOException e) {
            System.err.println("Error guardando el archivo: " + e.getMessage());
        }
    }
    
    private Zoologico obtenerZoo(int id) {
        for (Zoologico z : zoos) {
            if (z.getId() == id) {
                return z;
            }
        }
        return null;
    }

    public void adicionar(Zoologico z) throws Exception {
        if (obtenerZoo(z.getId()) != null) {
        }
        this.zoos.add(z);
        guardarCambios();
    }

    public void modificarNombreZoo(int id, String nuevoNombre) throws Exception {
        Zoologico z = obtenerZoo(id);
        System.out.println("No se modificó el nombre (atributo privado sin setter).");
    }

    public void eliminarPorId(int id) throws Exception {
        Zoologico z = obtenerZoo(id);
        this.zoos.remove(z);
        System.out.println("Zoológico ID " + id + " eliminado correctamente.");
        guardarCambios();
    }

    public ArrayList<Zoologico> listarZoosMayorVariedad() throws Exception {
        if (zoos.isEmpty()) {
            throw new Exception("No hay zoológicos registrados.");
        }        
        int maxVariedad = -1;
        for (Zoologico z : zoos) {
            if (z.getNroVariedades() > maxVariedad) {
                maxVariedad = z.getNroVariedades();
            }
        }        
        ArrayList<Zoologico> resultado = new ArrayList<>();
        for (Zoologico z : zoos) {
            if (z.getNroVariedades() == maxVariedad) {
                resultado.add(z);
            }
        }        
        return resultado;
    }

    public ArrayList<Zoologico> listarZoosVaciosYEliminar() {
        ArrayList<Zoologico> eliminados = new ArrayList<>();        
        for (int i = zoos.size() - 1; i >= 0; i--) {
            Zoologico z = zoos.get(i);
            if (z.estaVacio()) {
                eliminados.add(z);
                zoos.remove(i);
            }
        }        
        if (!eliminados.isEmpty()) {
            guardarCambios();
        }
        return eliminados;
    }

    public void mostrarAnimalesPorEspecie(String especie) {
        System.out.println("\n--- Animales de especie '" + especie + "' en todos los Zoológicos ---");
        boolean encontradoTotal = false;
        
        for (Zoologico z : zoos) {
            ArrayList<Animal> animalesZoo = z.buscarAnimalesPorEspecie(especie);
            if (!animalesZoo.isEmpty()) {
                System.out.println("\nEn Zoológico ID " + z.getId() + " (" + z.getNombre() + "):");
                animalesZoo.forEach(a -> System.out.println("  -> " + a));
                encontradoTotal = true;
            }
        }        
        if (!encontradoTotal) {
            System.out.println("No se encontraron animales de la especie '" + especie + "' en ningún zoológico.");
        }
    }

    public void moverAnimales(int idOrigen, int idDestino) throws Exception {
        Zoologico origen = obtenerZoo(idOrigen);
        Zoologico destino = obtenerZoo(idDestino);        
        if (origen.equals(destino)) {
            throw new Exception("El zoológico de origen y destino son el mismo.");
        }
        int contador = 0;        
        for (Animal a : origen.getAnimales()) {
            destino.adicionarAnimal(a); 
            contador += a.getCantidad();
        }
        System.out.println("Se movieron " + contador + " individuos de " + origen.getNombre() + " (ID " + idOrigen + ") a " + destino.getNombre() + " (ID " + idDestino + ").");
        guardarCambios();
    }
    
    public void listar() {
        if (zoos.isEmpty()) {
            System.out.println("Lista de zoológicos vacía.");
            return;
        }
        System.out.println("\n--- LISTA ACTUAL DE ZOOLÓGICOS ---");
        for (Zoologico z : zoos) {
            System.out.println(z);
            for (Animal a : z.getAnimales()) {
                System.out.println("  -> " + a);
            }
        }
        System.out.println("---------------------------------");
    }
}