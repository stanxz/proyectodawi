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
<link href="./css/miEstilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Editar Mis Datos</h2>
<form action="ActualizarPacienteAction" method="post">
<table align="center"">
  <tr valign="top">
    <td>
<div class="ui-tabs ui-widget ui-corner-all"
	style="border: 3px solid #dddddd; background: #f2f5f7 url(./images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
			<tr>
				<td align="left">Nombre:</td>
				<td colspan="2"><s:textfield name="paciente.nombre" readonly="true" style="background-color: #D8D8D8;"></s:textfield>
				</td>
			</tr>
			<tr>
				<td align="left">Apellido Paterno:</td>
				<td colspan="2"><s:textfield name="paciente.apepat"  readonly="true" style="background-color: #D8D8D8;"></s:textfield>
				</td>
			</tr>
			<tr>
				<td align="left">Apellido Materno:</td>
				<td colspan="2"><s:textfield name="paciente.apemat" readonly="true" style="background-color: #D8D8D8;"></s:textfield>
				</td>
			</tr>
			<tr>
				<td align="left">Sexo:</td>
				<td colspan="2">
				<s:textfield name="paciente.sexo" readonly="true" style="background-color: #D8D8D8;"></s:textfield>
				</td>
			</tr>
		 	<tr>
				<td align="left">DNI:</td>
				<td colspan="2"><s:textfield name="paciente.dni" readonly="true" style="background-color: #D8D8D8;"></s:textfield>
				</td>
			</tr>
			<tr>
				<td align="left">Fecha de Nacimiento:</td>
				<td colspan="2"> <sj:datepicker name="paciente.fechanac" displayFormat="dd/mm/yy" changeYear="true" changeMonth="true" yearRange="-55:-15"></sj:datepicker> 
				</td>
			</tr>
			
			<tr>
				<td align="left">Email:</td>
				<td> <s:textfield name="paciente.email"></s:textfield>
				 </td>
				 <td align="left"> <s:fielderror fieldName="paciente.email"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Telf. Fijo:</td>
				<td> <s:textfield name="paciente.fijo"></s:textfield>
				 </td >
				<td align="left"> <s:fielderror fieldName="paciente.fijo"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Celular:</td>
				<td> <s:textfield name="paciente.celular"></s:textfield>
				 </td>
				<td align="left"> <s:fielderror fieldName="paciente.celular"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Dirección:</td>
				<td> <s:textfield name="paciente.direccion"></s:textfield> 
				</td>
				<td> <s:fielderror fieldName="paciente.direccion"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Usuario Sistema:</td>
				<td> <s:textfield name="paciente.user"></s:textfield>
				</td>
				<td align="left"> <s:fielderror fieldName="paciente.user"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Contraseña:</td>
				<td> <s:textfield name="paciente.contrasena"></s:textfield> 
				</td>
				<td align="left"> <s:fielderror fieldName="paciente.contrasena"></s:fielderror></td>
			</tr>
			<tr>
				<td colspan="3">
					<sj:submit value="Actualizar"
					button="true"/>
				</td>
			</tr>
		</table>
		</div>
		</td>
		</tr>
	</table>
	</form>
</body>
</html>