package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
<<<<<<< HEAD
import uo.sdi.business.Services;
=======
>>>>>>> 1976f53eeb9db26da7d571c952c59306daf18a05
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.user.UserServiceImpl;
import uo.sdi.dto.User;
import uo.sdi.util.Comprobador;

public class RegistrarUsuarioAction implements Accion {

	/*
	 * Dos opciones:
	 * 
	 * Lo guardamos en la base si tuvo éxito e iniciamos sesion.
	 * 
	 * Lo guardamos en la base y le mandamos al login para que inicie sesion.
	 * (Esta será mas facil, es la que estoy usando actualmente.)
	 * 
	 * Mirar mapa de acciones del controlador.
	 */

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		// Resultados que puede mandar
		String result = "EXITO";

		// Obtencion de datos

		String nombreUsuario = request.getParameter("nombreUsuario");
		String email = request.getParameter("email");
		String contraseña = request.getParameter("pass");
		String contraseñaRepetida = request.getParameter("pass2");

		// HttpSession session = request.getSession();
		User user = new User();

		if (!Comprobador.esEmailValido(email)) {
			// El email no es valido y hay que tratar el error
			Log.debug("Email inválido!");
			result = "FRACASO";
		} else if (!Comprobador.esContraseñasIguales(contraseña,
				contraseñaRepetida)) {
			Log.debug("Las contraseñas no son iguales!");
			result = "FRACASO";
		} else {
			user.setEmail(email);
			user.setPassword(contraseña);
			user.setLogin(nombreUsuario);
<<<<<<< HEAD
			UserService userService = Services.getUserService();
=======
			UserService userService = new UserServiceImpl();
>>>>>>> 1976f53eeb9db26da7d571c952c59306daf18a05
			try {
				userService.registerUser(user);
			} catch (BusinessException e) {
				Log.debug("El registro de usuario ha fallado por lo siguiente:\n"
						+ e.getMessage());
				result = "FRACASO";
			}
		}

		return result;
	}

}
