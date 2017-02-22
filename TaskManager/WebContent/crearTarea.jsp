<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Crear tarea</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<form action="crearTarea" method="post" name="crearTarea_form_name">
					<center>
						<h1>Crear una tarea nueva:</h1>
					</center>
					<hr>
					<br>
					<table align="center">
						<tr>
							<td align="right">Titulo de la tarea:</td>
							<td><input type="text" name="tituloTarea" align="left"
								size="15"></td>
						</tr>

						<tr>
							<td align="right">Comentario:</td>
							<td><input type="text" name="comentarioTarea" align="left"
								size="15"></td>
						</tr>

						<tr>
							<td align="right">Fecha planned:</td>
							<td><input type="date" name="plannedTarea" align="left"
								size="15"></td>
						</tr>
						<tr>
							<td align="right">Fecha finish:</td>
							<td><input type="date" name="finishTarea" align="left"
								size="15"></td>
						</tr>

						<tr>
							<td align="right">Editar categoria</td>
							<td><select name="categoriaSeleccionada">
									<c:forEach var="entry" items="${categoriasUser}" varStatus="i">
										<option value = ${entry.id}>${entry.name}</option>
									</c:forEach>

							</select></td>
						</tr>
						<!-- Terminar la creacion -->
						<tr>
							<td><input type="submit" value="Terminar" /></td>
						</tr>
					</table>

				</form>
			</td>
		</tr>
	</table>
	<br />
	<a id="cancelarCrearCategoria_link_id" href="IRmenuUsuario">Cancelar</a>
	<br></br>
	<a id="cerrarSesion_link_id" href="cerrarSesion">Cerrar sesión</a>

	<%@ include file="pieDePagina.jsp"%>
</body>
</html>