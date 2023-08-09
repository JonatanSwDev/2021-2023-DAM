package net.iescierva.dam22_06.mislugaresjavar.Actividades;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import net.iescierva.dam22_06.mislugaresjavar.Aplicacion;
import net.iescierva.dam22_06.mislugaresjavar.R;
import net.iescierva.dam22_06.mislugaresjavar.casos_uso.CasosUsoLugar;

import net.iescierva.dam22_06.mislugaresjavar.databinding.EdicionLugarBinding;
import net.iescierva.dam22_06.mislugaresjavar.datos.RepositorioLugares;
import net.iescierva.dam22_06.mislugaresjavar.modelo.Lugar;
import net.iescierva.dam22_06.mislugaresjavar.modelo.TipoLugar;

import java.text.DateFormat;
import java.util.Date;

public class EdicionLugarActivity extends AppCompatActivity {
    private EdicionLugarBinding binding;
    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;
    private int pos;
    private Lugar lugar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EdicionLugarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("pos", 0);
        lugares = ((Aplicacion) getApplication()).lugares;
        usoLugar = new CasosUsoLugar(this, lugares);
        lugar = lugares.get_element(pos);
        actualizaVistas();
    }



    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edicion_lugar, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.accion_cancelar:
                setResult(RESULT_CANCELED);
                finish();
                return true;
            case R.id.accion_guardar:
                setResult(RESULT_OK);
                actualizarLugar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void actualizarLugar() {
        lugar.setNombre(binding.editNombre.getText().toString());
        lugar.setDireccion(binding.editDireccion.getText().toString());
        lugar.setTipo(TipoLugar.values()[binding.spinnerTipo.getSelectedItemPosition()]);
        lugar.setTelefono(Integer.parseInt(binding.editTelefono.getText().toString()));
        lugar.setUrl(binding.editUrl.getText().toString());
        lugar.setComentario(binding.editComentario.getText().toString());
        usoLugar.guardar(pos, lugar);
        finish();
    }

    public void actualizaVistas() {
        lugar = lugares.get_element(pos);
        binding.editNombre.setText(lugar.getNombre());
        binding.editDireccion.setText(lugar.getDireccion());
        binding.editTelefono.setText(Integer.toString(lugar.getTelefono()));
        binding.editUrl.setText(lugar.getUrl());
        binding.editComentario.setText(lugar.getComentario());

        ArrayAdapter adaptador = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, TipoLugar.getNombres());
        adaptador.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        binding.spinnerTipo.setAdapter(adaptador);
        binding.spinnerTipo.setSelection(lugar.getTipo().ordinal());
    }

}
