package Classes;
/**
 * Utils.java
 * Clase que contiene metodos de utilidad encargados de validar datos o realizar conversiones
 * version 1.1.0 >> 09/04/2022
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utils{
	public static boolean validateUserName(String userName) {
		return userName.matches("(^[a-zA-Z]{1}[a-zA-Z0-9]{3,99})");
	}
	
	public static boolean validatePassword(String passWD) {
		return passWD.matches("(?=.*[A-ZÑ])(?=.*[a-zñ])(?=.*\\d)(?=.*\\.).{8,}");
	}
	
	public static boolean validateNif(String nif) {
		return nif.matches("(^[0-9]{8}[A-Z]{1})");
	}
	
	public static boolean validateName(String name) {
		return name.matches("(^[A-Z]{1})([a-z ]{2,299})");
	}
	
	public static boolean validateEmail(String email) {
		return email.matches("^[\\w-\\+]+(\\.[\\w-\\+]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	public static boolean validateDate(String date) {
		date = formatDateSQL(date);
		if (date == null) {
			return false;
		} else {
			String[] vectorDate = date.split("-");
			if (vectorDate.length != 3) {
	            return false;
	        }

	        int dd = Integer.parseInt(vectorDate[2]);
	        int mm = Integer.parseInt(vectorDate[1]);
	        int yy = Integer.parseInt(vectorDate[0]);
	        
	        boolean bisiesto = false;
	        if(yy % 100 == 0 && yy % 400 == 0) {
	        	bisiesto = true;
	        }

	        if (yy < 1){
	            return false;
	        }
	        if (mm < 1 || mm > 12) {
	            return false;
	        }
	       //Hasta Julio
	        if (mm % 2 != 0 && mm <=7 && dd > 0 && dd <= 31) {
	            return true;
	        }
	        if (mm % 2 == 0 && mm <=7 && dd > 0 && dd <=30 && mm != 2) {
	            return true;
	        }
	        if (dd > 0 && dd <=28 && mm == 2 && !bisiesto) {
	            return true;
	        } else if (dd > 0 && dd <=29 && mm == 2 && bisiesto) {
	        	return true;
	        }
	        if (mm % 2 != 0 && mm <=7 && dd > 0 && dd <= 31) {
	            return true;
	        }

	        //Despues de Julio
	        if (mm % 2 == 0 && mm > 7 && dd > 0 && dd <= 31) {
	            return true;
	        }
	        if (mm % 2 != 0 && mm > 7 && dd > 0 && dd <= 30) {
	            return true;
	        }

	        return false;
	        }
	}
	
	public static String formatDateSQL(String date){
		String regex = "([0-9]{1,2}/[0-9]{1,2}/[0-9]{4})"; //Regex del formato Europeo (dd-MM-yyyy)
		Pattern patron = Pattern.compile(regex);	//Compila el regex
		Matcher matches = patron.matcher(date);	//Determina las concordancias
		
		if (matches.find()) {	//Si encuentra concordancias
			String[] vectorDate = date.split("/");	//Vector para separar los campos
			String formattedDate = vectorDate[2] +"-" +  vectorDate[1] + "-" + vectorDate[0];	//Creacion de la fecha con el nuevo formato
			return formattedDate;	//Devuelve la fecha con el nuevo formato
		} 
		
		else {	//En caso de que no haya encontrado concordancias compruebo que ya esté en formato SQL	
			regex = "([0-9]{4}-[0-9]{1,2}-[0-9]{1,2})"; //Comprueba que el patron se encuentre en formate SQL (yyyy-MM-dd)
			patron = Pattern.compile(regex);	//Compila el regex
			matches = patron.matcher(date);	//Determina las concordancias
			
			if (matches.find()) {	//Si encuentra
			return date;	//Deveulve la fecha inicial
			} else {	//Si no es ninguna de las dos
				System.err.println("Formato incorrecto");
				return null;	//Devuelve valor nulo
			}
		}
	}
	
	public static String formatDateEU(String date){
		if (date.matches("([0-9]{4}-[0-9]{1,2}-[0-9]{1,2})")) {		//Si encuentra concordancias
			String[] vectorDate = date.split("-");		//Vector para separar los campos
			String formattedDate = vectorDate[2] +"/" +  vectorDate[1] + "/" + vectorDate[0];	//Creacion de la fecha con el nuevo formato
			return formattedDate;	//Devuelve la fecha con el nuevo formato
		} else if (date.matches("([0-9]{1,2}/[0-9]{1,2}/[0-9]{4})")) {	//Si encuentra concordancias
			return date;	//Devuelve la fecha inicial
		} else {	//Si no es ninguna de las dos
			System.err.println("Formato incorrecto");
			return null;	//Devuelve valor nulo
			}
			
		}
	
	public static String getAge(String date) {
		String[] vectorDate = date.split("-");
		Period edad = Period.between(LocalDate.of(	Integer.parseInt(vectorDate[0]),
													Integer.parseInt(vectorDate[1]), 
													Integer.parseInt(vectorDate[2])), LocalDate.now());
				
		return edad.getYears() + " años";
	}
	
	public static String encryptMd5(String password) {
        final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();

            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            password = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return password;
    }
	
	public static String firstUpper(String text) {
		String upper = text.substring(0, 1).toUpperCase();
        String lower = text.substring(1, text.length()).toLowerCase();
        
        return upper + lower;
	}
}