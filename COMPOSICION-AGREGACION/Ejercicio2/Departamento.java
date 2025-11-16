package Ejercicio2;

import java.util.ArrayList;

public class Departamento {

	private String nombre;
	private String area;
	private ArrayList<Empleado> empleados;
	
	public Departamento(String nom,String area,ArrayList<Empleado> empleados){
		this.nombre=nom;
		this.area=area;
		this.empleados=empleados;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", area=" + area + ", \nempleados=" + empleados;
	}
	//! Auxi dice cambiarSalario se puede hacer con un monto fijo o por porcentaje deje las 2 opciones 
	/*public void cambioSalario(double porcentaje) {
	    for (Empleado e : empleados) {
	        double nuevoSueldo = e.getSueldo()* (1 + porcentaje / 100);
	        e.setSueldo(nuevoSueldo);
	    }
	    System.out.println("Se cambió el salario de todos los empleados del " + nombre);
	}*/
	
	public void cambioSalario(double monto) {
	    for (Empleado e : empleados) {
	        double nuevoSueldo = e.getSueldo() + monto;
	        e.setSueldo(nuevoSueldo);
	    }
	    System.out.println("Se aumentó " + monto + " Bs a todos los empleados del " + nombre);
	}

	/*public void verificacionEmpleado() {
		
	}*/

	public void mostrarEmpleados() {
		if(empleados.isEmpty()){
			System.out.println("No hay empleados en " +nombre);}
		else {
			System.out.println("Empleados de "+nombre+":");
			for(Empleado e:empleados) {
				System.out.println(e);
			}
		}

	}
}
