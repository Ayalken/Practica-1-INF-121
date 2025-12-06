package ejercicio7;

public class Niño extends Persona {
    private int edad; 
    private double peso; 
    private double talla; 

    public Niño(String nombre, String apellidoPaterno, String apellidoMaterno, int ci, int edad, double peso, double talla) {
        super(nombre, apellidoPaterno, apellidoMaterno, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public Niño() {
        super();
        edad = 0;
        peso = 0.0;
        talla = 0.0;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public double getTalla() {
        return talla;
    }
    
    public boolean tienePesoAdecuado() {
        double pesoIdeal = (edad * 2) + 8; 
        double minPeso = pesoIdeal * 0.90; 
        double maxPeso = pesoIdeal * 1.10; 
        
        return peso >= minPeso && peso <= maxPeso;
    }

    public boolean tieneTallaAdecuada() {
        double tallaIdeal = (edad * 5) + 80; 
        double minTalla = tallaIdeal * 0.95; 
        double maxTalla = tallaIdeal * 1.05; 
        
        return talla >= minTalla && talla <= maxTalla;
    }

    @Override
    public String toString() {
        return "Niño [CI=" + getCi() + ", Nombre=" + getNombreCompleto() + 
               ", Edad=" + edad + " años, Peso=" + peso + " kg, Talla=" + talla + " cm]";
    }
}