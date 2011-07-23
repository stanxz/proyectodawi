package sermeden.java.action;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;

import com.opensymphony.xwork2.ActionSupport;

public class PacienteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UsuarioDTO> listadoPacientes;
	private UsuarioDTO paciente;
	private String mensaje;
	private String titulo;
	private String dniBuscado;
	private String tipocriterio;
	private String filtro;

	
	public String getTipocriterio() {
		return tipocriterio;
	}
	public void setTipocriterio(String tipocriterio) {
		this.tipocriterio = tipocriterio;
	}
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	public List<UsuarioDTO> getListadoPacientes() {
		return listadoPacientes;
	}
	public void setListadoPacientes(List<UsuarioDTO> listadoPacientes) {
		this.listadoPacientes = listadoPacientes;
	}
	public UsuarioDTO getPaciente() {
		return paciente;
	}
	public void setPaciente(UsuarioDTO paciente) {
		this.paciente = paciente;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDniBuscado() {
		return dniBuscado;
	}
	public void setDniBuscado(String dniBuscado) {
		this.dniBuscado = dniBuscado;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	UsuarioService_I pacienteService = 
			PaqueteBusinessDelegate.getUsuarioService();
	
	public String registrarPatient(){
		int idnuevousuario=-1;
		String vista = "exito";
		System.out.println("Dentro del metodo registrar Paciente- Struts 2 ");
		System.out.println("Nombre del usaurio a registrar Paciente: " + paciente.getNombre() + " " + paciente.getApepat());
		
		//Invocamos al servicio requerido para registrar cliente
		
		try {
			if(pacienteService.validarUsuarioRegistrado(paciente)==false){
				System.out.println("llego hasta aqui");
				idnuevousuario=pacienteService.registrarUsuario(paciente);
				System.out.println("1 idnuevousuario: "+idnuevousuario+" registrado en la BD");
				if(idnuevousuario>0){
					paciente.setUser(paciente.getDni());
					paciente.setContrasena(paciente.getDni());
					paciente.setEstado(1);
					idnuevousuario=pacienteService.registrarUsuarioxPersona(paciente);
					mensaje="El paciente con DNI "+paciente.getDni()+" se registró con exito !";
					
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
		                new InternetAddress(paciente.getEmail()));
		            message.setSubject("Bienvenida");
		            message.setText("Estimado "+paciente.getNombre() + " " + 
		            		paciente.getApepat() + ", Sermeden le da la bienvenida \n" + 
		            		"Usuario   : " + paciente.getUser() + "\n" +
		            		"Contraseña: "  + paciente.getContrasena());
		 
		            // Lo enviamos.
		            Transport t = session.getTransport("smtp");
		            t.connect("proylp2@gmail.com", "cibertec");
		            t.sendMessage(message, message.getAllRecipients());
		            System.out.println("Mensaje Enviado Correctamente");

		         // Cierre.
		            t.close();

				}
				else{
					mensaje="Error al registrar al paciente con DNI "+paciente.getDni();
				}
					
				System.out.println("idPersona: "+paciente.getIdPersona());
			}
			else{
				System.out.println("El paciente con DNI "+paciente.getDni()+" ya existe en la BD !");
				mensaje="El paciente con DNI "+paciente.getDni()+" ya existe en la BD !";
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return vista;
	}
	
	
	public String buscarPatient(){
		
		String vista="exito";
		System.out.println("Dentro del metodo buscarPaciente - Struts 2");
		System.out.println("Parametro filtro : " + dniBuscado);
		
		//Logica de listado de clientes
		
		try {
			if( dniBuscado!=null && !dniBuscado.equalsIgnoreCase("")){
				
				if(pacienteService.pacienteXDNI(dniBuscado)!=null){
					paciente = (UsuarioDTO) pacienteService.pacienteXDNI(dniBuscado);
					mensaje="Paciente encontrado: "+paciente.getNombre()+" "+paciente.getApepat()+" "+paciente.getApemat();
				}else{
					mensaje="Lo sentimos. No existe ese DNI registrado en el Sistema";
					vista="error";
				}
				
				
			}else{
				mensaje="Ingrese un numero válido de DNI (8 cifras)";
				vista="error";
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("e: "+e.getMessage());
		}
		
		return vista;
	}
	
public void validate(){
		
		if(paciente!=null){
			
			if(paciente.getNombre().length()==0){
				addFieldError("paciente.nombre", getText("Ingrese un nombre"));
			}
			
			if(paciente.getApepat().length()==0){
				addFieldError("paciente.apepat", getText("Ingrese un apellido paterno"));
			}

			if(paciente.getApemat().length()==0){
				addFieldError("paciente.apemat", getText("Ingrese un apellido materno"));
			}
			
			if(paciente.getDni().length()==0){
				addFieldError("paciente.dni", getText("Ingrese un DNI"));
			}else if(paciente.getDni().length()>8){
				addFieldError("paciente.dni", getText("El DNI solo permite 8 digitos"));
			}
			
			try {
				int x=Integer.parseInt(paciente.getDni());
				if(x<10000000 || x>99999999){
					addFieldError("paciente.dni", getText("DNI incorrecto"));
				}
			} catch (Exception e) {
				addFieldError("paciente.dni", getText("El DNI solo permite digitos del 0 al 9"));
			}
			
			if(paciente.getSexo()==null){
				addFieldError("paciente.sexo", getText("Seleccione sexo"));
			}
			
			if(paciente.getEmail().length()==0){
				addFieldError("paciente.email", getText("Ingrese un email"));
			}
			else if(!paciente.getEmail().contains("@")){
				addFieldError("paciente.email", getText("Email con formato incorrecto"));
			}
			
			if(paciente.getFijo().length()==0){
				addFieldError("paciente.fijo", getText("Ingrese un numero de telefono fijo"));
			}else if(paciente.getFijo().length()>7){
				addFieldError("paciente.fijo", getText("El numero de telefono debe tener como maximo 7 digitos"));
			}
			
			if(paciente.getCelular().length()==0){
				addFieldError("paciente.celular", getText("Ingrese un numero de celular"));
			}else if(paciente.getCelular().length()>15){
				addFieldError("paciente.celular", getText("El numero de celular debe tener como maximo 15 digitos"));
			}
			
			if(paciente.getDireccion().length()==0){
				addFieldError("paciente.direccion", getText("Ingrese una direccion"));
			}
			/*
			if(paciente.getObservaciones().length()>500){
				addFieldError("paciente.observaciones", getText("Las observaciones no pueden sobrepasar los 500 caracteres"));
			}*/
		}
	}

	public String actualizarPatient(){
	int resultado=-1;
	String vista="exito";
	System.out.println("Dentro del metodo actualizar Usuario - Struts2");
	try {
		
		System.out.println("DNI de Usuario a modificar: " +paciente.getNombre());
		System.out.println("DNI de Usuario a modificar: " +paciente.getDni());
		resultado= pacienteService.modificarPersona(paciente);
		System.out.println("1 actualiza: "+resultado);
		System.out.println("dni: "+paciente.getDni());
		System.out.println("---------");
		if(resultado>0){
			resultado=pacienteService.modificarUsuarioxPersona(paciente);
			System.out.println("2 actualiza: "+resultado);
			System.out.println("dni: "+paciente.getDni());
			System.out.println("---------");
			titulo = "Actualización de Usuario";
			mensaje="El usuario con DNI " + paciente.getDni() + " se actualizó con exito";
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return vista;
	}
	
	public String listarPacientes(){
		
		String vista="exito";
		
		System.out.println("Dentro del metodo listarPacientes - Struts 2");
		System.out.println("Parametro filtro : " + filtro);
		System.out.println("Parametro criterio : " + tipocriterio);
		
		//Logica de listado de clientes
		
		try {
			if( tipocriterio!=null && tipocriterio.equalsIgnoreCase("1")){
				listadoPacientes = pacienteService.listadoPacienteXDNI(filtro);
			}else if(tipocriterio!=null && tipocriterio.equalsIgnoreCase("2")){
				listadoPacientes = pacienteService.listadoPacienteXApellido(filtro);
			}
			
			if( listadoPacientes!=null && listadoPacientes.size()>0)
				System.out.println("Numero de usuarios : " + listadoPacientes.size());
			else
				System.out.println("Lista de usuarios vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return vista;
	}
	
	public String cargaDatosPatient(){
		String vista = "exito";
		System.out.println("Ingresando al metodo cargaDatos");	
		//System.out.println("usuario a buscar " + idBuscar);
		// Invocar a los servicios necesarios	
		try {
			
			//usuario = usuarioService.buscarUsuario(idBuscar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vista;
	
	}
	

}
