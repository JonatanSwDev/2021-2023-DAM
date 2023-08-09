package net.iescierva.dam22_06.p02primos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import net.iescierva.dam22_06.p02primos.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class p02Primos extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Integer> lista = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void primos(View v) {

        //Inalcanzable porque el length esta limitado a 4 desde el propio Layout, pero si no fuera el caso sería asi
        if (binding.editNumero.length() > 4){
            binding.txtResultado.setText("Maximo 9999");
            binding.editNumero.setText("");
            //Fin de inalcanzable
        } else {
            try {
                int n1 = Integer.parseInt(binding.editNumero.getText().toString());
                if (n1 > lista.size()) {
                    lista = Calculadora.algoritmo(n1, lista);
                    binding.txtResultado.setText("" + lista.get(lista.size() - 1));
                } else {
                    binding.txtResultado.setText("" + lista.get(n1 - 1));
                }
                binding.editNumero.setText("");
            } catch (Exception e) {
                binding.txtResultado.setText("Introduce valores validos");
            }
        }
    }
}