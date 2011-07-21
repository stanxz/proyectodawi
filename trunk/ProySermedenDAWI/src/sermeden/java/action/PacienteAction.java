package sermeden.java.action;

import java.util.List;

import sermeden.java.bean.UsuarioDTO;

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
	
	
}
