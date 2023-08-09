package domain;

public class Buffer {
	private char contenido;
	private boolean disponible=false;
	
	public Buffer() {
	}
	
	public synchronized char recoger(){
		while(!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//end-while
		disponible=false;
		notifyAll();
		return (contenido);
	}
	public synchronized void poner(char c){
		while(disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//end-while
		contenido=c;
		disponible=true;
		notifyAll();
	}
}
