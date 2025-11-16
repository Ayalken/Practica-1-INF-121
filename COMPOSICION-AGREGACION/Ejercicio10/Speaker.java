package Ejercicio10;

public class Speaker extends Persona {
    private String especialidad;

    public Speaker(String nombre, String apellido, int edad, int ci, String especialidad) {
        super(nombre, apellido, edad, ci);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
