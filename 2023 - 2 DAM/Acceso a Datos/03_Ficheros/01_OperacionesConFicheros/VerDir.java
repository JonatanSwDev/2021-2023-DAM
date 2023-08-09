
import java.io.*;

public class VerDir {
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			System.out.println(args[i]);
			File f = new File(args[i]);
			File[] archivos = f.listFiles();
			System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
			for (int j = 0; j < archivos.length; j++) {
				System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[j], archivos[i].isFile(),
						archivos[j].isDirectory());
			}
		}
	}
}

// ("D:\\ADAT-1314\\UNI1\\Departamentos.dat");
// ("C:\\Program Files");
// ( "D:\\ADAT-1314\\UNI1");
/*
 * System.out.println("¿Se puede leer ?"+f.canRead()); System.out.println(
 * "¿Se puede escribir ?"+f.canWrite()); System.out.println(
 * "Nombre del fichero : "+f.getName()); System.out.println(
 * "Ruta               : "+f.getPath()); System.out.println(
 * "Ruta absoluta      : "+f.getAbsolutePath()); System.out.println(
 * "Tamaño             : "+f.length()); System.out.println(
 * "Es un directorio   : "+f.isDirectory()); System.out.println(
 * "Es un fichero      : "+f.isFile()); System.out.println(
 * "Directorio padre   : "+f.getParent());
 * 
 * 
 * 
 */