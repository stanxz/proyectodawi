<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar al Sistema</title> 
<link href="css/misEstilos.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">  
	function okButton(){
       $('#mybuttondialog').dialog('close');
     };
</script>
<sj:head jqueryui="true"/>
</head>
<h1>Sermeden</h1>
<body>
	<form action="logueo">
<table align="center" class="box degradado blue"
		style="border-style: outset;border-color: #2382a1;">
  <tr valign="top">
    <td>
	<div >
		<table align="center">
			<tr>
				<td><s:label value="Usuario"></s:label></td>
				<td><s:textfield name="elusuario.user"></s:textfield> </td>
			</tr>
			<tr>
				<td><s:label value="Contrase�a"></s:label> </td>
				<td><s:password name="elusuario.contrasena"></s:password> </td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				<div class="btn">
					<s:submit value="Ingresar" class="boton"></s:submit>
				</div>					
				</td>
			</tr>
			<tr>
				<td> <s:a href="a_recuperarPassword">Olvido su contrase�a?</s:a> </td>
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