package Ejercicio8;

public class Facultad {
	private String nombre;
	
	public Facultad(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return "Facultad [nombre=" + nombre + "]";
	}
	
}
