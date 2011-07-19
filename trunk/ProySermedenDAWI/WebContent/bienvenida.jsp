<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head jqueryui="true"/>
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
				<!--  <a href="NuevoUsuarioAction"  >
				  Nuevo Usuario
				</a>
			</td>
		</tr>
		<tr>
			<td >  
				<a href="ListadoAction"  >
				  Modificar Usuario
				</a>
				-->
			</td>
		</tr>
	</table>
</body>
</html>