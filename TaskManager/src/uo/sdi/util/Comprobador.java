package uo.sdi.util;

public class Comprobador {

	public static boolean esEmailValido(String email) {
		try {
			String[] cachos = email.split("@");
			if (cachos.length != 2) {
				throw new Exception();
			}
			cachos[1].split(".");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean esContraseñasIguales(String p1, String p2) {
		char[] pass1 = p1.toCharArray();
		char[] pass2 = p2.toCharArray();
		if (pass1.length != pass2.length)
			return false;
		for (int i = 0; i < pass1.length; i++) {
			if (pass1[i] != pass2[i])
				return false;
		}
		return true;
	}

	/**
	 * Si es null el String lo pone como cadena vacia. Es decir ""
	 * 
	 * @param problems strings con problemas
	 */
	public static String eliminarNullDeString(String problems) {
		if(problems == null){
			return "";
		}
		return problems;
	}
	
	public static boolean esLetrasYnumerosValido(String into){
		if(into == "" || into == null){
			return false;	
		}
		for(char c : into.toCharArray()){
			if(!(Character.isAlphabetic(c) || Character.isDigit(c) || Character.isWhitespace(c))){
				return false;
			}
		}
		return true;
	}
}
