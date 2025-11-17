package Teleferico;

public class Linea {
	String color;
	Cabina cabinas[];

	 public Linea(String c) {
	     color = c;
	     cabinas = new Cabina[5]; 
	 }
	
	 public void agregarCabina(Cabina c) {
	     for (int i = 0; i < cabinas.length; i++) {
	         if (cabinas[i] == null) {
	             cabinas[i] = c;
	             break;
	         }
	     }
	 }
	
	 public float ingresoLinea() {
	     float t = 0;
	     for (Cabina ca : cabinas) {
	         if (ca != null) t += ca.ingresoCabina();
	     }
	     return t;
	 }
	
	 public boolean reglasOk() {
	     for (Cabina c : cabinas) {
	         if (c != null && !c.cumpleReglas()) return false;
	     }
	     return true;
	 }
}


