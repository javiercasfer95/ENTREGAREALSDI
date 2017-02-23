package uo.sdi.acciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.util.Comprobador;
import uo.sdi.util.Utilidades;

public class ModificarTareaAction  implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		long oldTaskID = Long.parseLong(request.getParameter("id"));
		TaskService tasker = Services.getTaskService();
		Task oldTask = null;
		try {
			oldTask = tasker.findTaskById(oldTaskID);
		} catch (BusinessException e1) {
			resultado = "FRACASO";
			request.setAttribute("mensajeParaElUsuario",
					"No he encontrado la tarea a modificar.");
			Log.debug(
					"no he encontrado la tarea con el id [%s].",
					oldTaskID);
			return resultado;
		}
		
		//Clonando
		Task cloneTask = Utilidades.clonarTarea(oldTask);
		
		
		
		String newTitle = request.getParameter("tituloTarea");
		String newComment = request.getParameter("comentarioTarea");
		String newPlanned = request.getParameter("plannedTarea");
//		String newFinish = request.getParameter("finishTarea");
		String newCategoria = request.getParameter("categoriaSeleccionada");
		
		boolean titleOK = Comprobador.esLetrasYnumerosValido(newTitle);
		boolean comentarioOK = true; // Yo creo que no necesita ningun filtro.
		boolean fechaPlannedOK = newPlanned.equals("") ? false : true;
		
		if (!(titleOK && comentarioOK && fechaPlannedOK)) {
			request.setAttribute("mensajeParaElUsuario",
					"Comprueba que todos los campos se han introducido correctamente!.");
			resultado = "FRACASO";
			Log.debug(
					"Los campos que ha introducido el usuario son incorrectos.");
		} else {
			 //Fechas
			Date plannedDate = null;
		
			try {
				 plannedDate = new SimpleDateFormat("yyyy-mm-dd").parse(newPlanned);
				// finishDate = new SimpleDateFormat("yyyy-mm-dd").parse(newFinish);
			} catch (ParseException e) {
				Log.debug(
						"Error al parsear las fechas [%s] y [%s]",
						newPlanned);
			}
			
			if(!(plannedDate != null)){
				resultado = "FRACASO";
			}else{
				
//				if(!oldTask.getFinished().equals(finishDate)){
//					cloneTask.setFinished(finishDate);
//				}
				if(!oldTask.getPlanned().equals(plannedDate)){
					cloneTask.setPlanned(plannedDate);
				}
				if(!oldTask.getTitle().equals(newTitle)){
					cloneTask.setTitle(newTitle);
				}
				if(!oldTask.getComments().equals(newComment)){
					cloneTask.setComments(newComment);
				}
				
				long newCatID = Long.parseLong(newCategoria);
				if(!oldTask.getCategoryId().equals(newCatID)){
					cloneTask.setCategoryId(newCatID);
				}
				
				//Hasta aqui todo ha ido bien.
				try {
					tasker.deleteTask(oldTask.getId());
					tasker.createTask(cloneTask);
					Log.debug(
							"Tarea [%s] modificada correctamente",
							cloneTask.getTitle());
					request.setAttribute("mensajeParaElUsuario",
							"Tarea modificada correctamente.");
				} catch (BusinessException e) {
					resultado = "FRACASO";
					Log.debug(
							"No se ha podido guardar en la base de datos la tarea [%s].",
							cloneTask.getTitle());
					request.setAttribute("mensajeParaElUsuario",
							"No se ha podido guardar en la base de datos. Inténtelo más tarde.");
				}
				
				
			}
			
			
			
		}
		
		return resultado;
	}

}
