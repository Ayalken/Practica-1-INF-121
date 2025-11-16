package Ejercicio10;

import java.util.ArrayList;

public class Charla {
    private String lugar;
    private String nombreCharla;
    private Speaker speaker;
    private ArrayList<Participante> participantes;

    public Charla(String lugar, String nombreCharla, Speaker speaker) {
        this.lugar = lugar;
        this.nombreCharla = nombreCharla;
        this.speaker = speaker;
        this.participantes = new ArrayList<>();
    }

    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public String getNombreCharla() { 
    	return nombreCharla; 
    	}
    
    public Speaker getSpeaker() { 
    	return speaker; 
    	}
    
    public ArrayList<Participante> getParticipantes() { 
    	return participantes; 
    	}
    
    public int getNumParticipantes() { 
    	return participantes.size(); 
    	}
}

