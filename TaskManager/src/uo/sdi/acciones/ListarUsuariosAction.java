package uo.sdi.acciones;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;

import uo.sdi.dto.User;
import alb.util.log.Log;

public class ListarUsuariosAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";

		List<User> listaUsuarios;
		
		//HttpSession session = request.getSession();

		//User actualUser = (User) session.getAttribute("user");
		//	Long idUser = actualUser.getId();
		
		try {
			AdminService adminService = Services.getAdminService();

			//obtenemos todos los usuarios existentes
			listaUsuarios = adminService.findAllUsers();
			request.setAttribute("listaUsuarios", listaUsuarios);
			
			Log.debug(
					"Obtenida lista de usuarios. Obtenidos [%d] usuarios ",
					listaUsuarios.size());
			
			
		} catch (BusinessException b) {
			Log.debug("Algo ha ocurrido obteniendo lista de usuarios: %s",
					b.getMessage());
			resultado = "FRACASO";
		}
		return resultado;
	}

}
