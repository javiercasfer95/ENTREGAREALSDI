package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.util.Cloner;
import uo.sdi.util.Comprobador;

public class ModificarDatosAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String resultado = "EXITO";

		String nuevoEmail = request.getParameter("email");
		nuevoEmail = Comprobador.eliminarNullDeString(nuevoEmail);
		// String nuevoLogin = request.getParameter("login");
		// nuevoLogin = Comprobador.eliminarNullDeString(nuevoLogin);
		// String nuevaPass = request.getParameter("password");
		// nuevaPass = Comprobador.eliminarNullDeString(nuevaPass);
		HttpSession session = request.getSession();
		User user = ((User) session.getAttribute("user"));
		User userClone = Cloner.clone(user);

		userClone.setEmail(nuevoEmail); // Borrar si se hace lo siguiente
		// if (Comprobador.esEmailValido(nuevoEmail)) {
		// userClone.setEmail(nuevoEmail);
		// } else {
		// Log.debug("El email es incorrecto.");
		// }
		// if (nuevoLogin.length() >= 3) {
		// userClone.setLogin(nuevoLogin);
		// } else {
		// Log.debug("El login es demasiado corto. Minimo 3 caracteres.");
		// }
		// if (nuevaPass.length() >= 3) {
		// userClone.setPassword(nuevaPass);
		// } else {
		// Log.debug("La password es demasiado corta. Minimo 3 caracteres.");
		// }
		try {
			UserService userService = Services.getUserService();
			userService.updateUserDetails(userClone);
			Log.debug("Modificados los parametros de [%s] con el valor [%s]",
					userClone.getLogin(), nuevoEmail);
			session.setAttribute("user", userClone);
		} catch (BusinessException b) {
			Log.debug(
					"Algo ha ocurrido actualizando el email de [%s] a [%s]: %s",
					user.getLogin(), nuevoEmail, b.getMessage());
			resultado = "FRACASO";
		}
		if (resultado.equals("EXITO")) {
			request.setAttribute(
					"mensajeParaElUsuario",
					"Se han modificado los datos del usuario: "
							+ userClone.getLogin());
		} else {
			request.setAttribute("mensajeParaElUsuario",
					"Todavia no funciona el modificar un usuario.");
		}
		return resultado;
	}

	@Override
	public String toString() {
		return getClass().getName();
	}

}
