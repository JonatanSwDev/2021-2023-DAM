/**
 * Session.java
 * Clase encargada de gestionar el sistema de usuarios dentro del sistema de resolucion de laberintos
 * Jonatan Gomez Garcia
 * version 1.1.0 >> 09/04/2022
 */

package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Session {
	private User user = new User();
	private boolean logged;
	Labyrinth labyrinth = new Labyrinth();

	//Constructor de la clase Session
	public Session() {
		logged = false;
	}
	//Devuelve el valor de la variable logged en un momento determinado, util para estados de sesion
	public boolean isLogged() {
		return logged;
	}

	public void login() {
		String userName = Interface.getString("Usuario: "); // Paso 1 pedir usuario.
		String passWD = Interface.getString("Password: "); // Paso 2 pedir contraseña.
		
		this.user = Database.login(userName, passWD);
		if (user != null) {
			logged = true;
			SysLog.loginOK(userName);
		}
		if (logged == false) {
			System.out.println("\nUsuario y/o password incorrectos"); 
			SysLog.loginFail(userName);
		}
	}

	public void signup() {
		 String[] newUser = new String[Config.fields.length];
		 String aux;
		for (int i = 0; i < Config.fields.length; i++) { 	
			if (i == 2 || i == 5) {	//Nombre y Direccion
				aux = Utils.firstUpper(Interface.getString(Config.fields[i] + ": ").trim());//Pasar a mayuscula la primera letra
			} else if (i == 3){		//DNI
				aux = Interface.getString(Config.fields[i] + ": ").trim().toUpperCase();	//Pasar a mayuscula la ultima letra
			} else {
			aux = Interface.getString(Config.fields[i] + ": ").trim();
			}
			//COMPROBACIONES!!!!!!!!!!!!
			//Check USERNAME
				if (i == 0 && Database.checkUser(aux)) {
					System.err.println(aux + " ya existe");
					SysLog.registerFail(aux);
					return;
				}
				//Validate USERNAME
				if (i == 0 && !Utils.validateUserName(aux)) {
					System.err.println("Nombre de usuario no valido");
					SysLog.registerFail(aux);
					return;
				}
				
			//Validate PASSWORD
			if (i == 1 && !Utils.validatePassword(aux)) {	
				System.err.println("La contraseña no cumple con los requisitos:"
						+ "\nDebe empezar por un caracter alfabetico"
						+ "\nDebeebe contener al menos una mayuscula, un numero y un caracter especial"
						+ "\nDebe de tener al menos 8 caracteres");
				SysLog.registerFail(newUser[0]);
				return;
			}
			//Validate NAME
			if (i == 2 && !Utils.validateName(aux)) { 
				System.err.println("Nombre no valido");
				SysLog.registerFail(newUser[0]);
				return;
			}
			
			//Validate NIF
			if (i == 3 && !Utils.validateNif(aux)) {
				System.err.println("NIF no valido");
				SysLog.registerFail(newUser[0]);
				return;
			}
			//Check NIF
			if (i == 3 && Database.checkUser(aux)) {
				System.err.println("Ya existe un usuario con ese NIF");
				SysLog.registerFail(newUser[0]);
				return;
			} 
			//Validate EMAIL
			if (i== 4 && !Utils.validateEmail(aux)){
				System.err.println("El email introducido no es valido");
				SysLog.registerFail(newUser[0]);
				return;
			}
			if (i == 4 && Database.checkUser(aux)) { 
					System.err.println("El email ya existe");
					SysLog.registerFail(newUser[0]);
					return;
			}
			//Validate DATE		
			while (i == 6 && !Utils.validateDate(aux)) {	
				System.err.println("Fecha incorrecta");
				SysLog.registerFail(newUser[0]);
				return;
			}
			
			newUser[i] = aux;
		}

		if (Database.signup(newUser)) {
			System.out.println("\nRegistro correcto.");
			SysLog.registerOK(newUser[0]);
		} else {
			System.out.println("\nHa ocurrido un error en el registro.");
			SysLog.registerFail(newUser[0]);
		}
	}

	//Mostrar información del usuario autenticado
	public void showUser() { 
		user = Database.getUser(user.username);
		
		System.out.println("\nUsuario actual\n---------------------");
		System.out.println("ID: " + user.id);
		System.out.println("Nombre de usuario: " + user.username);
		System.out.println("Nombre: " + user.fullName);
		//System.out.println("Edad: " + user.age);
		System.out.println("NIF: " + user.nif);
		System.out.println("Email: " + user.email);
		System.out.println("Direccion: " + user.address);
		System.out.println("Fecha de nacimiento: " + Utils.formatDateEU(user.birthdate) +", " +  Utils.getAge(user.birthdate));
		System.out.println("Rol: " + user.role);
		//Se requiere de pulsar una tecla para continuar
		
		SysLog.showUserLog(user.username, user.id);
		Interface.toContinue();
	}

	// Loggout
	public void logout() {
		logged = false;
		SysLog.logOutLog(user.username);
		user = new User();
	}

	public User getUser() {
		return this.user;
	}
}