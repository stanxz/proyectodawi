<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Ficha</title>
<sj:head jqueryui="true"/>
</head>
<body>
<h4>Registrar Ficha</h4>
	<s:form id="form1" action="buscarPacienteAction" theme="simple">
	<table align="center">
		<tr>
			<td>Paciente</td>
			<td> <s:textfield name="dniBuscado"></s:textfield> </td>
			<td>
<%-- 				<s:url id="buscarPaciente"  action="buscarPacienteAction" > --%>
<%-- 					<s:param name="dniBuscado"> --%>
<%-- 						 <s:property value="paciente.dni"/> --%>
<%-- 					</s:param> --%>
<%-- 				</s:url> --%>
<%-- 				<s:a  href="%{buscarPaciente}"> Buscar Paciente </s:a> --%>
				<sj:submit targets="resultado1" value="Buscar Paciente">
				</sj:submit>
			</td>
		</tr>
		</table>
	</s:form>
	<sj:div id="resultado1">
	</sj:div>
	
	<s:form action="registrarFichaAction" method="post">
	 <table align="center">
		<tr>
			<td>
				
			</td>
		</tr>
		<tr>
			<td colspan="3"> <s:fielderror fieldName="paciente.dni"></s:fielderror></td>
		</tr>
		<tr>
			<td align="center" colspan="3"> <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/></td>
		</tr>
		<tr>
			<td colspan="3">
				<s:url id="remoteurl" action="jsonsample"/> 
				<sj:radio
					href="%{remoteurl}" 
					id="remoteRadiobuttons" 
					name="remoteRadiobuttons" 
					list="#{'1':'Si','2':'No'}" 
					label="Registrar Nueva Cita?"
					onChangeTopics="submitForm1"
				></sj:radio>
				<sj:submit 
	            	id="form2button"
	            	targets="formResult" 
	            	indicator="indicator"
	            	button="true"
	            	listenTopics="submitForm1"
	            	cssStyle="display:none;"
	            	/>			
			</td>
		</tr>
		<tr>
			<td>
				<div id="formResult" class="result ui-widget-content ui-corner-all" >Seleccione un botón</div>
			</td>
		</tr>
		</table>
	</s:form>
</body>
</html>