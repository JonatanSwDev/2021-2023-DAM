package main;

import java.io.IOException;

public class runProcessBuilder {

	public static void main(String[] args) {
		
		String comando = "xed";
		ProcessBuilder p;
		try {
			p = new ProcessBuilder(comando);
			p.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
