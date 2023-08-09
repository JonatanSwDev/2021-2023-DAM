package FicherosTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class NombresAPP {
    private static final String path = ".\\src\\FicherosTexto\\Nombres\\";
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter(path + "Nombres.txt");
        PrintWriter pw = new PrintWriter(fw);

        ArrayList<String> lista = new ArrayList<String>();

        for (String nombre : args) {
            lista.add(nombre);
        }

        Collections.sort(lista);

        for (String nombre : lista) {
            pw.println(nombre);
            System.out.println(nombre);
        }

        pw.close();
    }

}
