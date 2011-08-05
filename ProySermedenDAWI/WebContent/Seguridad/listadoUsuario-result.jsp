<%@ taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="./css/tablas.css" />
<!--  
<table align="center">
	<tr>
		<td>
		Dato Ingresado: <s:property value="filtro"/>
		<br>
		Tipo Criterio: <s:property value="tipocriterio"/>
		<br>
		</td>
	</tr>
</table>
-->
<table class="lista"  >
	<tr>
		<th><s:text name="D.N.I."></s:text> </th>
		<th><s:text name="Nombre"></s:text> </th>
		<th><s:text name="Paterno"></s:text> </th>
		<th><s:text name="Materno"></s:text> </th>
		<th><s:text name="Perfil"></s:text> </th>
		<th><s:text name="Estado"></s:text> </th>
		<th><s:text name="Modificar"></s:text> </th>
		<th><s:text name="Estado"></s:text> </th>
	</tr>
	
	<s:iterator value="listadoUsuarios">
		<tr>
			<td align="center"><s:property value="dni"/> </td>
			<td align="center"><s:property value="nombre"/> </td>
			<td align="center"><s:property value="apepat"/> </td>
			<td align="center"><s:property value="apemat"/> </td>
			<td align="center"><s:property value="idPerfil"/> </td>
			<td align="center"><s:property value="estado"/> </td>
			<td align="center">
				<s:url id="cargaDatos" action="buscarUserxId">					    	
					<s:param name="idBuscar">
						 <s:property value="idPersona"/>
					</s:param>
				</s:url>    	
				<s:a href="%{cargaDatos}"> <img src="images/modificar.gif" border="0"> </s:a>
			</td>
			<td align="center">
				<s:url id="desactivar" action="cambiarEstadoUser">
					<s:param name="idBuscar">
						 <s:property value="idPersona"/>
					</s:param>
					
				</s:url>
				<s:a href="%{desactivar}" onclick="return confirm('¿Seguro que quieres cambiar de estado este usuario?')"><img src="images/estado.png" border="0"></s:a>
			</td>
		</tr>
	</s:iterator>
	
</table>