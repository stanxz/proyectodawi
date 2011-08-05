<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Medicos de Paciente</title>
<sj:head jqueryui="true"/>
<link href="css/miEstilo.css" rel="stylesheet" type="text/css" /> 
<script>
$(document).ready(function(){
	$("#dmpaciente.Otros").click(function(event){
		alert("WAAAAA");
		if ($("#dmpaciente.Otros").attr("checked")){
			$("#midiv").css("display", "block");
		}else{
			$("#midiv").css("display", "none");
		}
	});
});
</script>



</head>
<body >
<h2>Modificar Datos Medicos de Paciente</h2>
<form action="ActualizarDMPacienteAction" method="post">
<table align="center"">
  <tr valign="top">
    <td>
	<div class="ui-tabs ui-widget ui-corner-all"
	style="border: 3px solid #dddddd; background: #f2f5f7 url(./images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
			<tr>
				<td colspan="3"> <s:property value="mensaje"/></td>
			</tr>
			<tr>
				<td align="left">DNI Paciente:</td>
				   <td> <s:textfield name="dmpaciente.dni"></s:textfield> </td>
			</tr>
			<tr>
				<td align="left">Cefalea:</td>
				<td> 
					<s:if test="dmpaciente.Cefalea==1">
						<s:checkbox name="dmpaciente.Cefalea" value="true" >
						</s:checkbox> 
					</s:if>
					<s:else>
						<s:checkbox name="dmpaciente.Cefalea" value="false" >
						</s:checkbox> 
					</s:else>
				</td>
				
			</tr>
			<tr>
				<td align="left">Asma:</td>
				<td> 
					<s:if test="dmpaciente.Asma==1">
						<s:checkbox name="dmpaciente.Asma" value="true" >
						</s:checkbox> 
					</s:if>
					<s:else>
						<s:checkbox name="dmpaciente.Asma" value="false" >
						</s:checkbox> 
					</s:else>
				</td>
			</tr>
			<tr>
				<td align="left">Alergia:</td>
				<td> 
					<s:if test="dmpaciente.Alergia==1">
						<s:checkbox name="dmpaciente.Alergia" value="true" >
						</s:checkbox> 
					</s:if>
					<s:else>
						<s:checkbox name="dmpaciente.Alergia" value="false" >
						</s:checkbox> 
					</s:else>
				</td>
			</tr>

			<tr>
				<td align="left">Otros:</td>
				<td> 
					<s:if test="dmpaciente.Otros==1">
						<s:checkbox id="dmpaciente.Otros" name="dmpaciente.Otros" value="true" >
						</s:checkbox> 
					</s:if>
					<s:else>
					<s:checkbox id="dmpaciente.Otros" name="dmpaciente.Otros" value="false" >
						</s:checkbox> 
					</s:else>
				</td>
			</tr>
				<tr >
					<td align="left">Especificacion:</td>
					<td>
						<s:textarea id="dmpaciente.Especificacion" name="dmpaciente.Especificacion"></s:textarea>
					</td>
				</tr>
			
			<tr>
				<td align="left">Peso:</td>
				<td> <s:textfield name="dmpaciente.Peso"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.celular"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Talla:</td>
				<td> <s:textfield name="dmpaciente.Talla"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.direccion"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Presión Arterial:</td>
				<td> <s:textfield name="dmpaciente.PresionArterial"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.user"></s:fielderror></td>
			</tr>
			<tr>
				<td align="left">Grupo Sanguineo:</td>
				<td> <s:textfield name="dmpaciente.GrupoSanguineo"></s:textfield> </td>
				<td align="left"> <s:fielderror fieldName="usuario.contrasena"></s:fielderror></td>
			</tr>
			
			<tr>
				<td align="left">Observaciones:</td>
				<td> <s:textarea name="dmpaciente.Observaciones"></s:textarea> </td>
				<td align="left"> <s:fielderror fieldName="usuario.observaciones"></s:fielderror></td>
			</tr>
			<tr>
				<td colspan="3">
					<sj:submit value="Actualizar DM"
								button="true"
								effect="highlight"/>
				</td>
			</tr>
		</table>
		</div>
		</td>
		</tr>
		</table>
	</form>
	<div  id="midiv" style="display: none; ">
			HOLAAAA
		</div>
</body>
</html>