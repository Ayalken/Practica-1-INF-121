package Ejercicio5;

public class Main {

	public static void main(String[] args) {
		Celular c1=new Celular("12345678","Javier",64,4,12);
		System.out.println("+++Datos antes del cambio:+++");
		c1.mostrarDatos();
		c1.incremetarOperador();
		c1.disminuirOperador();
		System.out.println("\n++++Mejoras/reducciones de celular++++");
		c1.mostrarDatos();
	}

}
