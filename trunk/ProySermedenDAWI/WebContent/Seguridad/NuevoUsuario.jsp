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
<h2>Nuevo Usuario</h2>

	<form action="">
		<table align="center">
			<tr>
				<td>Nombre</td>
				<td> <s:textfield></s:textfield> </td>
			</tr>
			<tr>
				<td>Apellido Paterno</td>
				<td> <s:textfield></s:textfield> </td>
			</tr>
			<tr>
				<td>Apellido Materno</td>
				<td> <s:textfield></s:textfield> </td>
			</tr>
			<tr>
				<td>DNI</td>
				<td> <s:textfield></s:textfield> </td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento</td>
				<td> <sj:datepicker  displayFormat="dd/mm/yy" 
								value="today" ></sj:datepicker> 
			   </td>
			</tr>
			<tr>
				<td>Sexo</td>
				<td> <s:radio list="#{'M':'Masculino','F':'Femenino'}"  ></s:radio> </td>
			</tr>
			<tr>
				<td>Email</td>
				<td> <s:textfield></s:textfield> </td>
			</tr>
			<tr>
				<td>Telf. Fijo</td>
				<td> <s:textfield></s:textfield> </td>
			</tr>
			<tr>
				<td>Celular</td>
				<td> <s:textfield></s:textfield> </td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td> <s:textfield></s:textfield> </td>
			</tr>
			<tr>
				<td>Tipo Usuario</td>
				<td> <s:select list="#{'1':'Administrador','2':'Paciente','3':'Paciente','4':'Paciente','5':'Paciente','6':'Paciente','7':'Paciente','8':'Paciente'}" 
								headerValue="----- Seleccione -----"
								
								headerKey="0">				
							</s:select>
			    </td>
			</tr>
			<tr>
				<td>Observaciones</td>
				<td> <s:textarea></s:textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
					<s:submit></s:submit>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>