package Ejercicio2;

public class Empleado {

	private String nombre;
	private String cargo;
	private double sueldo;
	
	public Empleado(String nom,String car,double suel) {
		this.nombre=nom;
		this.cargo=car;
		this.sueldo=suel;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public double getSueldo() {
		return sueldo;
	}
	public double setSueldo(double sueldo) {
		return this.sueldo=sueldo;
	}	
	
	@Override
	public String toString() {
		return "\nnombre=" + nombre + ", cargo=" + cargo + ", sueldo=" + sueldo ;
	}
	
}
