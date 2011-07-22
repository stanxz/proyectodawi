package sermeden.java.action;

import java.util.List;

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
	private String dniBuscado;
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
	
	UsuarioService_I pacienteService = 
			PaqueteBusinessDelegate.getUsuarioService();
	
	public String registrarPatient(){
		int idnuevousuario=-1;
		String vista = "exito";
		System.out.println("Dentro del metodo registrar Paciente- Struts 2 ");
		System.out.println("Nombre del usaurio a registrar Paciente: " + paciente.getNombre() + " " + paciente.getApepat());
		//System.out.println("Nombre " + usuario.getUsuario());
		
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
					
					
				}
				else{
					mensaje="Error al registrar al usuario con DNI "+paciente.getDni();
				}
					
				System.out.println("idPersona: "+paciente.getIdPersona());
			}
			else{
				System.out.println("El usuario con DNI "+paciente.getDni()+" ya existe en la BD !");
				mensaje="El usuario con DNI "+paciente.getDni()+" ya existe en la BD !";
			}
			
			//listadoUsuarios = usuarioService.listado(filtro);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return vista;
	
	}
}
