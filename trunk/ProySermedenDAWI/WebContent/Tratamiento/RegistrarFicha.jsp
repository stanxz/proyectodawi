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
</head>
<body>
<h4>Registrar Ficha</h4>
	<s:form id="form1" action="registrarFichaAction" method="post">
		
		<table>
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
				<sj:submit value="Registrar Ficha" onclick="return confirm('Se desactivará la Ficha Actual del Usuario si la tuviera y se creará una nueva.¿Seguro que desea continuar?')" >
			</sj:submit>
				</td>
			</tr>
			
		</table>
		<s:property value="mensaje"/>
	</s:form>
</body>
</html>