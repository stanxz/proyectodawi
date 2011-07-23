<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Medicos de Paciente</title>
<sj:head jqueryui="true"/>
</head>
<body>
	<h2>Modificar Datos Medicos de Paciente</h2>
<form action="ActualizarDMPacienteAction" method="post">
		<table align="center">
			<tr>
				<td colspan="3"> <s:property value="mensaje"/></td>
			</tr>
			<tr>
				<td>DNI Paciente</td>
				   <td> <s:textfield name="dmpaciente.dni"></s:textfield> </td>
			</tr>
			<tr>
				<td>Cefalea</td>
				<!--   <td> <s:textfield name="dmpaciente.Cefalea"></s:textfield> </td>-->
				<td> <s:checkbox name="dmpaciente.dni" 
					<s:if test="usuario.Cefalea==1">
					fieldValue="true"
					</s:if>
					label="Check me !!"
				 > 
				</s:checkbox> </td>
				
			</tr>
			<tr>
				<td>Asma</td>
				<td> <s:textfield name="dmpaciente.Asma"></s:textfield> </td>
			</tr>
			<tr>
				<td>Alergia</td>
				<td> <s:textfield name="dmpaciente.Alergia"></s:textfield> </td>
			</tr>

			<tr>
				<td>Otros</td>
				<td> <s:textfield name="dmpaciente.Otros"></s:textfield> </td>
			</tr>
			<tr>
				<td>Telf. Fijo</td>
				<td> <s:textfield name="dmpaciente.Especificacion"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.fijo"></s:fielderror></td>
			</tr>
			<tr>
				<td>Peso</td>
				<td> <s:textfield name="dmpaciente.Peso"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.celular"></s:fielderror></td>
			</tr>
			<tr>
				<td>Talla</td>
				<td> <s:textfield name="dmpaciente.Talla"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.direccion"></s:fielderror></td>
			</tr>
			<tr>
				<td>Presión Arterial</td>
				<td> <s:textfield name="dmpaciente.PresionArterial"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.user"></s:fielderror></td>
			</tr>
			<tr>
				<td>Grupo Sanguineo</td>
				<td> <s:textfield name="dmpaciente.GrupoSanguineo"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.contrasena"></s:fielderror></td>
			</tr>
			
			<tr>
				<td>Observaciones</td>
				<td> <s:textarea name="dmpaciente.Observaciones"></s:textarea> </td>
				<td> <s:fielderror fieldName="usuario.observaciones"></s:fielderror></td>
			</tr>
			<tr>
				<td colspan="2">
					<s:submit value="Actualizar DM"></s:submit>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>