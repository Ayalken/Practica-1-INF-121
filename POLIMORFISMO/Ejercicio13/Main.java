package Ejercicio13;

public class Main {
    public static void main(String[] args) {
        Mp4 miMp4 = new Mp4("Sony", 2);

        miMp4.añadirCancion("Back To Black", "Amy Winehouse", 100);
        miMp4.añadirCancion("Lost On You", "LP", 150);

        miMp4.añadirVideo("Heathens", "twenty one pilots", 50);
        miMp4.añadirVideo("Without Me", "Halsey", 30);

        miMp4.mostrarContenido();
        miMp4.mostrarCapacidadDisponible();

        miMp4.borrarPorNombre("Back To Black");
        miMp4.mostrarContenido();
        miMp4.mostrarCapacidadDisponible();

        miMp4.borrarPorArtista("LP");
        miMp4.mostrarContenido();
        miMp4.mostrarCapacidadDisponible();

        miMp4.borrarPorNombreYPeso("Lost On You", 150);
        miMp4.mostrarContenido();
        miMp4.mostrarCapacidadDisponible();
    }
}
