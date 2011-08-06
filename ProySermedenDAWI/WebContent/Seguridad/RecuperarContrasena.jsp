<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recuperar contraseña</title>
<sj:head jqueryui="true"/>
<link href="./css/miEstilo.css" rel="stylesheet" type="text/css" />
<link href="./css/stylesWeb.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
	<!-- begin #header -->
    <table width="100%;">
    	<tr>
        	<td>
            <div class="logo">
            	<a href="#"><img src="./images/logo.png" alt="" width="179" height="77" /></a>Sermeden
            </div>
             </td>
        </tr>
        <tr>
        	<td>
            	<div id="header"></div>
        <div class="mainMenu">
        	<ul>
        <li id="active"><a href="../index.jsp">Home</a></li>
                <li><a href="#">xxxxxxx</a></li>
                <li><a href="#">xxxxxxx</a></li>
                <li><a href="../LogueoSistema.jsp">Intranet</a></li>
                <li><a href="#">Contactenos</a></li>
            </ul>
        </div>          
            </td>
        </tr>
         <tr>
        	<td>
          <h2>Recuperar Contraseña</h2>
          <br/><br/><br/><br/><br/><br/>
<form action="RecuperaPassAction" method="post">
<table align="center">
  <tr valign="top">
    <td>
	<div class="ui-tabs ui-widget ui-corner-all"
	style="border: 3px solid #dddddd; background: #f2f5f7 url(./images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
		<table align="center">
			<tr>
				<td colspan="2" style="font-weight: bold;">
				<s:label >Al darle click a recuperar, se enviará un mail al correo  registrado</s:label>
				</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="center">
					<s:label >Ingrese su DNI:</s:label>
				</td>
				<td align="left">
					<s:textfield name="dniBuscado"></s:textfield>
				</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td colspan="2" align="center">
				<sj:submit value="Recuperar" button="true"/>
			</td>
			</tr>
			<tr>
				<td colspan="2">
					<s:property value="mensaje"/>
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
        	Copyright &copy; 2011. Designed by <a href="http://www.facebookpagetemplates.com" title="Facebook Templates">XXXXXXXX</a><br />
            <a title="This page validates as XHTML 1.0 Strict" href="#" class="footerLink"><abbr title="eXtensible HyperText Markup Language">XHTML</abbr></a> | 
            <a title="This page validates as CSS" href="#" class="footerLink"><abbr title="Cascading Style Sheets">CSS</abbr></a>
          </p>
           </div>
        	</td>
        </tr>
    </table>
    </div>
    <div class="allContent">
        <!-- begin #sidebar1 -->
</div>
</body>
</html>