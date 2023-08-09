package Classes;

/**
 * Database.java
 * Clase encargada de gestionar todo lo relacionado con la base de datos.
 * version 1.1.0 >> 09/04/2022
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	public static User login(String userName, String passWD) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Config.connectionPath, Config.getUsr(), Config.getPass());
			Statement stmt = conn.createStatement();
			ResultSet user = stmt.executeQuery("SELECT * FROM users where username = '" + userName + "';");
			while (user.next()) {
				if (!user.getString("username").equalsIgnoreCase(userName)
						|| !user.getString("password").equals(Utils.encryptMd5(passWD))) {
					return null;
				} else {
					User userLogin = new User(user.getInt("id"), user.getString("username"), user.getString("name"),
							user.getString("nif"), user.getString("email"), user.getString("address"),
							user.getString("birthdate"), user.getString("role"));
					System.out.println("Sesion iniciada con exito!");
					user.close();
					stmt.close();
					conn.close();
					return userLogin;
				}
			}

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
		}

		return null;
	}

	public static boolean checkUser(String user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Config.connectionPath, Config.getUsr(), Config.getPass());
			Statement stmt = conn.createStatement();
			ResultSet newUser = stmt
					.executeQuery("SELECT * FROM users " + "								where username = '" + user
							+ "' " + "or nif = '" + user + "' " + "or email = '" + user + "' ;");
			while (newUser.next()) {
				if (newUser.getString("username").equalsIgnoreCase(user)
						|| newUser.getString("nif").equalsIgnoreCase(user)
						|| newUser.getString("email").equalsIgnoreCase(user)) {
					newUser.close();
					stmt.close();
					conn.close();
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			return false;
		}
		return false;
	}

	public static boolean signup(String[] newUser) {
		try {
			String plantilla = "INSERT INTO users (username, password, name, nif, email, address, birthdate) VALUES ('<username>', '<password>', '<name>', '<nif>', '<email>', '<address>','<birthdate>');";

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Config.connectionPath, Config.getUsr(), Config.getPass());
			Statement stmt = conn.createStatement();

			String query = plantilla.replaceAll("<username>", newUser[0])
					.replaceAll("<password>", Utils.encryptMd5(newUser[1])).replaceAll("<name>", newUser[2])
					.replaceAll("<nif>", newUser[3]).replaceAll("<email>", newUser[4])
					.replaceAll("<address>", newUser[5]).replaceAll("<birthdate>", Utils.formatDateSQL(newUser[6]));
			stmt.executeUpdate(query);
			stmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR " + e);
		}

		return false;
	}

	public static boolean modifyUser(int id, String into, String value) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Config.connectionPath, Config.getUsr(), Config.getPass());
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("update users set " + into + " = '" + value + "' where id = " + id + ";");
			stmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR " + e);
		}

		return false;
	}

	public static User getUser(String username) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Config.connectionPath, Config.getUsr(), Config.getPass());
			Statement stmt = conn.createStatement();
			ResultSet user = stmt.executeQuery("SELECT * FROM users where username = '" + username + "';");
			User userValues = new User();
			while (user.next()) {
				userValues = new User(user.getInt("id"), user.getString("username"), user.getString("name"),
						user.getString("nif"), user.getString("email"), user.getString("address"),
						user.getString("birthdate"), user.getString("role"));
				user.close();
				stmt.close();
				conn.close();
				return userValues;
			}
			
			return userValues;

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			return null;
		}

		
	}
	
	public static void showUsers() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Config.connectionPath, Config.getUsr(), Config.getPass());
			Statement stmt = conn.createStatement();
			ResultSet user = stmt.executeQuery("SELECT * FROM users;");
			while (user.next()) {
				System.out.println(	user.getInt("id") + ", " + 
									user.getString("username") + ", " +
									user.getString("name") + ", " +
									user.getString("nif") + ", " +
									user.getString("email") + ", " +
									user.getString("address") +
									user.getString("birthdate") + ", " +
									user.getString("role"));
			}
			user.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("ERROR: " + e);

		}
	}

	public static boolean verifyPassword(int id, String passWD) {
		try {
			Connection conn = DriverManager.getConnection(Config.connectionPath, Config.getUsr(), Config.getPass());
			Statement stmt = conn.createStatement();
			ResultSet userPasswd = stmt.executeQuery("SELECT id, password FROM users " + "where id = " + id + ";");
			while (userPasswd.next()) {
				if (userPasswd.getInt("id") == id && userPasswd.getString("password").equals(passWD)) {
					userPasswd.close();
					stmt.close();
					conn.close();
					return true;
				}
			}
			stmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR " + e);
		}

		return false;
	}
	
	public static boolean deleteUser(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Config.connectionPath, Config.getUsr(), Config.getPass());
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete from users where id = " + id + ";");
			System.out.println("Usuario eliminado");
			stmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR " + e);
		}
		return false;
	}
}
