package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import alb.util.log.Log;

public class ListarTareasAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";

		List<Task> inboxTasks;
		List<Task> todayTasks;
		List<Task> weeklyTasks;
		HttpSession session = request.getSession();

		User actualUser = (User) session.getAttribute("user");
		Long idUser = actualUser.getId();
		try {
			TaskService taskService = Services.getTaskService();

			inboxTasks = taskService.findInboxTasksByUserId(idUser);
			todayTasks = taskService.findTodayTasksByUserId(idUser);
			weeklyTasks = taskService.findWeekTasksByUserId(idUser);

			request.setAttribute("inboxTasks", inboxTasks);
			request.setAttribute("todayTasks", todayTasks);
			request.setAttribute("weeklyTasks", weeklyTasks);
			Log.debug(
					"Obtenida lista de tareas inbox conteniendo [%d] categorías",
					inboxTasks.size());
			Log.debug(
					"Obtenida lista de tareas today conteniendo [%d] categorías",
					todayTasks.size());
			Log.debug(
					"Obtenida lista de tareas weekly conteniendo [%d] categorías",
					weeklyTasks.size());
			
		} catch (BusinessException b) {
			Log.debug("Algo ha ocurrido obteniendo lista de categorías: %s",
					b.getMessage());
			resultado = "FRACASO";
		}
		return resultado;
	}

	@Override
	public String toString() {
		return getClass().getName();
	}

}
