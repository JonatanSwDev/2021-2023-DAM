package domain;

public class Cifrador extends Thread{
	private int id;
	private Resource sincroniza;
	private char c;
	private char cc;
	private char[] alfabetoClaro;
	private char[] alfabetoCode;
	private char[] mensaje02;
	
	public Cifrador(int id, Resource sincroniza, char c, char[] alfabetoClaro, char[] alfabetoCode, char[] mensaje02) {
		this.id = id;
		this.sincroniza = sincroniza;
		this.c = c;
		this.alfabetoClaro = alfabetoClaro;
		this.alfabetoCode = alfabetoCode;
		this.mensaje02 = mensaje02;
		this.start();

	}

	public void run() {
		int posi;
		//esperamos para que todos los hilos se inicien
		//a la vez
		sincroniza.inicioConcurrente();
		cc = ' ';
		posi = 0;
		for (int i=0;i < alfabetoClaro.length;i++) {
			if (alfabetoClaro[i]==c) {
				cc = alfabetoCode[i];
				posi = i;
				break;
			}
		}
		sincroniza.getAcceso();
		mensaje02[id] = cc;
		sincroniza.releaseAcceso();
		sincroniza.notificaFinHilo();
	}
}
