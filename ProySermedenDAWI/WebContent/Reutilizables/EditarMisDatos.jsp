<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Mis Datos</title>
<sj:head jqueryui="true"/>
<script type="text/javascript">
function obtieneValues(){
	document.getElementById("idModificado").value = document.getElementById("id").value;

	alert(document.getElementById("idModificado").value);
}
</script>
</head>
<body>
<h2>Editar Mis Datos</h2>
<form action="ActualizarPacienteAction" method="post">
		<table align="center">
			<tr>
				<td>Nombre           :</td>
				<td><s:label name="paciente.nombre"></s:label>
				</td>
			</tr>
			<tr>
				<td>Apellido Paterno :</td>
				<td><s:label name="#session.b_usuario.apepat"></s:label>
				<input  name="paciente.apepat" value='<s:property value="#session.b_usuario.apepat"/>' />
				</td>
			</tr>
			<tr>
				<td>Apellido Materno :</td>
				<td><s:label name="#session.b_usuario.apemat"></s:label>
				<input name="paciente.apemat" value='<s:property value="#session.b_usuario.apemat"/>'/>
				</td>
			</tr>
			<tr>
				<td>Sexo             :</td>
				<td>
				<s:if test='#session.b_usuario.sexo == "H"'>
				<s:label value="Masculino"></s:label>
				</s:if><s:else>
				<s:label value="Femenino"></s:label>
				</s:else>
				<input name="paciente.sexo" value='<s:property value="#session.b_usuario.sexo"/>'/>
				</td>
			</tr>
		 	<tr>
				<td>DNI</td>
				<td><s:label name="#session.b_usuario.dni"></s:label> 
				<input  name="paciente.dni" value='<s:property value="#session.b_usuario.dni"/>'/>
				</td>
				<td> <s:fielderror fieldName="paciente.dni"></s:fielderror></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento</td>
				<td> <sj:datepicker name="#session.b_usuario.fechanac" displayFormat="dd/mm/yy" changeYear="true" changeMonth="true" yearRange="-55:-15"></sj:datepicker> 
				<input name="paciente.fechanac" value='<s:date name="#session.b_usuario.fechanac" format="dd/MM/yyyy"/>'/>
				</td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td> <s:textfield name="#session.b_usuario.email"></s:textfield>
				<input name="paciente.email" value='<s:property value="#session.b_usuario.email"/>'/>
				 </td>
				 <td> <s:fielderror fieldName="paciente.email"></s:fielderror></td>
			</tr>
			<tr>
				<td>Telf. Fijo</td>
				<td> <s:textfield name="#session.b_usuario.fijo"></s:textfield>
				<input name="paciente.fijo" value='<s:property value="#session.b_usuario.fijo"/>'/>
				 </td>
				<td> <s:fielderror fieldName="paciente.fijo"></s:fielderror></td>
			</tr>
			<tr>
				<td>Celular</td>
				<td> <s:textfield name="#session.b_usuario.celular"></s:textfield>
				<input name="paciente.celular" value='<s:property value="#session.b_usuario.celular"/>'/>
				 </td>
				<td> <s:fielderror fieldName="paciente.celular"></s:fielderror></td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td> <s:textfield name="#session.b_usuario.direccion"></s:textfield> 
				<input name="paciente.direccion" value='<s:property value="#session.b_usuario.direccion"/>'/>
				</td>
				<td> <s:fielderror fieldName="paciente.direccion"></s:fielderror></td>
			</tr>
			<tr>
				<td>Usuario Sistema</td>
				<td> <s:textfield id="id" name="#session.b_usuario.user"></s:textfield>
				<input id="idModificado" name="paciente.user"/>
				</td>
				<td> <s:fielderror fieldName="paciente.user"></s:fielderror></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td> <s:textfield name="#session.b_usuario.contrasena"></s:textfield> 
				<input name="usuario.contrasena" value='<s:property value="#session.b_usuario.contrasena"/>'/>
				</td>
				<td> <s:fielderror fieldName="paciente.contrasena"></s:fielderror></td>
			</tr>
			<tr>
				<td colspan="2">
					<s:submit value="Actualizar" onclick="obtieneValues();"></s:submit>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>