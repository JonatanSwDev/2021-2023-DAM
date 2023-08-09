/**
 * Config.java
 * Programa encargado de mostrar menus y datos dentro del sistema de resolucion de laberintos
 * Jonatan Gomez Garcia
 * version 0.1.0 >> 03/12/2021
 */
package Classes;

public class Config{
	public static final String version = "v.0.1.0";	
	public static final String filePath = "D:\\JONeSHOOT\\VS Java\\Proyecto\\Laberinto0.2.0\\assets\\files\\";	
	public static final String usersFile="users.txt";
	public static final int miliseconds = 1000;
	public static final String welcome = "MI LABERINTO(" +version +") \nEsto es un programa que muestra un laberinto.";

	public static final String unLoggedMenu = "\n\n\tMENU\n"+
											  "--------------------\n"+
											  "1 Iniciar sesión\n"+
											  "2 Registro\n"+
											  "0 Salir";

	public static final String LoggedMenu = "\n\n\tMENU\n"+
											"1 Cargar laberinto\n"+
											"2 Ver laberinto actual\n"+
											"3 Establecer casillas de entrada y salida\n"+
											"4 Buscar caminos\n"+
											"5 Ver usuario actual\n"+
											"6 Cerrar sesión\n"+
											"0 Salir\n"+
											"Elige una opcion: ";
		
	public static final String goodbye = "FIN DEL PROGRAMA";

	public static final String[] fields = {"Nombre de usuario","Password","Nombre completo","Edad","DNI/NIF","Email","Direccion","Fecha de nacimiento"};

}

