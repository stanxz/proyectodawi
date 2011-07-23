<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recuperar contraseña</title>
</head>
<body>
	<h2>Recuperar Contraseña</h2>
	<form action="RecuperaPassAction">
		<table align="center">
			<tr>
				<td colspan="2">Al darle click a recuperar, se enviara le enviara un mail al correo si es que se encuentra registrado</td>
			</tr>
			<tr>
				<td align="right">
					Ingrese su DNI:
				</td>
				<td>
					<s:textfield name="dniBuscado"></s:textfield>
				</td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="Recuperar"></s:submit> </td>
			</tr>
		</table>
	</form>
</body>
</html>