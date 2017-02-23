<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Opciones disponibles</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>
				<form action="listarTareas" method="post"
					name="opcionUsuario_listarTareas">

					<input type="submit" value="Listar tareas" />
				</form>
			</td>
			<td>
				<form action="IRcrearTarea" method="post"
					name="opcionUsuario_crearTarea">

					<input type="submit" value="Crear tarea" />
				</form>
			</td>

<!-- 
			<td>
				<form action="editarTareas" method="post"
					name="opcionUsuario_editarTareas">

					<input type="submit" value="Editar tareas" />
				</form>
			</td>
 -->
			<td>
				<form action="listarCategorias" method="post"
					name="opcionUsuario_listarCategorias">

					<input type="submit" value="Listar categorias" />
				</form>
			</td>
			<td>
				<form action="IRcrearCategoria" method="post"
					name="opcionUsuario_crearCategoria">

					<input type="submit" value="Crear categoria" />
				</form>
			</td>
			
			<td>
				<form action="IReditarUsuario" method="post"
					name="opcionUsuario_editarUsuario">

					<input type="submit" value="Editar mis datos" />
				</form>
			</td>
		</tr>

	</table>
	<a id="cerrarSesion_link_id" href="cerrarSesion">Cerrar sesión</a>
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>