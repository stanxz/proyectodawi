package sermeden.java.action;


import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import sermeden.java.bean.DMPacienteDTO;
import sermeden.java.bean.OdontogramaDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.OdontogramaService_I;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;

public class OdontogramaAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8023221043947485107L;
	static private Logger log = Logger.getLogger(OdontogramaAction.class);
	private OdontogramaDTO odontograma;
	private UsuarioDTO usuario;
	private List<UsuarioDTO> listadoUsuarios;
	private List<String> listadoPiezas;
	private DMPacienteDTO dmpaciente;
	private String mensaje;
	private String mensajeOdontograma;
	private String titulo;
	private String dniBuscado;
	
	private String[] jsonData;
	
	public OdontogramaDTO getOdontograma() {
		return odontograma;
	}
	public void setOdontograma(OdontogramaDTO odontograma) {
		this.odontograma = odontograma;
	}public String getMensajeOdontograma() {
		return mensajeOdontograma;
	}
	public void setMensajeOdontograma(String mensajeOdontograma) {
		this.mensajeOdontograma = mensajeOdontograma;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public DMPacienteDTO getDmpaciente() {
		return dmpaciente;
	}
	public void setDmpaciente(DMPacienteDTO dmpaciente) {
		this.dmpaciente = dmpaciente;
	}
	public String getDniBuscado() {
		return dniBuscado;
	}
	public void setDniBuscado(String dniBuscado) {
		this.dniBuscado = dniBuscado;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public List<UsuarioDTO> getListadoUsuarios() {
		return listadoUsuarios;
	}
	public void setListadoUsuarios(List<UsuarioDTO> listadoUsuarios) {
		this.listadoUsuarios = listadoUsuarios;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String[] getJsonData() {
		return jsonData;
	}
	public void setJsonData(String[] jsonData) {
		this.jsonData = jsonData;
	}

	OdontogramaService_I odontogramaService = 
	PaqueteBusinessDelegate.getOdontogramaService();
	
	UsuarioService_I usuarioService = 
		PaqueteBusinessDelegate.getUsuarioService();	
	
	public String registro(){
		
		for(String s : jsonData){
			System.out.println("jsonData - Opcion Selecionada : " + s);
		}
		
		return SUCCESS;
		
	}

}
