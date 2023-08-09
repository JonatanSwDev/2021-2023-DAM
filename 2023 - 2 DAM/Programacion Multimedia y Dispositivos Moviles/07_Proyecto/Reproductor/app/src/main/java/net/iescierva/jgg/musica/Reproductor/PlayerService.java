package net.iescierva.jgg.musica.Reproductor;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.NotificationCompat;
import net.iescierva.jgg.musica.CaratulaActivity;
import net.iescierva.jgg.musica.Aplicacion;
import net.iescierva.jgg.musica.R;
import net.iescierva.jgg.musica.Listeners.OnSongChanged.SongChangedObserver;

import java.io.IOException;

public class PlayerService extends Service implements MediaPlayer.OnCompletionListener {

    //Definicion de la clase para la comunicacion con las actividades
    //Voy a combinarlo con Intenciones con acciones
    public class ServiceBinder extends Binder {
        public PlayerService getPlayerService() {
            return PlayerService.this;
        }
    }
    //Metodo que devuelve el servicio
    @Override
    public IBinder onBind(Intent intent) {
        return serviceBinder;
    }

    private MediaSessionCompat mediaSession;
    //Servicio de comunicacion para las actividades
    private final IBinder serviceBinder = new ServiceBinder();
    public MediaPlayer mediaPlayer;
    private ControlReproductor rControl;
    private SongChangedObserver songChangedObserver;
    private final String CHANNEL_ID = "Reproductor";

    @Override
    public void onCreate() {
        super.onCreate();
        Aplicacion app = (Aplicacion) getApplicationContext();
        rControl = app.getrControl();
        songChangedObserver = app.getSongChangedObserver();

        //Declaramos el MediaSession para la notificacion
        mediaSession = new MediaSessionCompat(this, "PlayerService");

        //Creacion del canal de Notificaciones
        // Crear el canal al sistema de notificaciones del movil
        crearNotificationChannel();

        //Crear el MediaPlayer
        mediaPlayer = new MediaPlayer();
        //Asignar atributos
        mediaPlayer.setAudioAttributes(setAudioAtributes());
        // Registrar el MediaSession con el sistema
        mediaSession.setActive(true);
        //Establecer el onCompletitionListener aqui
        mediaPlayer.setOnCompletionListener(this);
        //Empezar la reproduccion de inmediato
        reproduccionInicial();

        //Listener para el onPrepared
        mediaPlayer.setOnPreparedListener(mp -> {
            //Equivalente a mediaPlayer.play() pero lanzando notificaciones
            songChangedObserver.changeSong(mediaPlayer);
            notificacion();
        });
    }

    //////SECCIONE LISTENERS//////
    @Override
    public void onCompletion(MediaPlayer mp) {
        rControl.siguienteCancion();
    }


    //////SECCIONE DE COMANDOS//////
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            //Accion de reproducir una cancion
            switch (intent.getAction()) {
                case "PLAY":
                    String mediaUrl = intent.getStringExtra("MEDIA_URL");
                    playCancion(mediaUrl);
                    break;
                case "PLAYPAUSE":
                    playPause();
                    break;
                case "STOP":
                    songChangedObserver.stopSong(mediaPlayer);
                    rControl.setStop(true);
                    break;
                case "NEXT":
                    rControl.siguienteCancion();
                    break;
                case "PREV":
                    rControl.anteriorCancion();
                    break;
                case "PAUSE":
                    songChangedObserver.pauseSong(mediaPlayer);
                case "REANUDE":
                    songChangedObserver.playSong(mediaPlayer);
            }
        }
        return START_NOT_STICKY;
    }


    //////SECCIONE DE METODOS DEL MEDIAPLAYER//////

    //Metodo para devolver los atributos del reproductor
    private AudioAttributes setAudioAtributes() {
        return new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
    }
    //Metodo para comenzar la reproduccion de inmediato
    private void reproduccionInicial() {
        try {
            String path = rControl.getCancionActual().getPath();
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Metodo que cambia de cancion
    private void playCancion(String mediaUrl) {
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(mediaUrl);
            mediaPlayer.prepare();
            //Notificacion
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Metodo que controla los distintos bootones del play Pause
    private void playPause() {
        if (mediaPlayer.isPlaying()) {
            //Equivalente a mediaPlayer.pause() pero lanzando notificaciones
            songChangedObserver.pauseSong(mediaPlayer);
        } else {
            //Equivalente a mediaPlayer.start() pero lanzando notificaciones
            if (rControl.isStopped()) {
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                songChangedObserver.playSong(mediaPlayer);
            }
        }
    }


    //////SECCION DE NOTIFICACIONES//////

    //Metodo para la creacion del canal de notificaciones
    private void crearNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, getString(R.string.channel_name), NotificationManager.IMPORTANCE_DEFAULT);
        //Asignar descripcion al Canal
        channel.setDescription(getString(R.string.channel_description));
        //Crear el notification manager y registrar el canal
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    //Metodo para crear la notificacion
    private void notificacion() {
        // Crear intent para lanzar la actividad principal al hacer clic en la notificación
        Intent intent = new Intent(this, CaratulaActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        // Crear intent para el botón de pausa
        Intent pauseIntent = new Intent(this, PlayerService.class);
        pauseIntent.setAction("PLAYPAUSE");
        PendingIntent pausePendingIntent = PendingIntent.getService(this, 0, pauseIntent, PendingIntent.FLAG_IMMUTABLE);

        // Crear intent para el botón de siguiente
        Intent nextIntent = new Intent(this, PlayerService.class);
        nextIntent.setAction("NEXT");
        PendingIntent nextPendingIntent = PendingIntent.getService(this, 0, nextIntent, PendingIntent.FLAG_IMMUTABLE);

        // Crear intent para el botón de atrás
        Intent prevIntent = new Intent(this, PlayerService.class);
        prevIntent.setAction("PREV");
        PendingIntent prevPendingIntent = PendingIntent.getService(this, 0, prevIntent, PendingIntent.FLAG_IMMUTABLE);


        //Tratamiento de imagenes
        Bitmap bitmap;
        byte[] img = rControl.getCaratula1();
        if (img != null){
            bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
        } else {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.default_afterlife);
        }


        // Crear las acciones para los botones
        NotificationCompat.Action prevAction = new NotificationCompat.Action.Builder(
                R.mipmap.atras, "Atrás", prevPendingIntent).build();

        NotificationCompat.Action pauseAction = new NotificationCompat.Action.Builder(
                mediaPlayer.isPlaying() ? R.mipmap.pausa : R.mipmap.play, "Pausa", pausePendingIntent).build();

        NotificationCompat.Action nextAction = new NotificationCompat.Action.Builder(
                R.mipmap.siguiente, "Siguiente", nextPendingIntent).build();

        //GENERAR LA NOTIFICACION SIN ESTAR DEPRECATED!!!!
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.fab)
                .setContentTitle(rControl.getCancionActual().getTitulo())
                .setContentText(rControl.getCancionActual().getArtista())
                .setContentIntent(pendingIntent)
                .setLargeIcon(bitmap)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(0, 1, 2)
                        .setMediaSession(mediaSession.getSessionToken()))
                .addAction(prevAction)
                .addAction(pauseAction)
                .addAction(nextAction)
                .setOngoing(true);

        // Lanzar la notificación
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.notify(6969, builder.build());
    }

    //Acciones al parar el servicio
    @Override
    public void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            stopSelf();
            super.onDestroy();
        }
    }
}