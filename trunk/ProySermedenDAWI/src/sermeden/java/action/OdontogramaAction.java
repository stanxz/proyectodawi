package sermeden.java.action;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

import sermeden.java.bean.DMPacienteDTO;
import sermeden.java.bean.OdontogramaDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.OdontogramaService_I;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;

public class OdontogramaAction extends ActionSupport{
	
	private OdontogramaDTO odontograma;
	private DMPacienteDTO dmpaciente;
	private String mensaje;
	private String titulo;
	private String dniBuscado;
	
	public OdontogramaDTO getOdontograma() {
		return odontograma;
	}
	public void setOdontograma(OdontogramaDTO odontograma) {
		this.odontograma = odontograma;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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



	OdontogramaService_I odontogramaService = 
	PaqueteBusinessDelegate.getOdontogramaService();
	
	public String generarOdontograma(){

		int nuevoOdontograma=-1;
		String vista = "exito";
		
		
		try {
			System.out.println("-->" + dmpaciente.getDni());
				
				odontograma.setDni(dmpaciente.getDni());
				odontograma.setFechareg(new java.sql.Date(new java.util.Date().getTime()));
			
			    nuevoOdontograma = odontogramaService.generarOdontograma(odontograma);
				
				
				if(nuevoOdontograma>0){									
					titulo = "Generar de Odontograma";
					mensaje = "Se ha generado correctamente el odontograma " +
					"para el usuario con Dni " + odontograma.getDni();
					System.out.println("mensaje-->" + mensaje);

				}
				
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return vista;
	
	}
	
	public String verOdontograma(){
		String vista="exito";
		System.out.println("Dentro del metodo desactivar - Struts2");
		System.out.println("Nombre del Usuario a cambiar de Estado: " +dniBuscado);
		try {
			
			
			if(odontogramaService.listadoOdontogramaXDNI(dniBuscado).size()>0){
				
	            
			}else{
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
