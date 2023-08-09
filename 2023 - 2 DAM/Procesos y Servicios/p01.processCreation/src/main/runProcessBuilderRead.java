package main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;

public class runProcessBuilderRead {

	public static void main(String[] args) {
		
		String[] comando = {"ls","-l"};
		ProcessBuilder p;
		
		try {
			p = new ProcessBuilder(comando);
			File fout = new File("salida.txt");
			p.redirectOutput(fout);
			p.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
