package Teleferico;

public class MiTeleferico {
    Linea lineas[];
    float cantidadIngresos;

    public MiTeleferico() {
        lineas = new Linea[3];
    }

    public void agregarLinea(Linea l) {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] == null) {
                lineas[i] = l;
                break;
            }
        }
    }

    public boolean verificarReglas() {
        for (Linea l : lineas) {
            if (l != null && !l.reglasOk()) return false;
        }
        return true;
    }

    public float ingresoTotal() {
        float t = 0;
        for (Linea l : lineas) {
            if (l != null) t += l.ingresoLinea();
        }
        cantidadIngresos = t;
        return t;
    }

    public Linea lineaMayorRegular() {
        Linea mayor = null;
        float max = -1;

        for (Linea l : lineas) {
            if (l != null) {
                float suma = 0;
                for (Cabina c : l.cabinas) {
                    if (c != null) {
                        for (Persona p : c.personasAbordo) {
                            if (p != null && p.edad >= 25 && p.edad <= 60) {
                                suma += 3; // solo regular
                            }
                        }
                    }
                }
                if (suma > max) {
                    max = suma;
                    mayor = l;
                }
            }
        }
        return mayor;
    }
}
