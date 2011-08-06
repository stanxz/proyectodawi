<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/tablas.css" />
<title>Insert title here</title>
</head>
<body>
<h2>Odontograma</h2>
<s:form action="insertaOdontograma">
<table width="10%">
	        <tr >
				<td align="center" colspan="16">DNI: <s:textfield name="dmpaciente.dni" readonly="true" style="background-color: #D8D8D8;"></s:textfield></td>
		    </tr>
	<tr>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
	</tr>
	<tr>
		<td align="left"><s:checkbox name="d1"></s:checkbox></td>
		<td align="left"><s:checkbox name="d2"></s:checkbox></td>
		<td align="left"><s:checkbox name="d3"></s:checkbox></td>
		<td align="left"><s:checkbox name="d4"></s:checkbox></td>
		<td align="left"><s:checkbox name="d5"></s:checkbox></td>
		<td align="left"><s:checkbox name="c6"></s:checkbox></td>
		<td align="left"><s:checkbox name="d7"></s:checkbox></td>
		<td align="left"><s:checkbox name="d8"></s:checkbox></td>
		<td align="left"><s:checkbox name="d9"></s:checkbox></td>
		<td align="left"><s:checkbox name="d10"></s:checkbox></td>
		<td align="left"><s:checkbox name="d11"></s:checkbox></td>
		<td align="left"><s:checkbox name="d12"></s:checkbox></td>
		<td align="left"><s:checkbox name="d13"></s:checkbox></td>
		<td align="left"><s:checkbox name="d14"></s:checkbox></td>
		<td align="left"><s:checkbox name="d15"></s:checkbox></td>
		<td align="left"><s:checkbox name="d16"></s:checkbox></td>
	</tr>
	<tr>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
		<td><img alt="" src="./images/diente.png"></td>
	</tr>
	<tr>
		<td align="left"><s:checkbox name="d17"></s:checkbox></td>
		<td align="left"><s:checkbox name="d18"></s:checkbox></td>
		<td align="left"><s:checkbox name="d19"></s:checkbox></td>
		<td align="left"><s:checkbox name="d20"></s:checkbox></td>
		<td align="left"><s:checkbox name="d21"></s:checkbox></td>
		<td align="left"><s:checkbox name="d22"></s:checkbox></td>
		<td align="left"><s:checkbox name="d23"></s:checkbox></td>
		<td align="left"><s:checkbox name="d24"></s:checkbox></td>
		<td align="left"><s:checkbox name="d25"></s:checkbox></td>
		<td align="left"><s:checkbox name="d26"></s:checkbox></td>
		<td align="left"><s:checkbox name="d27"></s:checkbox></td>
		<td align="left"><s:checkbox name="d28"></s:checkbox></td>
		<td align="left"><s:checkbox name="d29"></s:checkbox></td>
		<td align="left"><s:checkbox name="d30"></s:checkbox></td>
		<td align="left"><s:checkbox name="d31"></s:checkbox></td>
		<td align="left"><s:checkbox name="d32"></s:checkbox></td>
	</tr>
	<tr><sj:submit value="Registrar" 
				   button="true"/></tr>
</table>
</s:form>
</body>
</html>