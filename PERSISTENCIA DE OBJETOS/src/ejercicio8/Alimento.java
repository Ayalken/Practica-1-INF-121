package ejercicio8;

public class Alimento {
    private String nombre;
    private String fechaVencimiento; 
    private int cantidad;

    public Alimento(String nombre, String fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.fechaVencimiento = fechaVencimiento; 
        this.cantidad = cantidad;
    }

    public Alimento() {
        nombre = "";
        fechaVencimiento = "2000-01-01"; 
        cantidad = 0;
        
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

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    public boolean isVencidoAntesDe(String otraFecha) {
        return this.fechaVencimiento.compareTo(otraFecha) < 0;
    }

    @Override
    public String toString() {
        return "Alimento{" + "nombre=" + nombre + ", fechaVencimiento=" + fechaVencimiento + ", cantidad=" + cantidad + '}';
    }
    
}