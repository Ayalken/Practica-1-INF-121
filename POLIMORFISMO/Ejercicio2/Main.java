package Ejercicio2;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Videojuego v1=new Videojuego("Minecraft","PC");
		Videojuego v2=new Videojuego("FIFA 25","PS5",1);
		
		System.out.println("Videojuego 1: "+v1.nombre+"-"+v1.plataforma+" - Jugadores: "+v1.cantidadDeJugadores);
		System.out.println("Videojuego 2: "+v2.nombre+"-"+v2.plataforma+" - Jugadores: "+v2.cantidadDeJugadores);
		v1.agregarJugadores();
		System.out.println("Despues de agregar Jugadores a: "+v1.nombre+"cantidad de jugadores: "+v1.cantidadDeJugadores);
		System.out.println("¿Cuantos jugadores quieres añadir a: "+v2.nombre+"?");
		int cantidad=sc.nextInt();
		v2.agregarJugadores(cantidad);
		
		System.out.println("Resultado final");

		System.out.println("Videojuego 1: "+v1.nombre+"-"+v1.plataforma+" - Jugadores: "+v1.cantidadDeJugadores);
		System.out.println("Videojuego 2: "+v2.nombre+"-"+v2.plataforma+" - Jugadores: "+v2.cantidadDeJugadores);
		sc.close();
	}

}
