package sermeden.java.action;

import java.util.List;


import com.opensymphony.xwork2.ActionSupport;

import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class UsuarioAction extends ActionSupport{
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
static private Logger log = Logger.getLogger(UsuarioAction.class);
private String filtro;
private String condicion;
private String idBuscar;
private String tipocriterio;
private List<UsuarioDTO> listadoUsuarios;
private UsuarioDTO usuario;
private String mensaje;
private String titulo;
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
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getCondicion() {
	return condicion;
}
public void setCondicion(String condicion) {
	this.condicion = condicion;
}



	UsuarioService_I usuarioService = 
	PaqueteBusinessDelegate.getUsuarioService();

	public String listarUsuarios(){
		
		String vista="exito";
		
		log.debug("Dentro del metodo listarUsuario - Struts 2");
		log.debug("Parametro filtro : " + filtro);
		log.debug("Parametro criterio : " + tipocriterio);
		
		//Logica de listado de clientes
		
		try {
			if( tipocriterio!=null && tipocriterio.equalsIgnoreCase("1")){
				listadoUsuarios = usuarioService.listadoUsuariosXDNI(filtro);
			}else if(tipocriterio!=null && tipocriterio.equalsIgnoreCase("2")){
				listadoUsuarios = usuarioService.listadoUsuariosXApellido(filtro);
			}
			
			if( listadoUsuarios!=null && listadoUsuarios.size()>0)
				log.debug("Numero de usuarios : " + listadoUsuarios.size());
			else
				log.debug("Lista de usuarios vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return vista;
	}

	public String cargaDatosUser(){
		String vista = "exito";
		log.debug("Ingresando al metodo cargaDatos");	
		log.debug("usuario a buscar " + idBuscar);
		
		// Invocar a los servicios necesarios	
		try {
			
			usuario = usuarioService.buscarUsuario(idBuscar);
			log.debug("$$$$$ idPerfil del usuario: "+usuario.getIdPerfil());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vista;
	
	}
	
	public String registrarUser(){

		int idnuevousuario=-1;
		String vista = "exito";
		
		log.debug("Dentro del metodo registrar - Struts 2 ");
		log.debug("Nombre del usaurio a registrar: " + usuario.getNombre() + " " + usuario.getApepat());
		//log.debug("Nombre " + usuario.getUsuario());
		
		//Invocamos al servicio requerido para registrar cliente
		
		try {
			if(usuarioService.validarUsuarioRegistrado(usuario)==false){
				log.debug("llego hasta aqui");
				idnuevousuario=usuarioService.registrarUsuario(usuario);
				log.debug("1 idnuevousuario: "+idnuevousuario+" registrado en la BD");
				
				if(idnuevousuario>0){
					usuario.setUser(usuario.getDni());
					usuario.setContrasena(usuario.getDni());
					usuario .setEstado(1);
					idnuevousuario=usuarioService.registrarUsuarioxPersona(usuario);
					
					titulo = "Registro de Usuario";
					mensaje="El usuario con DNI " + usuario.getDni() + " se registró con exito";
					
					//logica para envio de correos debe ir aqui
					 // Propiedades de la conexión
		            Properties props = new Properties();
		            props.setProperty("mail.smtp.host", "smtp.gmail.com");
		            props.setProperty("mail.smtp.starttls.enable", "true");
		            props.setProperty("mail.smtp.port", "587");
		            props.setProperty("mail.smtp.user", "proylp2@gmail.com");
		            props.setProperty("mail.smtp.auth", "true");

		            // Preparamos la sesion
		            Session session = Session.getDefaultInstance(props);
		       
		            // Construimos el mensaje
		            MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress("proylp2@gmail.com"));
		            message.addRecipient(
		                Message.RecipientType.TO,
		                new InternetAddress(usuario.getEmail()));
		            message.setSubject("Bienvenida");
		            message.setText("Estimado "+usuario.getNombre() + " " + 
		            		usuario.getApepat() + ", Sermeden le da la bienvenida \n" + 
		            		"Usuario   : " + usuario.getUser() + "\n" +
		            		"Contraseña: "  + usuario.getContrasena() + "\n" +
		            		"Recomendamos ingrese al portal para cambiar su usuario y contraseña");
		 
		            // Lo enviamos.
		            Transport t = session.getTransport("smtp");
		            t.connect("proylp2@gmail.com", "cibertec");
		            t.sendMessage(message, message.getAllRecipients());
		            log.debug("Mensaje Enviado Correctamente");

		         // Cierre.
		            t.close();

				}
				else{
					mensaje="Error al registrar al usuario con DNI "+usuario.getDni();
				}
					
				log.debug("idPersona: "+usuario.getIdPersona());
			}
			else{
				log.debug("El usuario con DNI "+usuario.getDni()+" ya existe en la BD !");
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
				if(x<10000000 || x>99999999){
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
		log.debug("Dentro del metodo actualizar Usuario - Struts2");
		try {
			
			log.debug("DNI de Usuario a modificar: " +usuario.getNombre());
			log.debug("DNI de Usuario a modificar: " +usuario.getDni());
			resultado=usuarioService.modificarPersona(usuario);
			log.debug("1 actualiza: "+resultado);
			log.debug("dni: "+usuario.getDni());
			log.debug("---------");
			if(resultado>0){
				resultado=usuarioService.modificarUsuarioxPersona(usuario);
				log.debug("2 actualiza: "+resultado);
				log.debug("dni: "+usuario.getDni());
				log.debug("---------");
				titulo = "Actualización de Usuario";
				mensaje="El usuario con DNI " + usuario.getDni() + " se actualizó con exito";
				
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
		log.debug("Dentro del metodo desactivar - Struts2");
		log.debug("Nombre del Usuario a cambiar de Estado: " +usuario.getNombre());
		try {
			UsuarioDTO auxiliar=new UsuarioDTO();
			auxiliar.setIdPersona(usuario.getIdPersona());
			if(usuario.getEstado()==0)
				auxiliar.setEstado(1);
			else if(usuario.getEstado()==1)
				auxiliar.setEstado(0);
			
			resultado=usuarioService.cambiarEstadoUsuario(auxiliar);
			log.debug("resultado cambiar Estado: "+resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vista;

	}
	
	public String recuperaPassUser(){
		String vista="exito";
		log.debug("Dentro del metodo desactivar - Struts2");
		log.debug("Nombre del Usuario a cambiar de Estado: " +dniBuscado);
		try {
			UsuarioDTO auxiliar=new UsuarioDTO();
			
			
			if(usuarioService.listadoUsuariosXDNI(dniBuscado).size()>0){
				auxiliar=(UsuarioDTO)usuarioService.listadoUsuariosXDNI(dniBuscado).get(0);
				log.debug("email Destino del pass: "+auxiliar.getEmail());
				
				//logica para envio de correos debe ir aqui
				 // Propiedades de la conexión
	            Properties props = new Properties();
	            props.setProperty("mail.smtp.host", "smtp.gmail.com");
	            props.setProperty("mail.smtp.starttls.enable", "true");
	            props.setProperty("mail.smtp.port", "587");
	            props.setProperty("mail.smtp.user", "proylp2@gmail.com");
	            props.setProperty("mail.smtp.auth", "true");

	            // Preparamos la sesion
	            Session session = Session.getDefaultInstance(props);
	       
	            // Construimos el mensaje
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("proylp2@gmail.com"));
	            message.addRecipient(
	                Message.RecipientType.TO,
	                new InternetAddress(auxiliar.getEmail()));
	            message.setSubject("Recuperación de Contraseña");
	            message.setText("Estimado "+auxiliar.getNombre() + " " + 
	            		auxiliar.getApepat() + " su usuario es: " + auxiliar.getUser()+" y su contraseña es: " + auxiliar.getContrasena());
	 
	            // Lo enviamos.
	            Transport t = session.getTransport("smtp");
	            t.connect("proylp2@gmail.com", "cibertec");
	            t.sendMessage(message, message.getAllRecipients());
	            log.debug("Mensaje Enviado Correctamente");

	         // Cierre.
	            t.close();
	            mensaje="El Sistema ha enviado un correo a "+auxiliar.getNombre()+ " "+auxiliar.getApepat()+" con su usuario y clave";
			}else{
				mensaje="El DNI no se encuentra registrado en el Sistema";
				vista="error";
			}
			
			
			
			 
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vista="error";
			e.printStackTrace();
		}
		return vista;

	}
	
}
