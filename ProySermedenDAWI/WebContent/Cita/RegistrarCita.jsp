<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Nueva Cita</title>
<sj:head jqueryui="true" compressed="false"/>
</head>
<body>

<h3 align="center" > Nueva Cita</h3>

<form id="formNuevaCita" action="RegistrarNuevaCitaAction">
	<table align="center">
	<tr>
			<s:if test='#session.b_usuario.idPerfil == 3'>
                <td>
			 DNI de Paciente: 
			 </td>
			 <td>
			 	<s:textfield name="dnibuscado" required="true"></s:textfield>
			  </td>        
            </s:if>
			 	
	</tr>
	<s:if test='#session.b_usuario.idPerfil == 3'>
	<tr>
			<td colspan="2"> <s:property value="mensaje"/> </td>
	</tr>
	</s:if>	
		
		<tr>
			<td colspan="2">
				<table align="center">
					<tr>
						<td align="center" colspan="2">
						<jsp:include page="../Cita/turnos-result.jsp"></jsp:include>
						</td>
					</tr>
	
					<tr>
						<td>
							Elija un  Medico Tratante:
						</td>
						<td>
							<div>
								<s:url id="opcionesUrl" action="listarMedicosAction"/>
								<sj:select	
									href="%{opcionesUrl}"
									id="medicoCita"
									name="medicoCita"
									onChangeTopics="reloadHoras"
									list="listamedicos"
									listKey="idPersona"
									listValue="ncompleto"
									headerKey="-1"
									headerValue="--Seleccione un Id de Médico Tratante--" required="true" />
							</div>
						</td>
					</tr>
					<tr>
						<td>
							Elija Fecha para Cita:
						</td>
						<td>
						    <div>
						    	<!-- <s:url id="opcionesUrl2" action="listarFechasAction"/> -->
								<sj:datepicker id="fechaCita" name="fechaCita" displayFormat="yy-mm-dd" changeYear="true" changeMonth="true" yearRange="+00:+01"
							    disabled="false" onChangeTopics="reloadHoras"></sj:datepicker> 
							</div>
						</td>
					</tr>
					<tr>
						<td>
							Elija Hora:
						</td>
						<td>
							     <div>
							   <!--<s:url id="opcionesUrl2" action="listarHorasAction"/>-->
								<sj:select 
									href="%{opcionesUrl}"
									id="horaCita"
									formIds="formNuevaCita"
									reloadTopics="reloadHoras" 
									name="horaCita"
									list="listahorasxfechaxmedicos"
									headerKey="-1"
									headerValue="- Seleccione una hora -"/>
							
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2"><sj:submit value="Registrar"></sj:submit> </td>
					</tr>
					</table>
			</td>
		</tr>
		
		
		
	</table>
</form>

</body>
</html> 

