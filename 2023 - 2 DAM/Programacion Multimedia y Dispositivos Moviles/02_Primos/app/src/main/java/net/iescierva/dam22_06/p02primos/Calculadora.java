package net.iescierva.dam22_06.p02primos;

import net.iescierva.dam22_06.p02primos.p02Primos;

import java.util.ArrayList;

public class Calculadora {
    public static ArrayList<Integer> algoritmo(int n1, ArrayList<Integer> lista) {
        int num = 0;
        int bucle = 0;
        if (!lista.isEmpty()) {
            num = lista.get(lista.size() - 1);
            bucle = lista.size();
        }
        while (n1 > bucle) {
            int x = 1;
            int contador = 0;
            num++;
            while (x <= num) {
                if ((num % x) == 0) {
                    contador++;
                }
                x++;
            }
            if (contador == 2) {
                lista.add(num);
                n1--;
            }
        }
        return lista;
    }
}
