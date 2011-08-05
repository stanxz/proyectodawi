<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de Gestion Medico Odontologica SERMEDEN</title>
</head>
<body>
<table>
	<tr>
		<td colspan="2">
			<tiles:insertAttribute name="cabecera"></tiles:insertAttribute>	
		</td>
	</tr>
	
	<tr>
		<td>
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>	
		</td>
		<td width="100%" height="100%" align="center">
			<tiles:insertAttribute name="cuerpo"></tiles:insertAttribute>	
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<tiles:insertAttribute name="pie"></tiles:insertAttribute>	
		</td>
	</tr>

</table>
</body>
</html>