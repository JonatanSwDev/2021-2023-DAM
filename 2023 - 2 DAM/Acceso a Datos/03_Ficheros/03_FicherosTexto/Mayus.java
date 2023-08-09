package FicherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Mayus {
    private static final String path = ".\\src\\FicherosTexto\\Mayusculas\\";
    public static void main(String[] args) throws IOException {
        

        File f = new File(path, "Minusculas.txt");
        FileReader fr = new FileReader(f);

        BufferedReader bf = new BufferedReader(fr);

        escribirFichero(bf);
        bf.close();
    }

    private static void escribirFichero(BufferedReader bf) throws IOException {
        FileWriter fw = new FileWriter(path + "Mayusculas.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        String linea;
        while (bf.ready()) {
            linea = bf.readLine().toUpperCase();
            pw.println(linea);
            System.out.println(linea);
        }
            pw.close();
    }
}
