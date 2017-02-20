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
	<table border="1" align="center">
		<tr>
			<dl>
				<dt>Inbox Tasks</dt>
				<c:forEach var="entry" items="${inboxTasks}" varStatus="i">
					<dd id="item_${i.index}">		
<%-- 						<td><a href="mostrarTarea?id=${entry.id}">${entry.id}</a></td>
						<td>${entry.name}</td> --%>
						<dl>
							<dt>${entry.title}</dt>
								<dd>
									${entry.comments}
								</dd>
							
						</dl>
					</dd>
				</c:forEach>

			</dl>
		</tr>

	</table>
	<br/>	
	<a id="panelDeControl_link_id" href="panelDeControl">Panel de control</a>
	<a id="cerrarSesion_link_id" href="cerrarSesion">Cerrar sesión</a>
	
	<%@ include file="pieDePagina.jsp" %>
</body>
</html>
