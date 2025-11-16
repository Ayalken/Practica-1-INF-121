package Ejercicio10;

public class Persona {
	private String nombre;
    private String apellido;
    private int edad;
    private int ci;

    public Persona(String nombre, String apellido, int edad, int ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ci = ci;
    }

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public int getCi() {
		return ci;
	}
    
}
