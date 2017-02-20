<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarNavegacion.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Crear categoria</title>
</head>
<body>
	<%-- <jsp:useBean id="user" class="uo.sdi.dto.User" scope="session" /> --%>
	<table>
		<tr>
			<td>
				<form action="crearCategoria" method="post"
					name="crearCategoria_form_name">
					<center>
						<h1>Crear una categoría:</h1>
					</center>
					<hr>
					<br>
					<table align="center">
						<tr>
							<td align="right">Nombre de la categoria:</td>
							<td><input type="text" name="nombreCategoria" align="left"
								size="15"></td>
						</tr>
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