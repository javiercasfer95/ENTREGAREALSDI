package uo.sdi.acciones;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
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
		
		TaskService tasker = Services.getTaskService();

		try {
			Task task = tasker.findTaskById(tareaID);
			Category catFromEditedTask = Services.getTaskService()
					.findCategoryById(task.getCategoryId());
			List<Category> categoriasUser = new ArrayList<>();
			
			categoriasUser = tasker.findCategoriesByUserId(task.getUserId());
			
			categoriasUser.remove(catFromEditedTask);

			request.setAttribute("tareaAeditar", task);
			request.setAttribute("catFromEditedTask", catFromEditedTask);
			request.setAttribute("categoriasUser", categoriasUser);

		} catch (BusinessException e) {
			result = "FRACASO";
			Log.debug("Error al obtener la tarea con id [%s]", tareaID);
			request.setAttribute("mensajeParaElUsuario",
					"No se ha podido obtener la información de la tarea. Inténtelo más tarde.");
		}
		return result;
	}

}
