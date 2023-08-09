package Classes;

import java.io.FileWriter;
import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class SysLog {

	public static void writeLine(String newLine) {
		try {
			FileWriter myWriter = new FileWriter(Config.filePath + Config.logFile, true); // Se debe colocar true al
																							// final para que no borre
																							// todo
			myWriter.write(newLine);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static void wellcome() {
		writeLine(getTime() + " - " + "Inicio de programa\n");
	}

	public static void registerOK(String username) {
		writeLine(getTime() + " - " + "Registro exitoso (usuario " + username + ")\n");
	}

	public static void registerFail(String username) {
		writeLine(getTime() + " - " + "Registro fallido (usuario " + username + ")\n");
	}

	public static void loginOK(String username) {
		writeLine(getTime() + " - " + "Loggin correcto (usuario " + username + ")\n");
	}

	public static void loginFail(String username) {
		writeLine(getTime() + " - " + "Loggin fallido (usuario " + username + ")\n");
	}

	public static void loadLaby(String filename) {
		writeLine(getTime() + " - " + "Laberinto cargado (" + filename + ")\n");
	}

	public static void showLaby(String filename) {
		writeLine(getTime() + " - " + "Mostrar laberinto (" + filename + ")\n");
	}

	public static void errorShowMap() {
		writeLine(getTime() + " - " + "Show Map Error (No se ha cargado laberinto)\n");
	}

	public static void succesENEX(int startI, int startJ, int endI, int endJ) {
		writeLine(getTime() + " - " + "Casillas establecidas (Entrada: " + startI + ":" + startJ + " / Salida: " + endI
															+ ":" + endJ + ")\n");
	}

	public static void errorENEX(int startI, int startJ, int endI, int endJ) {
		writeLine(getTime() + " - " + "Error al estableer casillas (Entrada: " + startI + ":" + startJ + " / Salida: "
				+ endI + ":" + endJ + ")\n");
	}

	public static void errorENEXLoaded() {
		writeLine(getTime() + " - " + "Error al establecer casillas (No se ha cargado laberinto)\n");
	}

	public static void searchMenu() {
		writeLine(getTime() + " - " + "Acceso al menu de buscar caminos\n");
	}

	public static void errorSearching(boolean loaded, boolean establishedStEn) {
		if (!loaded) {
			writeLine(getTime() + " - " + "Error al buscar caminos (No se ha cargado laberinto)\n");
		} else if (loaded && !establishedStEn) {
			writeLine(getTime() + " - " + "Error al buscar caminos (No hay casillas establecidas)\n");
		}
	}

	public static void solveFirst(boolean solved, int size) {
		if (!solved) {
			writeLine(getTime() + " - " + "Primer camino no encontrado (Imposible de resolver)\n");
		} else {
			writeLine(getTime() + " - " + "Primer camino encontrado (Exito: " + (size - 1) + " pasos)\n");
		}
	}

	public static void solveShort(boolean solved, int size) {
		if (!solved) {
			writeLine(getTime() + " - " + "Camino mas corto no encontrado (Imposible de resolver)\n");
		} else {
			writeLine(getTime() + " - " + "Camino mas corto encontrado (Exito: " + (size - 1) + " pasos)\n");
		}
	}

	public static void showUserLog(String username, int id) {
		writeLine(getTime() + " - " + "Mostrar usuario (Usuario: " + username + ", ID: " + id + ")\n");
	}

	public static void logOutLog(String username) {
		writeLine(getTime() + " - " + "Sesion cerrada (Usuario: " + username + ")\n");
	}

	public static void exitLog() {
		writeLine(getTime() + " - " + "Fin de programa\n");
	}

}
