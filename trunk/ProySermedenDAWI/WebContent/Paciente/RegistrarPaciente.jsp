<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Nuevo Paciente</title>
</head>
<body>
<h4 align="center" >Registrar Nuevo Paciente</h4>

<form action="registrarPacienteAction" method="post" >
		<table align="center">
			<tr>
				<td>Nombre</td>
				<td> <s:textfield name="usuario.nombre"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.nombre"></s:fielderror></td>
			</tr>
			<tr>
				<td>Apellido Paterno</td>
				<td> <s:textfield name="usuario.apepat"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.apepat"></s:fielderror></td>
			</tr>
			<tr>
				<td>Apellido Materno</td>
				<td> <s:textfield name="usuario.apemat"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.apemat"></s:fielderror></td>
			</tr>
			<tr>
				<td>DNI</td>
				<td> <s:textfield name="usuario.dni"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.dni"></s:fielderror></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento</td>
				<td> <sj:datepicker name="usuario.fechanac" displayFormat="dd/mm/yy" changeYear="true" changeMonth="true" yearRange="-55:-15"
								value="today" ></sj:datepicker> 
			   </td>
			   
			</tr>
			<tr>
				<td>Sexo</td>
				<td> <s:radio name="usuario.sexo" list="#{'H':'Masculino','M':'Femenino'}" value="M"  ></s:radio> </td>
				<td> <s:fielderror fieldName="usuario.sexo"></s:fielderror></td>
			</tr>
			<tr>
				<td>Email</td>
				<td> <s:textfield name="usuario.email"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.email"></s:fielderror></td>
			</tr>
			<tr>
				<td>Telf. Fijo</td>
				<td> <s:textfield name="usuario.fijo"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.fijo"></s:fielderror></td>
			</tr>
			<tr>
				<td>Celular</td>
				<td> <s:textfield name="usuario.celular"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.celular"></s:fielderror></td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td> <s:textfield name="usuario.direccion"></s:textfield> </td>
				<td> <s:fielderror fieldName="usuario.direccion"></s:fielderror></td>
			</tr>		
			<tr>
				<td>Observaciones</td>
				<td> <s:textarea name="usuario.observaciones"></s:textarea> </td>
				<td> <s:fielderror fieldName="usuario.observaciones"></s:fielderror></td>
			</tr>
			<tr>			
				<td colspan="2">
					<!--<s:submit value="Registrar"></s:submit>-->
					<sj:submit 
				    	value="Registrar" 
				    	button="true"
				    />
					
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>