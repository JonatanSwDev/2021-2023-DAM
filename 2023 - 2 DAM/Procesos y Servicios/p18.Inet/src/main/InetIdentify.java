package main;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetIdentify {

	public static void main(String[] args) {
		InetAddress equipo, googleDNS,usal;
		
		try {
			equipo = InetAddress.getLocalHost();
			
			System.out.println("Mi equipo es: "+equipo);
			System.out.println("Mi dirección IP es: "+equipo.getHostAddress());
			System.out.println("Mi nombre es: "+equipo.getHostName());
			System.out.println("Mi nombre canónico es: "+equipo.getCanonicalHostName());
			
			googleDNS = InetAddress.getByName("8.8.8.8");
			System.out.println("Mi nombre canónico es: "+googleDNS.getCanonicalHostName());
			System.out.println("Mi nombre es: "+googleDNS.getHostName());
			
			usal = InetAddress.getByName("www.um.es");
			System.out.println("USAL dirección IP es: "+usal.getHostAddress());
			System.out.println("USAL nombre : "+usal.getHostName());
			System.out.println("USAL nombre canónico : "+usal.getCanonicalHostName());
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
