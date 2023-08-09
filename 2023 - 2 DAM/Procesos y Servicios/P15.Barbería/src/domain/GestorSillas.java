package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestorSillas {
	private final int numeroSillas;
	private boolean [] silla;
	
	private LinkedList<String> siguienteCliente;
	
	Semaphore lock = new Semaphore(1);
	
	public GestorSillas(int numeroSillas) {
		this.numeroSillas = numeroSillas;
		this.silla = new boolean[numeroSillas];
		this.siguienteCliente = new LinkedList<String>();
		
		for (int i=0; i < numeroSillas;i++) {
			silla[i] = false;
		}
	}

	public int getSilla(int id) {
		int sillaAsignada = -1;
		//Sección crítica - entra
		try {
			lock.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i=0; i < numeroSillas;i++) {
			if (!silla[i]) {
				//cocupamos la silla
				silla[i] = true;
				sillaAsignada = i;
				esperarBarbero(i);
				break;
			}
		}
		lock.release();
		//Sección crítica - Sale
		return sillaAsignada;
	}

	private void esperarBarbero(int id) {
		this.siguienteCliente.add(Integer.toString(id));
	}

	public synchronized int getSiguienteCliente() {
		int sig;
		
		//implementar siguienteCliente con una lista
		if (this.siguienteCliente.isEmpty()) {
			return -1;
		}
		else {
			sig =  Integer.parseInt(this.siguienteCliente.getFirst());
			this.siguienteCliente.removeFirst();
			return sig;
		}
	}

	public synchronized void liberar(int sillaLiberar) {
		//Terminar de liberar
		this.silla[sillaLiberar] = false;
	}

	public boolean isEmpty() {
		if (siguienteCliente.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

}
