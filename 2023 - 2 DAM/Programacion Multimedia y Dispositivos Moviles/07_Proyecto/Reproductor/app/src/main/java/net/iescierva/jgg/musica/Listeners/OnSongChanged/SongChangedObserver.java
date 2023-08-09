package net.iescierva.jgg.musica.Listeners.OnSongChanged;

import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;


public class SongChangedObserver {
    private List<OnSongChanged> observers = new ArrayList<>();

    public void registerObserver(OnSongChanged observer) {
        observers.add(observer);
    }

    public void unregisterObserver(OnSongChanged observer) {
        observers.remove(observer);
    }

    public void changeSong(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        notifyReanude();
        notifyChange();
    }

    public void pauseSong(MediaPlayer mediaPlayer) {
        mediaPlayer.pause();
        notifyPause();
    }

    private void notifyPause() {
        for (OnSongChanged observer : observers) {
            observer.onSongPaused();
        }
    }

    public void playSong(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        notifyReanude();
    }

    public void stopSong(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        notifyPause();
    }

    private void notifyReanude() {
        for (OnSongChanged observer : observers) {
            observer.onSongPlayed();
        }
    }

    private void notifyChange() {
        for (OnSongChanged observer : observers) {
            observer.onSongChanged();
        }
    }
}
