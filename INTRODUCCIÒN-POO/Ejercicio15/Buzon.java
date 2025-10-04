package Introduccion_a_POO.Ejercicio15;
public class Buzon {
    int nro;
    int nroC;
    String[][] c;

    public Buzon(int nro) {
        this.nro = nro;
        this.nroC = 0;
        this.c = new String[50][3];
    }

    public void agregarCarta(String codigo, String remitente, String destinatario) {
        if (nroC >= 50) {
            System.out.println("Buzon " + nro + " lleno. No se puede agregar más cartas.");
            return;
        }
        c[nroC][0] = codigo;
        c[nroC][1] = remitente;
        c[nroC][2] = destinatario;
        nroC++;
    }

    public boolean eliminarCarta(String codigo) {
        for (int i = 0; i < nroC; i++) {
            if (c[i][0].equalsIgnoreCase(codigo)) {
                for (int j = i; j < nroC - 1; j++) {
                    c[j][0] = c[j + 1][0];
                    c[j][1] = c[j + 1][1];
                    c[j][2] = c[j + 1][2];
                }
                c[nroC - 1][0] = null;
                c[nroC - 1][1] = null;
                c[nroC - 1][2] = null;
                nroC--;
                return true;
            }
        }
        return false;
    }

    public int contarCartasDestinatario(String destinatario) {
        int cuenta = 0;
        for (int i = 0; i < nroC; i++) {
            if (c[i][2].equalsIgnoreCase(destinatario)) cuenta++;
        }
        return cuenta;
    }

    public void mostrarCartas() {
        System.out.println("Buzon " + nro + " (nroC = " + nroC + ")");
        System.out.println("Codigo | Remitente | Destinatario");
        for (int i = 0; i < nroC; i++) {
            System.out.println(c[i][0] + " | " + c[i][1] + " | " + c[i][2]);
        }
        System.out.println();
    }

    public String[] buscarPorCodigo(String codigo) {
        for (int i = 0; i < nroC; i++) {
            if (c[i][0].equalsIgnoreCase(codigo)) {
                return new String[] { c[i][0], c[i][1], c[i][2] };
            }
        }
        return null;
    }
}
