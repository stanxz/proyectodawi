package sermeden.java.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;

public class UsuarioAction extends ActionSupport{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String filtro;
private String tipocriterio;
private List<UsuarioDTO> listadoUsuarios;

public String getFiltro() {
	return filtro;
}
public void setFiltro(String filtro) {
	this.filtro = filtro;
}
public String getTipocriterio() {
	return tipocriterio;
}
public void setTipocriterio(String tipocriterio) {
	this.tipocriterio = tipocriterio;
}
public List<UsuarioDTO> getListadoUsuarios() {
	return listadoUsuarios;
}
public void setListadoUsuarios(List<UsuarioDTO> listadoUsuarios) {
	this.listadoUsuarios = listadoUsuarios;
}

	UsuarioService_I usuarioService = 
	PaqueteBusinessDelegate.getUsuarioService();

	public String listarUsuarios(){
		
		String vista="exito";
		
		System.out.println("Dentro del metodo listarUsuario - Struts 2");
		System.out.println("Parametro filtro : " + filtro);
		System.out.println("Parametro criterio : " + tipocriterio);
		
		//Logica de listado de clientes
		
		try {
			if( tipocriterio!=null && tipocriterio.equalsIgnoreCase("1")){
				listadoUsuarios = usuarioService.listadoUsuariosXDNI(filtro);
			}else if(tipocriterio!=null && tipocriterio.equalsIgnoreCase("2")){
				listadoUsuarios = usuarioService.listadoUsuariosXApellido(filtro);
			}
			
			if( listadoUsuarios!=null && listadoUsuarios.size()>0)
				System.out.println("Numero de usuarios : " + listadoUsuarios.size());
			else
				System.out.println("Lista de usuarios vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return vista;
	}

	public String cargaDatosUser(){
		String vista="exito";
		
		return vista;
	}
	
	public String registrarUser(){

		
		String vista = "exito";
		
		System.out.println("Dentro del metodo registrar - Struts 2 ");
		//System.out.println("Nombre " + cliente.getNombre());
		//System.out.println("Nombre " + cliente.getUsuario());
		
		//Invocamos al servicio requerido para registrar cliente
		
		try {
			
			//clienteService.registrarCliente(cliente);
			
			//listadoClientes = clienteService.listadoClientes(filtro);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return vista;
	
	}
	
	public String actualizarUser(){

		String vista="exito";
		System.out.println("Dentro del metodo actualizar - Struts2");
		//System.out.println("Nombre modificado " +cliente.getNombre());
		try {
			//clienteService.modificarCliente(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vista;
	}
	
	public String desactivarUser(){

		String vista="exito";
		System.out.println("Dentro del metodo desactivar - Struts2");
		//System.out.println("Nombre modificado " +cliente.getNombre());
		try {
			//clienteService.modificarCliente(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vista;
	
	
	}
}
