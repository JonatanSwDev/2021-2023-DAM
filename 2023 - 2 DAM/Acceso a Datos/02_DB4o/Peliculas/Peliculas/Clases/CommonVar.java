package Peliculas.Clases;

public class CommonVar {
    private static String rutaPelis = "D:\\Acceso a Datos\\Java\\AaD\\src\\Peliculas\\BD40\\Pelis.db04";
    private static String rutaDirectores = "D:\\Acceso a Datos\\Java\\AaD\\src\\Peliculas\\BD40\\Directores.db04";
    
    public static String mainMenu = "\n1 - Consultar todas las peliculas" +
                                    "\n2 - Consultar peliculas por director" + 
                                    "\n3 - Consulta las peliculas de un rango de duracion" + 
                                    "\n4 - Eliminar una pelicula" + 
                                    "\n5 - Modifica la duracion de una pelicula" + 
                                    "\n6 - Salir" +
                                    "\n--> ";
    
    
    
    
    
    public static String getRutaPelis() {
        return rutaPelis;
    }
    public static String getRutaDirectores() {
        return rutaDirectores;
    }



    
}