<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Listado de tareas</title>
</head>
<body>
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
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>