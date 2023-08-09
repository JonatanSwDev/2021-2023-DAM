package Practica4;
/*
Ejercicio23.java
Fecha: 22/12/2021
Autor: Jonatan Gomez Garcia

*/
import java.util.Scanner;
public class Ejercicio23 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce el texto deseado: ");
        String textodeseado = teclado.nextLine();

        for (int i = 0; i < 7; i++) {
			for (int j = 0; j < textodeseado.length(); j++){
				if (textodeseado.charAt(j) != ' ') {
					System.out.print(bannerTexto(Character.toUpperCase(textodeseado.charAt(j)),i ) + "   ");
				}	
		    }
			System.out.println();
        }   
	   
    }
   

	static String bannerTexto(char letra, int linea) {
        return letras [letra -'A'][linea];
	}

    public static String[][] letras = {
		
		{"   A   ",
		" A   A ",
		"A     A",
		"A     A",
		"AAAAAAA",
		"A     A",
		"A     A"},
		
		{"BBBBBB ",
		"B     B",
		"B     B",
		"BBBBBBB",
		"B     B",
		"B     B",
		"BBBBBB "},
		
		{"  CCCCC",
		" C     ",
		"C      ",
		"C      ",
		"C      ",
		" C     ",
		"  CCCCC"},
		
		{"DDDDD  ",
		"D     D",
		"D     D",
		"D     D",
		"D     D",
		"D     D",
		"DDDDD  "},
		
		{"EEEEEEE",
		"E      ",
		"E      ",
		"EEEEEEE",
		"E      ",
		"E      ",
		"EEEEEEE"},
		
		{"FFFFFFF",
		"FF     ",
		"FF     ",
		"FFFFF  ",
		"F      ",
		"F      ",
		"F      "},
		
		{"  GGGGG",
		"GG     ",
		"G      ",
		"G   GG ",
		"G    GG",
		"G     G",
		"GGGGGG "},
		
		{"H     H",
		"H     H",
		"H     H",
		"HHHHHHH",
		"H     H",
		"H     H",
		"H     H"},
		
		{"IIIIIII",
		"   I   ",
		"   I   ",
		"   I   ",
		"   I   ",
		"   I   ",
		"IIIIIII"},
		
		{"   JJJJ",
		"      J",
		"      J",
		"J     J"+
		"J     J",
		"J     J",
		" JJJJ  "},
		 
		{"K     K",
		"K    K ",
		"K   K  ",
		"KKKKK  ",
		"K   K  ",
		"K    K ",
		"K     K"},
		
		{"L      ",
		"L      ",
		"L      ",
		"L      ",
		"L      ",
		"L      ",
		"LLLLLLL"},
		
		{"M     M",
		"MM   MM",
		"M M M M",
		"M  M  M",
		"M     M",
		"M     M",
		"M     M"},
		
		{"N     N",
		"NN    N",
		"N N   N",
		"N  N  N",
		"N   N N",
		"N    NN",
		"N     N"},
		
		{"  OOO  ",
		"OO   OO",
		"O     O",
		"O     O",
		"O     O",
		"OO   OO",
		"  OOO  "},
		
		{"PPPPPP ",
		"P     P",
		"P     P",
		"PPPPPP ",
		"P      ",
		"PP     ",
		"PP     ",},
		
		{" QQQQQ ",
		"Q     Q",
		"Q     Q",
		"Q     Q",
		"Q     Q",
		" QQQQQ ",
		"      Q"},
		
		{"RRRRRR ",
		"R     R",
		"R     R",
		"RRRRRR ",
		"R   R  ",
		"R    R ",
		"R     R"},
		
		{" SSSSSS",
		"SS     ",
		"SS     ",
		"  SSSS ",
		"     SS",
		"     SS",
		"SSSSS  "},
		
		{"TTTTTTT",
		"   T   ",
		"   T   ",
		"   T   ",
		"   T   ",
		"   T   ",
		"   T   "},
		
		{"U     U",
		"U     U",
		"U     U",
		"U     U",
		"U     U",
		"U     U",
		" UUUUU "},
		
		{"V     V",
		"V     V",
		"V     V",
		"V     V",
		" V   V ",
		"  V V  ",
		"   V   "},
		
		{"W     W",
		"W     W",
		"W     W",
		"W     W",
		"W  W  W",
		"W W W W",
		" W   W "},
		
		{"X     X",
		" X   X ",
		"  X X  ",
		"   X   ",
		"  X X  ",
		" X   X ",
		"X     X"},
		
		{"Y     Y",
		"Y     Y",
		" Y   Y ",
		"  Y Y  ",
		"   Y   ",
		"   Y   ",
		"   Y   "},
		
		{"ZZZZZZZ",
		"      Z",
		"    Z  ",
		"   Z   ",
		" Z     ",
		"Z      ",
		"ZZZZZZZ"}};
    }
   
