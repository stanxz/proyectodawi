package sermeden.java.action;

import java.util.List;
import java.util.Map;

import sermeden.java.bean.MenuDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.MenuService_I;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogueoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String clave;
	private String mensaje;
	private List<MenuDTO> listadoMenu;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public List<MenuDTO> getListadoMenu() {
		return listadoMenu;
	}
	public void setListadoMenu(List<MenuDTO> listadoMenu) {
		this.listadoMenu = listadoMenu;
	}
	public String execute(){
		
		String vista="exito";

		System.out.println("Dentro del primer Action "+
				"con Struts 2");
		
		System.out.println("Usuario :" + this.getUsuario());
		System.out.println("Clave : " + this.getClave());
		
		UsuarioService_I usuarioService = PaqueteBusinessDelegate.getUsuarioService();
		
		MenuService_I menuService = PaqueteBusinessDelegate.getMenuService();
		
		//Creamos el objeto temporal clienteAux
		UsuarioDTO clienteAux = new UsuarioDTO();
		UsuarioDTO clienteMenuAux = new UsuarioDTO();
		
		clienteAux.setUser(this.getUsuario());
		clienteAux.setContrasena(this.getClave());
		
		clienteMenuAux.setUser(this.getUsuario());
		clienteMenuAux.setContrasena(this.getClave());

		try {
			
			clienteAux = usuarioService.validarUsuario(clienteAux);
		
			
			//Si encontro el cliente en la BD
			if(clienteAux!=null){
				listadoMenu = menuService.obtieneMenu(clienteMenuAux);
				
				/*if(clienteAux.getContrasena().equals(elusuario.getContrasena())){*/
					
					//Referenciando a la session con Struts 2
					Map<String, Object> lasession=
						ActionContext.getContext().getSession();
					
					//lasession.put("b_usuario", clienteAux);
					lasession.put("b_menu",listadoMenu);
					
				/*}else{
					vista="error";
					mensaje = "Lo sentimos la clave no es correcta";
				}*/
				
			}else{
				vista="error";
				mensaje = "Usuario o clave inválidos";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vista;	
	
	}
}
