<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarNavegacion.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Página principal del usuario</title>
</head>
<body>
	<i>Iniciaste sesión el <fmt:formatDate
			pattern="dd-MM-yyyy' a las 'HH:mm"
			value="${sessionScope.fechaInicioSesion}" /> (usuario número
		${contador})
	</i>
	<br />
	<br />
	<jsp:useBean id="category" class="uo.sdi.dto.Category" scope="session" />
	<table>
		<tr>
		<td>Id Categoria: </td>
		<td><input type="text" name="id" size="1"
						value="<jsp:getProperty property="id" name="category"/>"  readonly="readonly"/>
		<tr>
			<td>Nombre de la categoría:</td>
			<td id="nombreCategoria"><form action="modificarCategoria"
					method="POST">
					<input type="text" name="nombreCategoria" size="15"
						value="<jsp:getProperty property="name" name="category"/>"/>
					<input type="submit" value="Modificar">
				</form></td>
			<td>
				<form action="eliminarCateogira" method="POST">
						<input type="submit" value="Eliminar categoria">
				</form>
			</td>
		</tr>
	</table>
	<br />
	<a id="cerrarSesion_link_id" href="IRmenuUsuario">Menu</a>
	<a id="cerrarSesion_link_id" href="cerrarSesion">Cerrar sesión</a>
	

	<%@ include file="pieDePagina.jsp"%>
</body>
</html>
