package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudRetiroService;
import entidades.AsistenteDireccionAcademica;
import entidades.Persona;
import entidades.SolicitudRetiro;
import entidades.Usuario;

@SessionScoped
@ManagedBean
public class EvaluarRetiroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static SolicitudRetiroService retiroService = abd.getRetiroService();
	
	private ArrayList<SolicitudRetiro> listaSR;
	private Persona persona;
	private AsistenteDireccionAcademica ada;
	private SolicitudRetiro selectedSolicitud;
	private boolean editMode;
	
	public EvaluarRetiroBean() {
		// TODO Auto-generated constructor stub
		System.out.println("creando EvaluarRetiroBean ...");
	}

	public ArrayList<SolicitudRetiro> getListaSR() {

		try {
			
			//NO BORRAR 
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Usuario usuario = (Usuario)session.getAttribute("b_usuario");
			System.out.println("codigo Persona: "+usuario.getPersonas().getStrCodigoPersona());
			
			persona = new Persona();
			persona.setStrCodigoPersona(usuario.getPersonas().getStrCodigoPersona());
			ada = new AsistenteDireccionAcademica();
			ada.setPersonas(persona);	
			
			//listaSR = retiroService.obtenerSRxADA(ada);
			listaSR = retiroService.obtenerSolicitudesPendientes();
			System.out.println("listaSR cargada - tamaño: "+listaSR.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaSR;
	
		//return listaSRPendientes;
	}

	public void setListaSR(ArrayList<SolicitudRetiro> listaSR) {
		this.listaSR = listaSR;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public AsistenteDireccionAcademica getAda() {
		return ada;
	}

	public void setAda(AsistenteDireccionAcademica ada) {
		this.ada = ada;
	}

	public SolicitudRetiro getSelectedSolicitud() {
		return selectedSolicitud;
	}

	public void setSelectedSolicitud(SolicitudRetiro selectedSolicitud) {
		this.selectedSolicitud = selectedSolicitud;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	
}
