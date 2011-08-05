<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Ficha</title>
<sj:head jqueryui="true"/>
<link href="./css/miEstilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Registrar Ficha</h2>
<s:form id="form1" action="registrarFichaAction" method="post">
<table align="center"">
  <tr valign="top">
    <td>
	<div class="ui-tabs ui-widget ui-corner-all"
	style="border: 3px solid #dddddd; background: #f2f5f7 url(./images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
			<tr>
				<td colspan="2">
                            <s:text name="lblDNIbuscado">DNI Paciente: </s:text>
 							<s:textfield name="dniBuscado" label="DNI Paciente: "></s:textfield>
				</td>
			</tr>
			<tr>
				<td>Observaciones: </td>
				<td> <s:textarea name="observaciones"></s:textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
				<sj:submit value="Registrar Ficha" 
				           onclick="return confirm('Se desactivará la Ficha Actual del Usuario si la tuviera y se creará una nueva.¿Seguro que desea continuar?')"
				           button="true">
			</sj:submit>
				</td>
			</tr>
		    <s:property value="mensaje"/>
		   </table>
		  </div>
		</td>
	  </tr>
	</table>	
	</s:form>
</body>
</html>