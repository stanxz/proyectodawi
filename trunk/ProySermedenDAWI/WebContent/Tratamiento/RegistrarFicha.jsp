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
	<s:form id="form1" action="buscarPacienteAction" >
		<s:text name="lblDNIbuscado">DNI Paciente: </s:text>
 		<s:textfield name="dniBuscado" label="DNI Paciente: "></s:textfield>
		<sj:submit targets="resultado1" value="Buscar Paciente">
		</sj:submit>
	</s:form>
	
	<sj:div id="resultado1">
	</sj:div>
	
	<s:form  id="form2" action="registrarFichaAction" method="post">
		<table>
			<tr>
				<td>Observaciones: </td>
				<td> <s:textarea name="observaciones"></s:textarea> </td>
			</tr>
			<sj:submit value="Registrar Ficha">
			</sj:submit>
		</table>
	
<!-- 	 <table align="center"> -->
<!-- 		<tr> -->
<!-- 			<td align="center" colspan="3"> <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td colspan="3"> -->
<%-- 				<s:url id="remoteurl" action=""/>  --%>
<%-- 				<sj:radio --%>
<!-- 					href="%{remoteurl}"   -->
<!-- 					id="remoteRadiobuttons"  -->
<!-- 					name="remoteRadiobuttons"  -->
<%--  					list="#{'1':'Si','2':'No'}"   --%>
<!-- 					label="Registrar Nueva Cita?" -->
<!-- 					onChangeTopics="submitForm1" -->
<%-- 				></sj:radio>  --%>
<%-- 				<sj:submit   --%>
<!-- 	            	id="form2button" -->
<!-- 	            	targets="formResult"  -->
<!-- 	            	indicator="indicator" -->
<!-- 	            	button="true" -->
<!-- 	            	listenTopics="submitForm1" -->
<!-- 	            	cssStyle="display:none;" -->
<!-- 	            	/>			 -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td> -->
<!-- 				<div id="formResult" class="result ui-widget-content ui-corner-all" >Seleccione un botón</div> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		</table> -->
	</s:form>
</body>
</html>