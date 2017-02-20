<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarNavegacion.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Página principal del administrador</title>
</head>
<body>
<i>Iniciaste sesión el <fmt:formatDate pattern="dd-MM-yyyy' a las 'HH:mm" 
								value="${sessionScope.fechaInicioSesion}"/>
								(usuario número ${contador})</i>
	<br/><br/>
	<jsp:useBean id="user" class="uo.sdi.dto.User" scope="session" />
	<table border="0.1" align="center" cellspacing=0.3 cellpadding=4>
		<tr>
			<dl>
				<dt>Lista de usuarios</dt>
				
				<c:forEach var="entry" items="${listaUsuarios}" varStatus="i">
				<tr>
					<dd id="item_${i.index}">
 						<td>${entry.id}	</a></td>
						<td>${entry.login}</td> 
						<td>${entry.email}</td>
						<td>${entry.status}</td>
							<td> <form action="cambiarEstado" method="post" name="opcionCambiarEstado" >
					<input type="submit" name=envioIndice value="${entry.status=='ENABLED' ? 'DISABLE' : 'ENABLE'}" />
						</td>
						</dd>
						</tr>
				</c:forEach>

			</dl>
		</tr>

	</table>
	<INPUT TYPE="HIDDEN" NAME="idex" value=""></td>
	
	<br/>	
	<a id="panelDeControl_link_id" href="panelDeControl">Panel de control</a>
	<a id="cerrarSesion_link_id" href="cerrarSesion">Cerrar sesión</a>
	
	<%@ include file="pieDePagina.jsp" %>
</body>
</html>
