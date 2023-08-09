package net.iescierva.dam22_06.bbddjonatan;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.iescierva.dam22_06.bbddjonatan.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    String[] datos;
    SQLiteDatabase db;
    private ActivityMainBinding binding;
    ArrayList<String> lista = new ArrayList<>();
    List<String> listamostrar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        registerForContextMenu(binding.imgCumple);
        db=openOrCreateDatabase("MisContactos", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS miscontactos(usuario VARCHAR, telefono NUMERIC, fecha_nac DATE);");
        db.execSQL("INSERT INTO miscontactos VALUES ('usuario1',666666666,'1999-12-01');");
        db.execSQL("INSERT INTO miscontactos VALUES ('usuario2',777777777,'1997-04-21');");
        db.execSQL("INSERT INTO miscontactos VALUES ('Angelica',888888888,'1997-11-18');");
        listar();
       binding.listContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           @Override
           public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
               datos = lista.get(i).trim().split(" - ");
               mostrarCampos(i);
               comprobarCumple();
           }
        });
    }

    private void mostrarCampos(int i) {
        listar();
        List<String> listaAux = new ArrayList<>();
        listaAux = listamostrar;
        listaAux.set(i, lista.get(i));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,  android.R.layout.simple_list_item_1, listaAux );
        binding.listContactos.setAdapter(adaptador);
    }

    private void comprobarCumple() {
        Calendar calendarNow = new GregorianCalendar(TimeZone.getTimeZone("Europe/Madrid"));

        String diaActual = String.valueOf(calendarNow.get(Calendar.DAY_OF_MONTH));
        String mesActual = String.valueOf(calendarNow.get(Calendar.MONTH)+1);
        String[] fecha = datos[2].split("-");

        if (mesActual.equals(fecha[1]) && diaActual.equals(fecha[2])){
            Toast.makeText(getApplicationContext(), "Es el cumpleaños de " + datos[0], Toast.LENGTH_SHORT).show();
            felicitar();
        }
    }

    public void listar()
    {
        lista = new ArrayList<String>();
        listamostrar = new ArrayList<String>();
        Cursor c = db.rawQuery("SELECT * FROM miscontactos order by usuario;", null);
        if (c.getCount()!=0) {
            while (c.moveToNext()) {
                lista.add(" " + c.getString(0) + " - " + c.getInt(1) + " - " + c.getString(2));
                listamostrar.add(" " + c.getString(0));
            }
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,  android.R.layout.simple_list_item_1, listamostrar );
        binding.listContactos.setAdapter(adaptador);
        c.close();
    }

    public void nuevo(View v){
        String file = db.getPath();


        Intent intent = new Intent(this, ImportActivity.class);
        intent.putExtra("path", file);
        //Ubicacion de la base de datos: /data/data/com.example.usuarioadministrador.miproyecto/databases/"+DATABASE_NAME;"
        startActivity(intent);
    }

    public void eliminar(View v){
        try {
            db.execSQL("delete from miscontactos where usuario = '" + datos[0] + "' and telefono = " + datos[1] + " and fecha_nac = '" + datos[2] + "';");
            Toast.makeText(getApplicationContext(), datos[0] + "eliminado", Toast.LENGTH_SHORT).show();
            listar();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Selecciona un contacto", Toast.LENGTH_SHORT).show();
        }
    }

    private void felicitar(){
        try {
            binding.imgCumple.buildDrawingCache();
            Bitmap bitmap = binding.imgCumple.getDrawingCache();

            /* COMPARTIR IMAGEN */
            try {
                File file = new File(getCacheDir(), bitmap + ".png");

                FileOutputStream fOut = null;
                fOut = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                fOut.flush();
                fOut.close();

                file.setReadable(true, false);

                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                intent.putExtra(Intent.EXTRA_TEXT, "Felicidades @" + datos[0] + " me debes una cerveza por felicitarte");
                intent.setType("image/png");
                intent.setPackage("com.whatsapp");
                startActivity(intent);

            } catch (Exception e) {
                e.printStackTrace();
            }

            /*Intent sendIntentt = new Intent();
            sendIntentt.setAction(Intent.ACTION_SEND);

            sendIntentt.putExtra(Intent.EXTRA_TEXT, "Felicidades @" + datos[0] + " me debes una cerveza por felicitarte");
            sendIntentt.setType("text/plain");
            sendIntentt.setPackage("com.whatsapp");
            startActivity(sendIntentt);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}