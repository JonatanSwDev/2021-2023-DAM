package net.iescierva.dam22_06.mislugaresjavar.casos_uso;

import android.app.Activity;
import android.content.Intent;

import net.iescierva.dam22_06.mislugaresjavar.Actividades.AcercaDeActivity;
import net.iescierva.dam22_06.mislugaresjavar.Actividades.PreferenciasActivity;

public class CasosUsoActividades {
    private Activity actividad;

    public CasosUsoActividades(Activity actividad){
        this.actividad = actividad;

    }

    public void lanzarAcercaDe() {
        Intent i = new Intent(actividad, AcercaDeActivity.class);
        actividad.startActivity(i);
    }

    public void lanzarPreferencias() {
        Intent i = new Intent(actividad, PreferenciasActivity.class);
        actividad.startActivity(i);
    }
}
