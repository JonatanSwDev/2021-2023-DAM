package net.iescierva.dam22_06.p04calculadoramd;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import net.iescierva.dam22_06.p04calculadoramd.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
//Rhino
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean decimal = false;
    private String operacion = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        binding.fab.setOnClickListener(view -> Snackbar.make(view, "Logica al boton jajajajaja", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void but0 (View v){
        operacion += "0";
        binding.txtResultado.setText(operacion);
    }
    public void but1 (View v){
        operacion += "1";
        binding.txtResultado.setText(operacion);
    }
    public void but2 (View v){
        operacion += "2";
        binding.txtResultado.setText(operacion);
    }
    public void but3 (View v){
        operacion += "3";
        binding.txtResultado.setText(operacion);
    }
    public void but4 (View v){
        operacion += "4";
        binding.txtResultado.setText(operacion);
    }
    public void but5 (View v){
        operacion += "5";
        binding.txtResultado.setText(operacion);
    }
    public void but6 (View v){
        operacion += "6";
        binding.txtResultado.setText(operacion);
    }
    public void but7 (View v){
        operacion += "7";
        binding.txtResultado.setText(operacion);
    }
    public void but8 (View v){
        operacion += "8";
        binding.txtResultado.setText(operacion);
    }
    public void but9 (View v){
        operacion += "9";
        binding.txtResultado.setText(operacion);
    }
    public void butE (View v){
        operacion += "e";
        binding.txtResultado.setText(operacion);
        decimal = true;
    }
    public void butPunto (View v){
        if (!decimal) {
            operacion += ".";
            binding.txtResultado.setText(operacion);
            decimal = true;
        }
    }
    public void butSuma (View v){
        decimal = false;
        operacion += "+";
        binding.txtResultado.setText(operacion);
    }
    public void butResta (View v){
        decimal = false;
        operacion += "-";
        binding.txtResultado.setText(operacion);
    }
    public void butMultiplicar (View v){
        decimal = false;
        String op = operacion + "x";
        binding.txtResultado.setText(op);
        operacion += "*";
    }
    public void butDividir (View v){
        decimal = false;
        operacion += "/";
        binding.txtResultado.setText(operacion);
    }
    public void butPorcentaje (View v){
        decimal = false;
        String op = operacion + "%";
        binding.txtResultado.setText(op);
        operacion += "p";
    }
    public void butC (View v){
        decimal = false;
            binding.txtResultado.setText(binding.txtResultado.getText().toString().substring(0,
                    binding.txtResultado.getText().toString().length() - 1));
            operacion = operacion.substring(0, operacion.length() -1);
    }
    public void butAC (View v){
        decimal = false;
        binding.txtResultado.setText("");
        operacion = "";
        binding.textView3.setText("");
    }
    public void butIgual (View v){
        try {
            String operacionfinal;
            if (operacion.endsWith("p")){
                operacionfinal = operacion.substring(0, operacion.length()-1);
            } else{
                operacionfinal = operacion;
            }

            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String resultado1 = context.evaluateString(scriptable, operacionfinal, "Javascript", 1, null).toString();

            if (operacion.endsWith("p")){
                resultado1 = porcentaje(resultado1);
            }
            String resultadofinal = binding.txtResultado.getText().toString() + "\n=\n" + resultado1;
            binding.textView3.setText(resultadofinal);
            //Comentar las dos siguientes lineas para que no se limpie la memoria de la calculadora
            binding.txtResultado.setText("");
            operacion = "";
            decimal = false;

        }catch (Exception e) {
            binding.textView3.setText("Err");
            decimal = false;
        }
    }
    private String porcentaje(String numero){
        try {
            double n1 = Double.parseDouble(numero);
            return String.valueOf(n1/100);
        } catch (Exception e) {
            return null;
        }
    }
}