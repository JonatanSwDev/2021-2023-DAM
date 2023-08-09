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
	private static final int TIEMPO=30;
	private int disparos;
	private int tiempoJuego;
	private long tiempoInicial;
	private long tiempoPartida;
	private long tiempoRestante;
	
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
		String rutaGloboTocado = "imagenes/globo-rojo.png";
		String rutaObjetivo = "imagenes/objetivo.png";
		String rutaExplosion = "imagenes/explosion.png";
		
		//Objeto de sincronización
		Sincroniza sincro = new Sincroniza();
		
		//Definir objetivo
		Objetivo objetivo = new Objetivo(pantalla, ANCHO,ALTO,rutaObjetivo,rutaExplosion, sincro);
				
		//Definir Sprites
		Sprite globo01 = new Sprite(ANCHO,ALTO,rutaGlobo, rutaGloboTocado, sincro, objetivo);
		Sprite globo02 = new Sprite(ANCHO,ALTO,rutaGlobo, rutaGloboTocado, sincro, objetivo);
		Sprite globo03 = new Sprite(ANCHO,ALTO,rutaGlobo, rutaGloboTocado, sincro, objetivo);
		
		LinkedList<Sprite> listaSprites = new LinkedList<Sprite>();
		listaSprites.add(globo01);
		listaSprites.add(globo02);
		listaSprites.add(globo03);
		
		//Control de tiempo
		tiempoInicial = System.currentTimeMillis();
		tiempoPartida = tiempoInicial + (TIEMPO * 1000);
		tiempoRestante = (tiempoPartida-tiempoInicial)/1000;
		pantalla.setBarraEstado("Tiempo restante :"+tiempoRestante);
		
		//Bucle main del juego
		do {
			pantalla.resetear();
			cargarFondo(pantalla,rutaFondo);
			cargarSprites(pantalla,listaSprites);
			objetivo.procesar();
			pantalla.dibujar();
			tiempoRestante = (tiempoPartida-System.currentTimeMillis())/1000;
			pantalla.setBarraEstado("Tiempo restante :"+tiempoRestante);
			Alarma.dormir(REDRAW);
			if (tiempoRestante <= 0) {
				finPartida=true;
			}
		}while (!finPartida);
		
		//notificar a los sprites el fin
		for (Sprite s : listaSprites) {
			s.finalizar();
		}
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
