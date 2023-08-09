package domain;

import java.awt.*;
import java.util.LinkedList;

import topos.vista1.Alarma;
import topos.vista1.Pantalla;

public class Partida {

	private static final int ANCHO=11;
	private static final int ALTO=11;
	private static final int LADO=50;
	private static final int REDRAW=150;
	private int disparos;
	private int tiempoJuego;
	
	public Partida(int disparos, int tiempoJuego) {
		this.disparos = disparos;
		this.tiempoJuego = tiempoJuego;
	}

	public void start() {
		boolean finPartida = false;
		//Creamos la pantalla
		Pantalla pantalla = new Pantalla(ANCHO,ALTO,LADO,Color.BLUE);
		
		//Rutas de Sprites
		String rutaFondo = "imagenes/panel-basico.gif";
		String rutaGlobo = "imagenes/globo.png";
		
		//Objeto de sincronización
		Sincroniza sincro = new Sincroniza();
		
		//Definir Sprites
		Sprite globo01 = new Sprite(ANCHO,ALTO,rutaGlobo, sincro);
		Sprite globo02 = new Sprite(ANCHO,ALTO,rutaGlobo, sincro);
		Sprite globo03 = new Sprite(ANCHO,ALTO,rutaGlobo, sincro);
		
		LinkedList<Sprite> listaSprites = new LinkedList<Sprite>();
		listaSprites.add(globo01);
		listaSprites.add(globo02);
		listaSprites.add(globo03);
		
		do {
			pantalla.resetear();
			cargarFondo(pantalla,rutaFondo);
			cargarSprites(pantalla,listaSprites);
			pantalla.dibujar();
			Alarma.dormir(REDRAW);
		}while (!finPartida);
	}

	private void cargarSprites(Pantalla pantalla, LinkedList<Sprite> listaSprites) {
		for (Sprite s : listaSprites) {
			pantalla.addImagen(s.getPosiX(), s.getPosiY(), s.getRutaSprite());
		}
		
	}


	private void cargarFondo(Pantalla pantalla, String rutaFondo) {
		for (int i=0; i< ANCHO;i++) {
			for (int j=0; j < ALTO; j++) {
				pantalla.addImagen(i, j, rutaFondo);
			}
		}
		
	}

}
