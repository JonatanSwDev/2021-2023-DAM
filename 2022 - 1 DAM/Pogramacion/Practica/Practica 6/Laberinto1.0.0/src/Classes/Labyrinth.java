package Classes;
/**
 * Lbyrinth.java
 * Calase encargada de gestionar la carga y manupulación de los laberintos.
 * Jonatan Gomez Garcia
 * version 1.0.0 >> 03/03/2022
 */
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.stream.events.Characters;

import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.reflect.Array;

public class Labyrinth{
    private char[][] map;
    private String filename;
    private boolean loaded;
    private int startI, startJ, endI, endJ;
    private boolean solved;
    private boolean establishedStEn;
    ArrayList<Coordinate> path = new ArrayList();
    ArrayList<Coordinate> auxPath = new ArrayList();

    public Labyrinth() {
        loaded = false;
        solved = false;
        establishedStEn = false;
    }

    public void loadLabyrinth(){
        File[] maze = listDirectory();
        path = new ArrayList <Coordinate>();

        if (maze.length == 0){
            System.err.println("No existen laberintos a cargar o no se han podido listar");
            return;
        }
        System.out.println("\nSelecciona un laberinto:");
        System.out.println("-----------------------");

        for (int i = 0; i < maze.length; i++){
            System.out.println(i + 1 + "- " + maze[i].getName());
        }
        System.out.println("0- Atras");
        int option = Interface.getInt();
        if (option == 0){
            return;
        } 

        if (option > 0 && option <= maze.length){
            ArrayList<String> lines = openFile(maze[option -1].getName());
            int aux = lines.get(0).length();
            map = new char [aux][aux];

            for (int i = 0; i < lines.size(); i++){
                if (lines.get(i).length() != aux){
                    loaded = false;
                    System.err.println("Se ha producido un error al cargar el laberinto\n Error 101: Laberinto corrupto");
                    return;
                }
                for (int j = 0; j < lines.get(i).length(); j++){
                    map[i][j] = lines.get(i).charAt(j);
                    if (i == lines.get(0).length() - 1 && j == lines.get(0).length() - 1){
                        loaded = true;
                    }
                }  
            }  
        System.out.println("Laberinto cargado correctamente");
        filename = maze[option -1].toString();
        }
        else {
            System.out.println("Pelitos, elige una opvión váida");
        }
    }

    public void showLabyrinth() throws InterruptedException{
        if (!loaded){
            System.err.println("No ha cargado ningun laberinto, por favor seleccione la opcion \"1 Cargar laberinto\"");
            Thread.sleep(Config.miliseconds * 2);
            return;
        }

        char[][] map2 = new char[map[0].length][map[0].length];
        for (int i =0; i < map.length; i++){
            for (int j = 0; j < map.length; j++) {
                map2[i][j] = map[i][j];
                if (solved) {
                    for (int k = 0; k < path.size(); k++){
                        if (i == path.get(k).i && j == path.get(k).j && map[i][j] != 'S' && map[i][j] != 'E') {
                            if (path.get(k).direction == 1){
                                map2[i][j] = 17;
                            } else if (path.get(k).direction == 2){
                                map2[i][j] = 30;
                            } else if (path.get(k).direction == 3){
                                map2[i][j] = 16;
                            } else if (path.get(k).direction == 4){
                                map2[i][j] = 31;
                            }
                        }
                    }
                }
            }
        }

        String showArray = "";
        System.out.println();
        if (map.length > 9){
            showArray += "                       ";
        }   

        for (int p = 0; p <= map.length; p++){
            if (p > 10 && p < 21){
                showArray += 1 + " ";
            }
            if (p > 20){
                showArray += 2 + " ";
            }
            if (p == map.length){
                showArray += "\n";
            }
        }

        for(int p = 0; p < map.length; p++){
            if (p == 0){
                showArray += "   ";
            }
            if (p < 10){
                showArray += p + " ";
            }
            if (p >= 10 && p < 20){
                showArray += (p - 10) + " ";
            }
            if (p >= 20 && p < 30){
                showArray += (p - 20) + " ";
            }
            if (p == map.length - 1){
                showArray += "\n";
            }
        } 

        for (int i = 0; i < map.length; i++) {
            if (i < 10){
            showArray += i + "  ";
            }
            if (i >= 10){
            showArray += i + " ";
            }
            for (int j =0; j < map[i].length; j++) {
                    showArray += map2[i][j];
                    showArray += " ";
            }
                showArray += "\n";
        }

        showArray += "\n\tPasos: " + path.size() + "\n\n";

        for(int k = 0; k < path.size(); k++){
            showArray += "\t(" + path.get(k).i + "," + path.get(k).j + ") ";
            if (path.get(k).direction == 1){
                showArray += "Izquierda\n";
            } else if (path.get(k).direction == 2){
                showArray += "Arriba\n";
            } else if (path.get(k).direction == 3){
                showArray += "Derecha\n";
            } else if (path.get(k).direction == 4){
                showArray += "Abajo\n";
            } else if (k == path.size() -1){
                showArray += "SALIDA\n";
            }
        }
        System.out.println(showArray);
        Interface.toContinue();
    }

    private File[] listDirectory() {

        File[] files = new File[0];

        try {
        files = new File(Config.labyrinthsPath).listFiles();
        } catch (Exception e) {
        System.err.println("No se ha podido acceder al directorio de laberintos");
        }

        return files;
    }

    private ArrayList<String> openFile(String filename) {
		ArrayList<String> users = new ArrayList<String>();

		try {
			File myObj = new File(Config.labyrinthsPath + filename);
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				users.add(data);
			}

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error.");
			e.printStackTrace();
		}
		return users;
    }

    public void setEntranceExit() throws InterruptedException{
        if (!loaded){
            System.err.println("No ha cargado ningun laberinto, por favor seleccione la opcion \"1 Cargar laberinto\"");
            Thread.sleep(Config.miliseconds * 2);
            return;
        }
        System.out.println("\n Introduce la casilla de entrada");
        startI = Interface.getInt("Entrada X: ");
        startJ = Interface.getInt("Entrada Y: ");
            if (startI >= map.length || startJ >= map.length){
                System.err.println("¡Error! Casilla fuera de alcance");
                return;
            }
        
        System.out.println("\n Introduce la casilla de salida");
        endI = Interface.getInt("Salida X: ");
        endJ = Interface.getInt("Salida Y: ");
            if (endI >= map.length || endJ >= map.length){
                System.err.println("¡Error! Casilla fuera de alcance");
                return;
            }

        if (startI == endI && startJ == endJ){
            System.err.println("¡ERROR!\nHas introducido la misma casilla de entrada y salida ");
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++){
                if (map[i][j] == 'E' || map[i][j] == 'S') {
                    map[i][j] = ' ';
                }
            }
        }
        
        try {
            if (map[startI][startJ] == '#'){
                System.err.println("La casilla introducida no es válida");
                Interface.toContinue();
                return;
            }
            if (map[startI][startJ] != '#'){
                map[startI][startJ] = 'E';
                System.out.println("¡Casilla de entrada marcada con exito!");
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No se ha podido establecer casilla de entrada o salida\n Codifo de error:");
            e.printStackTrace();
            Interface.toContinue();
            return;
        }
        
        try {
            if (map[endI][endJ] == '#'){
                System.err.println("La casilla introducida no es válida");
                Interface.toContinue();
                return;
            }
            if (map[endI][endJ] != '#'){
                map[endI][endJ] = 'S';
                System.out.println("¡Casilla de salida marcada con exito!");
                path = new ArrayList <Coordinate>();
                establishedStEn = true;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No se ha podido establecer casilla de entrada o salida\nCodigo de error:");
            e.printStackTrace();
            Interface.toContinue();
            return;
        }
    }

    public void findFirst(){
        solved = false;
        if (loaded && establishedStEn){
            solved = findFirstPath();
        } else if (!loaded){
            System.err.println("\nAntes debe cargar un laberinto");
        } else if (!establishedStEn){
            System.err.println("\nPor favor, establezca las casillas de entrada y salida\nVolviendo al menú...");
        }
    }

    public void findShort(){
        solved = false;
        if (loaded && establishedStEn){
            solved = findShortPath();
        } else if (!loaded){
            System.err.println("\nAntes debe cargar un laberinto");
        } else if (!establishedStEn){
            System.err.println("\nPor favor, establezca las casillas de entrada y salida\nVolviendo al menú...");
        }
    }

    private boolean findFirstPath() {
        boolean found = false;

        path = new ArrayList <Coordinate>();

        Coordinate startCell = new Coordinate();
        startCell.i = startI;
        startCell.j = startJ;
        startCell.direction = 0;

        path.add(startCell);

        while (!found && path.size() > 0) {
            //Incrementar direccion del ultimo elemento del path
            path.get(path.size() - 1).direction ++;

            if (path.get(path.size() - 1).direction < 5) {
                //TODO LO QUE SE HACE
                //Obtener la siguiente casilla posible
                Coordinate nextCell = getNextCell(path.get(path.size() - 1));
                if (checkCell(nextCell)) { //Comprobar casilla válida
                    path.add(nextCell);
                    if (nextCell.i == endI && nextCell.j == endJ){ //Comprobamos si la siguiente celda councide con la salida!!!!
                        found = true;
                    }
                }
            } else {
                //Borramos el ultimo elemento.
                path.remove(path.size() - 1);
            }

        }
        System.out.println("¡Camino encontrado!");
        return found;
    }

    private Coordinate getNextCell (Coordinate currentCoord){
        Coordinate nextCoord = new Coordinate();
        nextCoord.i = currentCoord.i;
        nextCoord.j = currentCoord.j;
        nextCoord.direction = 0;

        if (currentCoord.direction == 1) {
            //Izquierda
            nextCoord.j --;
        } else if (currentCoord.direction == 2){
            //Arriba
            nextCoord.i --;
        } else if(currentCoord.direction == 3) {
            //Derecha
            nextCoord.j ++;
        }else if (currentCoord.direction == 4) {
            //Abajo
            nextCoord.i ++;
        }

        return nextCoord;
    }

    private boolean checkCell(Coordinate cell){
        if (map[cell.i][cell.j] == '#') { //Comprobamos si es pared
            return false;
        }

        //COMPROBAR SI ESTÁ EN EL PATH
        for (int i = 0; i < path.size(); i++) {
            if(path.get(i).i == cell.i && path.get(i).j == cell.j){
                return false;
            }
        }

        return true;
    }

    private boolean findShortPath() {
        boolean found = false;

        auxPath = new ArrayList <Coordinate>();
        path = new ArrayList <Coordinate>();

        Coordinate startCell = new Coordinate();
        startCell.i = startI;
        startCell.j = startJ;
        startCell.direction = 0;

        path.add(startCell);

        while (!path.isEmpty()) {
            //Incrementar direccion del ultimo elemento del path
            path.get(path.size() - 1).direction ++;

            if (path.get(path.size() - 1).direction < 5) {
                //TODO LO QUE SE HACE
                //Obtener la siguiente casilla posible
                Coordinate nextCell = getNextCell(path.get(path.size() - 1));
                if (checkCell(nextCell)) { //Comprobar casilla válida
                    path.add(nextCell);
                    if (nextCell.i == endI && nextCell.j == endJ){ //Comprobamos si la siguiente celda councide con la salida!!!!
                        found = true;
                        if (auxPath.isEmpty()){
                            for (int k = 0; k < path.size(); k++) {
                                Coordinate aux = new Coordinate();
                                aux.i = path.get(k).i;
                                aux.j = path.get(k).j;
                                aux.direction = path.get(k).direction;

                                auxPath.add(aux);
                            }
                        }
                        
                        if (auxPath.size() > path.size()) {
                            auxPath = new ArrayList<Coordinate>();
                            for (int k = 0; k < path.size(); k++) {
                                Coordinate aux = new Coordinate();
                                aux.i = path.get(k).i;
                                aux.j = path.get(k).j;
                                aux.direction = path.get(k).direction;

                                auxPath.add(aux);
                            }
                        }
                    }
                }
            } else {
                //Borramos el ultimo elemento.
                path.remove(path.size() - 1);
            }
        }
        if (!auxPath.isEmpty()){
            for (int k = 0; k < auxPath.size(); k++) {
                Coordinate aux = new Coordinate();
                aux.i = auxPath.get(k).i;
                aux.j = auxPath.get(k).j;
                aux.direction = auxPath.get(k).direction;

                path.add(aux);
            }
        }
        
        System.out.println("¡Camino encontrado!");
        return found;
    }

    
}
