
/**
 * Main.java
 * Programa principal del sistema para resolver un laberinto
 * Jonatan Gomez Garcia
 * version 1.0.0 >> 03/03/2021
 */

import javax.swing.plaf.LabelUI;

import Classes.Config;
import Classes.Session;
import Classes.Interface;
import Classes.Labyrinth;

public class Main {
	public static Session session = new Session();
	public static Labyrinth labyrinth = new Labyrinth();
	

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
			labyrinth.loadLabyrinth();
			Thread.sleep(Config.miliseconds);
			break;

		case 2:
			labyrinth.showLabyrinth();
			Thread.sleep(Config.miliseconds);
			break;

		case 3:
			labyrinth.setEntranceExit();
			Thread.sleep(Config.miliseconds);
			break;

		case 4:
		option = Interface.getInt(Config.searchMenu);
			searchOption(option);
			Thread.sleep(Config.miliseconds);
			break;

		case 5:
			session.showUser();
			break;
			
		case 6:
			System.out.println("\nCERRANDO SESION");
			session.logout();
			labyrinth = new Labyrinth();
			Thread.sleep(Config.miliseconds);
			break;
		}
	}

	public static void searchOption(int option) throws InterruptedException {
		switch (option) {
		case 1:
			labyrinth.findFirst();
			Thread.sleep(Config.miliseconds);
			break;

		case 2:
			labyrinth.findShort();
			Thread.sleep(Config.miliseconds);
			break;

		case 3:
		System.out.println("Volviendo al menú...");
			option = Interface.getInt(Config.LoggedMenu);
			loggedAction(option);
			
		}
	}
}