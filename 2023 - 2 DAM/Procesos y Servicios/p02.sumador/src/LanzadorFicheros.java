

import java.io.File;


public class LanzadorFicheros {
	public void lanzarSumador(Integer n1,
			Integer n2, String fichResultado){
		String clase="Sumador";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(
					"java",clase,
					n1.toString(),
					n2.toString());
			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado));
			pb.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		LanzadorFicheros l = new LanzadorFicheros();
		l.lanzarSumador(1, 500000, "result1.txt");
		l.lanzarSumador(500000,1000000, "result2.txt");
		System.out.println("Ok");
	}
}
