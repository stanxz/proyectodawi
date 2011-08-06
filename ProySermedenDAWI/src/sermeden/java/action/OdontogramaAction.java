package sermeden.java.action;


import com.opensymphony.xwork2.ActionSupport;

import sermeden.java.bean.DMPacienteDTO;
import sermeden.java.bean.OdontogramaDTO;
import sermeden.java.service.OdontogramaService_I;
import sermeden.java.service.PaqueteBusinessDelegate;

public class OdontogramaAction extends ActionSupport{
	
	private OdontogramaDTO odontograma;
	private DMPacienteDTO dmpaciente;
	private String mensaje;
	private String titulo;
	
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
}
