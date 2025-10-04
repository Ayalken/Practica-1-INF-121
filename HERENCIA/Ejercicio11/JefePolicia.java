package Herencia.Ejercicio11;

public class JefePolicia extends Persona implements IComparacion {
    private Empleado empleado;
    private Policia policia;
    private String area;
    private String ciudad;

    public JefePolicia(String nombre, int edad, double sueldo, int aniosExp, String grado, String rango, String area, String ciudad) {
        super(nombre, edad);
        this.empleado = new Empleado(sueldo, aniosExp);
        this.policia = new Policia(grado, rango);
        this.area = area;
        this.ciudad = ciudad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Policia getPolicia() {
        return policia;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre() + ", Edad: " + getEdad());
        System.out.println("Sueldo: " + empleado.getSueldo() + ", Años Exp: " + empleado.getAniosExp());
        System.out.println("Grado: " + policia.getGrado() + ", Rango: " + policia.getRango());
        System.out.println("Área: " + area + ", Ciudad: " + ciudad);
        System.out.println("-----------------------------");
    }

    @Override
    public JefePolicia compararSueldo(JefePolicia j1, JefePolicia j2) {
        return (j1.getEmpleado().getSueldo() > j2.getEmpleado().getSueldo()) ? j1 : j2;
    }

    @Override
    public boolean compararGrado(JefePolicia j1, JefePolicia j2) {
        return j1.getPolicia().getGrado().equalsIgnoreCase(j2.getPolicia().getGrado());
    }
}