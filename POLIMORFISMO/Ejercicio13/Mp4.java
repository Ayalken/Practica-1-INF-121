package Ejercicio13;

public class Mp4 {
    private String marca;
    private double capacidadGb;
    private int nroCanciones;
    private String[][] canciones = new String[3][100];
    private int nroVideos;
    private String[][] videos = new String[100][3];

    public Mp4(String marca, double capacidadGb) {
        this.marca = marca;
        this.capacidadGb = capacidadGb;
    }

    public void borrarPorNombre(String nombre) {
        for (int i = 0; i < nroCanciones; i++) {
            if (canciones[0][i].equalsIgnoreCase(nombre)) {
                for (int j = i; j < nroCanciones - 1; j++) {
                    canciones[0][j] = canciones[0][j + 1];
                    canciones[1][j] = canciones[1][j + 1];
                    canciones[2][j] = canciones[2][j + 1];
                }
                nroCanciones--;
                System.out.println("Se borró '" + nombre + "' del MP4 " + marca);
                break;
            }
        }
    }

    public void borrarPorArtista(String artista) {
        for (int i = 0; i < nroCanciones; i++) {
            if (canciones[1][i].equalsIgnoreCase(artista)) {
                for (int j = i; j < nroCanciones - 1; j++) {
                    canciones[0][j] = canciones[0][j + 1];
                    canciones[1][j] = canciones[1][j + 1];
                    canciones[2][j] = canciones[2][j + 1];
                }
                nroCanciones--;
                i--;
            }
        }
        System.out.println("Se borraron canciones del artista '" + artista + "' del MP4 " + marca);
    }

    public void borrarPorNombreYPeso(String nombre, int pesoKb) {
        for (int i = 0; i < nroCanciones; i++) {
            if (canciones[0][i].equalsIgnoreCase(nombre) && Integer.parseInt(canciones[2][i]) == pesoKb) {
                for (int j = i; j < nroCanciones - 1; j++) {
                    canciones[0][j] = canciones[0][j + 1];
                    canciones[1][j] = canciones[1][j + 1];
                    canciones[2][j] = canciones[2][j + 1];
                }
                nroCanciones--;
                System.out.println("Se borró '" + nombre + "' con peso " + pesoKb + "Kb del MP4 " + marca);
                break;
            }
        }
    }

    public void añadirCancion(String nombre, String artista, int pesoKb) {
        if (nroCanciones < 100) {
            canciones[0][nroCanciones] = nombre;
            canciones[1][nroCanciones] = artista;
            canciones[2][nroCanciones] = String.valueOf(pesoKb);
            nroCanciones++;
            System.out.println("Se añadió '" + nombre + "' al MP4 " + marca);
        }
    }

    public void añadirVideo(String nombre, String artista, int pesoMg) {
        if (nroVideos < 100) {
            videos[0][nroVideos] = nombre;
            videos[1][nroVideos] = artista;
            videos[2][nroVideos] = String.valueOf(pesoMg);
            nroVideos++;
            System.out.println("Se añadió el video '" + nombre + "' al MP4 " + marca);
        }
    }

    public void mostrarContenido() {
        System.out.println("Contenido del MP4 " + marca + ":");
        System.out.println("Canciones:");
        for (int i = 0; i < nroCanciones; i++)
            System.out.println(canciones[0][i] + " - " + canciones[1][i] + " - " + canciones[2][i] + "Kb");
        System.out.println("Videos:");
        for (int i = 0; i < nroVideos; i++)
            System.out.println(videos[0][i] + " - " + videos[1][i] + " - " + videos[2][i] + "Mb");
    }

    public void mostrarCapacidadDisponible() {
        double totalCancionesMb = 0;
        for (int i = 0; i < nroCanciones; i++) totalCancionesMb += Integer.parseInt(canciones[2][i]) / 1024.0;
        double totalVideosMb = 0;
        for (int i = 0; i < nroVideos; i++) totalVideosMb += Integer.parseInt(videos[2][i]);
        double usadoGb = (totalCancionesMb + totalVideosMb) / 1024.0;
        System.out.println("Capacidad disponible en el MP4 " + marca + ": " + (capacidadGb - usadoGb) + " GB");
    }
}
