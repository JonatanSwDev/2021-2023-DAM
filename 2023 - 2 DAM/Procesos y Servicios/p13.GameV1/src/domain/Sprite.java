package domain;

import java.util.Random;
import java.util.concurrent.Semaphore;

import topos.vista1.Alarma;

public class Sprite extends Thread{

	private final int ancho;
	private final int alto;
	private final String rutaSprite;
	private Sincroniza sincro;
	private Posicion posi;
	private int mover;
	private int maxMovimiento;
	private Semaphore lock = new Semaphore(1);
	
	public Sprite(int ancho, int alto, String rutaSprite, Sincroniza sincro) {
		Random aleatorio = new Random();
		this.alto = alto;
		this.ancho = ancho;
		this.sincro = sincro;
		this.rutaSprite = rutaSprite;
		int x = aleatorio.nextInt(ancho);
		int y = aleatorio.nextInt(alto);
		this.posi = new Posicion(x,y);
		mover = aleatorio.nextInt(4);
		this.maxMovimiento = 11;
		this.start();
	}

	public void run() {
		Random aleatorio = new Random();
		int contar = 0;
		while(true) {
			try {
				
				if (contar > maxMovimiento) {
					mover = aleatorio.nextInt(4);
					contar = 0;
				}
				lock.acquire();
				if (mover == 0) {
					posi.incX();
					if (posi.getX() == this.ancho) {
						posi.setX(0);
					}
				}
				else if (mover == 1) {
					posi.decX();
					if (posi.getX() < 0) {
						posi.setX(this.ancho-1);
					}
				}
				else if (mover == 2){
					posi.incY();
					if (posi.getY() == this.alto) {
						posi.setY(0);
					}
				}
				else if (mover == 3){
					posi.decY();
					if (posi.getY() < 0) {
						posi.setY(this.alto-1);
					}
				}
				lock.release();
				Alarma.dormir(200);
				contar++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end-while
	}

	public int getPosiX() {
		int p = 0;
		try {
			lock.acquire();
			p = posi.getX();
			lock.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return p;
	}

	public int getPosiY() {
		int p = 0;
		try {
			lock.acquire();
			p = posi.getY();
			lock.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return p;
	}

	public String getRutaSprite() {
		return this.rutaSprite;
	}

}
