package Ejercicio2;

public class Videojuego {
	public String nombre;
	public String plataforma;
	public int cantidadDeJugadores;
	
	public Videojuego() {
		nombre="";
		plataforma="";
		cantidadDeJugadores=0;
	}
	public Videojuego(String nombre,String plataforma) {
		this.nombre=nombre;
		this.plataforma=plataforma;
		this.cantidadDeJugadores=0;
	}
	public Videojuego(String nombre,String plataforma,int cantidadDeJugadores) {
		this.nombre=nombre;
		this.plataforma=plataforma;
		this.cantidadDeJugadores=cantidadDeJugadores;
	}
	public void agregarJugadores() {
		cantidadDeJugadores++;
	}
	public void agregarJugadores(int cantidad) {
		cantidadDeJugadores+=cantidad;
	}
	
}
