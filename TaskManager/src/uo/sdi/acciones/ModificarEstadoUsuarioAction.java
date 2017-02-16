package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import uo.sdi.dto.util.Cloner;
import alb.util.log.Log;

public class ModificarEstadoUsuarioAction implements Accion {

		@Override
		public String execute(HttpServletRequest request,
				HttpServletResponse response) {
			
			String resultado="EXITO";
			HttpSession session=request.getSession();
			User user=((User)session.getAttribute("user"));
			Long userId = user.getId();
			try {
				AdminService adminService = Services.getAdminService();
				if(user.getStatus()==UserStatus.ENABLED)
					adminService.disableUser(userId);
				else adminService.enableUser(userId);
				Log.debug("Modificado estado de [%s]. Valor actual: [%s]", 
						user, user.getStatus() );
				
			}
			catch (BusinessException b) {
				Log.debug("Algo ha ocurrido actualizando el estado de [%s]. Estado actual [%s]: %s", 
						user.getLogin(),user.getStatus(),b.getMessage());
				resultado="FRACASO";
			}
			return resultado;
		}
		
		@Override
		public String toString() {
			return getClass().getName();
		}
		
	}

