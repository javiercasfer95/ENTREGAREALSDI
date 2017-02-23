<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Listado de categorías</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
				<dt>Mis categorias</dt>
				<hr/>
				<c:forEach var="entry" items="${listaCategorias}" varStatus="i">
					<tr id="item_${i.index}">
						<td>${entry.id}</td>
						<td>${entry.name}</td>
						<td><a href="mostrarCategoria?id=${entry.id}">Editar</a></td>
					</tr>
				</c:forEach>
			</dl>
		</tr>
	</table>
	<a id="cancelarCrearCategoria_link_id" href="IRmenuUsuario">Cancelar</a>
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>