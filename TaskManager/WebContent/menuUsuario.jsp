<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Opciones disponibles</title>
</head>
<body>
	<!-- <table border="1" align="center">
		<tr>
			<form action="listarTareas" method="post"
				name="opcionUsuario_listarTareas">
				
				<input type="submit" value="Listar tareas" />
			</form>
		</tr>
		
		<tr>
			<form action="crearTarea" method="post"
				name="opcionUsuario_crearTarea">
				
				<input type="submit" value="Crear tarea" />
			</form>
		</tr>
		
		
		<tr>
			<form action="editarTareas" method="post"
				name="opcionUsuario_editarTareas">
				
				<input type="submit" value="Editar tareas" />
			</form>
		</tr>
		
		<tr>
			<form action="listarCategorias" method="post"
				name="opcionUsuario_listarCategorias">
				
				<input type="submit" value="Listar categorias" />
			</form>
		</tr>

	</table> -->
	<a id="listarTareas_link_id" href="listarTareas">Listar tareas</a>
	<a id="crearTarea_link_id" href="crearTarea">Crear tarea</a>
	<a id="editarTareas_link_id" href="editarTareas">Editar tareas</a>
	<a id="listarCategorias_link_id" href="listarCategorias">Listar categorias</a>
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>