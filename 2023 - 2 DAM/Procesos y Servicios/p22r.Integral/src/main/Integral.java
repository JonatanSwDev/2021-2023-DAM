package main;
//https://www.wolframalpha.com/input?i=area+under+curve+x%5E2+from+1+to+5&lang=es
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import domain.Intervalo;
import domain.Sincro;
public class Integral {
	final static int MAX_INTERVALOS = 8000;
	static Intervalo [] intervalo = new Intervalo[MAX_INTERVALOS];
	
	//Creamos los pipes
	static PipedWriter [] emisor    = new PipedWriter[MAX_INTERVALOS];
	static PipedReader [] receptor  = new PipedReader[MAX_INTERVALOS];
	static PrintWriter [] flujoS    = new PrintWriter[MAX_INTERVALOS];
	static BufferedReader [] flujoE = new BufferedReader[MAX_INTERVALOS];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Sincro sincro = new Sincro(MAX_INTERVALOS);
		float resultado = 0;
		float pInicial = 0;
		float pFinal = 0;
		float anchoIntervalo = 0;
		float x_i, x_j;
		
		try {
			//Enlazamos pipes
			for (int i = 0;i < MAX_INTERVALOS;i++) {
				emisor[i] = new PipedWriter();
				receptor[i] = new PipedReader(emisor[i]);
				flujoS[i] = new PrintWriter(emisor[i]);
				flujoE[i] = new BufferedReader(receptor[i]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean correcto = false;
		while (!correcto) {
			System.out.println("Introduce el punto inicial>");
			pInicial = sc.nextFloat();
			sc.nextLine();
			System.out.println("Introduce el punto final  >");
			pFinal = sc.nextFloat();
			sc.nextLine();
			if (pFinal > pInicial) {
				correcto = true;
			}
		}
		//Iniciamos los hilos
		System.out.println("Inicial "+pInicial);
		System.out.println("Final   "+pFinal);
		anchoIntervalo = (pFinal - pInicial)/MAX_INTERVALOS;
		x_j = pInicial;
		for (int i=0;i< MAX_INTERVALOS;i++) {
			x_i = x_j;
			x_j = x_i + anchoIntervalo;
			intervalo[i] = new Intervalo(i,x_i,x_j,flujoS[i],sincro);
		}
		System.out.println("Hilos lanzandos...");
		sincro.esperaFinPadreEspera();
		
		//Determinar la suma de las áreas
		for (int i=0;i< MAX_INTERVALOS;i++) {
			try {
				resultado = resultado + Float.parseFloat(flujoE[i].readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("El área es "+resultado);
	}

}
