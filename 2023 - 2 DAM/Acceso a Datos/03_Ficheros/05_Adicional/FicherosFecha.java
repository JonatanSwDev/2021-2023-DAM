package ExamenDePractica1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FicherosFecha {
    //La lista de ficheros va a contener Arrays de tipo String en los que la posicion 0 va a ser el nombre del fichero y la posicion 1 va a ser la fecha de este
    private static ArrayList<String[]> ficheros = new ArrayList<String[]>();
    private static ArrayList<String> fechas = new ArrayList<String>();
    public static void main(String[] args){
        //Directorio a recorrer con todos sus subdirectorios
        File f = new File("D:\\Usuario\\JONeSHOOT\\Escritorio");
        

        if (f.isDirectory()){
            //Primero recorremos el directorio y guardamos en las listas todos los datos que nos hará falta para el tratamiento de estos
            recorrerDirectorio(f);
            try {
                //Una vez tenemos las listas completas simplemente organizamos los datos para escribirlos en el sistema
                escribirResultado();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void escribirResultado() throws IOException {
        //La forma de organizar los datos sería primero recorrer las fechas únicas que se encuentran entre los archivos, que van a ser a su vez determinantes para cada archivo
        //Ya que el nombre del fichero va a ser el mismo que el de la fecha, y ya tenemos una lísta cuyo contenido es el valor único de cada fecha, la enumeracion de fechas
        for (String fecha : fechas) {
            //Por cada vuelta del bucle vamos a necesitar declarar objetos y variables vacías
            //Lo necesario para escribir
            FileWriter fw = new FileWriter(".\\FicherosTexto\\src\\FicherosTexto\\Anios\\"+fecha+".txt");
            PrintWriter pw = new PrintWriter(fw);
            //Lo necesario para organizar
            int contador = 0;
            StringBuilder resultado = new StringBuilder();
            //Ahora con este bucle anidado vamos a recorrer todos los archivos por cada vuelta
            for (String[] fichero : ficheros) {
                //Como ya hemos mencionado, la lista de ficheros guarda Arrays de String[], la posicion 0 es el nombre del fichero y la posicion 1 es la fecha como cadena
                //Asi que si la fecha que estamos recorriendo coincide con la fecha de la posicion 1 del elemento actual
                if(fecha.equals(fichero[1])){
                    //Sumamos uno al contado (Que lo requiere el enunciado)
                    contador++;
                    //Y en la variable resultado vamos añadiendo las lineas de cada fichero encontrado a la fecha actual
                    resultado.append(fichero[0]+"\n");
                }
            }
            //Por último se escribe el fichero comenzando por la linea de numero de ficheros para la fecha actual, seguido de la lista de resultado de ficheros
            //Y por último cerramos la conexion de PrintWritter para que se efectuen los cambios reales.
            pw.println("Achivos de " + fecha + ": " + contador);
            pw.print(resultado);
            pw.close();
        }
        
    }

    //Metodo que se encarga de guardar todos los datos necesarios a tratar en dos listas
    private static void recorrerDirectorio(File f){
        //Como lo primero que va a llegar a este metodo siempre va a ser un directorio, lo primero que haremos será crear un Array de File[] para ir consultando individualmente los datos necesarios a guardar
        File[] f2 = f.listFiles();
        //Lo recorremos
        for (File file : f2) {
            //Y aqui es donde entra la parte recursiva del asunto, si se encuentra con un directorio vuelve a llamarse a si mismo para repetir el proceso hasta llegar al final del asunto
            if(file.isDirectory()){
                recorrerDirectorio(file);
            //Mencionar que cuando acaba de recorrer el directorio lo va a dejar por donde se quedó, ya que en lineas de instrucción el método aún no ha acabado
            } else{
                //En caso de que sea un fichero, que es lo que nos interesa tratar...
                //Obtenemos la fecha de última modificación ( el método devuelve un long )
                long tiempo = file.lastModified();
                //Asi que vamos a usar la clase Date para ayudarnos
                Date date = new Date(tiempo);
                //Con el SimpleDateFormat vamos a decir más adelante que solamente queremos el año de la fecha generada en la linea anterior
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
                //Por lo que ahora si, podemos guardar los dos únicos datos que nos hacen falta respecto a cada fichero individual
                //Posicion 0 = nombre del archivo - //Posicion 1 el año del archivo como String
                String[] fData = {file.getName(), formatter.format(date)};
                ficheros.add(fData);
                //En la segunda linea vamos a añadir solamente los años que contiene de forma individual todo
                //En SQL sería select distinct(fecha) from...
                if(!fechas.contains(formatter.format(date))){
                    fechas.add(formatter.format(date));
                }
                
            }
        }{

        }
    }
    
}
