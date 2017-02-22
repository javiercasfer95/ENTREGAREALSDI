<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Listado de tareas</title>
</head>
<body>
	<form action="finalizarTarea" method="POST">
		<center>
			<h1>Lista Tareas Inbox</h1>
		</center>
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Comentario</th>
				<th>Planeado</th>
				<th>Categoria</th>
				<th>Marcar Finalizada</th>
				<th>Editar Tarea</th>
			</tr>
			<c:forEach var="entry" items="${inboxTasks}" varStatus="i">
				<tr id="item_${i.index}">
					<td>${entry.id}</td>
					<td>${entry.title}</td>
					<td>${entry.comments}</td>
					<c:choose>
						<c:when test="${entry.planned le today}">
							<td><FONT COLOR="red"> ${entry.planned} </FONT></td>
						</c:when>
						<c:otherwise>
							<td>${entry.planned}</td>
						</c:otherwise>
					</c:choose>
					<td>${entry.categoryId}</td>
					<td><input type="checkbox"
						name="marcarFinalizadaInbox${entry.id}" /></td>
					<td><input type="checkbox" name="editarTareaInbox${entry.id}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br> <br>
		<center>
			<h1>Lista Tareas Hoy</h1>
		</center>
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Comentario</th>
				<th>Planeado</th>
				<th>Categoria</th>
				<th>Marcar Finalizada</th>
				<th>Editar tarea</th>
			</tr>
			<c:forEach var="entry" items="${todayTasks}" varStatus="i">
				<tr id="item_${i.index}">
					<td>${entry.id}</td>
					<td>${entry.title}</td>
					<td>${entry.comments}</td>
					<c:choose>
						<c:when test="${entry.planned le today}">
							<td><FONT COLOR="red"> ${entry.planned} </FONT></td>
						</c:when>
						<c:otherwise>
							<td>${entry.planned}</td>
						</c:otherwise>
					</c:choose>
					<td>${entry.categoryId}</td>
					<td><input type="checkbox"
						name="marcarFinalizadaHoy${entry.id}" /></td>
					<td><input type="checkbox" name="editarTareaHoy${entry.id}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br> <br>
		<center>
			<h1>Lista Tareas Semana</h1>
		</center>
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Comentario</th>
				<th>Planeada</th>
				<th>Categoria</th>
				<th>Marcar como finalizada</th>
				<th>Editar tarea</th>
			</tr>
			<c:forEach var="entry" items="${weeklyTasks}" varStatus="i">
				<tr id="item_${i.index}">
					<td>${entry.id}</td>
					<c:choose>
						<c:when test="${entry.planned le today}">
							<td><FONT COLOR="red"> ${entry.title} </FONT></td>
						</c:when>
						<c:otherwise>
							<td>${entry.title}</td>
						</c:otherwise>
					</c:choose>
					<td>${entry.comments}</td>
					<td>${entry.planned}</td>
					<td>${entry.categoryId}</td>
					<td><input type="checkbox"
						name="marcarFinalizadaSemana${entry.id}" /></td>
					<td><input type="checkbox" name="editarTareaSemana${entry.id}" /></td>
				</tr>
			</c:forEach>
		</table>
		<center>
			<h1>Editar Tarea</h1>
		</center>
		<hr>
		<br>
		<table align="center">
			<tr>
				<td align="right">Nombre de la tarea</td>
				<td><input type="text" name="nombreTarea" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td align="right">Comentario de la tarea</td>
				<td><input type="text" name="comentarioTarea" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td align="right">Fecha planeada(formato: dd-MM-yyyy)</td>
				<td><input type="date" name="plannedTarea" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td align="right">Editar categoria</td>
				<td>
					<!-- <input type="text" name="categoriaTarea" align="left"
					size="15"> -->
				<select name="listaCategoriasUsuario">
					<c:forEach var="entry" items="${categoriasUser}" varStatus="i">
						<option value = ${entry.id}> ${entry.name}</option>
					</c:forEach>
						
				</select>


				</td>
			</tr>
		</table>
		<br>
		<center>
			<input type="submit" value="Finalizar Tarea/Editar">
		</center>
	</form>
	<a id="añadirTarea_link_id" href="IRcrearTarea">Añadir Tarea</a>
	<a id="cancelarCrearCategoria_link_id" href="IRmenuUsuario">Cancelar</a>
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>