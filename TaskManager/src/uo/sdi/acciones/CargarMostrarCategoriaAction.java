package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;

public class CargarMostrarCategoriaAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		String id = request.getParameter("id");
		long realID = Long.parseLong(id);
		
		try {
			Category cat = Services.getTaskService().findCategoryById(realID);
			request.setAttribute("categoriaEditar", cat);
		} catch (BusinessException e) {
			Log.debug("Algo ha ocurrido obteniendo la categoria con id: %s",
					realID);
			resultado="FRACASO";
		}
		return resultado;
	}

}
