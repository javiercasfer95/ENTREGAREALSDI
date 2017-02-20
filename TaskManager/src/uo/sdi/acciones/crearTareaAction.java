package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.dto.User;

public class crearTareaAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String title = request.getParameter("tituloTarea");
		String comentario = request.getParameter("comentarioTarea");
		
		//Terminar clase
		
		resultado = "FRACASO";
		request.setAttribute("mensajeParaElUsuario",
				"Hay que terminar el crear una tarea.");
		
		return resultado;
	}

}
