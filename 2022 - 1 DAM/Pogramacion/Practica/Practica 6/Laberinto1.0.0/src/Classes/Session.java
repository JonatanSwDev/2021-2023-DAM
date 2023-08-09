/**
 * Session.java
 * Clase encargada de gestionar el sistema de usuarios dentro del sistema de resolucion de laberintos
 * Jonatan Gomez Garcia
 * version 1.0.0 >> 03/03/2021
 */

package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

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

	// Loggin
	public void login() {
		String username = Interface.getString("Usuario: "); // Paso 1 pedir usuario.
		String password = Interface.getString("Password: "); // Paso 2 pedir contraseña.
		ArrayList<String> users = readAllUsers(); // Paso 3 leer usuarios.

		for (int i = 0; i < users.size(); i++) { // Paso 4
			// Convertimos cada linea en un array con el usuario que estamos leyendo en este
			// momento.
			String[] currentUser = users.get(i).split("#");
			
			if (username.equalsIgnoreCase(currentUser[0]) && password.equals(currentUser[1])) {
				logged = true; // Paso 5A establecer valor de logged a true
				setUser(currentUser); // Se manda los datos del usuario a setUser
				System.out.println("Sesion iniciada con exito");
				break;// Rompemos el bucle porque ya ha encontrado usuario.
			}
		}

		// Paso 5B no se ha podido corroborar la integridad del loggin
		if (logged == false) {
			System.out.println("\nUsuario y/o password incorrectos"); 
		}
	}

	//Metodo para leer el fichero de usuarios
	private ArrayList<String> readAllUsers() {
		ArrayList<String> users = new ArrayList<String>();

		try {
			File myObj = new File(Config.filePath + Config.usersFile);
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				// System.out.println(data);
				users.add(data);
			}

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error.");
			e.printStackTrace();
		}
		return users;
	}

	
	// Singup o registro	
	public void singupv2() { // Signup Version 2
		System.out.println("Singup v2");
		String newUser = "\n";

		for (int i = 0; i < Config.fields.length; i++) { 						
			String aux = Interface.getString(Config.fields[i] + ": ");

			if (i == 0 && checkUser(aux)) {
				System.out.println("El usuario ya existe");
				return;
			}
			newUser += aux + "#";
		}
		newUser += "user";

		if (writeUser(newUser)) {
			System.out.println("\nRegistro correcto.");
		} else {
			System.out.println("\nHa ocurrido un error en el registro.");
		}
	}

	//Signup o registro
	public void signupv1() { // Signup version 1
		String username = Interface.getString("Nombre de usuario: "); //Se pide el nombre de usuario
		
		if (checkUser(username)) { //Comprobacion de existencia del usuario introducido
			System.out.println("El usuario ya existe");
			return;
		}

		// Se completa todos los campos requeridos del registro
		String password = Interface.getString("Password: ");
		String fullName = Interface.getString("Nombre completo: ");
		String age = Interface.getString("Edad: ");
		String nif = Interface.getString("DNI/NIF: ");
		String email = Interface.getString("Email: ");
		String address = Interface.getString("Direccion: ");
		String birthdate = Interface.getString("Fecha de nacimiento: ");

		//Creacion de la linea para el nuevo usuario dentro del fichero
		String newUser = "\n" + username + "#" + password + "#" + fullName + "#" + age + "#" + nif + "#" + email + "#"
				+ address + "#" + birthdate + "#user";
		// Se manda la nueva linea al metodo que escribe el usuario dentro del fichero
		if (writeUser(newUser)) {
			System.out.println("\nUsuario creado satosfactoriamente");
		} else {
			System.out.println("\nHa ocurrido un error en el registro");
		}
	}

	//Metodo usado para comprobar el usuario
	private boolean checkUser(String username) { 
		ArrayList<String> users = readAllUsers();	//Se lee el fichero de usuario y se guarda en un ArrayList
		//Comprobación de existencia de usuario recorriendo el ArrayList
		for (int i = 0; i < users.size(); i++) {
			String[] currentUser = users.get(i).split("#");
			
			if (username.equalsIgnoreCase(currentUser[0])) {
				System.out.println("\nEl ususario ya existe");
				return true;
			}
		}
		return false;
	}

	// Para escribir un usuario en el fichero de usuarios
	private boolean writeUser(String newUser) {
		boolean success = false;

		try {
			FileWriter myWriter = new FileWriter(Config.filePath + Config.usersFile, true); //Se debe colocar true al final para que no borre todo
			myWriter.write(newUser);
			myWriter.close();
			success = true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return success;
	}

	// Establecer datos de usuario
	private void setUser(String[] currentUser) {
		user.username = currentUser[0];
		user.fullName = currentUser[2];
		user.age = currentUser[3];
		user.nif = currentUser[4];
		user.email = currentUser[5];
		user.address = currentUser[6];
		user.birthdate = currentUser[7];
		user.role = currentUser[8];
	}

	//Mostrar información del usuario autenticado
	public void showUser() { 
		System.out.println("\nUsuario actual\n---------------------");
		System.out.println("Nombre de usuario: " + user.username);
		System.out.println("Nombre: " + user.fullName);
		System.out.println("Edad: " + user.age);
		System.out.println("NIF: " + user.nif);
		System.out.println("Email: " + user.email);
		System.out.println("Direccion: " + user.address);
		System.out.println("Fecha de nacimiento: " + user.birthdate);
		System.out.println("Rol: " + user.role);
		//Se requiere de pulsar una tecla para continuar
		Interface.toContinue();
	}

	// Loggout
	public void logout() {
		logged = false;
		user = new User();
	}

}

