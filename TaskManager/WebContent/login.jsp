<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Inicie sesión</title>
<body>
	<form action="validarse" method="post" name="validarse_form_name">

		<center>
			<h1>Inicie sesión</h1>
		</center>
		<hr>
		<br>
		<table align="center">
			<tr>
				<td align="right">Su identificador de usuario</td>
				<td><input type="text" name="nombreUsuario" align="left"
					size="15"></td>
			</tr>
			<tr>
<<<<<<< HEAD
				<td align="right">Password</td>
				<td><input type="text" name="userPass" align="left" size="15"></td>
			</tr>
			<tr>
=======
>>>>>>> 1976f53eeb9db26da7d571c952c59306daf18a05
				<td><input type="submit" value="Enviar" /></td>
			</tr>
		</table>
	</form>
	<a id="registrarUsuarios_link_id" href="registrarUsuarios_form.jsp">Registrar
		usuarios</a>
	<a id="listarCategorias_link_id" href="listarCategorias">Lista de
		categorias</a>
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>