package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        Ropa r1 = new Ropa("chompa", "lana");
        Ropa r2 = new Ropa("guantes", "lana");
        Ropa r3 = new Ropa("pantalon", "jeans");
        Ropa r4 = new Ropa("camisa", "algodon");

        Ropero ropero = new Ropero("madera");

        ropero.adicionar(r1);
        ropero.adicionar(r2);
        ropero.adicionar(r3);
        ropero.adicionar(r4);

        System.out.println("++++ ROPERO ++++");
        ropero.mostrarTodo();

        ropero.eliminar("lana", "camisa");

        System.out.println("\n++++ ROPERO DESPUES DE ELIMINAR +++");
        ropero.mostrarTodo();

        System.out.println("\n+++ PRENDAS DE MATERIAL 'jeans' Y TIPO 'pantalon' +++");
        ropero.mostrar("jeans", "pantalon");
    }
}
