package Peliculas;

import Peliculas.Clases.CommonVar;
import Peliculas.Clases.DataEntry;
import Peliculas.Clases.Database;

public class Main {
    public static void main(String[] args){
        new Database();
        int option = -1;
        do {
            //Para mostrar el menu a la vez que se recoge el dato necesario:
            option = DataEntry.getInt(CommonVar.mainMenu); //Se recoge el dato de la opcion mostrando el menu
    
            //Funciones de cada eleccion del menu
            switch(option){
                case 1:
                    Database.getPelis();
                    break;
                case 2:
                    Database.getPelisDirector(DataEntry.getString("\nIntroduce el nombre del director" + 
                                                                    "\nAlmodovar, Tim Burton, Paco Leon " +
                                                                    "\n--> "));
                    break;
                case 3:
                    int duracionMin = DataEntry.getInt("\nIntroduce la duracion minima: ");
                    int duracionMax = DataEntry.getInt("Introduce la duracion maxima: ");
                    Database.getPelisDuracion(duracionMin, duracionMax);
                    break;
                case 4:
                    Database.getPelis();
                    Database.eliminarPelis(DataEntry.getString("\nIntroduce el titulo a eliminar: "));
                    break;
                case 5:
                    String titulo = DataEntry.getString("Introduce el titulo de la pelicula: ");
                    if (Database.getPelisTitulo(titulo)){
                        int duracion = DataEntry.getInt("Introduce la nueva duracion de la pelicula: ");
                        Database.modificarDuracion(titulo, duracion);
                    }
                    break;
                case 6:
                    System.out.println("FIN DE PROGRAMA");
                    Database.closeConnection();
                    break;
                default:
                    System.out.println("\nLa opcion introducida no se corresponde con ninguna accion\n");
                    break;
            }
        } while (option != 6);
    }
}
