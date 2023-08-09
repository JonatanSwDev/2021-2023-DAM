

import java.io.*;

public class VerDir2 {
	public static void main(String[] args) {
		File f = new File(args[0]);
        long kb = Integer.parseInt(args[1]);
		File[] listaficheros= f.listFiles();
		System.out.printf("Ficheros en el directorio actual: %d %n", listaficheros.length);
		for (int i = 0; i < listaficheros.length; i++) {
            if (listaficheros[i].length() < kb){
			System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", 
					listaficheros[i].getName(), listaficheros[i].isFile(),listaficheros[i].isDirectory());
            }
		}
	}
}
