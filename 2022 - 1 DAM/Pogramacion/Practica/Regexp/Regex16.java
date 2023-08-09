import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex16 {
	static public void main(String[] args) {
		String texto = "abcd ggg"; // Texto
		String regex = "abc.*"; // Comprueba si contiene el patron “abc”,
								// opcionalmente seguido de ninguno o varios caracteres

		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);

		System.out.println("\nConcordancias: ");
		while (concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (TEXTO: " + concordancias.group() + ")");
		}
	}
}