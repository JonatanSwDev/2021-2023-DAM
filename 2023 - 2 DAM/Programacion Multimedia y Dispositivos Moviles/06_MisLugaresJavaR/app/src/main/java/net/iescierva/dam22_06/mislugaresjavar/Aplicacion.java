package net.iescierva.dam22_06.mislugaresjavar;

import android.app.Application;

import net.iescierva.dam22_06.mislugaresjavar.datos.LugaresLista;
import net.iescierva.dam22_06.mislugaresjavar.datos.RepositorioLugares;

public class Aplicacion extends Application {
    public RepositorioLugares lugares = new LugaresLista();
    public AdaptadorLugares adaptador = new AdaptadorLugares(lugares);
    @Override public void onCreate() {
        super.onCreate();
    }
}