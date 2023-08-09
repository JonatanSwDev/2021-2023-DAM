package net.iescierva.jgg.musica.Reproductor;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.MediaController;
import net.iescierva.jgg.musica.Aplicacion;
import net.iescierva.jgg.musica.Listeners.OnSongChanged.SongChangedObserver;

public class UsosMediaController implements MediaController.MediaPlayerControl {
    private final MediaPlayer mediaPlayer;
    private ControlReproductor rControl;
    private SongChangedObserver songChangedObserver;

    public UsosMediaController (MediaPlayer mediaPlayer, MediaController mediaController, Context context){
        this.mediaPlayer = mediaPlayer;
        Aplicacion app = (Aplicacion) context;
        this.rControl = app.getrControl();
        this.songChangedObserver = app.getSongChangedObserver();
        mediaController.setMediaPlayer(this);

        //El segundo listener es para el boton prev
        mediaController.setPrevNextListeners(
                //El primer listener es para el boton next
                v -> rControl.siguienteCancion(), v -> rControl.anteriorCancion());
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    @Override
    public void pause() {
        if (mediaPlayer.isPlaying()) songChangedObserver.pauseSong(mediaPlayer);
    }

    @Override
    public void seekTo(int pos) {
        mediaPlayer.seekTo(pos);
    }

    @Override
    public void start() {
        songChangedObserver.playSong(mediaPlayer);
    }
}
