package FicherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SumatorioAPP {
    private static final String path = ".\\src\\FicherosTexto\\Sumatorio\\";
    public static void main(String[] args) throws IOException {
        
        File f = new File(path, "Numeros.txt");
        FileReader fr = new FileReader(f);

        BufferedReader bf = new BufferedReader(fr);

        escribirFichero(bf);
        bf.close();
    }

    private static void escribirFichero(BufferedReader bf) throws IOException {
        FileWriter fw = new FileWriter(path + "sumatorio.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        String linea;
        int operacion = 0;
        while (bf.ready()) {
            linea = bf.readLine();
            try{
                System.out.print(operacion + " + " + linea + " = ");
                operacion += Integer.parseInt(linea);
                System.out.println(operacion);
            } catch (Exception e){
                System.out.println("La linea no es numerica");
            }
        }
        pw.println(operacion);
            pw.close();
    }
    
}
