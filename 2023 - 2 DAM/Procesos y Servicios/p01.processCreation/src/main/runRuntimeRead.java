package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class runRuntimeRead {

	public static void main(String[] args) {
		
		String comando = "ls / -l";
		Runtime r = Runtime.getRuntime();
		Process p;
		String linea;
		int exitValue;
		try {
			p = r.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(
					new InputStreamReader(is));
			exitValue = p.waitFor();			linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			exitValue = p.waitFor();
			br.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
