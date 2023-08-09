package net.iescierva.dam22_06.mislugaresjavar.Actividades;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.takisoft.preferencex.PreferenceFragmentCompat;

import net.iescierva.dam22_06.mislugaresjavar.R;


public class PreferenciasFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferencesFix(@Nullable Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferencias, rootKey);

        // additional setup
    }
}
