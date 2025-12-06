package ejercicio9;

public class Animal {
    private String especie;
    private String nombre;
    private int cantidad; 

    public Animal(String especie, String nombre, int cantidad) {
        this.especie = especie;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Animal() {
        especie = "";
        nombre = "";
        cantidad = 0;
    }

    public String getEspecie() {
        return especie;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Animal [Especie=" + especie + ", Nombre='" + nombre + "', Cantidad=" + cantidad + "]";
    }
}