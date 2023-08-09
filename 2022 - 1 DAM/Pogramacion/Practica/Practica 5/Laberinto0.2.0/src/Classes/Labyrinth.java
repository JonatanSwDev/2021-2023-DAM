package Classes;
/**
 * Lbyrinth.java
 * Calase encargada de gestionar la carga y manupulación de los laberintos.
 * Jonatan Gomez Garcia
 * version 0.2.0 >> 13/12/2021
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

    public Labyrinth() {
        loaded = false;
    }

    public void loadLabyrinth(){
        File[] maze = listDirectory();

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

        String mostrarArray = "";
        System.out.println();
        if (map.length > 9){
        mostrarArray += "                       ";
    }   
        for (int p = 0; p <= map.length; p++){
            if (p > 10 && p < 21){
                mostrarArray += 1 + " ";
            }
            if (p > 20){
                mostrarArray += 2 + " ";
            }
            if (p == map.length){
                mostrarArray += "\n";
            }
        }
        for(int p = 0; p < map.length; p++){
            if (p == 0){
                mostrarArray += "   ";
            }
            if (p < 10){
                mostrarArray += p + " ";
            }
            if (p >= 10 && p < 20){
                mostrarArray += (p - 10) + " ";
            }
            if (p >= 20 && p < 30){
                mostrarArray += (p - 20) + " ";
            }
            if (p == map.length - 1){
                mostrarArray += "\n";
            }
        
        } 
        for (int i = 0; i < map.length; i++) {
            if (i < 10){
            mostrarArray += i + "  ";
            }
            if (i >= 10){
            mostrarArray += i + " ";
            }
            for (int j =0; j < map[i].length; j++) {
                mostrarArray += map[i][j];
                mostrarArray += " ";
            }
                mostrarArray += "\n";
        }
        System.out.println(mostrarArray);
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
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No se ha podido establecer casilla de entrada o salida\nCodigo de error:");
            e.printStackTrace();
            Interface.toContinue();
            return;
        }
    }
}
