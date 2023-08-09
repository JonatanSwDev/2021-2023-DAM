package domain;

public class Productor extends Thread{
	private Buffer buffer;
	private final String letras="abcdefghijklmnopqrstuvxyz";
	
	public Productor(Buffer buffer) {
		this.buffer=buffer;
	}
	
	public void run() {
		for(int i=0; i<20; i++){
			char c=letras.charAt((int)(Math.random()*letras.length()));
			buffer.poner(c);
			System.out.println(i+" Productor: " +c);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
		}
	}	
}
