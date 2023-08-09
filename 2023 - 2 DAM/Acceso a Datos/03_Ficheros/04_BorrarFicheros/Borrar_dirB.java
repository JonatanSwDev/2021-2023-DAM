package BorrarFicheros;

import java.io.File;

public class Borrar_dirB {
    public static void main(String[] args){
        /*
         * 
         * Medida de seguridad, estoy trabajando sobre C:\
         * ¡Descomentar para ejecutar!
         * 
         */
        if(!args[0].equals("C:\\Eliminar")){
            System.out.println("Cuidado! Que la lias!");
            System.exit(0);
        }
        File f = new File(args[0]);
        if(f.isFile()){
            System.out.println("Has seleccionado un fichero, no un directorio");
        } else{
            File[] ficheros = f.listFiles();
            eliminar(ficheros);
        }
    }

    private static void eliminar(File[] f){
        String option = "n";
        for(int i = 0; i < f.length; i++){
            if(f[i].isFile()){
                option = DataEntry.getString("Desea eliminar " + f[i].getAbsolutePath() + "?(S/N)");
                if(option.equalsIgnoreCase("S")){
                    f[i].delete();
                    System.out.println(f[i].getName() + " eliminado");
                }
            } else{
                System.out.println(f[i].getAbsolutePath() + " es un directorio\n"+
                "¿Desea borrarlo con todo su contenido?(S/N)");
                option = DataEntry.getString();
                if(option.equalsIgnoreCase("S")){
                    File[] ficheros = f[i].listFiles();
                    eliminarTodo(ficheros);
                    f[i].delete();                
                }
            }
        }
    }

    private static void eliminarTodo(File[] f){
        for(int i = 0; i < f.length; i++){
            if(f[i].isFile()){
                f[i].delete();
                System.out.println(f[i].getAbsolutePath() + " eliminado");
            } else{
                File[] ficheros = f[i].listFiles();
                eliminarTodo(ficheros);
            }
            f[i].delete();
                System.out.println(f[i].getAbsolutePath() + " eliminado");
        }
    }
}
