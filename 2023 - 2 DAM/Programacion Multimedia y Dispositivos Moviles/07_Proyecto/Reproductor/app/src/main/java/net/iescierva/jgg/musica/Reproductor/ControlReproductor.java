package net.iescierva.jgg.musica.Reproductor;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import net.iescierva.jgg.musica.Aplicacion;
import net.iescierva.jgg.musica.Data.RepositorioCanciones;
import net.iescierva.jgg.musica.Iintents.IntentManager;
import net.iescierva.jgg.musica.Modelo.Cancion;

import java.io.IOException;

public class ControlReproductor {
    private boolean repetir;
    private boolean random;
    private boolean stop;
    private int actual;
    private final Aplicacion app;
    private byte[] caratula1;
    private byte[] caratula2;
    IntentManager intentManager;
    private final RepositorioCanciones canciones;

    public ControlReproductor(Context context) {
        this.app = (Aplicacion) context;
        this.canciones = app.getCanciones();
        this.repetir = false;
        this.random = false;
        this.stop = false;
        this.intentManager = new IntentManager(context);
        this.actual = 0;
        generarCaratula1();
        generarCaratula2();
    }


    //////METODOS DEL REPRODUCTOR//////


    //Reproducir siguiente cancion
    public void siguienteCancion() {
        if (actual < canciones.size() -1){
            actual ++;
            intentManager.cambiarCancion(canciones.get(actual).getPath());
        } else if (repetir){
            actual = 0;
            intentManager.cambiarCancion(canciones.get(actual).getPath());
        }
    }

    //Reproducir cancion anterior
    public void anteriorCancion() {
        if (actual > 0) {
            actual--;
            intentManager.cambiarCancion(canciones.get(actual).getPath());
        }
    }


    //////GETTER Y SETTER SENCILLOS//////

    public Cancion getCancionActual(){return canciones.get(actual);}
    public boolean isRandom(){
        return random;
    }
    public boolean isStopped() {return stop;}
    public void setStop(boolean stop) {this.stop = stop;}


    //////GETTER Y SETTER COMPLEJOS//////

    //Caratula1
    public void generarCaratula1() {
        try {
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(canciones.get(actual).getPath());
            caratula1 = null;
            caratula1= mmr.getEmbeddedPicture();
            mmr.release();
            mmr.close();
        } catch (IOException ignored) {}
    }
    public byte[] getCaratula1() {
        return caratula1;
    }

    //Caratula2
    public void generarCaratula2(){
        int focus = -1;
        if(actual + 1 >= canciones.size()){
            focus = 0;
        } else {
            focus = actual +1;
        }
        try {
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(canciones.get(focus).getPath());
            caratula2 = null;
            caratula2 = mmr.getEmbeddedPicture();
            mmr.close();
            mmr.release();
        } catch (IOException ignored) {}
    }
    public byte[] getCaratula2() {
        return caratula2;
    }
    //Actual

    public void setActual(int actual) {
        if (actual >= 0 && actual < canciones.size()){
            this.actual = actual;
        }
    }

    //Repetir Set y Get juntos
    public boolean setRepetir() {
        //No sabia que se podia hacer esto, mola
        repetir = !repetir;
        return repetir;
    }
    //Random set y get Juntos
    public boolean setRandom() {
        if (isRandom()){
            random = false;
            canciones.ordenarLista(random);
        } else{
            random = true;
            canciones.ordenarLista(random);

        }
        actual = 0;
        app.notifyDataChanged();
        return random;
    }
}
