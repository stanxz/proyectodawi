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
		<td><s:text name="Paterno"></s:text> </td>
		<td><s:text name="Materno"></s:text> </td>
		<td><s:text name="Perfil"></s:text> </td>
		<td><s:text name="Estado"></s:text> </td>
		<td><s:text name="Datos Medicos"></s:text> </td>
	</tr>
	
	<s:iterator value="listadoPacientes">
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
						    	
				<s:a href="%{cargaDatos}">Modificar</s:a>
			</td>
		</tr>
	</s:iterator>
	
</table>