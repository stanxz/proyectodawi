package jsf.bean;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudRetiroService;
import entidades.AsistenteDireccionAcademica;
import entidades.Cita;
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
	private SolicitudRetiro selectedSolicitud2;
	private Cita loadedCita;
	private boolean editMode;
	private boolean bandera=false;
	
	public EvaluarRetiroBean() {
		// TODO Auto-generated constructor stub
		System.out.println("creando EvaluarRetiroBean ...");
	}

	public void cargaDatosCitaEvaluada(){
		System.out.println("en cargaDatosCitaEvaluada ... ");
		
		if(selectedSolicitud2!=null){
			try {
				for (Method m : selectedSolicitud2.getClass().getMethods()){
					if((m.getName().startsWith("getStr"))||(m.getName().startsWith("getInt"))){
						System.out.println("selectedSolicitud2 - "+m.getName().substring(6).toUpperCase() + " : " +  m.invoke(selectedSolicitud2));
					}	
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al pintar atributos del selectedSolicitud2");
			}
			
			System.out.println("cod del alumno en la solicitud2: "+selectedSolicitud2.getAlumno().getStrCodigoAlumno());
			
			try {
				System.out.println("cargando datos de cita evaluada ... ");
				loadedCita=retiroService.cargaDatosCitaxEvaluar(selectedSolicitud2);
				if(loadedCita!=null){
					bandera=true;
					System.out.println("cita realizada: "+loadedCita.getIntcodcita());
				}else{
					bandera=false;
					System.out.println("Cita aun no atendida");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				bandera=false;
				System.out.println("Cita aun no atendida");
			}
		}else{
			System.out.println("selectedSolicitud2 es nulaaaa");
		}
	}
	
	public void cargaDatosCitaEvaluada2(){
		System.out.println("en cargaDatosCitaEvaluada2 ... ");
		
		if(selectedSolicitud!=null){
			try {
				for (Method m : selectedSolicitud.getClass().getMethods()){
					if((m.getName().startsWith("getStr"))||(m.getName().startsWith("getInt"))){
						System.out.println("selectedSolicitud - "+m.getName().substring(6).toUpperCase() + " : " +  m.invoke(selectedSolicitud));
					}	
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al pintar atributos del selectedSolicitud");
			}
			
			System.out.println("cod del alumno en la solicitud: "+selectedSolicitud.getAlumno().getStrCodigoAlumno());
			
			try {
				System.out.println("cargando datos de cita evaluada ... ");
				loadedCita=retiroService.cargaDatosCitaxEvaluar(selectedSolicitud);
				if(loadedCita!=null){
					bandera=true;
					System.out.println("cita realizada: "+loadedCita.getIntcodcita());
				}else{
					bandera=false;
					System.out.println("Cita aun no atendida");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				bandera=false;
				System.out.println("Cita aun no atendida");
			}
		}else{
			System.out.println("selectedSolicitud es nulaaaa");
		}
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

	public Cita getLoadedCita() {
		return loadedCita;
	}

	public void setLoadedCita(Cita loadedCita) {
		this.loadedCita = loadedCita;
	}

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public SolicitudRetiro getSelectedSolicitud2() {
		return selectedSolicitud2;
	}

	public void setSelectedSolicitud2(SolicitudRetiro selectedSolicitud2) {
		this.selectedSolicitud2 = selectedSolicitud2;
	}


	
}
