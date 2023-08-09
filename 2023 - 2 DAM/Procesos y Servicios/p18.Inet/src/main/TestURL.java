package main;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {

	public static void main(String[] args) {
		try {
			URL urlBase = new URL("https://www.amrood.com:8080/");
			URL miURL = new URL(urlBase,"index.htm?language=en#j2se");
			System.out.println("URL 	>" + miURL.toString());
			System.out.println("protocolo >" + miURL.getProtocol());
			System.out.println("autoridad > " + miURL.getAuthority());
			System.out.println("path    >" + miURL.getPath());
			System.out.println("p. defecto >" + miURL.getDefaultPort());
			System.out.println("puerto  	>" + miURL.getPort());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
