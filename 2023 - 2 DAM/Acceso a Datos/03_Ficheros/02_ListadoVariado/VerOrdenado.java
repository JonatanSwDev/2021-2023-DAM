package Ficheros;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class VerOrdenado {
    public static void main(String[] args){
    String dir = "D:\\Usuario\\JONeSHOOT\\Descargas";
		
		File f = new File(dir);
		String[] archivos = f.list();

        ArrayList <String> arch = new ArrayList<String>();

        for (int i = 0; i < archivos.length; i++){
            arch.add(archivos[i]);
        }
        Collections.sort(arch);

        for(int i = arch.size()-1; i >=0 ; i--){
            System.out.println(arch.get(i));
        }
    }
}
