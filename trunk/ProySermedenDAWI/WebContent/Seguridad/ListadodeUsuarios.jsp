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
<h2>Busqueda de Usuarios</h2>
	<s:form action="listarUsuariosxNombre">
		<s:textfield name="filtro" label="Criterio:">
		</s:textfield>
		<br>
		<s:radio name="tipocriterio" list="#{'1':'DNI','2':'Apellido'}" label="Elija tipo:" value="2"  ></s:radio>
		<br>
		<sj:submit targets="resultado" value="Listar">
		</sj:submit>
		<br>
	</s:form>
	
	<sj:div id="resultado">
		</sj:div>
</body>
</html>