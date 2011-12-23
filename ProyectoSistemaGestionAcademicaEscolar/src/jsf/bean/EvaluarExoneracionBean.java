package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudExoneracionService;

import entidades.SolicitudExoneracion;


@SuppressWarnings("serial")
@SessionScoped
@ManagedBean 
public class EvaluarExoneracionBean implements Serializable{
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static SolicitudExoneracionService exoneracionService = abd.getExoneracionService();
	
    private SolicitudExoneracion solicitud,selectedSolicitud;
	private ArrayList<SolicitudExoneracion> solicitudes;
	
	private boolean editMode;
	
	
	public EvaluarExoneracionBean(){
		System.out.println("Creando EvaluarExoneracionBean ...");
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
	
	
}
