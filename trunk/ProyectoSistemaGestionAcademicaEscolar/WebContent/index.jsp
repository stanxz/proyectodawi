
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:h="http://java.sun.com/jsf/html"
	  xmlns:f="http://java.sun.com/jsf/core">
<h:head>
	<sj:head jqueryui="true" jquerytheme="cupertino"/>	
	<link href="css/misEstilos1.css" type="text/css" rel="stylesheet" />
	<link href="css/misEstilos2.css" type="text/css" rel="stylesheet" />
</h:head>
<h:body style="background-color: #A8C2D3;">
	<h1 align="center">I.E.P &quot;SAN CARLOS&quot;</h1>
	 <sj:tabbedpanel id="localtabs" animate="true" collapsible="true">
      			<sj:tab id="tab1" target="tone" label="Inicio" />
      			<sj:tab id="tab2" target="ttwo" label="Misión"/>
      			<sj:tab id="tab3" target="tthree" label="Visión"/>
      			<sj:tab id="tab4" target="tfour" label="Contáctenos"/>
      			<sj:tab id="tab5" target="tfive" label="Intranet"/>
     			 <div id="tone">
     			 	 <s:form>
					 </s:form>
     			</div>
     			 <div id="ttwo">
     			 	<s:form>
     			 		
     			 	</s:form>
     			 </div>
      			 <div id="tthree">
      			    <s:form>
      			    	
      			    </s:form>
      			 </div>
      			 <div id="tfour">
      			 	<s:form>
      			 	</s:form>
      			 </div>
      			  <div id="tfive">
      			  <br></br><br></br><br></br><br></br><br></br><br></br>
      			  <br></br><br></br><br></br><br></br><br></br><br></br>
      			  <br></br><br></br><br></br><br></br><br></br>
    					   <div id="login" >
    							<h:form>
    								<table>
    								<tr>
    									<td><s:textfield label="Usuario    " name="" labelSeparator=" "/></td>
    								</tr>
    								<tr>
    									<td><s:textfield label="Contraseña " name="" labelSeparator=" "/></td>
    								</tr>
    								<tr>
    									<td>
    									<sj:submit value="Ingresar" button="true" />
    									</td>
    								</tr>
    								</table>
    								
    							</h:form>
    						</div>
      			 </div>
    		</sj:tabbedpanel>	
    		
    		<h:form>
    		<h:inputText label="Usuario"/>
    		</h:form>

</h:body>
</html>

<!-- http://www.java2s.com/Code/JavaScript/Ext-JS/formscancontainTabPanels.htm -->
<!--  http://code.google.com/p/struts2-jquery/wiki/HeadTag -->