<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Nuevo Paciente</title>
<sj:head jqueryui="true"/>
<link href="./css/miEstilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2 align="center" >Registrar Nuevo Paciente</h2>
<form action="registrarPacienteAction" method="post" >
<table align="center"">
  <tr valign="top">
    <td>
	<div class="ui-tabs ui-widget ui-corner-all"
	style="border: 3px solid #dddddd; background: #f2f5f7 url(./images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
			<tr>
				<td align="left">Nombre:</td>
				<td> <s:textfield name="paciente.nombre"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="paciente.nombre"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Apellido Paterno:</td>
				<td> <s:textfield name="paciente.apepat"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="paciente.apepat"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Apellido Materno:</td>
				<td> <s:textfield name="paciente.apemat"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="paciente.apemat"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">DNI:</td>
				<td> <s:textfield name="paciente.dni"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="paciente.dni"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Fecha de Nacimiento:</td>
				<td> <sj:datepicker name="paciente.fechanac" displayFormat="dd/mm/yy" changeYear="true" changeMonth="true" yearRange="-55:-15"
								value="today" ></sj:datepicker> 
			   </td>
			   
			</tr>
			<tr>
				<td align="left">Sexo:</td>
				<td> <s:radio name="paciente.sexo" list="#{'H':'Masculino','M':'Femenino'}" value="H"  ></s:radio> </td>
				<td align="left"> <s:fielderror fieldName="paciente.sexo"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Email:</td>
				<td> <s:textfield name="paciente.email"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="paciente.email"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Telf. Fijo:</td>
				<td> <s:textfield name="paciente.fijo"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="paciente.fijo"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Celular:</td>
				<td> <s:textfield name="paciente.celular"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="paciente.celular"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Dirección:</td>
				<td> <s:textfield name="paciente.direccion"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="paciente.direccion"></s:fielderror></td>
			</tr>		
			<tr>
				<td align="left">Observaciones:</td>
				<td> <s:textarea name="paciente.observaciones"></s:textarea> </td>
				<td align="left"> <s:fielderror fieldName="paciente.observaciones"></s:fielderror></td>
			</tr>
			<tr>			
				<td colspan="3" align="center">
					<sj:submit 
				    	value="Registrar" 
				    	button="true"
				    	effect="highlight"
				    />
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