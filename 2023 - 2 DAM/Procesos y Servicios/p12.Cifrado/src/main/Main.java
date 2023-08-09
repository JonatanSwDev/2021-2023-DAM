package main;

import java.util.concurrent.Semaphore;

import domain.Cifrador;
import domain.Resource;

public class Main {
	
	public static void main(String[] args) {
	    
		
		char [] mensaje01 = {'H','o','l','a','M','u','n','d','o'};
		char [] mensaje02 = new char[mensaje01.length];
		char [] alfabetoClaro = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
		char [] alfabetoCode  = {'e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z','a', 'b', 'c', 'd'};
		//limitamos a 3 hilos el acceso concurrente
		//a mensaje03
		Resource sincroniza = new Resource(3,mensaje01.length);
		System.out.println("Claro "+alfabetoClaro.length);
		System.out.println("Code  "+alfabetoCode.length);
		
		Cifrador [] cifrador = new Cifrador[mensaje01.length];
		for (int i=0; i<mensaje01.length;i++) {
			//sync todos los hilos se inician a la vez
			//CyclicBarrier
			cifrador[i] = new Cifrador(i,sincroniza,mensaje01[i],
					alfabetoClaro,alfabetoCode,mensaje02);
		}
		//syn esperamos que todos los hilos hayan terminado
		//CountDownLatch
		//para imprimir en mensaje cifrado
		sincroniza.esperaFinHilos();
		System.out.println("Cifrado "+String.valueOf(mensaje02));
	}

}
