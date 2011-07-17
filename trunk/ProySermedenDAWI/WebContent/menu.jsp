<%@ taglib uri="/struts-tags" prefix="s" %>
<link href="css/menu.css" rel="stylesheet" type="text/css" />


<TABLE width="100%" border="0">

		  <TR><td>&nbsp;</td></TR>
		  <TR>
		  	   <TD>
		  	   <div>
					<ul id="navlist">
						<li><A class=SiteLinkBold href="intranetPrincipal.jsp">Principal</A></li>
				</ul>
				</div>
	           </TD>
		  </TR>	
		 		
		   <TR><td>&nbsp;</td></TR>
		   <s:iterator value="#session.b_menu">
		   	 <TR>
		  	   <TD>
		  	   <div>
					<ul id="navlist">
						<li><A class=SiteLinkBold href="<s:property value="enlace"/>" id="current"><s:property value="descripcion"/></A></li>
				</ul>
				</div>
	           </TD>
		  </TR>
		   </s:iterator>

		  <TR><td>&nbsp;</td></TR>
		  <TR>
			    <TD>
			    <div>
					<ul id="navlist">
						<li>
						<A class="SiteLinkBold" HREF="login?metodo=logout">Salir</A>
						</li>
				</ul>
				</div>	
				</TD>
		  </TR>	
		  <TR><td>&nbsp;</td></TR>
		  <TR><td>&nbsp;</td></TR>	
		    <TR>
			    <TD class="TextoMenu">
                  
				</TD>
		  </TR>		  
</TABLE>