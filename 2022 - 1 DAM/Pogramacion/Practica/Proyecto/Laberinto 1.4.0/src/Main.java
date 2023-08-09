
/**
 * Main.java
 * Programa principal del sistema para resolver un laberinto
 * Jonatan Gomez Garcia
 * version 1.1.0 >> 09/04/2022
 */

import Classes.Admin;
import Classes.Config;
import Classes.Database;
import Classes.Session;
import Classes.SysLog;
import Classes.User;
import Classes.Interface;
import Classes.Labyrinth;
import Classes.ModUser;

public class Main {
	public static Session session = new Session();
	public static Labyrinth labyrinth = new Labyrinth();

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Config.welcome);
		SysLog.wellcome();
		int option = -1;

		do {
			if (!session.isLogged()) {
				option = Interface.getInt(Config.unLoggedMenu);
				unloggedAction(option);
			}
			if (session.isLogged() ) {
				Admin admin = new Admin(session.getUser());
				if(!admin.isAdmin()) {
					option = Interface.getInt(Config.LoggedMenu);
					loggedAction(option);
				}
				if (admin.isAdmin()) {
					option = Interface.getInt(Config.adminMenu);
					adminAction(option);
				}
			}
		} while (option != 0);

		System.out.println(Config.goodbye);
		SysLog.exitLog();
	}

	// Acciones del menu Sin sesion iniciada
	public static void unloggedAction(int option) throws InterruptedException {
		switch (option) {
		case 1:
			session.login();
			Thread.sleep(Config.miliseconds);
			break;

		case 2:
			session.signup();
			break;
		}
	}

	// Acciones del menu CON sesion iniciada
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
			SysLog.searchMenu();
			Thread.sleep(Config.miliseconds);
			break;

		case 5:
			session.showUser();
			break;

		case 6:
			option = Interface.getInt(Config.modifyMenu);
			modifyOption(option);
			Thread.sleep(Config.miliseconds);
			break;

		case 7:
			System.out.println("\nCERRANDO SESION");
			session.logout();
			labyrinth = new Labyrinth();
			Thread.sleep(Config.miliseconds);
			break;
		}
	}

	//Menu para resolucion del laberinto
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

	//Menu para modificar usuarios
	public static void modifyOption(int option) throws InterruptedException {
		switch (option) {
		case 1:
			ModUser.chPassword(session.getUser());
			Thread.sleep(Config.miliseconds);
			break;

		case 2:
			ModUser.chName(session.getUser());
			Thread.sleep(Config.miliseconds);
			break;

		case 3:
			ModUser.chNif(session.getUser());
			Thread.sleep(Config.miliseconds);
			break;

		case 4:
			ModUser.chEmail(session.getUser());
			Thread.sleep(Config.miliseconds);
			break;
			
		case 5:
			ModUser.chDirection(session.getUser());
			Thread.sleep(Config.miliseconds);
			break;
			
		case 6:
			ModUser.chBirthDate(session.getUser());
			Thread.sleep(Config.miliseconds);
			break;
			
		case 7:
			if(ModUser.deleteUser(session.getUser())) {
				session.logout();
				labyrinth = new Labyrinth();
			}
			Thread.sleep(Config.miliseconds);
			break;
		}
	}
	
	//Menu de Admin
	public static void adminAction(int option) throws InterruptedException {
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
			option = Interface.getInt(Config.administrationMenu);
			administrationOption(option);
			Thread.sleep(Config.miliseconds);
			break;

		case 7:
			System.out.println("\nCERRANDO SESION");
			session.logout();
			labyrinth = new Labyrinth();
			Thread.sleep(Config.miliseconds);
			break;
		}
	}
	
	//Menu de admin
	public static void administrationOption(int option) throws InterruptedException {
		switch (option) {
		case 1:
			session.signup();
			Thread.sleep(Config.miliseconds);
			break;
			
		case 2:
			Database.showUsers();
			Interface.toContinue();
			break;
			
		case 3:
			Admin.chPassword(Admin.selectUser());
			Thread.sleep(Config.miliseconds);
			break;

		case 4:
			Admin.chName(Admin.selectUser());
			Thread.sleep(Config.miliseconds);
			break;

		case 5:
			Admin.chNif(Admin.selectUser());
			Thread.sleep(Config.miliseconds);
			break;

		case 6:
			Admin.chEmail(Admin.selectUser());
			Thread.sleep(Config.miliseconds);
			break;
			
		case 7:
			Admin.chDirection(Admin.selectUser());
			Thread.sleep(Config.miliseconds);
			break;
			
		case 8:
			Admin.chBirthDate(Admin.selectUser());
			Thread.sleep(Config.miliseconds);
			break;
			
		case 9:
			Admin.deleteUser(Admin.selectUser(), session.getUser().id);
			Thread.sleep(Config.miliseconds);
			break;
		}
	}
}