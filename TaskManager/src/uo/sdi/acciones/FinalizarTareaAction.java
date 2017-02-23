package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.date.DateUtil;
import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;

public class FinalizarTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String result = "EXITO";
		long tareaID = Long.parseLong(request.getParameter("id"));
		TaskService tasker = Services.getTaskService();

		Task myTask = null;

		try {
			myTask = tasker.findTaskById(tareaID);

			if (myTask.getFinished() != null) {
				Log.debug("La tarea con id [%s] ya ha sido finalizada.",
						tareaID);
				request.setAttribute("mensajeParaElUsuario",
						"La tarea ya ha sido finalizada.");
				return result;
			}
			myTask.setFinished(DateUtil.today());
			
			Log.debug("Se ha finalizado la tarea con id [%s].", tareaID);
			request.setAttribute("mensajeParaElUsuario",
					"La tarea se ha finalizado.");
			tasker.updateTask(myTask);
			
			Task taskPrueba = tasker.findTaskById(myTask.getId());
		} catch (BusinessException e) {
			result = "FRACASO";
			Log.debug("No se ha podido encontrar la tarea con el id [%s].",
					tareaID);
			request.setAttribute("mensajeParaElUsuario",
					"No se ha podido realizar la operacion, inténtelo mas tarde.");
			return result;
		}

		return result;
	}

}
