package net.iescierva.jgg.musica;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import net.iescierva.jgg.musica.Iintents.IntentManager;
import net.iescierva.jgg.musica.Listeners.OnMenuItem.ItemMenuObserver;
import net.iescierva.jgg.musica.Listeners.OnMenuItem.OnItemMenuChanged;
import net.iescierva.jgg.musica.Modelo.CancionAdapter;
import net.iescierva.jgg.musica.Reproductor.ControlReproductor;
import net.iescierva.jgg.musica.Reproductor.PlayerService;
import net.iescierva.jgg.musica.Reproductor.UsosMediaController;
import net.iescierva.jgg.musica.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnItemMenuChanged {
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private ActivityMainBinding binding;
    private MediaController mediaController;
    private MediaPlayer mediaPlayer;
    private Aplicacion app;
    private boolean isBound;
    private ControlReproductor rControl;
    private ItemMenuObserver itemMenuObserver;
    private IntentManager intentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Seccion de permisos
        /*Primero, verifica si la aplicación ya tiene el permiso solicitado, llamando a checkSelfPermission()
         con el permiso Manifest.permission.READ_EXTERNAL_STORAGE. Si el permiso no está concedido,
         la aplicación procede a solicitar el permiso mediante requestPermissions().
         */
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            }
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //Centro de mando
        app = (Aplicacion) MainActivity.this.getApplication();

        //Clase que controla las intenciones
        intentManager = new IntentManager(this);

        //Clase encargada del control
        rControl = app.getrControl();

        //Clase encargada de la sincronizacion del menu
        itemMenuObserver = app.getItemMenuObserver();
        //Registrar esta actividad para el servicio de la interfaz, que es un listener
        itemMenuObserver.registerObserver(this);

        //Construir el adaptador y asignarlo al recyclerView
        CancionAdapter adaptador = app.getAdapter();

        //Posible implementacion de RecyclerView para crear el metodo de notifyDataSetChanged() desde otra actividad
        recyclerView.setAdapter(adaptador);

        //Construir y asignar el LayoutManager, en este caso de tipo Linear
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Construir y asignar el separador de elementos
        DividerItemDecoration separador = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(separador);

        //Inincializar el mediaController
        mediaController = new MediaController(this);

        //Arrancar el servicioPlayService
        doBindService();

        //Genera dos listeners
        adaptador.setOnItemClickListener(posicion -> {
            rControl.setActual(posicion);
            intentManager.cambiarCancion(app.getCanciones().get(posicion).getPath());
        });

        //Onclick del fab
        binding.fab.setOnClickListener(view -> {
            if(mediaController.isShowing()){
                mediaController.hide();
            } else {
                mediaController.show(0);
            }
        });

        //OnlongClick del fab
        binding.fab.setOnLongClickListener(v -> {
            //Traer la caratula al frente
            intentManager.mostrarCaratula();
            return true;
        });
    }

    /////SECCION SERVICIO/////
    private void doBindService() {
        Intent playerServiceIntent = new Intent(this, PlayerService.class);
        bindService(playerServiceIntent, playerServiceConnection, Context.BIND_AUTO_CREATE);
    }

    //Objeto del servicio
    ServiceConnection playerServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //Obtener la instancia del servicio
            PlayerService.ServiceBinder binder = (PlayerService.ServiceBinder) service;
            //Obtener el mediaPlayer para el mediaController
            mediaPlayer = binder.getPlayerService().mediaPlayer;
            app.setMediaPlayer(mediaPlayer);

            //Asignar el mediaPlayer al mediaController
            mediaController.setAnchorView(findViewById(R.id.linearLayout));
            isBound = true;

            //Una vez que crea el mediaController se levanta la clase del control del mediaController
            new UsosMediaController(mediaPlayer, mediaController, app);

            //Arrancamos la caratula
            intentManager.arrancarCaratula();
        }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaController = null;
        mediaPlayer = null;
    }};


    /////SECCION MENU/////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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

    //Listener para la sincronizacion de los iconos del menu
    @Override
    public void onMenuIconChanged() {
        // Actualiza el icono del menú en la actividad
        MenuItem menuItem = binding.toolbar.getMenu().findItem(itemMenuObserver.getMenuItem());
        menuItem.setIcon(itemMenuObserver.getMenuIconResId());
    }

    @Override
    protected void onDestroy() {
        if (isBound) {
            unbindService(playerServiceConnection);
            isBound = false;
        }
        itemMenuObserver.unregisterObserver(this);
        super.onDestroy();
    }
}