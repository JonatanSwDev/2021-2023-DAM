import java.io.File;

public class BorraFich {
    public static void main(String[] args){
        File f = new File(args[0],args[1]);
        if(f.isFile()){
            f.delete();
            System.out.println(f.getName() + " eliminado");
        } else{
            File[] ficheros = f.listFiles();
            eliminar(ficheros);
            f.delete();
            
        }
    }

    private static void eliminar(File[] f){
        for(int i = 0; i < f.length; i++){
            if(f[i].isFile()){
                f[i].delete();
                System.out.println(f[i].getName() + " eliminado");
            } else{
                File[] ficheros = f[i].listFiles();
                eliminar(ficheros);
            }
            f[i].delete();
                System.out.println(f[i].getName() + " eliminado");
        }
    }
}
