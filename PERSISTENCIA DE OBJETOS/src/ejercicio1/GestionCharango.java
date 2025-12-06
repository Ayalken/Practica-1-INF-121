package ejercicio1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Clase GestionCharangos
public class GestionCharango {
    
    private static final String ARCHIVO = "charangos.json";
    private final Gson gson = new Gson();

    /**
     * Guarda la lista de Charangos en un archivo JSON.
     */
    public void guardarCharangos(List<Charango> lista) {
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, writer);
            System.out.println("✅ Lista de charangos guardada exitosamente en " + ARCHIVO);
        } catch (IOException e) {
            System.err.println("❌ Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Carga la lista de Charangos desde un archivo JSON.
     */
    public List<Charango> cargarCharangos() {
        try (FileReader reader = new FileReader(ARCHIVO)) {
            java.lang.reflect.Type type = new TypeToken<ArrayList<Charango>>() {}.getType();
            List<Charango> lista = gson.fromJson(reader, type);
            System.out.println("✅ Lista de charangos cargada exitosamente desde " + ARCHIVO);
            // Devuelve la lista cargada o una lista vacía si la deserialización fue null
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("ℹ️ Archivo " + ARCHIVO + " no encontrado o vacío. Se devolverá una lista vacía.");
            return new ArrayList<>();
        }
    }

    // b) Eliminar a los charangos cuyas cuerdas en estado false sea mayor a 6.
    public void eliminarCharangosMalos(List<Charango> lista) {
        boolean removed = lista.removeIf(c -> c.getCuerdasMalas() > 6);
        if (removed) {
            System.out.println("✅ Se removieron los charangos con más de 6 cuerdas malas.");
        } else {
            System.out.println("ℹ️ No se encontraron charangos para remover.");
        }
    }

    // c) Listar a los charangos de material x.
    public List<Charango> listarPorMaterial(List<Charango> lista, String material) {
        return lista.stream()
                .filter(c -> c.getMaterial().equalsIgnoreCase(material))
                .collect(Collectors.toList());
    }

    // d) Buscar los charangos con 10 cuerdas (nroCuerdas).
    public List<Charango> buscarPorNroCuerdas(List<Charango> lista) {
        final int CUERDAS_BUSCADAS = 10;
        return lista.stream()
                .filter(c -> c.getNroCuerdas() == CUERDAS_BUSCADAS)
                .collect(Collectors.toList());
    }

    // e) Ordenar los charangos por material en orden alfabético.
    public void ordenarPorMaterial(List<Charango> lista) {
        Collections.sort(lista, (c1, c2) -> c1.getMaterial().compareToIgnoreCase(c2.getMaterial()));
        System.out.println("✅ La lista ha sido ordenada por material.");
    }
}