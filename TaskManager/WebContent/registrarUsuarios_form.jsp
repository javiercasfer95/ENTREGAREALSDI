<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Registrarse</title>
<body>
	<form action="registrarse" method="post" name="register_user">
		<center>
			<h1>Log in</h1>
		</center>
		<hr>
		<br>
		<table align="center">
			<tr>
				<td align="right">User id:</td>
				<td><input type="text" name="nombreUsuario" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td align="right">e-mail:</td>
				<td><input type="text" name="email" align="left"></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td><input type="password" name="pass" align="left"></td>
			</tr>
			<tr>
				<td align="right">Repite passwrod:</td>
				<td><input type="password" name="pass2" align="left"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enviar" /></td>
			</tr>
		</table>
	</form>

	<a id="CancelarRegistro_link_id" href="login.jsp">Cancelar registro</a>
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>