<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar al Sistema</title> 
<script type="text/javascript">  
	function okButton(){
       $('#mybuttondialog').dialog('close');
     };
</script>
<sj:head jqueryui="true"/>
<link href="css/miEstilo.css" rel="stylesheet" type="text/css" />
</head>
<h1>Sermeden</h1>
<body>
<form action="logueo" method="post">
<table align="center"">
  <tr valign="top">
    <td>
	<div class="ui-tabs ui-widget ui-corner-all" 
	style="border: 3px solid #dddddd; background: #f2f5f7 url(images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
			<tr>
				<td align="left"><s:label value="Usuario"></s:label></td>
				<td><s:textfield name="elusuario.user"></s:textfield> </td>
			</tr>
			<tr>
				<td><s:label value="Contraseña"></s:label> </td>
				<td><s:password name="elusuario.contrasena"></s:password> </td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					 <sj:submit 
					 value="Ingresar" 
					 button="true"/>		
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