<!-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table id="EstiloTable" border="3">
<tr><td>dsdfsfsfsfsfs</td></tr>

</table>
</body>
</html> -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento Usuarios</title>



    <link rel="stylesheet" href="Tema/development-bundle/themes/cupertino/jquery.ui.all.css">
	<script src="Tema/development-bundle/jquery-1.4.4.js"></script>
	<script src="Tema/development-bundle/ui/jquery.ui.core.js"></script>
	<script src="Tema/development-bundle/ui/jquery.ui.widget.js"></script>
	<script src="Tema/development-bundle/ui/jquery.ui.mouse.js"></script>
	<script src="Tema/development-bundle/ui/jquery.ui.button.js"></script>
    <script src="Tema/development-bundle/ui/jquery.ui.button.js"></script>
	<script src="Tema/development-bundle/ui/jquery.ui.draggable.js"></script>
	<script src="Tema/development-bundle/ui/jquery.ui.position.js"></script>	
	<script src="Tema/development-bundle/ui/jquery.ui.dialog.js"></script>
	<script src="Tema/development-bundle/ui/jquery.ui.tabs.js"></script>
	<script src="Tema/development-bundle/ui/jquery.ui.button.js"></script>
    <script src="Tema/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>


	<style type="text/css" title="currentStyle">
			@import "css/demo_page.css";
			@import "css/demo_table_jui2.css";
	</style>
	
	<script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
	
	<link rel="stylesheet" href="Tema/development-bundle/demos/demos.css">
	<script type="text/javascript" src="js/util.js"></script>

  <script type="text/javascript">
	$(function() {

		 $("#commentForm").validate();
		
		$( "#NuevoUsu" ).tabs();
		$( "button, input:submit", ".btn" ).button();
		
		$( "#btnBusTrabaja" ).click(function() {
			$( "#dialog" ).dialog( "open" );
			return false;
		});

		$( "#btnAcepEmp" ).click(function() {
			
		 	var i;
		 	var c=1;
		 	var valor;

		


		 		for (i=0;i<document.fordiv.rd.length;i++){ 
			      	 if (document.fordiv.rd[i].checked){
			      		 	c=55;
			      		 	valor=document.fordiv.rd[i].value;
				      	 }
			         	
			   	} 
			   	if(c!=55){
				   	alert('Tiene que Seleccionar a un Empleado');
				 }else{

					 	document.getElementById('txtCodEmple').value=valor;
					    $( "#dialog" ).dialog( "close" );
						return false;
					 }


			
		   
			
			
		});
		$( "#btnCanceEmp" ).click(function() {
			$( "#dialog" ).dialog( "close" );
			return false;
			
		});
		

		

		
		$( "#dialog" ).dialog({
			autoOpen: false,
			show: "blind",
			hide: "explode",
			minHeight: 100,
			minWidth: 500,		
			modal: true
		
		} );


		
		$(document).ready(function() {			
			oTable = $('#example2').dataTable({
				
				"bJQueryUI": true,
				"bFilter":true,
				"sPaginationType": "full_numbers",
				"oLanguage": {
				"oPaginate":  {
						"sFirst":    "<<",
						"sPrevious": "<",
						"sNext":     ">",
						"sLast":     ">>"
					},
				"sInfo": "Cantidad de Empleados _TOTAL_"
				}		
			});				
		} );

		
	});
	
	</script>
	
	
	
	<script type="text/javascript">
		function confirmar(pass1){
			var c = document.getElementById('c').value;
			if (c!=pass1){
				document.getElementById('confirmar').innerHTML='Correjir Contraseña';
				document.getElementById('confirmar').style.color= 'red';
				}
			else{
				document.getElementById('confirmar').innerHTML='Contraseña correcta';
				document.getElementById('confirmar').style.color= 'green';
				}
		}
		function confirmar2(pass2){
			var b = document.getElementById('c').value;
			if (c!=pass2){				
				document.getElementById('confirmar').innerHTML='Correjir Contraseña';
				document.getElementById('confirmar').style.color= 'red';
				}
			else{
				document.getElementById('confirmar').innerHTML='Contraseña correcta';
				document.getElementById('confirmar').style.color= 'green';
				}
		}
		
	</script>

</head>
<body >
<form action="insertaUsuario" method="get" id="commentForm" name="form">
<table width="550" height="270" border="0">
  <tr valign="top">
    <td width="550">
    
    <div class="demo">
     <div id="NuevoUsu">
					 <ul>
					 <li><a href="#tabs-1" >Nuevo Usuario</a></li>
					</ul>
					<div id="tabs-1">  
                    
                    <table width="450" border="0">
  <tr>
    <td align="left"><strong>Usuario:</strong></td>
    <td colspan="2" align="left"><label>
    <input class= "required" type="text" id="txtNick" name="usuario.codUsu"   onkeyup="javascript:mensajeMostrar();"/>
    </label></td>
    <td><div id="mensaje"></div>
    </td>
    </tr>
  <tr>
    <td align="left"><strong>Codigo Trabajador:</strong></td>
    <td colspan="2" align="left"><label>
      <input class= "required" type="text" id="txtCodEmple" name="usuario.codEmple" />
    </label>
     
    </td>
      <td align="left"> 
    	  <div id="btnBusTrabaja" class="btn" align="left"> 
        		
        		   <div >
        		     <input type="submit" value="..."/>
      		     </div>
         </div> 
      </td>
  </tr>
  <tr>
    <td align="left"><strong >Contraseña</strong></td>
    <td width="144" align="left"><label>
      <input id="c" class= "required" type="password" name="usuario.clave" onkeyup="confirmar2(this.value);"/>
    </label></td>
  </tr>
    <tr>
    <td align="left"><strong >Confirmar Contraseña</strong></td>
    <td colspan="2"  width="144" align="left">
      <input id="b" class= "required" type="password"  onkeyup="confirmar(this.value);"/></td>
   <td><div id="confirmar" > </div></td>
    
  </tr>
   <tr>
  <td align="left"><strong >Area:</strong></td>
    <td colspan="2" align="left"><label>
    
    <select name="usuario.codArea">
		<s:iterator value="lareas">
		<option value="<s:property value="codArea"></s:property>"><s:property value="descArea" ></s:property></option>
		</s:iterator>
     </select>
    </label></td>
  </tr>
  <tr>
    <td align="left"><strong >Perfil:</strong></td>
    <td colspan="2" align="left"><label>
    
    <select name="usuario.codRol">
		<s:iterator value="lrol">
		<option value="<s:property value="codRol"></s:property>"><s:property value="descRol" ></s:property></option>
		</s:iterator>
     </select>
    </label></td>
  </tr>
  <tr>
    <td align="left"><strong >Estado</strong></td>
    <td colspan="2" align="left">
      <select name="usuario.estado">
      <option value="1">Activo</option>
      <option value="2">Inactivo</option>
    </select></td>
  </tr>
  <tr>
    <td>
    
     <div id="btnAceptar" class="btn" align="right"> 
        		
        		   <div >
        		     <input type="submit" value="Aceptar"/>
      		     </div>
      </div>  
    
    </td>
    <td colspan="2" align="left">
    
             <div id="btnCancelar" class="btn"> 
        		
        		  <div >
        		     <input type="submit" value="Cancelar"/>
      		     </div>
              </div>  
    
    </td>
  </tr>
</table>

                    
                    </div>
                </div>
                </div> 
    </td>
  </tr>
</table>

</form>

<div id="dialog" title="Seleccionar Empleado">
<br>
<center>
<form action="" name="fordiv">
<table border="0" cellpadding="0" cellspacing="0" class="display" id="example2">
	<thead>
		<tr>
			<th width="40%"><div align="center">Nombre</div></th>
			<th width="40%"><div align="center">Apellidos</div></th>
			<th width="40%"><div align="center">DNI</div></th>
			<th width="40%"><div align="center">&nbsp;</div></th>		
		</tr>
	</thead>

	<tbody>
			<s:iterator value="lemp">
		<tr>
			<td><s:property value="nombres" ></s:property></td>
			<td><s:property value="apellidos" ></s:property></td>
			<td align="center"><s:property value="dni" ></s:property></td>
			<td align="center"><input type="radio" name="rd" value="<s:property value="codigo" ></s:property>"></td>
		</tr>	
		 </s:iterator>
		 
	</tbody>	
</table> 

	<table>
			<tr>
			<td>
			  <div id="btnAcepEmp" class="btn"> 
        		
        		  <div >
        		     <input type="button" value="Aceptar" class="btn" />
      		     </div>
              </div>  
			</td>
			<td>
			  <div id="btnCanceEmp" class="btn"> 
        		
        		  <div >
        		     <input type="button" value="Cancelar"/>
      		     </div>
              </div>  
			</td>
			
			</tr>


	</table>
	</form>

</center>
</div>






</body>
</html>