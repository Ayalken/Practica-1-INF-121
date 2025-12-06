package ejercicio10;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestionEmpresas {
    private static final String NOMBRE_ARCHIVO = "empresas.txt";
    private final Gson gson = new Gson();

    public List<Empresa> cargarEmpresas() {
        try (JsonReader reader = new JsonReader(new FileReader(NOMBRE_ARCHIVO))) {
            Type listType = new TypeToken<ArrayList<Empresa>>() {}.getType();
            
            List<Empresa> empresas = gson.fromJson(reader, listType);
            
            return (empresas == null) ? new ArrayList<>() : empresas;
            
        } catch (IOException e) {
            System.out.println("No se encontró el archivo de empresas o está vacío. Se creará uno nuevo al guardar.");
            return new ArrayList<>();
        }
    }

    public void guardarEmpresas(List<Empresa> empresas) {
        try (FileWriter writer = new FileWriter(NOMBRE_ARCHIVO)) {
            gson.toJson(empresas, writer);
            System.out.println("✅ Datos de empresas guardados exitosamente en " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.err.println("❌ Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public Empresa buscarEmpresa(String nombre, List<Empresa> empresas) {
        for (Empresa empresa : empresas) {
            if (empresa.getNombre().equalsIgnoreCase(nombre)) {
                return empresa;
            }
        }
        return null; 
    }
}