<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Nueva Cita</title>
</head>
<body>

<h4>Nueva Cita</h4>
<form action="">
	<table align="center">
	<tr><td> <s:property value="#session.b_usuario.idPerfil"  /> </td> </tr>
		<tr>
			 <s:if test="#session.b_usuario.idPerfil==3">
			 <td>
			 Código de Paciente: 
			 </td>
			 <td>
			 	<s:textfield name="dnibuscado" required="true"></s:textfield>
			  </td>	
			  
			 </s:if>
			 
			 <s:if test="#session.b_usuario.idPerfil==0">
			 	<td></td>
			 	<td>
			 	<s:hidden name="dnibuscado" value= "#session.b_usuario.dni"></s:hidden>
			 	</td>		 	
			 </s:if>
			
		</tr>
		<tr>
			<td>
				<jsp:include page="/Cita/Turnos-result.jsp"></jsp:include>
			</td>
		</tr>
		
	</table>
</form>

</body>
</html> 

