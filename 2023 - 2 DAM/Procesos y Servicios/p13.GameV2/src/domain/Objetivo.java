package domain;

import topos.vista1.Pantalla;

public class Objetivo {
	
	private static final String KEY_UP = "i";
	private static final String KEY_DOWN = "k";
	private static final String KEY_LEFT = "j";
	private static final String KEY_RIGHT = "l";
	private static final String KEY_FIRE  = " ";
	private static final int OBJ_X = 5;
	private static final int OBJ_Y = 5;
	
	private Pantalla pantalla;
	private int ancho;
	private int alto;
	private String rutaObjetivo;
	private String rutaExplosion;
	private Sincroniza sincro;
	private Posicion posi;
	private boolean disparado;
	
	public Objetivo(Pantalla pantalla, int ancho, int alto, String rutaObjetivo, String rutaExplosion, Sincroniza sincro) {
		this.pantalla = pantalla;
		this.ancho = ancho;
		this.alto = alto;
		this.rutaObjetivo = rutaObjetivo;
		this.rutaExplosion = rutaExplosion;
		this.sincro = sincro;
		this.posi = new Posicion(OBJ_X,OBJ_Y);
		this.disparado = false;
	}
	
	public void procesar() {
		String tecla;
		disparado = false;
				
		if (pantalla.hayTecla()) {
			tecla = pantalla.leerTecla();
			switch (tecla) {
			case KEY_UP:
				posi.incY();
				break;
			case KEY_DOWN:
				posi.decY();
				break;
			case KEY_LEFT:
				posi.decX();
				break;
			case KEY_RIGHT:
				posi.incX();
				break;
			case KEY_FIRE:
				disparado = true;
				break;
			}//end-case	
		}//end-if
		//Agregamos a la pantalla el objetivo
		if (disparado) {
			pantalla.addImagen(posi.getX(), posi.getY(), rutaExplosion);	
		}
		else {
			pantalla.addImagen(posi.getX(), posi.getY(), rutaObjetivo);
		}
	}//end-procesar

	public boolean esDisparado() {
		return disparado;
	}

	public Posicion getPosicion() {
		Posicion retPosi;
		//evitar aliasing
		retPosi = new Posicion(posi);
		return retPosi;
	}
	

}
