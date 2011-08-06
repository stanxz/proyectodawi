<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Pacientes</title>
<sj:head jqueryui="true"/>
<link href="./css/miEstilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<s:form action="listarPacientesxNombreOdontograma">
<table align="center"">
  <tr valign="top">
    <td>
	<div class="ui-tabs ui-widget ui-corner-all"
	style="border: 3px solid #dddddd; background: #f2f5f7 url(./images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
		<tr>
			<td colspan="2"><h2>Busqueda de Pacientes</h2></td>
		</tr>
		<tr>
			<td><s:label name="Criterio:"></s:label></td>
			<td><s:textfield name="filtro" label=""></s:textfield></td>
		</tr>
		<tr>
			<td><s:label name="Elija tipo::"></s:label></td>
			<td><s:radio name="tipocriterio" list="#{'1':'DNI','2':'Apellido'}" label="" value="2"  ></s:radio></td>
		</tr>
		<tr align="center">
			<td colspan="2">
			<sj:submit  targets="resultado" 
						value="Listar" 
						button="true"/>
			</td>
			</tr>
		</table>
		</div>
		</td>
		</tr>
		</table>
	</s:form>
	
	<sj:div id="resultado">
	</sj:div>
</body>
</html>