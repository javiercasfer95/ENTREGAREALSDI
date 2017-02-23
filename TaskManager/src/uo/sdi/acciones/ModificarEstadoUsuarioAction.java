package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import alb.util.log.Log;

public class ModificarEstadoUsuarioAction implements Accion {

		@Override
		public String execute(HttpServletRequest request,
				HttpServletResponse response) {
			
			String resultado="EXITO";
			//HttpSession session=request.getSession();
			Long indice= Long.parseLong(request.getParameter("id"));
		
			User usuario=null ;
			try {
				
				AdminService adminService = Services.getAdminService();
				usuario = adminService.findUserById( indice);
				if(usuario.getStatus()==UserStatus.ENABLED)
					adminService.disableUser(indice);
				else adminService.enableUser(indice);
				Log.debug("Modificado estado de [%s]. Valor actual: [%s]", 
						usuario, usuario.getStatus() );
				request.setAttribute("mensajeParaElUsuario", "ERROR: no manda correctamente los ids");
				
				new ListarUsuariosAction().execute(request, response);
				
			}
			catch (BusinessException b) {
				Log.debug("Algo ha ocurrido actualizando el estado de [%s]. Estado actual [%s]: %s", 
						usuario.getLogin(),usuario.getStatus(),b.getMessage());
				resultado="FRACASO";
			}
			return resultado;
		}
		
		@Override
		public String toString() {
			return getClass().getName();
		}
		
	}

