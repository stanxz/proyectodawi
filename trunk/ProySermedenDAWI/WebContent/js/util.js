/*METODO FORMULARIO MANTENER USUSARIO*/
function mensajeMostrar(){
	
    $.ajax({
            type: "POST",
            url: "mensajeNombre",
            data: "dato="+$("#txtNick").val(),
            success: function(datos){
                $("#mensaje").html(datos);
            }
    });
}
/*================================*/
/*METODO FORMULARIO MANTENER USUSARIO*/
function AgregarArea(valor,valor2,valor3){
	
    $.ajax({
            type: "POST",
            url: "ajaxarea?txtTimepo="+valor2+"&codRol="+valor3,
            data: "codigoArea="+valor,
            success: function(datos){
                $("#listArea").html(datos);
            }
    });
}
/*================================*/

function AgregarRequi(cod,cant,estado){
	
    $.ajax({
            type: "POST",
            url: "ajaxrequi?cant="+cant+"&est="+estado,
            data: "codigoRequi="+cod,
            success: function(datos){
                $("#listRequi").html(datos);
            }
    });
}


function DetalleProceso(codigo,tipo){

	document.getElementById('codProceso').value=codigo;
    $.ajax({
        type: "POST",
        url: "ajaxDetalleProc",
        data: "codigoPro="+codigo,
        success: function(datos){
            $("#detalleProc").html(datos);
        }
    });	
}

function AgregarAreaUpdate(){
	
	var codigo = document.getElementById('codProceso').value;
	var tiempUpdate = document.getElementById('tiempUpdate').value;
	alert(codigo+"--"+tiempUpdate);
    $.ajax({
        type: "POST",
        url: "ajaxInsertArea?codigoPro="+codigo,
        data: "tiempUpdate="+tiempUpdate+"&"+"codArea="+$("#codigoArea").val()+"&"+"codRol="+$("#codigoRol").val(),
        success: function(datos){
            $("#detalleProc").html(datos);
        }
    });
}

function updateNOrden(codArea,pro,tiempo,codrol){
	//alert(codArea+"[--]"+pro+"[--]"+tiempo+"[--]"+codrol);
    $.ajax({
        type: "POST",
        url: "ajaxUpdateTiempo?codArea="+codArea,
        data: "codigoPro="+pro+"&"+"tiempUpdate="+tiempo+"&"+"codRol="+codrol,
        success: function(datos){
            $("#vacio").html(datos);
        }
    });
}

function updateDiasProc(codArea,pro,dias,codrol){
	
    $.ajax({
        type: "POST",
        url: "ajaxTiempoProc?codArea="+codArea,
        data: "codigoPro="+pro+"&"+"DiasUpdate="+dias+"&"+"codRol="+codrol,
        success: function(datos){
            $("#vacio").html(datos);
        }
    });
	
}
 
function eliminarDetalle(codArea,pro,codrol){
	
	//alert(codArea+"[--]"+pro+"[--]"+codrol);
	
    $.ajax({
        type: "POST",
        url: "ajaxEliminarDetalle?codArea="+codArea,
        data: "codigoPro="+pro+"&"+"codRol="+codrol,
        success: function(datos){
            $("#detalleProc").html(datos);
        }
    });
	
}

function updateCantRequi(codRequi,pro,cantidad){
	
    $.ajax({
        type: "POST",
        url: "ajaxCantidad?codRequi="+codRequi,
        data: "codigoPro="+pro+"&"+"cantidad="+cantidad,
        success: function(datos){
            $("#vacio").html(datos);
        }
    });
}

function eliminarDetalleRequi(codRequi,pro){
	
    $.ajax({
        type: "POST",
        url: "ajaxEliminarDetalleRequi?codRequi="+codRequi,
        data: "codigoPro="+pro,
        success: function(datos){
            $("#detalleProc").html(datos);
        }
    });
	
}


function setCodigo(codigo){
	document.getElementById('txtdescripcion').value=codigo;
}

function loadRequisitosExpediente(codTramite){

    $.ajax({
        type: "POST",
        url: "ajaxListarRequisitos",
        data: "codTramite="+codTramite,
        success: function(datos){
            $("#Requisitos").html(datos);
        }
    });
	
	
}
	

