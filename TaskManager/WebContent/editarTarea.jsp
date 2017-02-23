<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Editar tarea</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<form action="modificarTarea?id=${tareaAeditar.id}" method="post"
					name="crearTarea_form_name">

					<center>
						<h1>Editar tarea:</h1>
					</center>
					<hr>
					<br>
					<table align="center">
						<jsp:useBean id="tareaAeditar" class="uo.sdi.dto.Task"
							scope="request" />
						<tr>

							<td align="right">Titulo de la tarea:</td>
							<td><input type="text" name="tituloTarea" align="left"
								size="15"
								value=<jsp:getProperty property="title" name="tareaAeditar"/>></td>
						</tr>

						<tr>
							<td align="right">Comentario:</td>
							<td><input type="text" name="comentarioTarea" align="left"
								size="15"
								value=<jsp:getProperty property="comments" name="tareaAeditar"/>></td>
						</tr>

						<tr>
							<td align="right">Fecha planned:</td>
							<td><input type="date" name="plannedTarea" align="left"
								size="15"
								value=<jsp:getProperty property="planned" name="tareaAeditar"/>></td>
						</tr>
<!-- 						<tr>
							<td align="right">Fecha finish:</td>
							<td><input type="date" name="finishTarea" align="left"
								size="15"
								value=<jsp:getProperty property="finished" name="tareaAeditar"/>></td>
						</tr> -->

						<tr>
							<td align="right">Editar categoria</td>
							<td><select name="categoriaSeleccionada">
									<c:forEach var="entry" items="${categoriasUser}" varStatus="i">
										<option value=${entry.id}>${entry.name}</option>
									</c:forEach>
									<jsp:useBean id="catFromEditedTask" class="uo.sdi.dto.Category"
										scope="session">
										<option
											value=<jsp:getProperty property="id" name="catFromEditedTask"/>
											selected><jsp:getProperty property="name"
												name="catFromEditedTask" />
										</option>
									</jsp:useBean>
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