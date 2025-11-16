package Ejercicio2;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
			ArrayList<Empleado> emp1=new ArrayList<Empleado>();
			emp1.add(new Empleado("Abel", "Gerente", 9500 ));
			emp1.add(new Empleado("Erling", "Director", 8700.5));
			emp1.add(new Empleado("Sami", "Contador", 5000));
			emp1.add(new Empleado("Ema", "Fiscalia", 6570.5));
			emp1.add(new Empleado("Lorenza", "Marketing", 8350.7));
			
			Departamento d1=new Departamento("Departamento 1", "Recursos Humanos",emp1);
			Departamento d2=new Departamento("Departamento 2", "Recursos Humanos",new ArrayList<Empleado> ());
			d1.mostrarEmpleados();
			d2.mostrarEmpleados();
			
			System.out.println("+++++++++++++++++++++++++++++++");

			d1.cambioSalario(10);
			d1.mostrarEmpleados(); 

	}

}
