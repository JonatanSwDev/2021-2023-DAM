package net.iescierva.jgg.musica;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;


import net.iescierva.jgg.musica.Iintents.IntentManager;
import net.iescierva.jgg.musica.databinding.ActivityCaratulaBinding;
import net.iescierva.jgg.musica.Reproductor.ControlReproductor;
import net.iescierva.jgg.musica.Listeners.OnAdapterData.AdapterDataObserver;
import net.iescierva.jgg.musica.Listeners.OnAdapterData.OnAdapterDataChanged;
import net.iescierva.jgg.musica.Listeners.OnMenuItem.ItemMenuObserver;
import net.iescierva.jgg.musica.Listeners.OnMenuItem.OnItemMenuChanged;
import net.iescierva.jgg.musica.Listeners.OnSongChanged.OnSongChanged;
import net.iescierva.jgg.musica.Listeners.OnSongChanged.SongChangedObserver;

import java.util.Objects;

public class CaratulaActivity extends AppCompatActivity implements OnItemMenuChanged, OnAdapterDataChanged, OnSongChanged {
    private ActivityCaratulaBinding binding;
    private static ControlReproductor rControl;
    private MediaPlayer mediaPlayer;
    private ItemMenuObserver itemMenuObserver;
    private AdapterDataObserver adapterDataObserver;
    private SongChangedObserver songChangedObserver;
    private IntentManager intentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Aplicacion app = (Aplicacion) getApplicationContext();
        rControl = app.getrControl();
        mediaPlayer = app.getMediaPlayer();
        binding = ActivityCaratulaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intentManager = new IntentManager(this);

        binding.progreso.setMax(mediaPlayer.getDuration());
        binding.progreso.postDelayed(mUpdateTimeTask, 100);

        //Habilitar la flecha de retroceso a al Toolbar
        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setSupportActionBar(binding.toolbar);

        //Establecer listener para los cambios en los items del menu desde MainActivity
        itemMenuObserver = app.getItemMenuObserver();
        itemMenuObserver.registerObserver(this);

        //Listener para cuando cambia la lista de canciones
        adapterDataObserver = app.getAdapterDataObserver();
        adapterDataObserver.registerObserver(this);

        //Establecer Listener para cuando cambie la cancion
        songChangedObserver = app.getSongChangedObserver();
        songChangedObserver.registerObserver(this);

        //Metodo para construir las caratulas al inicio
        ponerCaratulas();

        binding.progreso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }
            //No son necesarias acciones aqui
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    ///////SECCION METODOS ACTIVIDAD///////

    public void ponerCaratula2(){
        byte[] img2 = rControl.getCaratula2();
        if (img2 == null){
            binding.pSiguiente.setImageResource(R.drawable.default_afterlife);
        } else {
            binding.pSiguiente.setImageBitmap(BitmapFactory.decodeByteArray(img2, 0, img2.length));
        }
    }

    public void ponerCaratulas(){
        byte[] img1 = rControl.getCaratula1();
        byte[] img2 = rControl.getCaratula2();
        if (img1 == null){
            binding.pActual.setImageResource(R.drawable.default_afterlife);
        } else {
            binding.pActual.setImageBitmap(BitmapFactory.decodeByteArray(img1, 0, img1.length));
        }
        if (img2 == null){
            binding.pSiguiente.setImageResource(R.drawable.default_afterlife);
        } else {
            binding.pSiguiente.setImageBitmap(BitmapFactory.decodeByteArray(img2, 0, img2.length));
        }
    }

    public void stopCancion(View view) {
        intentManager.stopCancion();
    }

    public void anteriorCancion(View view) {
        rControl.anteriorCancion();
    }

    public void playPause(View view) {
        intentManager.playPause();
    }

    public void siguienteCancion(View view) {
        rControl.siguienteCancion();
    }

    ///////SECCION MENU///////

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.acerca_de:
                intentManager.lanzarAcercade();
                break;
            case android.R.id.home:
                intentManager.mostrarMainActivity();
                break;
            case R.id.mAction_random:
                if(rControl.setRandom()){
                    itemMenuObserver.setMenuIconResId(R.mipmap.aleatorio, R.id.mAction_random);
                } else {
                    itemMenuObserver.setMenuIconResId(R.mipmap.aleatorio_f, R.id.mAction_random);
                }
                break;
            case R.id.mAction_repeat:
                if(rControl.setRepetir()){
                    //Sincronizar iconos!
                    itemMenuObserver.setMenuIconResId(R.mipmap.repetir, R.id.mAction_repeat);
                } else {
                    itemMenuObserver.setMenuIconResId(R.mipmap.repetir_f, R.id.mAction_repeat);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    ///////LISTENERS///////

    //Listener para cuando cambian los iconos del menu
    @Override
    public void onMenuIconChanged() {
        // Actualiza el icono del menú en la actividad
        MenuItem menuItem = binding.toolbar.getMenu().findItem(itemMenuObserver.getMenuItem());
        menuItem.setIcon(itemMenuObserver.getMenuIconResId());
    }

    //Listener para cuando cambia la lista de orden
    @Override
    public void onAdapterDataChanged() {
        //Solo se actualiza la segunda caratula, ya que la primera está escuchandose
        rControl.generarCaratula2();
        ponerCaratula2();
    }
    @Override
    public void onSongChanged() {
        //Actualizar el contador de duracion del seekbar
        binding.progreso.setMax(mediaPlayer.getDuration());
        binding.progreso.postDelayed(mUpdateTimeTask, 100);

        //Se generan las dos caratulas, ya que el contador de actual en rControl se ha incrementado
        rControl.generarCaratula1();
        rControl.generarCaratula2();
        ponerCaratulas();
    }

    @Override
    public void onSongPaused() {
        binding.bPlayPause.setImageResource(R.mipmap.play);
    }

    @Override
    public void onSongPlayed() {
        binding.bPlayPause.setImageResource(R.mipmap.pausa);
        rControl.setStop(false);
    }

    @Override
    protected void onDestroy() {
        itemMenuObserver.unregisterObserver(this);
        adapterDataObserver.unregisterObserver(this);
        songChangedObserver.unregisterObserver(this);
        super.onDestroy();
    }


    /////CLASE RUNNABLE PARA EL SEEKBAR/////

    private final Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            if (mediaPlayer.isPlaying()) {
                int progress = mediaPlayer.getCurrentPosition();
                binding.progreso.setProgress(progress);
            }

            binding.progreso.postDelayed(this, 100);
        }
    };
}