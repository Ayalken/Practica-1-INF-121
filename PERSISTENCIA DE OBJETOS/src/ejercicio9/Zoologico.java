package ejercicio9;

import java.util.ArrayList;

public class Zoologico {
    private int id;
    private String nombre;
    private int nroAnimales; 
    private ArrayList<Animal> animales; 

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.animales = new ArrayList<>();
        this.nroAnimales = 0;
    }

    public Zoologico() {
        this(0, "");
    }

    public boolean adicionarAnimal(Animal nuevoAnimal) {
        for (Animal a : animales) {
            // Si ya existe la misma especie con el mismo nombre
            if (a.getEspecie().equalsIgnoreCase(nuevoAnimal.getEspecie()) && 
                a.getNombre().equalsIgnoreCase(nuevoAnimal.getNombre())) {
                
                a.setCantidad(a.getCantidad() + nuevoAnimal.getCantidad());
                this.nroAnimales += nuevoAnimal.getCantidad();
                return false; 
            }
        }
        
        this.animales.add(nuevoAnimal);
        this.nroAnimales += nuevoAnimal.getCantidad();
        return true; 
    }
    
    public boolean eliminarAnimal(String especie, String nombre) {
        for (int i = 0; i < animales.size(); i++) {
            Animal a = animales.get(i);
            if (a.getEspecie().equalsIgnoreCase(especie) && a.getNombre().equalsIgnoreCase(nombre)) {
                this.nroAnimales -= a.getCantidad();
                animales.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean estaVacio() {
        return nroAnimales == 0;
    }
    
    public ArrayList<Animal> buscarAnimalesPorEspecie(String especie) {
        ArrayList<Animal> resultado = new ArrayList<>();
        for (Animal a : animales) {
            if (a.getEspecie().equalsIgnoreCase(especie)) {
                resultado.add(a);
            }
        }
        return resultado;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNroVariedades() {
        return animales.size();
    }
    
    public int getNroAnimales() {
        return nroAnimales;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    @Override
    public String toString() {
        return "Zoologico [ID=" + id + ", Nombre='" + nombre + 
               "', #Variedades=" + getNroVariedades() + ", #Individuos=" + nroAnimales + "]";
    }
}