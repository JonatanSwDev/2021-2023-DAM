package net.iescierva.jgg.musica.Iintents;

import android.content.Context;
import android.content.Intent;
import net.iescierva.jgg.musica.Data.AcercaDeActivity;
import net.iescierva.jgg.musica.CaratulaActivity;
import net.iescierva.jgg.musica.MainActivity;
import net.iescierva.jgg.musica.Reproductor.PlayerService;

public class IntentManager {
    private final Context context;

    public IntentManager(Context context) {
        this.context = context;
    }

    public void arrancarCaratula() {
        Intent intent = new Intent(context, CaratulaActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void mostrarCaratula(){
        Intent intent = new Intent(context, CaratulaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }

    public void cambiarCancion(String path){
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction("PLAY");
        intent.putExtra("MEDIA_URL", path);
        context.startService(intent);
    }

    public void mostrarMainActivity(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }

    public void playPause() {
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction("PLAYPAUSE");
        context.startService(intent);
    }

    public void stopCancion() {
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction("STOP");
        context.startService(intent);
    }

    public void pause() {
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction("PAUSE");
        context.startService(intent);
    }

    public void reanude() {
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction("REANUDE");
        context.startService(intent);
    }

    public void lanzarAcercade(){
        Intent intent = new Intent(context, AcercaDeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
