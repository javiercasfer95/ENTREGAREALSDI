package uo.sdi.acciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.util.Comprobador;

public class crearTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String title = request.getParameter("tituloTarea");
		String comentario = request.getParameter("comentarioTarea");
		String fechaPlanned = request.getParameter("plannedTarea");
		String fechaFinish = request.getParameter("finishTarea");
		
		//Deberia dar el id por el value de la etiqueta
		String categoriaSelected = request
				.getParameter("categoriaSeleccionada"); 

		boolean titleOK = Comprobador.esLetrasYnumerosValido(title);
		boolean comentarioOK = true; // Yo creo que no necesita ningun filtro.
		boolean fechaPlannedOK = fechaPlanned.equals("") ? false : true;
		boolean fechaFinishOK = fechaFinish.equals("") ? false : true;

		if (!(titleOK && comentarioOK && fechaFinishOK && fechaPlannedOK)) {
			request.setAttribute("mensajeParaElUsuario",
					"Comprueba que todos los campos se han introducido correctamente!.");
			resultado = "FRACASO";
		} else {
			TaskService tasker = Services.getTaskService();
			Long catID = Long.parseLong(categoriaSelected);
			//Category cat = tasker.findCategoryById(catID);
			Task task = new Task();
			task.setCategoryId(catID);
			task.setComments(comentario);
			task.setTitle(title);
			task.setUserId(user.getId());
			
			 //Fechas
			Date plannedDate = null;
			Date finishDate = null;
			try {
				 plannedDate = new SimpleDateFormat("yyyy-mm-dd").parse(fechaPlanned);
				 finishDate = new SimpleDateFormat("yyyy-mm-dd").parse(fechaPlanned);
			} catch (ParseException e) {
				Log.debug(
						"Error al parsear las fechas [%s] y [%s]",
						fechaPlanned, fechaFinish);
			}
			
			if(!(plannedDate != null && finishDate != null)){
				resultado = "FRACASO";
			}else{
				
				task.setPlanned(plannedDate);
				task.setFinished(finishDate);
				
				//Hasta aqui todo ha ido bien.
				try {
					tasker.createTask(task);
					request.setAttribute("mensajeParaElUsuario",
							"Tarea añadida correctamente.");
				} catch (BusinessException e) {
					resultado = "FRACASO";
					request.setAttribute("mensajeParaElUsuario",
							"No se ha podido guardar en la base de datos. Inténtelo más tarde.");
				}
				
				
			}
			
			
			
		}
		

		return resultado;
	}
}
