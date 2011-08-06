<%@ taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="./css/tablas.css" />
<!--  <table align="center">
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
<table class="lista">
	<tr>
		<th><s:text name="Dia"></s:text> </th>
		<th><s:text name="Hora Inicio"></s:text> </th>
		<th><s:text name="Hora Fin"></s:text> </th>
		<th><s:text name="Medico Tratante"></s:text> </th>
	</tr>
	
	<s:iterator value="listadoTurnos">
		<tr>
			<td align="center"><s:property value="Dia"/> </td>
			<td align="center"><s:property value="HoraInicio"/> </td>
			<td align="center"><s:property value="HoraFin"/> </td>
			<td align="center"><s:property value="ncompleto"/> </td>
		</tr>
	</s:iterator>
	
</table>