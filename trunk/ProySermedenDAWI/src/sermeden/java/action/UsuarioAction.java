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
private String idBuscar;
private String tipocriterio;
private List<UsuarioDTO> listadoUsuarios;
private UsuarioDTO usuario;
private String mensaje;
private String dniBuscado;

public String getDniBuscado() {
	return dniBuscado;
}
public void setDniBuscado(String dniBuscado) {
	this.dniBuscado = dniBuscado;
}
public String getIdBuscar() {
	return idBuscar;
}
public void setIdBuscar(String idBuscar) {
	this.idBuscar = idBuscar;
}
public String getMensaje() {
	return mensaje;
}
public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}
public UsuarioDTO getUsuario() {
	return usuario;
}
public void setUsuario(UsuarioDTO usuario) {
	this.usuario = usuario;
}
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
		String vista = "exito";
		System.out.println("Ingresando al metodo cargaDatos");	
		System.out.println("usuario a buscar " + idBuscar);
		// Invocar a los servicios necesarios	
		try {
			
			usuario = usuarioService.buscarUsuario(idBuscar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vista;
	
	}
	
	public String registrarUser(){

		int idnuevousuario=-1;
		String vista = "exito";
		
		System.out.println("Dentro del metodo registrar - Struts 2 ");
		System.out.println("Nombre del usaurio a registrar: " + usuario.getNombre() + " " + usuario.getApepat());
		//System.out.println("Nombre " + usuario.getUsuario());
		
		//Invocamos al servicio requerido para registrar cliente
		
		try {
			if(usuarioService.validarUsuarioRegistrado(usuario)==false){
				System.out.println("llego hasta aqui");
				idnuevousuario=usuarioService.registrarUsuario(usuario);
				System.out.println("1 idnuevousuario: "+idnuevousuario+" registrado en la BD");
				if(idnuevousuario>0){
					usuario.setUser(usuario.getDni());
					usuario.setContrasena(usuario.getDni());
					usuario .setEstado(1);
					idnuevousuario=usuarioService.registrarUsuarioxPersona(usuario);
					mensaje="El usuario con DNI "+usuario.getDni()+"se registró con exito";
				}
				else{
					mensaje="Error al registrar al usuario con DNI "+usuario.getDni();
				}
					
				System.out.println("idPersona: "+usuario.getIdPersona());
			}
			else{
				System.out.println("El usuario con DNI "+usuario.getDni()+" ya existe en la BD !");
				mensaje="El usuario con DNI "+usuario.getDni()+" ya existe en la BD !";
			}
			
			//listadoUsuarios = usuarioService.listado(filtro);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return vista;
	
	}
	
	public void validate(){
		
		if(usuario!=null){
			
			if(usuario.getNombre().length()==0){
				addFieldError("usuario.nombre", getText("Ingrese un nombre"));
			}
			
			if(usuario.getApepat().length()==0){
				addFieldError("usuario.apepat", getText("Ingrese un apellido paterno"));
			}

			if(usuario.getApemat().length()==0){
				addFieldError("usuario.apemat", getText("Ingrese un apellido materno"));
			}
			
			if(usuario.getDni().length()==0){
				addFieldError("usuario.dni", getText("Ingrese un DNI"));
			}else if(usuario.getDni().length()>8){
				addFieldError("usuario.dni", getText("El DNI solo permite 8 digitos"));
			}
			
			try {
				int x=Integer.parseInt(usuario.getDni());
				if(x<0){
					addFieldError("usuario.dni", getText("DNI incorrecto"));
				}
			} catch (Exception e) {
				addFieldError("usuario.dni", getText("El DNI solo permite digitos del 0 al 9"));
			}
			
			if(usuario.getSexo()==null){
				addFieldError("usuario.sexo", getText("Seleccione sexo"));
			}
			
			if(usuario.getEmail().length()==0){
				addFieldError("usuario.email", getText("Ingrese un email"));
			}
			else if(!usuario.getEmail().contains("@")){
				addFieldError("usuario.email", getText("Email con formato incorrecto"));
			}
			
			if(usuario.getFijo().length()==0){
				addFieldError("usuario.fijo", getText("Ingrese un numero de telefono fijo"));
			}else if(usuario.getFijo().length()>7){
				addFieldError("usuario.fijo", getText("El numero de telefono debe tener como maximo 7 digitos"));
			}
			
			if(usuario.getCelular().length()==0){
				addFieldError("usuario.celular", getText("Ingrese un numero de celular"));
			}else if(usuario.getCelular().length()>15){
				addFieldError("usuario.celular", getText("El numero de celular debe tener como maximo 15 digitos"));
			}
			
			if(usuario.getDireccion().length()==0){
				addFieldError("usuario.direccion", getText("Ingrese una direccion"));
			}
			
			if(usuario.getIdPerfil()<=0){
				addFieldError("usuario.idPerfil", getText("Seleccione un perfil"));
			}
			
			if(usuario.getIdPerfil()==7){
				if(usuario.getIdEspecialidad()<=0){
					addFieldError("usuario.idEspecialidad", getText("Seleccione una especialidad"));
				}
			}
			
			if(usuario.getObservaciones().length()>500){
				addFieldError("usuario.observaciones", getText("Las observaciones no pueden sobrepasar los 500 caracteres"));
			}
		}
	}

	public String actualizarUser(){
		int resultado=-1;
		String vista="exito";
		System.out.println("Dentro del metodo actualizar Usuario - Struts2");
		System.out.println("DNI de Usuario a modificar: " +usuario.getDni());
		try {
			resultado=usuarioService.modificarPersona(usuario);
			System.out.println("1 actualiza: "+resultado);
			System.out.println("dni: "+usuario.getDni());
			System.out.println("---------");
			if(resultado>0){
				resultado=usuarioService.modificarUsuarioxPersona(usuario);
				System.out.println("2 actualiza: "+resultado);
				System.out.println("dni: "+usuario.getDni());
				System.out.println("---------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vista;
	}
	
	public String cambiarEstadoUser(){
		int resultado=-1;
		String vista="exito";
		System.out.println("Dentro del metodo desactivar - Struts2");
		System.out.println("Nombre del Usuario a cambiar de Estado: " +usuario.getNombre());
		try {
			UsuarioDTO auxiliar=new UsuarioDTO();
			auxiliar.setIdPersona(usuario.getIdPersona());
			if(usuario.getEstado()==0)
				auxiliar.setEstado(1);
			else if(usuario.getEstado()==1)
				auxiliar.setEstado(0);
			
			resultado=usuarioService.cambiarEstadoUsuario(auxiliar);
			System.out.println("resultado cambiar Estado: "+resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vista;

	}
	
	public String recuperaPassUser(){
		String vista="exito";
		System.out.println("Dentro del metodo desactivar - Struts2");
		System.out.println("Nombre del Usuario a cambiar de Estado: " +dniBuscado);
		try {
			UsuarioDTO auxiliar=new UsuarioDTO();
			auxiliar=(UsuarioDTO)usuarioService.listadoUsuariosXDNI(dniBuscado).get(0);
			System.out.println("email Destino del pass: "+auxiliar.getEmail());
			
			//logica para envio de correos debe ir aqui
			
			 
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vista;

	}
	
	
}
