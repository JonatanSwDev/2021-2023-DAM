package domain;

import java.util.Random;

public class Consumidor extends Thread {
	private Buffer buffer;
	private int id;
	
	public Consumidor(Buffer buffer,int id) {
		this.buffer=buffer;
		this.id = id;
	}
	
	public void run(){
		char valor;
		Random aleatorio = new Random();
		
		for(int i=0; i<10; i++){
			valor=buffer.recoger();
			System.out.println(i+ " Consumidor: "+id+" "+valor);
			try{
				sleep(aleatorio.nextInt(200)+200);
			}catch (InterruptedException e) { }
		}
	}
}
