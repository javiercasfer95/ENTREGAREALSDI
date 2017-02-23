package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;

public class CargarEditarTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String result = "EXITO";
		String id = request.getParameter("id");
		long tareaID = Long.parseLong(id);

		try {
			Task task = Services.getTaskService().findTaskById(tareaID);
			Category catFromEditedTask = Services.getTaskService()
					.findCategoryById(task.getCategoryId());

			request.setAttribute("tareaAeditar", task);
			request.setAttribute("catFromEditedTask", catFromEditedTask);

		} catch (BusinessException e) {
			result = "FRACASO";
			Log.debug("Error al obtener la tarea con id [%s]", tareaID);
			request.setAttribute("mensajeParaElUsuario",
					"No se ha podido obtener la información de la tarea. Inténtelo más tarde.");
		}
		return result;
	}

}
