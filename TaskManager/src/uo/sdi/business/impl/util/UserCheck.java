package uo.sdi.business.impl.util;

import java.util.regex.Pattern;

import uo.sdi.business.exception.BusinessCheck;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.persistence.Persistence;
import uo.sdi.persistence.UserDao;

public class UserCheck {

	public static void isNotAdmin(User user) throws BusinessException {
		String check = "A new admin cannot be registered"; 
		BusinessCheck.isFalse( user.getIsAdmin(), check);
	}

	public static void isValidEmailSyntax(User user) throws BusinessException {
		String check = "Email invalido";
		BusinessCheck.isTrue( isValidEmail( user.getEmail()), check);
	}

	public static void minLoginLength(User user) throws BusinessException {
		String check = "El nombre de usuario ha de estar compuesto por al menos 3 "
				+ "carácteres";
		BusinessCheck.isTrue( user.getLogin().length() >= 3, check);
	}

	/**
	 * Metodo que comprueba si la contraseña tiene numeros y letras
	 * @param user: usuario asmerluzo
	 * @throws BusinessException
	 */
	public static void isPasswordValid(User user) throws BusinessException {
		String check = "La contraseña ha de contener numeros y letras";
		char[] pass = user.getPassword().toCharArray();
		boolean numero=false;
		boolean letra=false;
		for (char c : pass) {
			if(Character.isDigit(c)) numero = true;
			else if(Character.isLetter(c)) letra = true;
			if(numero && letra) break;
			
		}
		
		 BusinessCheck.isTrue(numero && letra, check);

    }
	
	public static void minPasswordLength(User user) throws BusinessException {
		String check = "La contraseña ha de tener 8 caracteres";
		BusinessCheck.isTrue( user.getPassword().length() >= 8, check);
	}

	public static void notRepeatedLogin(User user) throws BusinessException {
		UserDao uDao = Persistence.getUserDao();
		User u = uDao.findByLogin( user.getLogin() );
		BusinessCheck.isNull(u, "El nombre de usuario ya esta en uso.");
	}
	
	

	private static boolean isValidEmail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}"
				+ "\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])"
				+ "|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		
        return Pattern.compile(ePattern)
        		.matcher(email)
        		.matches();
    }

}
