package Teleferico;

import java.util.ArrayList;

public class MiTeleferico {
	private ArrayList<Linea>lineas;
	private float cantidadIngresos;
	
	public MiTeleferico(ArrayList<Linea>lineas,float cantidadIngresos) {
		this.cantidadIngresos=cantidadIngresos;
		this.lineas=lineas;
	}
}
