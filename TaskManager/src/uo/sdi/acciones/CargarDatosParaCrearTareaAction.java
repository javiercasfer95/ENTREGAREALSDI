package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.User;

public class CargarDatosParaCrearTareaAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado = "EXITO";
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		long userID = user.getId();
		
		List<Category> categoriasUser = null;
		
		try {
			categoriasUser = Services.getTaskService().findCategoriesByUserId(userID);
		} catch (BusinessException e) {
			resultado = "FRACASO";
			Log.info("Error al precargar datos para crear una tarea.");
			request.setAttribute("mensajeParaElUsuario",
					"Error al precargar datos para crear una tarea.");
		}
		
		session.setAttribute("categoriasUser", categoriasUser);
		return resultado;
	}

}
