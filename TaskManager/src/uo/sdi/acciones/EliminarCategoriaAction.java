package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import alb.util.log.Log;


public class EliminarCategoriaAction implements Accion{

		public String execute(HttpServletRequest request,
				HttpServletResponse response) {
			String result = "EXITO";
			Long id = Long.parseLong(request.getParameter("id"));
			try {
				TaskService tS = Services.getTaskService();
				
				tS.deleteCategory(id);
				new ListarCategoriasAction().execute(request, response);
				Log.debug("Se ha eliminado correctamente la categoria con ID: [%s]", id);
			} catch (BusinessException e) {
				result = "FRACASO";
				Log.debug("Error al eliminar la categoria con id [%s]", id);
				request.setAttribute("mensajeParaElUsuario",
						"No se ha podido eliminar la categoria. Inténtelo más tarde.");
			}
			return result;
		}

}
