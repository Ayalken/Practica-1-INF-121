package Ejercicio5;

public class Celular {
	public String nroTelf;
	public String dueño;
	public int espacio;
	public int ram;
	public int nroApp;
	
	public Celular(String nroTelf,String dueño,int espacio,int ram,int nroApp) {
		this.nroTelf=nroTelf;
		this.dueño=dueño;
		this.espacio=espacio;
		this.ram=ram;
		this.nroApp=nroApp;
	}
	public void mostrarDatos() {
		System.out.println("Numero de telefono: "+this.nroTelf);
		System.out.println("Nombre de Dueño: "+this.dueño);
		System.out.println("Espacio: "+this.espacio+"GB");
		System.out.println("Ram"+this.ram+"GB");
		System.out.println("Nro App: "+this.nroApp);
	}
	public void incremetarOperador(){
		this.nroApp+=10;
	}
	public void disminuirOperador(){
		this.espacio-=5;
		if (this.espacio < 0) {
			this.espacio = 0;
		}
	}
	
}
