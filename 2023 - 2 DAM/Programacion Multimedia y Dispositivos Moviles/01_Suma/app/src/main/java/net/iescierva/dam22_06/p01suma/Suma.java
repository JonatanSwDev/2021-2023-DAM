package net.iescierva.dam22_06.p01suma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.iescierva.dam22_06.p01suma.databinding.ActivityMainBinding;

public class Suma extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void calculadora(View v){
        try{
            double n1, n2, resultado;
            n1 = Double.parseDouble(binding.editNumero1.getText().toString());
            n2 = Double.parseDouble(binding.editNumero2.getText().toString());
            resultado = n1 + n2;
            binding.txtResultado.setText("" + resultado);
            binding.editNumero1.setText("");
            binding.editNumero2.setText("");
        } catch (Exception e) {
            binding.txtResultado.setText("Introduce valores");
        }

    }
}