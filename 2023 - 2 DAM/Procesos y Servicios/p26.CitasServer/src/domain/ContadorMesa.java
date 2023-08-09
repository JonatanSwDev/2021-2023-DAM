package domain;

import java.util.concurrent.Semaphore;

public class ContadorMesa {
	private int maxMesas;
	//turno del alumno que estamos sirviendo
	private int contadorAlumno;
	//peticiones para ser atendido
	private int peticionAlumno;
	private int [] asignaMesas;
	private Semaphore lock = new Semaphore(1);
	
	public ContadorMesa(int maxMesas) {
		//Sumamos 1 porque no existe la mesa 0
		this.maxMesas = maxMesas+1;
		this.contadorAlumno = 0;
		this.peticionAlumno = 0;
		
		this.asignaMesas = new int[this.maxMesas];
		for (int i=0; i < this.maxMesas;i++) {
			asignaMesas[i] = 0;
		}
	}

	public boolean asignaMesa(int nmesa, int nterminal) {
		if (asignaMesas[nmesa] == 0) {
			asignaMesas[nmesa] = nterminal;
			return true;
		}
		else {
			return false;
		}
			
	}

	public int getNumeroEspera() {
		int next = 0;
		try {
			//concurrence control
			lock.acquire();
			this.peticionAlumno++;
			next = this.peticionAlumno;
			lock.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return next;
	}

	public int getSiguienteNumero() {
		int nextAlumno = 0;
		try {
			lock.acquire();
			this.contadorAlumno++;
			nextAlumno = this.contadorAlumno;
			lock.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nextAlumno;
	}

}
