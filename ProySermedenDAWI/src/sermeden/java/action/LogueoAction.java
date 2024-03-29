package sermeden.java.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/*import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;*/



import sermeden.java.bean.MenuDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.MenuService_I;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogueoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static private Logger log = Logger.getLogger(LogueoAction.class);
	private String mensaje;
	private String mensaje2;
	private UsuarioDTO elusuario;
	private List<MenuDTO> listadoMenu;
	public Map<String, Object> lasession;
	
    private static String fileProperties = System.getProperty("user.dir")+"\\log4j.properties";
  //  PropertyConfigurator.configure(System.getProperty("user.dir")+"\\log4j.properties");

    
	//private static Logger log = Logger.getLogger(LogueoAction.class);
	
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	public String getMensaje2() {
		return mensaje2;
	}
	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
	}
	public UsuarioDTO getElusuario() {
		return elusuario;
	}
	public void setElusuario(UsuarioDTO elusuario) {
		this.elusuario = elusuario;
	}

	public List<MenuDTO> getListadoMenu() {
		return listadoMenu;
	}
	public void setListadoMenu(List<MenuDTO> listadoMenu) {
		this.listadoMenu = listadoMenu;
	}
	
	
	public Map<String, Object> getLasession() {
		return lasession;
	}
	public void setLasession(Map<String, Object> lasession) {
		this.lasession = lasession;
	}
	
	public String execute(){

//log.debug("Holaaaaaaaaaaaaaaaaa");
		String vista="exito";
		
		
		log.debug("Dentro del primer Action "+
				"con Struts 2");
		
		log.debug("Usuario :" + elusuario.getUser());
		log.debug("Clave : " + elusuario.getContrasena());
		
		UsuarioService_I usuarioService = PaqueteBusinessDelegate.getUsuarioService();
		
		MenuService_I menuService = PaqueteBusinessDelegate.getMenuService();
		
		
		//Creamos el objeto temporal clienteAux
		UsuarioDTO clienteAux = new UsuarioDTO();
		
		/*clienteAux.setUser(elusuario.getUser());
		clienteAux.setContrasena(elusuario.getContrasena());*/

		try {
			
			clienteAux = usuarioService.validarUsuario(elusuario);
			
			//Si encontro el cliente en la BD
			if(clienteAux!=null){
				listadoMenu = menuService.obtieneMenu(clienteAux);
				
				log.debug("para: "+clienteAux.getNombre()+" "+clienteAux.getApepat());
				log.debug(clienteAux.getUser());
				log.debug(clienteAux.getContrasena());
				log.debug("listadoMenu cantidad de items: "+listadoMenu.size());
				
				for (MenuDTO menu : listadoMenu) {
					log.debug("menu.getIdFuncionalidad(): "+menu.getIdFuncionalidad());
					log.debug("menu.getDescripcion(): "+menu.getDescripcion());
					log.debug("menu.getEnlace(): "+menu.getEnlace());
				}
				
				/*if(clienteAux.getContrasena().equals(elusuario.getContrasena())){*/
					
					//Referenciando a la session con Struts 2
					//Map<String, Object> lasession=
						lasession=
						ActionContext.getContext().getSession();
					
					lasession.put("b_usuario", clienteAux);
					
					lasession.put("b_menu",listadoMenu);
					
				/*}else{
					vista="error";
					mensaje = "Lo sentimos la clave no es correcta";
				}*/
				
			}else{
				vista="error";
				mensaje2 = "Usuario o clave inválidos";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vista;	
	
	}
	
	
	
}
