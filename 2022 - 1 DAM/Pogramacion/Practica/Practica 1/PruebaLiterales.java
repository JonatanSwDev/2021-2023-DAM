package practica1;

/**
 * PruebaLiterales.java
 * Prueba de identificadores de variables válidos para el lenguaje JAVA
 * análisis de errores.
 */

public class PruebaLiterales {
	

double num1 = -11.1;
double num2 = -88.28;
double num3 =.3e27;
double num4 = 23e2.3;	//Se trata de un número exponencial, por lo que no puede llevar un decimal en el exponente
String pelos ="cañón";
short num5 = 0377;
int num6 = 69999;
byte num7 = 099; 		//Empieza por 0
double num8 = +521.6;
double num9 = 1.26;
double num10 = 5E-002;
short num11 = 0xFE;
int num12 = 0b101010;
double num13 = 1.26f;
String pelos2 = ‘/n’;	//Debería de llevar comillas, no comilla simple
int pelos3 = while;		//No puede usarse While para el valor de una Variable
int num14 = /xFE;		//Carácter inválido "/"
short num15 = 1234;
double num16 = .567;
int num17 = 0xFFFE;
int pelos4 = XGA;		//La variable no puede tener ese valor porque no se puede resolver
String pelos5 = "a";
char pelos6 = 'abc';	//Solo se permite un único caracter
double num18 = 02.45;
char pelos7 = 'a';
int num19 = xF2E;		//La variable no puede tener ese valor porque no se puede resolver
int num20 = 0xf;
int pelos8 = abc;		//La variable no puede tener ese valor porque no se puede resolver
String pelos9 = ab"c;	//La comilla está mal colocada, deberían de ser dos comillas envolviendo el valor
String pelos10 = "abc;	//La comilla está mal colocada, deberían de ser dos comillas envolviendo el valor
String pelos11 = "abc';	//La comilla está mal colocada, deberían de ser dos comillas envolviendo el valor, a demás está usando una comilla simple al fial
char pelos12 = a';		//Le falta una comilla simple
String pelos13 = "abc"";		//Le sobra una comilla
String pelos14 = ""abc"";;		//Le sobran dos comillas
String pelos15 = "true";
boolean resultado1 = True;		//Se escribe todo en minúscula, no puede ser True
boolean resultado2 = false;
char pelos16 = '\\';

	public static void main(String[] args) {	
		System.out.println("Hola mundo...");  //Muestra mensaje 
	}
}
