package Ejercicio4;

import java.util.ArrayList;

public class Ropero {
    private String material;
    private ArrayList<Ropa> ropas;
    private int nroRopas;
    
    public Ropero(String material) {
        this.material = material;
        this.ropas = new ArrayList<>();
        this.nroRopas = 0;
    }
    
    public void adicionar(Ropa r) {
        ropas.add(r);
        nroRopas++;
    }

    public void eliminar(String materialX, String tipoY) {
        ropas.removeIf(r -> 
            r.getMaterial().equalsIgnoreCase(materialX) ||
            r.getTipo().equalsIgnoreCase(tipoY)
        );
        nroRopas = ropas.size();
    }

    public void mostrar(String materialX, String tipoY) {
        for (Ropa r : ropas) {
            if (r.getMaterial().equalsIgnoreCase(materialX) &&
                r.getTipo().equalsIgnoreCase(tipoY)) {
                System.out.println(r);
            }
        }
    }

    public void mostrarTodo() {
        System.out.println("Ropero de " + material + " con " + nroRopas + " prendas:");
        for (Ropa r : ropas) {
            System.out.println(r);
        }
    }
}
