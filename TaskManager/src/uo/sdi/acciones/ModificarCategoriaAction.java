package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.util.Cloner;

public class ModificarCategoriaAction implements Accion{
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		//HttpSession session=request.getSession();
		Long indice= Long.parseLong(request.getParameter("id"));
		Category categoria=null;;
		
		try {
		
			TaskService taskService= Services.getTaskService();
			categoria = taskService.findCategoryById(indice);
			 
			String nombreAnterior = categoria.getName();
			String nuevoNombre= request.getParameter("nombreCategoria");
			Category categoriaClon = Cloner.clone(categoria);
			categoriaClon.setName(nuevoNombre);
			
			taskService.updateCategory(categoriaClon);
			
			Log.debug("Modificado el nombre de la categoria con el id= [%d] de [%s] a [%s]", 
					categoria.getId(),nombreAnterior, categoria.getName());
			new CargarMostrarCategoriaAction();
		}
		catch (BusinessException b) {
			Log.debug("Algo ha ocurrido actualizando el nombre de la categoria con id [%d]. Nombre actual [%s]: %s", 
					indice, categoria.getName(), b.getMessage());
			resultado="FRACASO";
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
}


