<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar al Sistema</title> 

    <link rel="stylesheet" href="css/jquery.ui.all.css">
	
	<script src="js/jquery-1.4.4.js"></script>
	<script src="js/jquery.ui.widget.js"></script>	
	<script src="js/jquery.ui.tabs.js"></script>
	<script src="js/jquery.ui.button.js"></script> 

	<link rel="stylesheet" href="css/demos.css">
	<script type="text/javascript" src="js/util.js"></script>

  <script type="text/javascript">
	$(function() {

		$( "#NuevoUsu" ).tabs();
		
		$( "button, input:submit", ".btn" ).button();
		
	});
	
	</script>
<script type="text/javascript">
	function okButton(){
       $('#mybuttondialog').dialog('close');
     };
</script>
<!-- El problema con la interfaz que puse es este 
<sj:head jqueryui="true"/>
-->
</head>
<h1>Sermeden</h1>
<body>
	<form action="logueo">
<table align="center" height="250">
  <tr valign="top">
    <td>
	<div id="NuevoUsu">
		<table align="center">
			<tr>
				<td><s:label value="Usuario"></s:label> </td>
				<td><s:textfield name="elusuario.user"></s:textfield> </td>
			</tr>
			<tr>
				<td><s:label value="Contraseña"></s:label> </td>
				<td><s:password name="elusuario.contrasena"></s:password> </td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				<div class="btn">
					<s:submit value="Ingresar" ></s:submit>
				</div>					
				</td>
			</tr>
			<tr>
				<td> <s:a href="a_recuperarPassword">Olvido su contraseña?</s:a> </td>
			</tr>
			<tr>
				<td><s:property value="mensaje2"/></td>
				<td>
				<s:if test='mensaje != null'>
					<sj:dialog 
					    	id="mybuttondialog" 
					    	buttons="{ 
					    		'OK':function() { okButton(); }
					    		}" 
					    	autoOpen="true" 
					    	modal="true" 
					    	title="%{titulo}">
					     <!--  Usuario Registrado con Exito !-->
					     <jsp:include page="/Seguridad/UsuarioRegistrado-result.jsp"></jsp:include>
					 </sj:dialog>
				</s:if>
			</td>
			</tr>
		</table>
		 </div>
	 </td>
	</tr>
</table>
	</form>
</body>
</html>