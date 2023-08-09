package main;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import javax.naming.InitialContext;

import domain.Filosofo;

public class Main {
	final static int MAX_FILOSOFOS = 5;
	
	public static void main(String[] args) {
		Filosofo [] filosofo = new Filosofo[MAX_FILOSOFOS];
		int [][] palillos = { {0,4},{0,1},{1,2},{2,3},{4,3}};
		Semaphore [] palilloEspera = new Semaphore[MAX_FILOSOFOS];
		CyclicBarrier inicioConcurrente = new CyclicBarrier(MAX_FILOSOFOS); 
		
		//array semáforos
		for (int i=0; i < MAX_FILOSOFOS;i++) {
			palilloEspera[i] = new Semaphore(1);
		}
		
		//array filosofos
		for (int i=0; i < MAX_FILOSOFOS;i++) {
			filosofo[i] = new Filosofo(i,palilloEspera[palillos[i][0]],
					      palilloEspera[palillos[i][1]],
					      inicioConcurrente);
		}
		
	}

}
