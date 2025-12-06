package ejercicio1;

public class Charango {
    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas; 
    
    public Charango() {
        this.material = "Desconocido";
        this.nroCuerdas = 0;
        this.cuerdas = new boolean[10]; 
    }

    public Charango(String material, int nroCuerdas, boolean[] cuerdas) {
        this.material = material;
        this.nroCuerdas = nroCuerdas;
        this.cuerdas = cuerdas;
    }

    public String getMaterial() { 
        return material; 
    }
    public int getNroCuerdas() { 
        return nroCuerdas; 
    }
    public boolean[] getCuerdas() { 
        return cuerdas; 
    }

    public int getCuerdasMalas() {
        int malas = 0;
        for (boolean estado : cuerdas) {
            if (!estado) {
                malas++;
            }
        }
        return malas;
    }

    @Override
    public String toString() {
        String estadoCuerdas = "";
       
        if (cuerdas != null) {
            for (boolean c : cuerdas) {
                estadoCuerdas += (c ? "T" : "F") + " ";
            }
        }
        return "Charango [Material: " + material + 
               ", Nro Cuerdas: " + nroCuerdas + 
               ", Cuerdas (T=Buena, F=Mala): " + estadoCuerdas.trim() + 
               ", Cuerdas Malas: " + getCuerdasMalas() + "]";
    }
}