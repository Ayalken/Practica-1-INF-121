package Teleferico;

public class Main {
    public static void main(String[] args) {
    	
        MiTeleferico mt = new MiTeleferico();

        Linea amarillo = new Linea("Amarillo");
        Linea rojo = new Linea("Rojo");
        Linea verde = new Linea("Verde");

        mt.agregarLinea(amarillo);
        mt.agregarLinea(rojo);
        mt.agregarLinea(verde);

        Cabina c1 = new Cabina("C1");
        Cabina c2 = new Cabina("C2");
        Cabina c3 = new Cabina("C3");

        amarillo.agregarCabina(c1);
        rojo.agregarCabina(c2);
        verde.agregarCabina(c3);

        Persona p1 = new Persona("Ana", 20, 60);
        Persona p2 = new Persona("Luis", 30, 70);
        Persona p3 = new Persona("Marta", 65, 55);

        c1.agregarPersona(p1);
        c2.agregarPersona(p2);
        c3.agregarPersona(p3);

        boolean reglas = mt.verificarReglas();
        System.out.println("¿Todas las cabinas cumplen reglas? " + reglas);

        float total = mt.ingresoTotal();
        System.out.println("Ingreso total del Teleférico: " + total);

        Linea mayor = mt.lineaMayorRegular();
        if (mayor != null) {
            System.out.println("Línea con mayor ingreso regular: " + mayor.color);
        }
    }
}

