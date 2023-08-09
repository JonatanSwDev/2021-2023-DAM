package FicherosTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NaturalesAPP {
    private static final String path = ".\\src\\FicherosTexto\\Naturales\\";

    public static void main(String[] args) throws IOException {
        int numero = DataEntry.getInt("Introduce un numero del 1 al 100: ");

        FileWriter fw = new FileWriter(path + "Naturales.txt");
        PrintWriter pw = new PrintWriter(fw);

        if (numero >= 1 && numero <= 100) {
            for (int i = 0; i <= numero; i++) {
                pw.println(i);
            }
            System.out.println("Archivo " + path + "Naturales.txt -- Creado con exito");
        } else {
            System.out.println("Fuera de rango");
        }

        pw.close();
    }

}
