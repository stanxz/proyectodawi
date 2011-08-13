
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/tablas.css" />
<title>Insert title here</title>
<sj:head jqueryui="true"/>
<link href="./css/miEstilo.css" rel="stylesheet" type="text/css" />
<link href="./css/stylesWeb.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.diente{
                position: absolute;
                cursor: pointer;
}
</style>
	   <link rel="stylesheet" href="./css/jquery.ui.all.css">
	   <script type="text/javascript" src="./js/jquery-1.6.2.js"></script>
       <script type="text/javascript" src="./js/util.js"></script>
	   <script type="text/javascript" src="./js/jquery.ui.core.js"></script>
	   <script type="text/javascript" src="./js/jquery.ui.widget.js"></script>
	   <script type="text/javascript" src="./js/jquery.ui.button.js"></script>
	   
 <script type="text/javascript">
    
 	var cadena = [];
    
            $(function(){
			
                var color = 'red';
				
				$( "#radio" ).buttonset();
				
				$( "#button" ).buttonset();
      
				//Original
                $('input[name="radios"]').click(function(){
                    color = $(this).attr('value');
                });
                
				
				/*Agrege esto*/
				/*$("div").click(function () {
 					 color = $(this).css("background-color");
					 alert($(this).attr("class"));
					 alert($(this).attr("id"));
                });*/

	
                $('#map area').click(function(){
											  
					var id = $(this).attr('id');	 
                    var coords = $(this).attr('coords').split(',');
                    var DIFERENCIA = 8;
                    
                    var left = parseInt(coords[0]) + DIFERENCIA + 552;
                    var top = parseInt(coords[1]) + DIFERENCIA + 98;
					
                    
                    $('body').append($('<div/>')
					.attr( 'id',id )		 	
                    .css('left', left + 'px')
                    .css('top',  top  + 'px')
                    .css('width',  (coords[2] - coords[0])+'px')
                    .css('height', (coords[3] - coords[1])+'px')
                    .css('background',color)
                    .addClass('diente')
					);
					
                    return false; 
                });
                
				/* class = colores*/
                $('div').live('click',function(){
					if($(this).attr('class') != "ui-buttonset" &&
							$(this).attr('class') != "menu" &&
							$(this).attr('class') != "footer" &&
							$(this).attr('class') != "logo" &&
							$(this).attr('id') != "button"){ 
                    $(this).remove();
					}
                });
                
                $('#submit').click(function(){
                	
                	cadena = [];
        			
        			var cont=0;
                  
                   $('div').each(function(){     
												 
          
					if($(this).attr('id') != "radio" &&
							$(this).attr('id') != "footer" &&
							$(this).attr('id') != "menu" &&
							$(this).attr('id') != "logo" &&
							$(this).attr('id') != "button"){
					/*alert("Id -->" + $(this).attr('id')+ "\n" +
						   "Left -->" + $(this).css('left')+ "\n" +
						   "Top -->" + $(this).css('top')+ "\n" +
						   "Width -->" + $(this).css('width')+ "\n" +
						   "Height -->" + $(this).css('height')+ "\n" +
						   $(this).css('background-color'));*/
					 /*cadena[cont] = $(this).attr('id')+ "," +
					          $(this).css('left')+  "," +
					          $(this).css('top')+ "," +
					  	      $(this).css('width')+ "," +
					          $(this).css('height');*/
					          cadena[cont] = "Hola";
					 cont++;
					 alert(cont);
					  }
                   });
                   
                   $.post('registrarOdontograma',{'jsonData':cadena});
                   
                });
             
            });
        </script>

</head>
<body>
<img src="./images/image4.jpeg" alt="imagen" width="391" height="327" border="0" usemap="#map"/>
          <map name="map" id="map">

			<!-- Cuadrante II-->
            <area id="d55U"  shape="rect" coords="31,126,54,133" alt="arriba"/>
            <area id="d55L" shape="rect" coords="31,132,37,145"  alt="izquierda" />
			<area id="d55C" shape="rect" coords="36,132,49,145"  alt="centro" />
            <area id="d55B" shape="rect" coords="31,144,54,150"  alt="abajo" />
            <area id="d55R" shape="rect" coords="48,132,54,145"  alt="derecha" />

            <area id="d54U"  shape="rect" coords="64,126,87,133"  alt="arriba" />
            <area id="d54L" shape="rect" coords="64,132,70,145" alt="izquierda" />
			<area id="d54C" shape="rect" coords="69,132,82,145"  alt="centro" />
            <area id="d54B" shape="rect" coords="64,144,87,150" alt="abajo" />
            <area id="d54R" shape="rect" coords="81,132,87,145" alt="derecha" />
			
			<area id="d53U"  shape="rect" coords="95,126,118,133" alt="arriba" />
            <area id="d53L" shape="rect" coords="95,132,101,145" alt="izquierda" />
			<area id="d53C" shape="rect" coords="100,132,113,145"  alt="centro" />
            <area id="d53B" shape="rect" coords="95,144,118,150" alt="abajo" />
            <area id="d53R" shape="rect" coords="112,132,118,145" alt="derecha" />
			
			<area id="d52U"  shape="rect" coords="127,126,150,133"  alt="arriba" />
            <area id="d52L" shape="rect" coords="127,132,133,145" alt="izquierda" />
			<area id="d52C" shape="rect" coords="132,132,145,145"  alt="centro" />
            <area id="d52B" shape="rect" coords="127,144,150,150" alt="abajo" />
            <area id="d52R" shape="rect" coords="144,132,150,145" alt="derecha" />
			
			<area id="d51U"  shape="rect" coords="159,126,182,133"  alt="arriba" />
            <area id="d51L" shape="rect" coords="159,132,165,145" alt="izquierda" />
			<area id="d51C" shape="rect" coords="164,132,177,145"  alt="centro" />
            <area id="d51B" shape="rect" coords="159,144,182,150" alt="abajo" />
            <area id="d51R" shape="rect" coords="176,132,182,145" alt="derecha" />

			<!-- Cuadrante I-->
            <area id="d61U"  shape="rect" coords="204,126,227,133" alt="arriba" />
            <area id="d61L" shape="rect" coords="204,132,210,145" alt="izquierda" />
			<area id="d61C" shape="rect" coords="209,132,222,145"  alt="centro" />
            <area id="d61B" shape="rect" coords="204,144,227,150" alt="abajo" />
            <area id="d61R" shape="rect" coords="221,132,227,145" alt="derecha" />
            
            <area id="d62U"  shape="rect" coords="238,126,261,133"  alt="arriba" />
            <area id="d62L" shape="rect" coords="238,132,244,145" alt="izquierda" />
			<area id="d62C" shape="rect" coords="243,132,256,145"  alt="centro" />
            <area id="d62B" shape="rect" coords="238,144,261,150" alt="abajo" />
            <area id="d62R" shape="rect" coords="255,132,261,145" alt="derecha" />
			
			<area id="d63U"  shape="rect" coords="270,126,293,133" href="" alt="arriba" />
            <area id="d63L" shape="rect" coords="270,132,276,145" alt="izquierda" />
			<area id="d63C" shape="rect" coords="275,132,288,145"  alt="centro" />
            <area id="d63B" shape="rect" coords="270,144,293,150" alt="abajo" />
            <area id="d63R" shape="rect" coords="287,132,293,145" alt="derecha" />
			
			<area id="d64U"  shape="rect" coords="302,126,325,133"  alt="arriba" />
            <area id="d64L" shape="rect" coords="302,132,308,145" alt="izquierda" />
			<area id="d64C" shape="rect" coords="307,132,320,145"  alt="centro" />
            <area id="d64B" shape="rect" coords="302,144,325,150" alt="abajo" />
            <area id="d64R" shape="rect" coords="319,132,325,145" alt="derecha" />
			
			<area id="d65U"  shape="rect" coords="334,126,357,133"  alt="arriba" />
            <area id="d65L" shape="rect" coords="334,132,340,145" alt="izquierda" />
			<area id="d65C" shape="rect" coords="339,132,352,145"  alt="centro" />
            <area id="d65B" shape="rect" coords="334,144,357,150" alt="abajo" />
            <area id="d65R" shape="rect" coords="351,132,357,145" alt="derecha" />
			
			
			<!-- Cuadrante III-->
			<area id="d85U"  shape="rect" coords="31,174,54,181"  alt="arriba" />
            <area id="d85L" shape="rect" coords="31,180,37,193"  alt="izquierda" />
			<area id="d85C" shape="rect" coords="36,180,49,193"  alt="centro" />
            <area id="d85B" shape="rect" coords="31,192,54,198" alt="abajo" />
            <area id="d85R" shape="rect" coords="48,180,54,193"  alt="derecha" />
			
			
			<area id="d84U"  shape="rect" coords="64,174,87,181"  alt="arriba" />
            <area id="d84L" shape="rect" coords="64,180,70,193" alt="izquierda" />
			<area id="d84C" shape="rect" coords="69,180,82,193" alt="centro" />
            <area id="d84B" shape="rect" coords="64,192,87,198" alt="abajo" />
            <area id="d84R" shape="rect" coords="81,180,87,193" alt="derecha" />
			
			<area id="d83U"  shape="rect" coords="95,174,118,181"  alt="arriba" />
            <area id="d83L" shape="rect" coords="95,180,101,193" alt="izquierda" />
			<area id="d83C" shape="rect" coords="100,180,113,193"  alt="centro" />
            <area id="d83B" shape="rect" coords="95,192,118,198" alt="abajo" />
            <area id="d83R" shape="rect" coords="112,180,118,193" alt="derecha" />
			
			<area id="d82U"  shape="rect" coords="127,174,150,181" alt="arriba" />
            <area id="d82L" shape="rect" coords="127,180,133,193" alt="izquierda" />
			<area id="d82C" shape="rect" coords="132,180,145,193" alt="centro" />
            <area id="d82B" shape="rect" coords="127,192,150,198" alt="abajo" />
            <area id="d82R" shape="rect" coords="144,180,150,193" alt="derecha" />
			
			
			<area id="d81U"  shape="rect" coords="159,174,182,181" alt="arriba" />
            <area id="d81L" shape="rect" coords="159,180,165,193" alt="izquierda" />
			<area id="d81C" shape="rect" coords="164,180,177,193" alt="centro" />
            <area id="d81B" shape="rect" coords="159,192,182,198" alt="abajo" />
            <area id="d81R" shape="rect" coords="176,180,182,193" alt="derecha" />
			
			
			<!-- Cuadrante IV-->
			<area id="d71U"  shape="rect" coords="204,174,227,181"  alt="arriba" />
            <area id="d71L" shape="rect" coords="204,180,210,193"  alt="izquierda" />
		    <area id="d71C" shape="rect" coords="209,180,222,193"  alt="centro" />
            <area id="d71B" shape="rect" coords="204,192,227,198"  alt="abajo" />
            <area id="d71R" shape="rect" coords="221,180,227,193"  alt="derecha" />
			
			
			<area id="d72U"  shape="rect" coords="238,174,261,181" href="" alt="arriba" />
            <area id="d72L" shape="rect" coords="238,180,244,193" alt="izquierda" />
			<area id="d72C" shape="rect" coords="243,180,256,193" href="" alt="centro" />
            <area id="d72B" shape="rect" coords="238,192,261,198" alt="abajo" />
            <area id="d72R" shape="rect" coords="255,180,261,193" alt="derecha" />
			
			<area id="d73U"  shape="rect" coords="270,174,293,181"  alt="arriba" />
            <area id="d73L" shape="rect" coords="270,180,276,193" alt="izquierda" />
			<area id="d73C" shape="rect" coords="275,180,288,193" alt="centro" />
            <area id="d73B" shape="rect" coords="270,192,293,198" alt="abajo" />
            <area id="d73R" shape="rect" coords="287,180,293,193" alt="derecha" />
			
			<area id="d74U"  shape="rect" coords="302,174,325,181" alt="arriba" />
            <area id="d74L" shape="rect" coords="302,180,308,193" alt="izquierda" />
			<area id="d74C" shape="rect" coords="307,180,320,193"  alt="centro" />
            <area id="d74B" shape="rect" coords="302,192,325,198" alt="abajo" />
            <area id="d74R" shape="rect" coords="319,180,325,193" alt="derecha" />
			
			
			<area id="d75U"  shape="rect" coords="334,174,357,181" alt="arriba" />
            <area id="d75L" shape="rect" coords="334,180,340,193" alt="izquierda" />
			<area id="d75C" shape="rect" coords="339,180,352,193" alt="centro" />
            <area id="d75B" shape="rect" coords="334,192,357,198" alt="abajo" />
            <area id="d75R" shape="rect" coords="351,180,357,193" alt="derecha" />
    </map>
    <br>
    <br>
    <br>
    	<div  id="radio">
        <input id="radio1" type="radio" name="radios" value="red" checked="checked"/>
        <label for="radio1">Rojo</label>
        <input id="radio2" type="radio" name="radios" value="green" />
        <label for="radio2">Verde</label>
        <input id="radio3" type="radio" name="radios" value="blue" />
        <label for="radio3">Azul</label>
	</div>
	<br>
	<p>
	<div id="button">
            <sj:submit id="submit" 
            		   value="Generar" 
                       onClickTopics="onclick"/>
	</div>	
    </p>	
</body>
</html>