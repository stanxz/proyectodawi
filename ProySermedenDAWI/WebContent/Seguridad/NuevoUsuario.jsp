<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Usuario</title>
<sj:head jqueryui="true"/>
<link href="./css/miEstilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Nuevo Usuario</h2>
	<form action="RegistrarUsuarioAction" method="post" >
<table align="center"">
  <tr valign="top">
    <td>
	<div class="ui-tabs ui-widget ui-corner-all"
	style="border: 3px solid #dddddd; background: #f2f5f7 url(./images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
			<tr>
				<td align="left">Nombre:</td>
				<td> <s:textfield name="usuario.nombre"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.nombre"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Apellido Paterno:</td>
				<td> <s:textfield name="usuario.apepat"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.apepat"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Apellido Materno:</td>
				<td> <s:textfield name="usuario.apemat"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.apemat"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">DNI:</td>
				<td> <s:textfield name="usuario.dni"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.dni"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Fecha de Nacimiento:</td>
				<td> <sj:datepicker name="usuario.fechanac" displayFormat="dd/mm/yy" changeYear="true" changeMonth="true" yearRange="-55:-15"
								value="today" ></sj:datepicker> 
			   </td>
			   
			</tr>
			<tr>
				<td align="left">Sexo:</td>
				<td> <s:radio name="usuario.sexo" list="#{'H':'Masculino','M':'Femenino'}" value="M"  ></s:radio> </td>
				<td align="left"> <s:fielderror fieldName="usuario.sexo"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Email:</td>
				<td> <s:textfield name="usuario.email"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.email"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Telf. Fijo:</td>
				<td> <s:textfield name="usuario.fijo"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.fijo"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Celular:</td>
				<td> <s:textfield name="usuario.celular"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.celular"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Dirección:</td>
				<td> <s:textfield name="usuario.direccion"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.direccion"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Tipo Usuario:</td>
				<td> <s:select name="usuario.idPerfil" list="#{'1':'Administrador','2':'Auxiliar','3':'Recepcionista','4':'Técnico Imágenes','5':'M. Tratante','6':'M. Especialista'}" 
								headerValue="----- Seleccione -----"
								headerKey="0">				
							</s:select>
			    </td>
			    <td align="left"> <s:fielderror fieldName="usuario.idPerfil"></s:fielderror></td>
			</tr>
				<tr>
				<td align="left">Especialidad: <br>(solo en el caso de Especialistas)</td>
				<td> <s:select name="usuario.idEspecialidad" list="#{'1':'Odontopediatria','2':'Endodoncia','3':'Cirugia Oral','4':'Ortodoncia','5':'Periodoncia','6':'Protesis Dental'}" 
								headerValue="----- Seleccione -----"
								headerKey="0">				
							</s:select>
			    </td >
			    <td align="left"> <s:fielderror fieldName="usuario.idEspecialidad"></s:fielderror></td>
				</tr>			
			<tr>
				<td align="left">Observaciones:</td>
				<td> <s:textarea name="usuario.observaciones"></s:textarea> </td>
				<td align="left"> <s:fielderror fieldName="usuario.observaciones"></s:fielderror></td>
			</tr>
			<tr>			
				<td colspan="3">
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