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
<link href="css/stylesWeb.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
	<!-- begin #header -->
    <table width="100%;">
    	<tr>
        	<td>
            <div class="logo">
            	<a href="#"><img src="images/logo.png" alt="" width="179" height="77" /></a>Sermeden
            </div>
             </td>
        </tr>
        <tr>
        	<td>
            	<div id="header"></div>
        <div class="mainMenu">
        	<ul>
        <li id="active"><a href="index.jsp">Home</a></li>
                <li><a href="#">Quienes Somos</a></li>
                <li><a href="#"></a></li>
                <li><a href="LogueoSistema.jsp">Intranet</a></li>
                <li><a href="#">Contactenos</a></li>
            </ul>
        </div>          
            </td>
        </tr>
        <tr>
        	<td>
        	<h2>Ingreso al Sistema</h2>
        	<br/><br/><br/><br/><br/><br/>
<form action="logueo" method="post">
	<table align="center"">
  	<tr valign="top">
  	<td>
	<div class="ui-tabs ui-widget ui-corner-all" 
	style="border: 3px solid #dddddd; background: #f2f5f7 url(./images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
		<br>
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
			</tr>
			
			<tr>
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
	<br/><br/><br/><br/><br/><br/>
            </td>
        </tr>
        <tr>
        	<td>
        	<div id="footer">
    	  <p>
        	Copyright &copy; 2011. Designed by <a href="http://www.facebookpagetemplates.com" title="Facebook Templates">Rodrigo Berrospi - Rhandy Muguruza</a><br />
            <a title="This page validates as XHTML 1.0 Strict" href="#" class="footerLink"><abbr title="eXtensible HyperText Markup Language">Diseño de Aplicaciones Web I</abbr></a> | 
            <a title="This page validates as CSS" href="#" class="footerLink"><abbr title="Cascading Style Sheets">5to ciclo CIBERTEC</abbr></a>
          </p>
           </div>
        	</td>
        </tr>
    </table>
    </div>
</body>
</html>