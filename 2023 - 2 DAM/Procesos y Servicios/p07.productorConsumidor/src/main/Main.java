package main;

import domain.Buffer;
import domain.Consumidor;
import domain.Productor;

public class Main {

	public static void main(String[] args) {
		Buffer miBuffer = new Buffer();
		Productor  p = new Productor(miBuffer);
		Consumidor c1 = new Consumidor(miBuffer,1);
		Consumidor c2 = new Consumidor(miBuffer,2);
		p.start();
		c1.start();
		c2.start();
	}

}
