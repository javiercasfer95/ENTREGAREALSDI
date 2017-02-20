package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.User;

public class CrearCategoriaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String resultado = "EXITO";
		String nombreCategoria = request.getParameter("nombreCategoria");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			long userId = user.getId();
			if (nombreCategoria != null && nombreCategoria != "") {
				
				Category cat = new Category();
				cat.setName(nombreCategoria);
				cat.setUserId(userId);
				request.setAttribute("mensajeParaElUsuario",
						"Tarea: "+ cat.getName()+", creada correctamente.");
				try {
					Services.getTaskService().createCategory(cat);
				} catch (BusinessException e) {
					resultado = "FRACASO";
					Log.info("Error, ya existe una categoria con el nombre: [%s]", cat.getName());
					request.setAttribute("mensajeParaElUsuario",
							"Error, ya existe una categoria con el nombre:" + cat.getName());
				}
				
				
			} else {
				resultado = "FRACASO";
				Log.info("El nombre de la categoría es incorrecto.");
				request.setAttribute("mensajeParaElUsuario",
						"El nombre de la categoría es incorrecto.");
			}
		} else {
			resultado = "FRACASO";
			Log.info("No existe usuario. Error de navegación.S");
		}
		return resultado;
	}

}
