package net.iescierva.dam22_06.p03calculadorabasica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;
import net.iescierva.dam22_06.p03calculadorabasica.databinding.ActivityMainBinding;

public class p03CalculadoraBasica extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean decimal = false;
    String operacion = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void but0 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "0");
        operacion += "0";
    }
    public void but1 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "1");
        operacion += "1";
    }
    public void but2 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "2");
        operacion += "2";
    }
    public void but3 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "3");
        operacion += "3";
    }
    public void but4 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "4");
        operacion += "4";
    }
    public void but5 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "5");
        operacion += "5";
    }
    public void but6 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "6");
        operacion += "6";
    }
    public void but7 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "7");
        operacion += "7";
    }
    public void but8 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "8");
        operacion += "8";
    }
    public void but9 (View v){
        binding.txtResultado.setText(binding.txtResultado.getText().toString() + "9");
        operacion += "9";
    }
    public void butE (View v){
        binding.txtResultado.setText(binding.txtResultado.getText() + "e");
        operacion += "^";
    }
    public void butPunto (View v){
        if (!decimal) {
            binding.txtResultado.setText(binding.txtResultado.getText() + ".");
            operacion += ".";
            decimal = true;
        }
    }
    public void butSuma (View v){
        decimal = false;
        binding.txtResultado.setText(binding.txtResultado.getText() + "+");
        operacion += "<+<";
    }
    public void butResta (View v){
        decimal = false;
        binding.txtResultado.setText(binding.txtResultado.getText() + "-");
        operacion += "<-<";
    }
    public void butMultiplicar (View v){
        decimal = false;
        binding.txtResultado.setText(binding.txtResultado.getText() + "x");
        operacion += "<*<";
    }
    public void butDividir (View v){
        decimal = false;
        binding.txtResultado.setText(binding.txtResultado.getText() + "/");
        operacion += "</<";
    }
    public void butResto (View v){
        decimal = false;
        binding.txtResultado.setText(binding.txtResultado.getText() + "%");
        operacion += "<%<";
    }
    public void butC (View v){
        decimal = false;
        try{
            binding.txtResultado.setText(binding.txtResultado.getText().toString().toString().substring(0,
                    binding.txtResultado.getText().toString().toString().length() - 1));
            if(operacion.endsWith("<")){
                operacion = operacion.substring(0, operacion.length() -3);
            } else{
                operacion = operacion.substring(0, operacion.length() -1);
            }
        } catch (Exception e){}
    }
    public void butAC (View v){
        decimal = false;
        binding.txtResultado.setText("");
        operacion = "";
    }
    public void butIgual (View v){
        try {
            String operacionfinal = "";
            String[] vector = operacion.split("<");
            if (vector.length != 0){
                for (int i = 0; i < vector.length; i++) {
                    if (vector[i].contains("^")) {
                        vector[i] = potencia(vector[i]);
                    }
                    operacionfinal += vector[i];
                }
            }
            else {
                operacionfinal = operacion;
            }
                Context context = Context.enter();
                context.setOptimizationLevel(-1);
                Scriptable scriptable = context.initStandardObjects();
                String resultado1 = context.evaluateString(scriptable, operacionfinal, "Javascript", 1, null).toString();
                binding.textView3.setText(binding.txtResultado.getText().toString() + "\n=\n" + resultado1);
                //Comentar las dos siguientes lineas para que no se limpie la memoria de la calculadora
                binding.txtResultado.setText("");
                operacion = "";
                decimal = false;

        }catch (Exception e) {
            binding.textView3.setText("Err");
            decimal = false;
        }
    }
    private String potencia(String numero){
        try {
            int posicion = numero.indexOf('^');
            double n1 = Double.parseDouble(numero.substring(0, posicion));
            double n2 = Double.parseDouble(numero.substring(posicion + 1, numero.length()));
            return String.valueOf(Math.pow(n1, n2));
        } catch (Exception e) {
            return null;
        }
    }
}