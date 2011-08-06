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
<!--  Rodrigo, este metodo javascript lo uso para un popup q puse al registrar una persona XD-->
<script type="text/javascript">
	function okButton(){
       $('#mybuttondialog').dialog('close');
     };
</script>
<!-- fin de cambios --> 
<link href="css/menu.css" rel="stylesheet" type="text/css" />
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
                    
                    <s:property value="#session.b_usuario.nombre"/>&nbsp;<s:property value="#session.b_usuario.apepat"/>
                	<br>
                	<s:if test='#session.b_usuario.idPerfil == 0'>
                            <h6> <font color="#87A1B8">Paciente</font> </h6> <br>
                    </s:if>
                    <s:if test='#session.b_usuario.idPerfil == 1'>
                            <h6> <font color="#87A1B8">Administrador del Sistema</font> </h6> <br>
                    </s:if>
                    <s:if test='#session.b_usuario.idPerfil == 2'>
                            <h6> <font color="#87A1B8">Auxiliar</font> </h6> <br>
                    </s:if>
                    <s:if test='#session.b_usuario.idPerfil == 3'>
                            <h6> <font color="#87A1B8">Recepcionista</font> </h6> <br>
                    </s:if>
                    <s:if test='#session.b_usuario.idPerfil == 4'>
                            <h6> <font color="#87A1B8">Tecnico de Imagenes</font> </h6> <br>
                    </s:if>
                    <s:if test='#session.b_usuario.idPerfil == 5'>
                            <h6> <font color="#87A1B8">Medico Tratante</font> </h6> <br>
                    </s:if>
                    <s:if test='#session.b_usuario.idPerfil == 6'>
                            <h6> <font color="#87A1B8">Medico Especialista</font> </h6> <br>
                    </s:if>
                    
			</TD>
		</tr>
</TABLE>
</h2>
	<table align="center">
		<tr>
			<td >  
				<TABLE width="100%" border="0" height="100%">
		  <TR><td>&nbsp;</td></TR>
          <TR>
		  	   <TD>
		  	   <div>
					<ul id="navlist">
						<li><A class=SiteLinkBold href="a_principal">Principal</A></li>
				</ul>
				</div>
	           </TD>
		  </TR> 
		   <TR><td>&nbsp;</td></TR>
		   <s:iterator value="#session.b_menu">
		   	 <TR> 
		  	   <TD>
		  	   <div>
					<ul id="navlist">
						<li>
						<s:if test="idFuncionalidad == 9">
						<s:url id="cargarDatos" action="buscarDatosPaciente">
							<s:param name="dniBuscado">
						 		<s:property value="#session.b_usuario.dni"/>
							</s:param>
						</s:url>
						<s:a href="%{cargarDatos}" id="current"><s:property value="descripcion"/></s:a>
						</s:if>
						<s:else>
						<A class=SiteLinkBold href="<s:property value="enlace"/>" id="current"><s:property value="descripcion"/></A>
						</s:else>
						</li>
				</ul>
				</div>
	           </TD>
		  </TR>
		   </s:iterator>

		  <TR><td>&nbsp;</td></TR>
		  <TR>
			    <TD>
			    <div>
					<ul id="navlist">
						<li>
						<A class="SiteLinkBold" HREF="LogueoSistema.jsp">Salir</A>
						</li>
				</ul>
				</div>	
				</TD>
		  </TR>
</TABLE>
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
					    	title="%{titulo}">
					     <!--  Usuario Registrado con Exito !-->
					     <jsp:include page="/Seguridad/UsuarioRegistrado-result.jsp"></jsp:include>
					 </sj:dialog>
				</s:if>
			</td>
		</tr>
	</table>
</body>
</html>