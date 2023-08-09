package main;

import java.io.IOException;

public class runRuntime {

	public static void main(String[] args) {
		
		String comando = "xed";
		ProcessBuilder p;
		p = new ProcessBuilder(comando);
		try {
			p.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
