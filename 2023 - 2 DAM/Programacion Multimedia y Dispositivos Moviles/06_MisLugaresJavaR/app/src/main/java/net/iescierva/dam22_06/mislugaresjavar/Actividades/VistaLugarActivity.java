package net.iescierva.dam22_06.mislugaresjavar.Actividades;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import net.iescierva.dam22_06.mislugaresjavar.Aplicacion;
import net.iescierva.dam22_06.mislugaresjavar.R;
import net.iescierva.dam22_06.mislugaresjavar.casos_uso.CasosUsoActividades;
import net.iescierva.dam22_06.mislugaresjavar.casos_uso.CasosUsoLugar;
import net.iescierva.dam22_06.mislugaresjavar.databinding.VistaLugarBinding;
import net.iescierva.dam22_06.mislugaresjavar.datos.RepositorioLugares;
import net.iescierva.dam22_06.mislugaresjavar.modelo.Lugar;

import java.text.DateFormat;
import java.util.Date;

public class VistaLugarActivity extends AppCompatActivity {
    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;
    private int pos;
    private Lugar lugar;
    private VistaLugarBinding binding;
    final static int RESULTADO_EDITAR = 1;
    final static int RESULTADO_GALERIA = 2;
    final static int RESULTADO_FOTO = 3;
    private ImageView foto;
    private ActivityResultLauncher edicionLauncher;
    private int requestCode = 0;
    private Uri uriUltimaFoto;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = VistaLugarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("pos", 0);
        lugares = ((Aplicacion) getApplication()).lugares;
        usoLugar = new CasosUsoLugar(this, lugares);
        lugar = lugares.get_element(pos);
        foto = findViewById(R.id.foto);
        actualizaVistas();
        edicionLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback() {
                    @Override
                    public void onActivityResult(Object result) {
                        if (requestCode == RESULTADO_EDITAR) {
                            if (((ActivityResult) result).getResultCode() == Activity.RESULT_OK) {
                                actualizaVistas();
                            }
                        } else if (requestCode == RESULTADO_GALERIA) {
                            if (((ActivityResult) result).getResultCode() == Activity.RESULT_OK) {
                                usoLugar.ponerFoto(pos, ((ActivityResult) result).getData().getDataString(), foto);
                            } else {
                                Toast.makeText(VistaLugarActivity.this, "Foto no cargada", Toast.LENGTH_LONG).show();
                            }
                        } else if (requestCode == RESULTADO_FOTO) {
                            if (((ActivityResult) result).getResultCode() == Activity.RESULT_OK && uriUltimaFoto != null) {
                                lugar.setFoto(uriUltimaFoto.toString());
                                usoLugar.ponerFoto(pos, lugar.getFoto(), foto);
                            } else {
                                Toast.makeText(VistaLugarActivity.this, "Error en captura", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vista_lugar, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.accion_compartir:
                usoLugar.compartir(lugar);
                return true;
            case R.id.accion_llegar:
                usoLugar.verMapa(lugar);
                return true;
            case R.id.accion_editar:
                usoLugar.editar(pos, edicionLauncher);
                return true;
            case R.id.accion_borrar:
                dialogoEliminar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void dialogoEliminar(){
        new AlertDialog.Builder(this)
                .setTitle("Borrado de lugar")
                .setMessage("¿Estás seguro de que quieres eliminar este lugar?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        usoLugar.borrar(pos);
                    }})
                .setNegativeButton("Cancelar", null)
                .show();
    }


    public void actualizaVistas() {

        lugar = lugares.get_element(pos);
        binding.nombre.setText(lugar.getNombre());
        binding.logoTipo.setImageResource(lugar.getTipo().getRecurso());
        binding.tipo.setText(lugar.getTipo().getTexto());
        if (lugar.getDireccion().isEmpty()) {
            binding.direccion.setVisibility(View.GONE);
        } else {
            binding.direccion.setVisibility(View.VISIBLE);
            binding.direccion.setText(lugar.getDireccion());
        }
        if (lugar.getTelefono() == 0) {
            binding.telefono.setVisibility(View.GONE);
        } else {
            binding.telefono.setVisibility(View.VISIBLE);
            binding.telefono.setText(Integer.toString(lugar.getTelefono()));
        }
        if (lugar.getUrl().isEmpty()) {
            binding.url.setVisibility(View.GONE);
        } else {
            binding.url.setVisibility(View.VISIBLE);
            binding.url.setText(lugar.getUrl());
        }
        if (lugar.getComentario().isEmpty()) {
            binding.comentario.setVisibility(View.GONE);
        } else {
            binding.comentario.setVisibility(View.VISIBLE);
            binding.comentario.setText(lugar.getComentario());
        }
        binding.fecha.setText(DateFormat.getDateInstance().format(
                new Date(lugar.getFecha())));
        binding.hora.setText(DateFormat.getTimeInstance().format(
                new Date(lugar.getFecha())));
        binding.valoracion.setRating(lugar.getValoracion());

        binding.valoracion.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override public void onRatingChanged(RatingBar ratingBar,
                                                          float valor, boolean fromUser) {
                        lugar.setValoracion(valor);
                    }
                });
        usoLugar.visualizarFoto(lugar, foto);
    }

    public void verMapa(View view) {
        usoLugar.verMapa(lugar);
    }

    public void llamarTelefono(View view) {
        usoLugar.llamarTelefono(lugar);
    }

    public void verPgWeb(View view) {
        usoLugar.verPgWeb(lugar);
    }
    public void galeria(View view) {
        requestCode = RESULTADO_GALERIA;
        usoLugar.galeria(RESULTADO_GALERIA);
    }
    public void tomarFoto(View view) {
        requestCode = RESULTADO_FOTO;
        uriUltimaFoto = usoLugar.tomarFoto(RESULTADO_FOTO);
    }

    public void eliminarFoto(View view) {
        usoLugar.ponerFoto(pos, "", foto);
    }

}