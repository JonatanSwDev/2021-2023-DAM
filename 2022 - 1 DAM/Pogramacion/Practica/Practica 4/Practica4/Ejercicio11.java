package Practica4;
/*
Ejercicio11.java
Fecha: 22/12/2021
Autor: Jonatan Gomez Garcia
Programa que recibe un texto y lo manda a un método que determina cada letra dentro del texto. Cada letra
es mandada a otro método que devuelve una cadena de texto con el banner 7x7 de la letra con el fin de crear
una cadena de texto en forma de Banner que mostrar en pantalla. 
*/
import java.util.Scanner;
public class Ejercicio11 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce el texto deseado: ");
        String textodeseado = teclado.nextLine().trim().toUpperCase();

        System.out.print(letrasChar(textodeseado));
    }

    
    
    static String letrasChar(String textodeseado){
        String textoDevuelto = "";
        char letra = ' ';
        for (int i = 0; i < textodeseado.length(); i++) {
			if (textodeseado.charAt(i) != ' ' || textodeseado.charAt(i) != ',' || textodeseado.charAt(i) != '\t' || textodeseado.charAt(i) != '\n') {
				letra = textodeseado.charAt(i);
		    }
            textoDevuelto += bannerLetra(letra);
        }
        return textoDevuelto;
    }

    static String bannerLetra(char letra) {
        final String[] letras = {
		
			"   A   \n"+
			" A   A \n"+
			"A     A\n"+
			"A     A\n"+
			"AAAAAAA\n"+
			"A     A\n"+
			"A     A\n",
			
			"BBBBBB \n"+
			"B     B\n"+
			"B     B\n"+
			"BBBBBBB\n"+
			"B     B\n"+
			"B     B\n"+
			"BBBBBB \n",
			
			"  CCCCC\n"+
			" C     \n"+
			"C      \n"+
			"C      \n"+
			"C      \n"+
			" C     \n"+
			"  CCCCC\n",
			
			"DDDDD  \n"+
			"D     D\n"+
			"D     D\n"+
			"D     D\n"+
			"D     D\n"+
			"D     D\n"+
			"DDDDD  \n",
			
			"EEEEEEE\n"+
			"E      \n"+
			"E      \n"+
			"EEEEEEE\n"+
			"E      \n"+
			"E      \n"+
			"EEEEEEE\n",
			
			"FFFFFFF\n"+
			"FF     \n"+
			"FF     \n"+
			"FFFFF  \n"+
			"F      \n"+
			"F      \n"+
			"F      \n",
			
			"  GGGGG\n"+
			"GG     \n"+
			"G      \n"+
			"G   GG \n"+
			"G    GG\n"+
			"G     G\n"+
			"GGGGGG \n",
			
			"H     H\n"+
			"H     H\n"+
			"H     H\n"+
			"HHHHHHH\n"+
			"H     H\n"+
			"H     H\n"+
			"H     H\n",
			
			"IIIIIII\n"+
			"   I   \n"+
			"   I   \n"+
			"   I   \n"+
			"   I   \n"+
			"   I   \n"+
			"IIIIIII\n",
			
			"   JJJJ\n"+
			"      J\n"+
			"      J\n"+
			"J     J\n"+
			"J     J\n"+
			"J     J\n"+
			" JJJJ  \n",
			 
			"K     K\n"+
			"K    K \n"+
			"K   K  \n"+
			"KKKKK  \n"+
			"K   K  \n"+
			"K    K \n"+
			"K     K\n",
			
			"L      \n"+
			"L      \n"+
			"L      \n"+
			"L      \n"+
			"L      \n"+
			"L      \n"+
			"LLLLLLL\n",
			
			"M     M\n"+
			"MM   MM\n"+
			"M M M M\n"+
			"M  M  M\n"+
			"M     M\n"+
			"M     M\n"+
			"M     M\n",
			
			"N     N\n"+
			"NN    N\n"+
			"N N   N\n"+
			"N  N  N\n"+
			"N   N N\n"+
			"N    NN\n"+
			"N     N\n",
			
			"  OOO  \n"+
			"OO   OO\n"+
			"O     O\n"+
			"O     O\n"+
			"O     O\n"+
			"OO   OO\n"+
			"  OOO  \n",
			
			"PPPPPP \n"+
			"P     P\n"+
			"P     P\n"+
			"PPPPPP \n"+
			"P      \n"+
			"PP     \n"+
			"PP     \n",
			
			" QQQQQ \n"+
			"Q     Q\n"+
			"Q     Q\n"+
			"Q     Q\n"+
			"Q     Q\n"+
			" QQQQQ \n"+
			"      Q\n",
			
			"RRRRRR \n"+
			"R     R\n"+
			"R     R\n"+
			"RRRRRR \n"+
			"R   R  \n"+
			"R    R \n"+
			"R     R\n",
			
			" SSSSSS\n"+
			"SS     \n"+
			"SS     \n"+
			"  SSSS \n"+
			"     SS\n"+
			"     SS\n"+
			"SSSSS  \n",
			
			"TTTTTTT\n"+
			"   T   \n"+
			"   T   \n"+
			"   T   \n"+
			"   T   \n"+
			"   T   \n"+
			"   T   \n",
			
			"U     U\n"+
			"U     U\n"+
			"U     U\n"+
			"U     U\n"+
			"U     U\n"+
			"U     U\n"+
			" UUUUU \n",
			
			"V     V\n"+
			"V     V\n"+
			"V     V\n"+
			"V     V\n"+
			" V   V \n"+
			"  V V  \n"+
			"   V   \n",
			
			"W     W\n"+
			"W     W\n"+
			"W     W\n"+
			"W     W\n"+
			"W  W  W\n"+
			"W W W W\n"+
			" W   W \n",
			
			"X     X\n"+
			" X   X \n"+
			"  X X  \n"+
			"   X   \n"+
			"  X X  \n"+
			" X   X \n"+
			"X     X\n",
			
			"Y     Y\n"+
			"Y     Y\n"+
			" Y   Y \n"+
			"  Y Y  \n"+
			"   Y   \n"+
			"   Y   \n"+
			"   Y   \n",
			
			"ZZZZZZZ\n"+
			"      Z\n"+
			"    Z  \n"+
			"   Z   \n"+
			" Z     \n"+
			"Z      \n"+
			"ZZZZZZZ\n"};

        return letras[letra - 'A'];
        }
    }
   

