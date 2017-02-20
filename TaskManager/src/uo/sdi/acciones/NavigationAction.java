package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Clase que sirve unicamente para navegar entre paginas jsp mediante acciones.
 * Sirve por ejemplo para los formularios o inputs (botones)
 * 
 * @author Javier Castro
 * 
 */
public class NavigationAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		return "EXITO";
	}

}
