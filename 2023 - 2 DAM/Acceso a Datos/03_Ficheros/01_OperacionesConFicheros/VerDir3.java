

import java.io.*;

public class VerDir3 {
	public static void main(String[] args) {
		File f = new File(args[0]);
        long kb = Integer.parseInt(args[1]);
		File[] listaficheros= f.listFiles();
		for (int i = 0; i < listaficheros.length; i++) {
            if (listaficheros[i].length() < kb){
				System.out.println("\nNombre del fichero  : " + listaficheros[i].getName());
				System.out.println("Ruta                : " + listaficheros[i].getPath());
				System.out.println("Ruta absoluta       : " + listaficheros[i].getAbsolutePath());
				System.out.println("Se puede leer       : " + listaficheros[i].canRead());
				System.out.println("Se puede escribir   : " + listaficheros[i].canWrite());
				System.out.println("Tamaño              : " + listaficheros[i].length());
				System.out.println("Es un directorio    : " + listaficheros[i].isDirectory());
				System.out.println("Es un fichero       : " + listaficheros[i].isFile());
				System.out.println("Nombre del directorio padre: " + listaficheros[i].getParent());
            }
		}
	}
}
