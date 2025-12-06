package ejercicio5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchFarmacia {

    private ArrayList<Farmacia> farmacias;
    private final String nombreArch; 
    private final Gson g = new Gson();

    public ArchFarmacia(String na) {
        this.nombreArch = na;
        this.farmacias = new ArrayList<>();
        crearArchivo();
    }
    
    public void crearArchivo() {
        try (FileReader reader = new FileReader(nombreArch)) {
            farmacias = g.fromJson(reader, new TypeToken<ArrayList<Farmacia>>(){}.getType());
            if (farmacias == null) {
                farmacias = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Archivo " + nombreArch + " no encontrado. Se crea una lista de farmacias vacía.");
            farmacias = new ArrayList<>();
        }
    }
    
    private void guardarCambios() {
        try (FileWriter writer = new FileWriter(nombreArch)) {
            g.toJson(farmacias, writer);
            System.out.println("Cambios guardados en " + nombreArch);
        } catch (IOException e) {
            System.err.println("Error guardando el archivo: " + e.getMessage());
        }
    }

    public void adicionar(Farmacia f) throws Exception {
        if (f == null) throw new IllegalArgumentException("La farmacia no puede ser nula.");
        
        for (Farmacia farmacia : farmacias) {
            if (farmacia.getSucursal() == f.getSucursal()) {
                throw new Exception("La sucursal número " + f.getSucursal() + " ya existe.");
            }
        }
        this.farmacias.add(f);
        guardarCambios();
    }
    
    private Farmacia buscaFarmaciaPorSucursal(int sucursal) throws Exception {
        for (Farmacia f : farmacias) {
            if (f.getSucursal() == sucursal) {
                return f;
            }
        }
        throw new Exception("No existe la Sucursal número " + sucursal);
    }

    public void mostrarMedicamentosTos(int sucursal) throws Exception {
        Farmacia f = buscaFarmaciaPorSucursal(sucursal);
        f.mostrarMedicamentos("tos");
    }

    public void mostrarSucursalesConMedicamento(String nombreMed) {
        System.out.println("--- Sucursales con medicamento '" + nombreMed + "' ---");
        boolean encontrado = false;
        
        for (Farmacia f : farmacias) {
            for (Medicamento m : f.getMedicamentos()) {
                if (m.getNombre().equalsIgnoreCase(nombreMed)) {
                    System.out.println("Sucursal: " + f.getSucursal() + ", Dirección: " + f.getDireccion());
                    encontrado = true;
                    break; 
                }
            }
        }
        if (!encontrado) {
            System.out.println("Ninguna sucursal tiene el medicamento " + nombreMed + ".");
        }
    }

    public void buscarMedicamentosPorTipo(String tipo) {
        System.out.println("--- Resultados de búsqueda por tipo '" + tipo + "' ---");
        boolean encontradoTotal = false;
        for (Farmacia f : farmacias) {
            System.out.println("\nEn " + f);
            boolean encontradoFarmacia = false;
            for (Medicamento m : f.getMedicamentos()) {
                if (m.getTipo().equalsIgnoreCase(tipo)) {
                    System.out.println("  -> " + m);
                    encontradoFarmacia = true;
                    encontradoTotal = true;
                }
            }
            if (!encontradoFarmacia) {
                System.out.println("  -> Ninguno.");
            }
        }
        if (!encontradoTotal) {
             System.out.println("El tipo '" + tipo + "' no fue encontrado en ninguna farmacia.");
        }
    }
    
    public void ordenarFarmaciasPorDireccion() throws Exception {
        if (farmacias.isEmpty()) {
            throw new Exception("No hay farmacias para ordenar.");
        }
        
        int n = farmacias.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compara direcciones alfabéticamente (String.compareTo())
                if (farmacias.get(j).getDireccion().compareTo(farmacias.get(j + 1).getDireccion()) > 0) {
                    Farmacia temp = farmacias.get(j);
                    farmacias.set(j, farmacias.get(j + 1));
                    farmacias.set(j + 1, temp);
                }
            }
        }
        System.out.println("Lista de farmacias ordenada por dirección.");
        listar();
    }

    public void moverMedicamentosPorTipo(String tipo, int sucursalA, int sucursalZ) throws Exception {
        Farmacia farmaciaA = buscaFarmaciaPorSucursal(sucursalA);
        Farmacia farmaciaZ = buscaFarmaciaPorSucursal(sucursalZ);

        ArrayList<Medicamento> medsATransferir = new ArrayList<>();
        
        for (Medicamento m : farmaciaA.getMedicamentos()) {
            if (m.getTipo().equalsIgnoreCase(tipo)) {
                medsATransferir.add(m);
            }
        }
        
        if (medsATransferir.isEmpty()) {
            throw new Exception("No se encontraron medicamentos de tipo '" + tipo + "' en la Sucursal " + sucursalA);
        }

        int contador = 0;
        for (Medicamento m : medsATransferir) {
            farmaciaA.eliminarMedicamento(m); // Eliminar de A
            farmaciaZ.adicionarMedicamento(m); // Añadir a Z
            contador++;
        }
        
        System.out.println("Se movieron " + contador + " medicamentos de tipo '" + tipo + "' de Sucursal " + sucursalA + " a Sucursal " + sucursalZ);
        guardarCambios();
    }
    
    public void listar() {
        if (farmacias.isEmpty()) {
            System.out.println("La lista de farmacias está vacía.");
            return;
        }
        System.out.println("\n--- LISTA ACTUAL DE FARMACIAS ---");
        for (Farmacia f : farmacias) {
            System.out.println(f);
            for (Medicamento m : f.getMedicamentos()) {
                System.out.println("  -> " + m);
            }
        }
        System.out.println("---------------------------------");
    }
}
