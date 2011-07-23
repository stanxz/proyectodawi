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
<form action="ActualizarPacienteAction" method="post">
		<table align="center">
			<tr>
				<td>Nombre           :</td>
				<td><s:textfield name="paciente.nombre"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>Apellido Paterno :</td>
				<td><s:textfield name="paciente.apepat" ></s:textfield>
				</td>
			</tr>
			<tr>
				<td>Apellido Materno :</td>
				<td><s:textfield name="paciente.apemat"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>Sexo             :</td>
				<td>
				<s:textfield name="paciente.sexo" ></s:textfield>
				</td>
			</tr>
		 	<tr>
				<td>DNI</td>
				<td><s:textfield name="paciente.dni"></s:textfield>
				</td>
				<td> <s:fielderror fieldName="paciente.dni"></s:fielderror></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento</td>
				<td> <sj:datepicker name="paciente.fechanac" displayFormat="dd/mm/yy" changeYear="true" changeMonth="true" yearRange="-55:-15"></sj:datepicker> 
				</td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td> <s:textfield name="paciente.email"></s:textfield>
				 </td>
				 <td> <s:fielderror fieldName="paciente.email"></s:fielderror></td>
			</tr>
			<tr>
				<td>Telf. Fijo</td>
				<td> <s:textfield name="paciente.fijo"></s:textfield>
				 </td>
				<td> <s:fielderror fieldName="paciente.fijo"></s:fielderror></td>
			</tr>
			<tr>
				<td>Celular</td>
				<td> <s:textfield name="paciente.celular"></s:textfield>
				 </td>
				<td> <s:fielderror fieldName="paciente.celular"></s:fielderror></td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td> <s:textfield name="paciente.direccion"></s:textfield> 
				</td>
				<td> <s:fielderror fieldName="paciente.direccion"></s:fielderror></td>
			</tr>
			<tr>
				<td>Usuario Sistema</td>
				<td> <s:textfield name="paciente.user"></s:textfield>
				</td>
				<td> <s:fielderror fieldName="paciente.user"></s:fielderror></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td> <s:textfield name="paciente.contrasena"></s:textfield> 
				</td>
				<td> <s:fielderror fieldName="paciente.contrasena"></s:fielderror></td>
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