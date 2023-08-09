package net.iescierva.jgg.musica;

import android.annotation.SuppressLint;
import android.app.Application;
import android.media.MediaPlayer;
import net.iescierva.jgg.musica.Listeners.BroadcastReceiver.BroadcastRegister;
import net.iescierva.jgg.musica.Listeners.OnAdapterData.AdapterDataObserver;
import net.iescierva.jgg.musica.Listeners.OnSongChanged.SongChangedObserver;
import net.iescierva.jgg.musica.Modelo.CancionAdapter;
import net.iescierva.jgg.musica.Data.ListaCanciones;
import net.iescierva.jgg.musica.Data.RepositorioCanciones;
import net.iescierva.jgg.musica.Reproductor.ControlReproductor;
import net.iescierva.jgg.musica.Listeners.OnMenuItem.ItemMenuObserver;

public class Aplicacion extends Application {
    private RepositorioCanciones canciones;
    private CancionAdapter adaptador;
    private ControlReproductor rControl;
    private MediaPlayer mediaPlayer;
    private ItemMenuObserver itemMenuObserver;
    private AdapterDataObserver adapterDataObserver;
    private SongChangedObserver songChangedObserver;

    @Override public void onCreate() {
        super.onCreate();
        this.canciones = new ListaCanciones();
        this.adaptador = new CancionAdapter(this, canciones);
        this.rControl = new ControlReproductor(this);
        this.itemMenuObserver = new ItemMenuObserver();
        this.adapterDataObserver = new AdapterDataObserver();
        this.songChangedObserver = new SongChangedObserver();
        new BroadcastRegister(this);
    }

    ////////GETTER Y SETTER////////
    public CancionAdapter getAdapter() {
        return adaptador;
    }
    public RepositorioCanciones getCanciones() {
        return canciones;
    }
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
    public ControlReproductor getrControl() {
        return rControl;
    }
    public ItemMenuObserver getItemMenuObserver() {return itemMenuObserver;}
    public AdapterDataObserver getAdapterDataObserver() {return adapterDataObserver;}

    public SongChangedObserver getSongChangedObserver() {return songChangedObserver;}


    ////////SECCION LISTENERS////////
    public void notifyDataChanged() {adapterDataObserver.notificarAdapter(adaptador);}
}
