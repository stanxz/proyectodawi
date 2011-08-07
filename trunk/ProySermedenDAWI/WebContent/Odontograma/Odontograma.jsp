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
<sj:head jqueryui="true"/>
<link href="css/miEstilo.css" rel="stylesheet" type="text/css" />
<link href="css/stylesWeb.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Odontograma</h2>
<s:form action="insertaOdontograma" method="post">
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
		<td align="left"><s:checkbox name="odontograma.d1"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d2"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d3"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d4"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d5"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d6"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d7"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d8"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d9"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d10"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d11"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d12"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d13"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d14"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d15"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d16"></s:checkbox></td>
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
		<td align="left"><s:checkbox name="odontograma.d17"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d18"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d19"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d20"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d21"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d22"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d23"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d24"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d25"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d26"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d27"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d28"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d29"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d30"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d31"></s:checkbox></td>
		<td align="left"><s:checkbox name="odontograma.d32"></s:checkbox></td>
	</tr>
	<tr>
	<td colspan="16" align="center">
	<sj:submit value="Registrar" 
				   button="true"/>
	</td>			   
	</tr>
</table>
</s:form>
</body>
</html>