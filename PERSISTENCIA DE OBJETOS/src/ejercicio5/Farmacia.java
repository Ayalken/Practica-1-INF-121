package ejercicio5;

import java.util.ArrayList;

public class Farmacia {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private ArrayList<Medicamento> medicamentos; 

    
    public Farmacia(String nombreFarmacia, int sucursal, String direccion) {
        this.nombreFarmacia = nombreFarmacia;
        this.sucursal = sucursal;
        this.direccion = direccion;
        this.medicamentos = new ArrayList<>();
        this.nroMedicamentos = 0;
    }

    public Farmacia() {
        this("", 0, "");
    }

    public void adicionarMedicamento(Medicamento m) {
        // Validación básica si se quiere limitar a 100, pero con ArrayList no es necesario
        this.medicamentos.add(m);
        this.nroMedicamentos = this.medicamentos.size();
    }
    
    public void mostrarMedicamentos(String tipo) {
        System.out.println("--- Medicamentos tipo '" + tipo + "' en Sucursal " + sucursal + " ---");
        boolean encontrado = false;
        for (Medicamento m : medicamentos) {
            if (m.getTipo().equalsIgnoreCase(tipo)) {
                System.out.println(m);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron medicamentos de tipo " + tipo + ".");
        }
    }

    public Medicamento buscaMedicamento(int cod) throws Exception {
        for (Medicamento m : medicamentos) {
            if (m.getCodMedicamento() == cod) {
                return m;
            }
        }
        throw new Exception("Medicamento con código " + cod + " no encontrado en Sucursal " + sucursal);
    }
    
    public Medicamento eliminarMedicamento(Medicamento med) {
        if (medicamentos.remove(med)) {
            this.nroMedicamentos = this.medicamentos.size();
            return med;
        }
        return null;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    @Override
    public String toString() {
        return "Farmacia [Sucursal=" + sucursal + ", Dirección='" + direccion + "', #Meds=" + nroMedicamentos + "]";
    }
}