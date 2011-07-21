<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvido a Sermeden</title>
<sj:head jqueryui="true"/>
<!--  Rodrigo, este metodo javascript lo uso para un popup q puse al registrar una persona-->
<script type="text/javascript">
	
	function okButton(){
       $('#mybuttondialog').dialog('close');
     };
</script>
<!-- fin de cambios -->
</head>
<body> 
<h2>
<TABLE width="100%" border="0">
		<tr>
			<TD class="TextoMenu">
                   <s:if test='#session.b_usuario.sexo == "H"'>
                            Bienvenido  Sr:<br>
                    </s:if>
                    <s:if test='#session.b_usuario.sexo == "M"'>
                            Bienvenida  Sra:<br>
                    </s:if> 
                    
                    <s:property value="#session.b_usuario.nombre"/>
                    
                    <s:property value="#session.b_usuario.apepat"/>
				</TD>
		</tr>
	</TABLE>
</h2>
	<table align="center">
		<tr>
			<td >  
				<jsp:include page="menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<!-- Rodrigo, esta parte yo la agregue para que me muestre un mensaje al registrar como dijo el profe
			     es un dialog con jquery -->
			<td>
				<s:if test='mensaje != null'>
					<sj:dialog 
					    	id="mybuttondialog" 
					    	buttons="{ 
					    		'OK':function() { okButton(); }
					    		}" 
					    	autoOpen="true" 
					    	modal="true" 
					    	title="Registro de Usuario"
					    >
					     <!--  Usuario Registrado con Exito !-->
					     <jsp:include page="/Seguridad/UsuarioRegistrado-result.jsp"></jsp:include>
					 </sj:dialog>
				</s:if>
			</td>
		</tr>
	</table>
</body>
</html>