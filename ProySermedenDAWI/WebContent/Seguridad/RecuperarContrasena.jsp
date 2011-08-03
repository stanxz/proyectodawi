<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recuperar contraseña</title>
<link href="../css/miEstilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h2>Recuperar Contraseña</h2>
	<form action="RecuperaPassAction">
<table align="center">
  <tr valign="top">
    <td>
	<div class="ui-tabs ui-widget ui-corner-all"
	style="border: 1px solid #dddddd; background: #f2f5f7 url(../images/ui-bg_highlight-hard_100_f2f5f7_1x100.png) 50% top repeat-x; color: #362b36;">
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
				<div>
				<s:submit value="Recuperar" 
				style="font-weight: bold;color: blue;height: 30px;width: 100px;text-align: center;"></s:submit>
				</div> 
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
</body>
</html>