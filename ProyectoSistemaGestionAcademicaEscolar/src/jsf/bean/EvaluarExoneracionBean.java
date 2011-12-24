package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudExoneracionService;

import entidades.AsistenteCoordinacionAcademica;
import entidades.Persona;
import entidades.SolicitudExoneracion;


@SuppressWarnings("serial")
@SessionScoped
@ManagedBean 
public class EvaluarExoneracionBean implements Serializable{
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static SolicitudExoneracionService exoneracionService = abd.getExoneracionService();
	
    private SolicitudExoneracion solicitud,selectedSolicitud;
    private Persona persona;
    private AsistenteCoordinacionAcademica asistentaCoordinacion;
	private ArrayList<SolicitudExoneracion> solicitudes;
	
	private boolean editMode;
	
	
	public EvaluarExoneracionBean(){
		System.out.println("Creando EvaluarExoneracionBean ...");
	}
	
	public void apruebaSolicitud(){
		System.out.println("Aprueba Solicitud");
		System.out.println(selectedSolicitud.getIntIdCodigoSolicitudExoneracion());
		
		//NO BORRAR 
		//HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		//Usuario usuario = (Usuario)session.getAttribute("b_usuario");
		
		
		//System.out.println(usuario.getPersonas().getStrCodigoPersona());
		
		persona = new Persona();
		//persona.setStrCodigoPersona(usuario.getPersonas().getStrCodigoPersona());
		persona.setStrCodigoPersona("PE-17171717");
		
		asistentaCoordinacion = new AsistenteCoordinacionAcademica();
		asistentaCoordinacion.setPersonas(persona);
		
		selectedSolicitud.setAsistenteCoordinacion(asistentaCoordinacion);
		
		try {
			exoneracionService.apruebaSolicitudExoneracion(selectedSolicitud);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evaluación Solicitud de Exoneracion","Solicitud APROBADA"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evaluación Solicitud de Exoneracion","ERROR: Evaluación Cancelada"));
		}
	}
	
	public void desapruebaSolicitud(){
		System.out.println("Aprueba Solicitud");
		System.out.println(selectedSolicitud.getIntIdCodigoSolicitudExoneracion());
		
		//NO BORRAR 
		//HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		//Usuario usuario = (Usuario)session.getAttribute("b_usuario");
		
		
		//System.out.println(usuario.getPersonas().getStrCodigoPersona());
		
		persona = new Persona();
		//persona.setStrCodigoPersona(usuario.getPersonas().getStrCodigoPersona());
		persona.setStrCodigoPersona("PE-17171717");
		
		asistentaCoordinacion = new AsistenteCoordinacionAcademica();
		asistentaCoordinacion.setPersonas(persona);
		
		selectedSolicitud.setAsistenteCoordinacion(asistentaCoordinacion);
		
		try {
			exoneracionService.desapruebaSolicitudExoneracion(selectedSolicitud);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evaluación Solicitud de Exoneracion","Solicitud DESAPROBADA"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evaluación Solicitud de Exoneracion","ERROR: Evaluación Cancelada"));
		}
		
		 
	}


	public ArrayList<SolicitudExoneracion> getSolicitudes() {
		
		try {
			solicitudes = exoneracionService.obtenerSolicitudes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return solicitudes;
	}


	public void setSolicitudes(ArrayList<SolicitudExoneracion> solicitudes) {
		this.solicitudes = solicitudes;
	}


	public SolicitudExoneracion getSolicitud() {
		return solicitud;
	}


	public void setSolicitud(SolicitudExoneracion solicitud) {
		this.solicitud = solicitud;
	}


	public SolicitudExoneracion getSelectedSolicitud() {
		return selectedSolicitud;
	}


	public void setSelectedSolicitud(SolicitudExoneracion selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}


	public boolean isEditMode() {
		return editMode;
	}


	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public AsistenteCoordinacionAcademica getAsistentaCoordinacion() {
		return asistentaCoordinacion;
	}

	public void setAsistentaCoordinacion(
			AsistenteCoordinacionAcademica asistentaCoordinacion) {
		this.asistentaCoordinacion = asistentaCoordinacion;
	}
	
	
}
