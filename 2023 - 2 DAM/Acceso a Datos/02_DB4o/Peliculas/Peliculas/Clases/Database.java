package Peliculas.Clases;

import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class Database {
    private static ObjectContainer dbPelis;
    private static ObjectContainer dbDirectores;

    public Database() {
        Pelicula p1 = new Pelicula("Julieta", "Almodovar", 120);
        Pelicula p2 = new Pelicula("Kiki", "Paco Leon", 115);
        Pelicula p3 = new Pelicula("Batman", "Tim Burton", 100);
        Pelicula p4 = new Pelicula("Volver", "Almodovar", 125);
        Pelicula p5 = new Pelicula("Big Fish", "Tim Burton", 120);
        Pelicula p6 = new Pelicula("Toc Toc", "Paco Leon", 118);

        Director d1 = new Director("Almodovar", "España");
        Director d2 = new Director("Paco Leon", "España");
        Director d3 = new Director("Tim Burton", "EE.UU");

        File fileP = new File(CommonVar.getRutaPelis());
        if (fileP.exists()) {
            fileP.delete();
        }
        File fileD = new File(CommonVar.getRutaDirectores());
        if (fileD.exists()) {
            fileD.delete();
        }

        dbPelis = Db4oEmbedded.openFile(CommonVar.getRutaPelis());
        dbPelis.store(p1);
        dbPelis.store(p2);
        dbPelis.store(p3);
        dbPelis.store(p4);
        dbPelis.store(p5);
        dbPelis.store(p6);
        dbDirectores = Db4oEmbedded.openFile(CommonVar.getRutaDirectores());
        dbDirectores.store(d1);
        dbDirectores.store(d2);
        dbDirectores.store(d3);
    }

    public static void getPelis() {
        ObjectSet<Pelicula> result = dbPelis.queryByExample(new Pelicula(null, null, 0));
        if (result.size() == 0)
            System.out.println("No se han encontrado registros en la base de datos");
        else {
            System.out.println("\n\tNúmero de registros encontrados: " + result.size());
            Pelicula pelicula = null;
            int i = 0;
            while (result.hasNext()) {
                pelicula = result.next();
                System.out.println("Registro nº " + i + " - " + pelicula.toString());
                i++;
            }
        }
    }

    public static void getPelisDirector(String director) {
        if (checkDirector(director)) {
            ObjectSet<Pelicula> result = dbPelis.queryByExample(new Pelicula(null, director, 0));
            if (result.size() == 0)
                System.out.println("\nNo se ha encontrado peliculas para el director " + director);
            else {
                System.out.println("\n\tNúmero de registros encontrados: " + result.size());
                Pelicula pelicula = null;
                int i = 0;
                while (result.hasNext()) {
                    pelicula = result.next();
                    System.out.println("Registro nº " + i + " - " + pelicula.toString());
                    i++;
                }
            }
        }
    }

    private static boolean checkDirector(String director) {
        ObjectSet<Director> result = dbDirectores.queryByExample(new Director(director, null));
        if (result.size() == 0) {
            System.out.println("\nNo se ha encontrado director.");
            return false;
        } else {
            System.out.println("\n" + director + " encontrado en la base de datos.");
            return true;
        }
    }

    public static void getPelisDuracion(int duracionMin, int duracionMax) {
        ObjectSet<Pelicula> result = dbPelis.queryByExample(new Pelicula(null, null, 0));
        if (result.size() == 0)
            System.out.println("No se han encontrado registros en la base de datos");
        else {
            Pelicula pelicula = null;
            int i = 0;
            while (result.hasNext()) {
                    pelicula = result.next();
                if (pelicula.getDuracion() >= duracionMin && pelicula.getDuracion() <= duracionMax) {
                    System.out.println("Registro nº " + i + " - " + pelicula.toString());
                    i++;
                }
            }
        }
    }

    public static void eliminarPelis(String titulo) {
        ObjectSet<Pelicula> result = dbPelis.queryByExample(new Pelicula(titulo, null, 0));
        if (result.size() == 0)
            System.out.println("No se han encontrado registros en la base de datos");
        else {
            System.out.println("\n\tNúmero de registros eliminados: " + result.size());
            Pelicula pelicula = null;
            int i = 0;
            while (result.hasNext()) {
                pelicula = result.next();
                dbPelis.delete(pelicula);
                i++;
            }
        }
    }

    public static void modificarDuracion(String titulo, int duracion) {
        ObjectSet<Pelicula> result = dbPelis.queryByExample(new Pelicula(titulo, null, 0));
        if (result.size() == 0)
            System.out.println("No se han encontrado registros en la base de datos");
        else {
            System.out.println("\n\tNúmero de registros eliminados: " + result.size());
            Pelicula pelicula = null;
            int i = 0;
            while (result.hasNext()) {
                pelicula = result.next();
                pelicula.setDuracion(duracion);
                dbPelis.store(pelicula);
                i++;
            }
        }
    }

    public static boolean getPelisTitulo(String titulo) {
        boolean encontrada = false;
        ObjectSet<Pelicula> result = dbPelis.queryByExample(new Pelicula(titulo, null, 0));
        if (result.size() == 0)
            System.out.println("No se han encontrado registros en la base de datos");
        else {
            System.out.println("\n\tNúmero de registros encontrados: " + result.size());
            encontrada = true;
            Pelicula pelicula = null;
            int i = 0;
            while (result.hasNext()) {
                pelicula = result.next();
                System.out.println("Registro nº " + i + " - " + pelicula.toString());
                i++;
            }
        }
        return encontrada;
    }

    public static void closeConnection() {
        dbPelis.close();
        dbDirectores.close();
    }
}


