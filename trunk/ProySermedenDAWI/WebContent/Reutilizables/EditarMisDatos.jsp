<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Mis Datos</title>
<sj:head jqueryui="true"/>
</head>
<body>
<h2>Editar Mis Datos</h2>
<form action="ActualizarUsuarioAction" method="post">
		<table align="center">
			<tr>
				<td>Nombre</td>
				<td><s:label name="usuario.nombre"></s:label></td>
			</tr>
			<tr>
				<td>Apellido Paterno</td>
				<td><s:label name="usuario.apepat"></s:label></td>
			</tr>
			<tr>
				<td>Apellido Materno</td>
				<td><s:label name="usuario.apemat"></s:label></td>
			</tr>
			<tr>
				<td>DNI</td>
				<td> <s:textfield name="usuario.dni"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.dni"></s:fielderror></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento</td>
				<td> <sj:datepicker name="usuario.fechanac" displayFormat="dd/mm/yy" changeYear="true" changeMonth="true" yearRange="-55:-15"
								value="today" ></sj:datepicker> 
			   </td>
			   
			</tr>
			<tr>
				<td>Sexo</td>
				<td> <s:radio name="usuario.sexo" list="#{'H':'Masculino','M':'Femenino'}"  ></s:radio> </td>
			</tr>
			<tr>
				<td>Email</td>
				<td> <s:textfield name="usuario.email"></s:textfield> </td>
			</tr>
			<tr>
				<td>Telf. Fijo</td>
				<td> <s:textfield name="usuario.fijo"></s:textfield> </td>
			</tr>
			<tr>
				<td>Celular</td>
				<td> <s:textfield name="usuario.celular"></s:textfield> </td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td> <s:textfield name="usuario.direccion"></s:textfield> </td>
			</tr>
			<tr>
				<td>Usuario Sistema</td>
				<td> <s:textfield name="usuario.user"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.user"></s:fielderror></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td> <s:textfield name="usuario.contrasena"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.contrasena"></s:fielderror></td>
			</tr>
			<tr>
				<td colspan="2">
					<s:submit value="Actualizar"></s:submit>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>