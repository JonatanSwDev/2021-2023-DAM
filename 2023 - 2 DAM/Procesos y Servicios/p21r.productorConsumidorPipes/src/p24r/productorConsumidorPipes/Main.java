package p24r.productorConsumidorPipes;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		//Creo pipe y enlazo
		PipedWriter emisor1 = new PipedWriter();
		PipedReader receptor1 = new PipedReader(emisor1);
		
		Productor productor = new Productor(emisor1);
		Consumidor consumidor1 = new Consumidor(1,receptor1);
		Consumidor consumidor2 = new Consumidor(2,receptor1);
	}

}
