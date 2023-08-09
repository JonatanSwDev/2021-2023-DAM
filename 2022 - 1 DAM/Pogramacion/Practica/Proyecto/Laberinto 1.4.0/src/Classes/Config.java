/**
 * Config.java
 * Clase encargada de mostrar menus y datos dentro del sistema de resolucion de laberintos
 * Jonatan Gomez Garcia
 * version 1.1.0 >> 09/04/2022
 */

package Classes;

public class Config{
	public static final String version = "v 1.4.0";	
	public static final String filePath = "D:\\JONeSHOOT\\VS Java\\Proyecto\\Laberinto1.4.0\\assets\\files\\";
	public static final String connectionPath = "jdbc:mysql://localhost:3306/labyrinth";
	private static final String usr = "root";
	private static final String pass = "mIchaeli13.";
	public static final String labyrinthsPath = "D:\\JONeSHOOT\\VS Java\\Proyecto\\Laberinto1.4.0\\assets\\labyrinths\\";	
	public static final String logFile= "syslog.txt";
	public static final int miliseconds = 1000;
	public static final String welcome = "MI LABERINTO(" +version +") \nEsto es un programa que muestra un laberinto.";

	public static final String unLoggedMenu = "\n\n\tMENU\n"+
											  "--------------------\n"+
											  "1 - Iniciar sesión\n"+
											  "2 - Registro\n"+
											  "0 - Salir\n" +
											  "Elige una opcion: ";

	public static final String LoggedMenu = "\n\n\tMENU\n"+
											"1 - Cargar laberinto\n"+
											"2 - Ver laberinto actual\n"+
											"3 - Establecer casillas de entrada y salida\n"+
											"4 - Buscar caminos\n"+
											"5 - Ver usuario actual\n"+
											"6 - Modificar usuario\n"+
											"7 - Cerrar sesión\n"+
											"0 - Salir\n"+
											"Elige una opcion: ";

	public static final String searchMenu = "\n\nSelecciona un camino\n"+
											"------------------------\n"+
											"1 - El primer camino posible\n"+
											"2 - El camino mas corto\n"+
											"0 - Cancelar\t";
	
	public static final String modifyMenu = "\n\nSelecciona una opcion\n"+
											"------------------------\n"+
											"1 - Cambiar contraseña\n"+
											"2 - Cambiar nombre\n"+
											"3 - Cambiar NIF\n"+
											"4 - Cambiar email\n"+
											"5 - Cambiar direccion\n"+
											"6 - Cambiar fecha de nacimiento\n"+
											"7 - Eliminar cuenta\n"+
											"0 - Cancelar\t";
	
	public static final String adminMenu = "\n\n\tMENU\n"+
											"1 - Cargar laberinto\n"+
											"2 - Ver laberinto actual\n"+
											"3 - Establecer casillas de entrada y salida\n"+
											"4 - Buscar caminos\n"+
											"5 - Ver usuario actual\n"+
											"6 - Administrar cuentas\n"+
											"7 - Cerrar sesión\n"+
											"0 - Salir\n"+
											"Elige una opcion: ";
	
	public static final String administrationMenu = "\n\nSelecciona una opcion\n"+
											"------------------------\n"+
											"1 - Crear nuevo usuario\n"+
											"2 - Ver todos los usuarios\n"+
											"3 - Cambiar contraseña\n"+
											"4 - Cambiar nombre\n"+
											"5 - Cambiar NIF\n"+
											"6 - Cambiar email\n"+
											"7 - Cambiar direccion\n"+
											"8 - Cambiar fecha de nacimiento\n"+
											"9 - Eliminar usuario\n"+
											"0 - Cancelar\t";
			
	public static final String goodbye = "FIN DEL PROGRAMA";

	public static final String[] fields = {"Nombre de usuario","Password","Nombre completo","DNI/NIF","Email","Direccion","Fecha de nacimiento (dd/mm/aaaa)"};

	public static String getUsr() {
        return usr;
    }
	
	public static String getPass() {
		return pass;
	}
}