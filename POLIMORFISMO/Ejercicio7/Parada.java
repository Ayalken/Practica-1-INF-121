package Ejercicio7;

public class Parada {
	private String admis[]=new String[10];
	private String autos[][] = new String[10][3]; // [i][0]=modelo, [i][1]=conductor, [i][2]=placa
    private String nombreP;
    private int nroAdmins = 0;
    private int nroAutos = 0;
    
    public Parada() {
    	this.nombreP="";
    }
    public Parada(String nombreP) {
    	this.nombreP=nombreP;
    }
    public void mostrar() {
    	System.out.println("Nombre de la Parada: "+nombreP);
    	System.out.println("Administradores:");
        for (int i = 0; i < nroAdmins; i++) {
            System.out.println(" - " + admis[i]);
        }

        System.out.println("Autos:");
        for (int i = 0; i < nroAutos; i++) {
            System.out.println("Modelo: " + autos[i][0] +
                               ", Conductor: " + autos[i][1] +
                               ", Placa: " + autos[i][2]);
        }
    }
    public void adicionar(String admin) {
    	 if (nroAdmins < 10) {
             admis[nroAdmins] = admin;
             nroAdmins++;
         } else {
             System.out.println("No se puede añadir más administradores.");
         }
    }
    public void adicionar(String modelo, String conductor, String placa) {
        if (nroAutos < 10) {
            autos[nroAutos][0] = modelo;
            autos[nroAutos][1] = conductor;
            autos[nroAutos][2] = placa;
            nroAutos++;
        } else {
            System.out.println("No se puede añadir más autos.");
        }
    }
    
    public String getNombreP() {
        return nombreP;
    }
    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }
    public int getNroAdmins() {
        return nroAdmins;
    }

    public int getNroAutos() {
        return nroAutos;
    }
    
}
