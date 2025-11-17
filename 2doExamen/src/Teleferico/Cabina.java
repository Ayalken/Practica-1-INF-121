package Teleferico;

public class Cabina {
	String nroCabina;
	Persona personasAbordo[];
	
	public Cabina(String nro) {
	    nroCabina = nro;
	    personasAbordo = new Persona[10]; 
	}
	
	public boolean agregarPersona(Persona p) {
	    float totalPeso = 0;
	    int cont = 0;
	
	    for (Persona x : personasAbordo) {
	        if (x != null) {
	            totalPeso += x.peso;
	            cont++;
	        }
	    }
	
	    if (cont >= 10) return false;      
	    if (totalPeso + p.peso > 850) return false; 
	
	    personasAbordo[cont] = p;
	    return true;
	}
	
	public float ingresoCabina() {
	    float total = 0;
	    for (Persona p : personasAbordo) {
	        if (p != null) {
	            if (p.edad < 25 || p.edad > 60)
	                total += 1.5f;
	            else
	                total += 3f;
	        }
	    }
	    return total;
	}
	
	public boolean cumpleReglas() {
	    float peso = 0;
	    int c = 0;
	    for (Persona p : personasAbordo) {
	        if (p != null) {
	            peso += p.peso;
	            c++;
	        }
	    }
	    return c <= 10 && peso <= 850;
	}
}

