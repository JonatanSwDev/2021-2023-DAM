/*
 * User.java
 * Clase que contiene las variables de la informacion de usuario dentro del sistema de resolucion de laberintos
 * Jonatan Gomez Garcia
 * version 1.1.0 >> 09/04/2022
 */

package Classes;

public class User {
	public int id;
	public String username;
	public String fullName;
	public String nif;
	public String email;
	public String address;
	public String birthdate;
	public String role;
	
	public User() {}
	
	public User(int id, String username, String fullName, String nif, String email, String address, String birthdate, String role) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.nif = nif;
		this.email = email;
		this.address = address;
		this.birthdate = birthdate;
		this.role = role;
	}
}