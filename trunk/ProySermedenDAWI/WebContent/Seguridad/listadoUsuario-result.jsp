<%@ taglib uri="/struts-tags" prefix="s" %>
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

<table align="center">
	<tr>
		<td><s:text name="D.N.I."></s:text> </td>
		<td><s:text name="Nombre"></s:text> </td>
		<td><s:text name="A. Paterno"></s:text> </td>
		<td><s:text name="A. Materno"></s:text> </td>
		<td><s:text name="Perfil"></s:text> </td>
		<td><s:text name="Estado"></s:text> </td>
		<td><s:text name="Modificar"></s:text> </td>
		<td><s:text name="Desactivar"></s:text> </td>
	</tr>
	
	<s:iterator value="listadoUsuarios">
		<tr>
			<td><s:property value="dni"/> </td>
			<td><s:property value="nombre"/> </td>
			<td><s:property value="apepat"/> </td>
			<td><s:property value="apemat"/> </td>
			<td><s:property value="idRol"/> </td>
			<td><s:property value="estado"/> </td>
			<td>
				<s:url id="cargaDatos" action="buscarUserxId">					    	
					<s:param name="idBuscar">
						 <s:property value="idPersona"/>
					</s:param>
				</s:url>
						    	
				<s:a href="%{cargaDatos}"> M </s:a>
			</td>
			<td>
				<s:url id="desactivar" action="desactivarUser">
					<s:param name="idBuscar">
						 <s:property value="idPersona"/>
					</s:param>
				</s:url>
				<s:a href="%{desactivar}" onclick="return confirm('¿Seguro que quieres desactivar este usuario?')">D</s:a>
			</td>
		</tr>
	</s:iterator>
	
</table>