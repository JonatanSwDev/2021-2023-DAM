package practica1;

/**
 * PruebaIdentificadores.java
 * Prueba de identificadores válidos para el lenguaje JAVA
 * análisis de errores.
 */
public class PruebaIdentificadores {
	public static void main(String[] args) {
		
		/**
		 * Todas las variables introducidas funcionan porque se trata de declaraciones de variables válidas para el lenguaje
		 * así que solamente voy a comentar el motivo por el que algunas de ellas arrojan un error.
		 */
		 
		
	int _alpha; 
	int maxValor;
	int Nbytes;
	int qué_dices;
	int Cañón;
	int	Return;
	int	Bloque#4;		//Contiene un caracter inválido para la sintaxis: "#"
	int	8ªRoca;			//Contiene un caracter inválido para la sintaxis: "8"
	int	FLOAT;
	int	cuantos;
	int	pink.panter;	//Contiene un caracter inválido para la sintaxis: "."
	int	Número;
	int	café;
	int	While;
	int	c o s a;		//Al utilizar el espacio entre letra y letra genera varios errores, si queremos que sea declarada como una variable no se pueden usar espacios
	int	3d2;			//Contiene carácteres numéricos
	int	1_de_muchos;	// Avisa de que no se pueden juntar los guiones bajos con números
	int	"dado";			//Avisa de un error en la sintaxis, las comillas. "dado" no se puede reconocer como una variable porque las comillas ya tienen un uso dentro del lenguaje
	int	int;			//Avisa de que int no puede declarase como variable, ya que el propio int declara una variable.
	int	cadena 2;		//Contiene un espacio a demás de un caracter inválido para la sintaxis: "2"
	int	Mesa-3;			//Detecta el -3 como un valor negativo y sugiere que se declare Mesa como variable y después se le otorgue el valor
	int	__if;
	int _CaPrIcHoSo_;
	int	Hoja3/5;		////Contiene un caracter inválido para la sintaxis: "/". A demás detecta que 3/5 podría ser un valor para la variable y sugiere declarar el valor en otra línea
	
	
		System.out.println("Hola mundo...");  //Muestra mensaje 
	}
}
