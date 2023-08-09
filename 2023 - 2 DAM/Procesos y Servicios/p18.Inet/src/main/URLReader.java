package main;

import java.net.*;
import java.io.*;
public class URLReader {
	public static void main(String[] args) throws Exception {
		
		URL iesURL = new URL("https://www.um.es/");
		InputStreamReader receptorISR = new InputStreamReader(iesURL.openStream());
		BufferedReader flujoE = new BufferedReader(receptorISR);
		
		String inputLine;
		inputLine = flujoE.readLine();
		while (inputLine != null) {
			System.out.println(inputLine);
			inputLine = flujoE.readLine();
		}
		flujoE.close();
	}
}