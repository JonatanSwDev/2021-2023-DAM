package net.iescierva.dam22_06.bbddjonatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import net.iescierva.dam22_06.bbddjonatan.databinding.ImportActibityBinding;

public class ImportActivity extends AppCompatActivity {
    SQLiteDatabase db;
    private ImportActibityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ImportActibityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db=SQLiteDatabase.openDatabase(getIntent().getStringExtra("path"), null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void insert(View v){
        if (binding.editUsuario.getText().length() > 0 && binding.editFecha.getText().toString().matches("([0-9]{4})-([0-9]{1,2})-([0-9]{0,2})")){
            db.execSQL("INSERT INTO miscontactos VALUES ('" + binding.editUsuario.getText() +
                    "'," + binding.editNumero.getText() +
                    ",'" + binding.editFecha.getText() + "');");
        }
        exit();
    }

    public void volver(View v){
        exit();
    }

    private void exit(){
        Intent intent = new Intent(this, MainActivity.class);
        db.close();
        startActivity(intent);
    }
}