<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head jqueryui="true"/>
</head>
<body>
<h4>Turnos</h4>
	<table align="center">
		<tr>
			<td>Dia</td>
			<td>HoraInicio</td>
			<td>Hora Fin</td>
			<td>Médico Tratante</td>
		</tr>
		
		<s:iterator value="listadoTurnos">
		<tr>
			<td align="center"><s:property value="dni"/> </td>
			<td align="center"><s:property value="nombre"/> </td>
			<td align="center"><s:property value="apepat"/> </td>
			<td align="center"><s:property value="apemat"/> </td>
		</tr>
	</s:iterator>
</table>
	

</body>
</html>