package Introduccion_a_POO.Ejercicio13;
import java.util.Arrays;

public class TestFruta {
    public static void main(String[] args) {
        // a) Instanciar 3 frutas de distintas maneras
        Fruta f1 = new Fruta("Kiwi", "Subtropical", new String[]{"K", "C", "E"});
        Fruta f2 = new Fruta("Naranja", "Cítrica", new String[]{"C", "A", "B1"});
        Fruta f3 = new Fruta("Plátano", "Tropical", new String[]{"B6", "C"});

        f1.mostrarVitaminas();
        f2.mostrarVitaminas();
        f3.mostrarVitaminas();

        // b) Verificar cuál es la fruta con más vitaminas
        Fruta max = f1;
        if (f2.getNroVitaminas() > max.getNroVitaminas()) max = f2;
        if (f3.getNroVitaminas() > max.getNroVitaminas()) max = f3;
        System.out.println("La fruta con más vitaminas es: " + max.getNombre());

        // c) Mostrar vitaminas de la fruta X (ejemplo Kiwi)
        System.out.println("Vitaminas de " + f1.getNombre() + ": " + Arrays.toString(f1.getVitaminas()));

        // d) Cuántas vitaminas son "C"
        int contadorC = 0;
        for (String v : f1.getVitaminas()) if (v.equals("C")) contadorC++;
        for (String v : f2.getVitaminas()) if (v.equals("C")) contadorC++;
        for (String v : f3.getVitaminas()) if (v.equals("C")) contadorC++;
        System.out.println("Cantidad de vitaminas C: " + contadorC);

        // e) Ordenar vitaminas de Kiwi
        String[] ordenadas = f1.getVitaminas();
        Arrays.sort(ordenadas);
        System.out.println("Vitaminas ordenadas de " + f1.getNombre() + ": " + Arrays.toString(ordenadas));
    }
}