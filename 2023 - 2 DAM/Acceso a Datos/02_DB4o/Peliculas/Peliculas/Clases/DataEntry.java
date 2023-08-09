package Peliculas.Clases;

import java.util.Scanner;

public class DataEntry {
    public static Scanner keyboard = new Scanner(System.in);

	// Pedir enteros sin pasar texto
	public static int getInt() {
		int number = -1;
		String value = keyboard.nextLine();
		
		try {
			number = Integer.parseInt(value);
		} catch (Exception e) {
			System.out.println("El valor introducido no es un numero");
		}
		return number;
	}

	// Pedir enteros con texto
	public static int getInt(String text) {
		int number = -1;
		System.out.print(text);
		String value = keyboard.nextLine();
		
		try {
			number = Integer.parseInt(value);
		} catch (Exception e) {
			System.out.println("El valor introducido no es un numero");	
		}

		return number;
	}

	// Pedir texto sin pasar texto
	public static String getString() {
		String value = keyboard.nextLine().trim();
		return value;
	}

	// Pedir texto usando un texto
	public static String getString(String text) {
		System.out.print(text);
		String value = keyboard.nextLine().trim();
		return value;
	}
	
	// Si se desea pedir una accion para continuar
	public static void toContinue() {
		System.out.print("\nIntroduzca cualquier tecla para continuar ");
		keyboard.next();
	}
}
