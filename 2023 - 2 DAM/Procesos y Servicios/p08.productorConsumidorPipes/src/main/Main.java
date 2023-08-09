package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;

import domain.Consumidor;
import domain.Productor;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		PipedWriter emisor   = new PipedWriter();
		PipedReader receptor = new PipedReader(emisor);
		PrintWriter flujoS = new PrintWriter(emisor);
		BufferedReader flujoE = new BufferedReader(receptor);
		
		Productor p1 = new Productor(flujoS);
		Consumidor c1 = new Consumidor(flujoE);
		
		c1.start();
		p1.start();
		
		p1.join();
		c1.join();
		
	}

}
