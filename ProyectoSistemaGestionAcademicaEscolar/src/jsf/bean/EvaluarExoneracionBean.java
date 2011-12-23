package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudExoneracionService;

import entidades.SolicitudExoneracion;


@SessionScoped
@ManagedBean 
public class EvaluarExoneracionBean implements Serializable{
	
	 private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static SolicitudExoneracionService exoneracionService = abd.getExoneracionService();
	
	private ArrayList<SolicitudExoneracion> solicitudes;
	
	
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
	
	
}
