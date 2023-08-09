/**
 * Main.java
 * Programa principal del sistema de resolucion de laberintos
 * Jonatan Gomez Garcia
 * version 0.1.0 >> 03/12/2021
 */

import Classes.Config;
import Classes.Session;
import Classes.Interface;

public class Main {
	public static Session session = new Session();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Version actual: " + Config.version);

		System.out.println(Config.welcome);
		int option = -1;

		do {
			if (!session.isLogged()) {
				option = Interface.getInt(Config.unLoggedMenu);
				unloggedAction(option);
			}

			if (session.isLogged()) {
				option = Interface.getInt(Config.LoggedMenu);
				loggedAction(option);
			}

		} while (option != 0);

		System.out.println(Config.goodbye);
	}

	//Acciones del menu Sin sesion iniciada
	public static void unloggedAction(int option) throws InterruptedException {
		switch (option) {
		case 1:	
			session.login();
			Thread.sleep(Config.miliseconds);
		break;

		case 2: 
			session.signupv1();
			break;
		}

	}
	
	//Acciones del menu CON sesion iniciada
	public static void loggedAction(int option) throws InterruptedException {
		switch (option) {
		case 1:
			System.out.println("\nPROXIMAMENTE");
			Thread.sleep(Config.miliseconds);
			break;

		case 2:
			System.out.println("\nPROXIMAMENTE");
			Thread.sleep(Config.miliseconds);
			break;

		case 3:
			System.out.println("\nPROXIMAMENTE");
			Thread.sleep(Config.miliseconds);
			break;

		case 4:
			System.out.println("\nPROXIMAMENTE");
			Thread.sleep(Config.miliseconds);
			break;

		case 5:
			session.showUser();
			Thread.sleep(Config.miliseconds);
			break;
			
		case 6:
				System.out.println("\nCERRANDO SESION");
			session.logout();
			Thread.sleep(Config.miliseconds);
			break;
		}
	}
}