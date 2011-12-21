package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import entidades.Asignatura;
import entidades.Grados;

import servicios.ApplicationBusinessDelegate;
import servicios.AsignaturaService;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean 
public class AsignaturaBean implements Serializable{
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AsignaturaService asignaturaService = abd.getAsignaturaService();
	
	private Asignatura asignatura,selectedAsignatura;
	private ArrayList<Asignatura> asignaturas;
	private boolean editMode;
	
	private String nivel;
	
	private String strNivel;
	
	private ArrayList<Grados> grados = new ArrayList<Grados>();
	
	
	private Asignatura nuevaAsignatura = new Asignatura();
	
	public AsignaturaBean(){
		System.out.println("Creando AsignaturaBean...");
	}
	
	public void actualizaAsignatura(){
		System.out.println("actualiza Nombre" + selectedAsignatura.getStrNombreAsignatura());
		System.out.println("actualiza Grado" + selectedAsignatura.getIntGrado());
		
		try {
			asignaturaService.actualizarAsignatura(selectedAsignatura);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registraAsignatura(){
		try {
			System.out.println("Registrando asignatura ... ");
			nuevaAsignatura.setStrNivel(strNivel);
			
			asignaturaService.insertarAsignatura(nuevaAsignatura);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Asignatura Registrada con exito: " + nuevaAsignatura.getStrNombreAsignatura()));				
			
			nuevaAsignatura = new Asignatura();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inhabilitaAsignatura(){
		try {
			asignaturaService.inhabilitarAsignatura(selectedAsignatura);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Asignatura getSelectedAsignatura() {
		return selectedAsignatura;
	}

	public void setSelectedAsignatura(Asignatura selectedAsignatura) {
		this.selectedAsignatura = selectedAsignatura;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		try {
			asignaturas = asignaturaService.obtenerTodosAsignaturas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public Asignatura getNuevaAsignatura() {
		return nuevaAsignatura;
	}

	public void setNuevaAsignatura(Asignatura nuevaAsignatura) {
		this.nuevaAsignatura = nuevaAsignatura;
	}
	
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	public ArrayList<Grados> getGrados() {
		return grados;
	}

	public void setGrados(ArrayList<Grados> grados) {
		this.grados = grados;
	}
	
	public String getStrNivel() {
		return strNivel;
	}

	public void setStrNivel(String strNivel) {
		this.strNivel = strNivel;
	}

	public void preCargaCombo(){
		nivel = "";
		
		nivel = selectedAsignatura.getStrNivel();
		
			if(nivel.equals("Primario")){
				try {
					grados =  new ArrayList<Grados>();
					grados = asignaturaService.gradosPrimaria();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (nivel.equals("Secundario")) {
				try {
					grados =  new ArrayList<Grados>();
					grados = asignaturaService.gradosSecundaria();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	

	public void obtieneGradosA(){
		
		strNivel = "";
		
		strNivel = selectedAsignatura.getStrNivel();

			if(strNivel.equals("Primario")){
				try {
					grados =  new ArrayList<Grados>();
					selectedAsignatura.setIntGrado(0);
					grados = asignaturaService.gradosPrimaria();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (strNivel.equals("Secundario")) {
				try {
					grados =  new ArrayList<Grados>();
					selectedAsignatura.setIntGrado(0);
					grados = asignaturaService.gradosSecundaria();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (strNivel.equals("0")){
				grados =  new ArrayList<Grados>();
			}
		
	}
	
    public void obtieneGradosN(){

		System.out.println("-->" + strNivel);

			if(strNivel.equals("Primario")){
				try {
					grados =  new ArrayList<Grados>();
					grados = asignaturaService.gradosPrimaria();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (strNivel.equals("Secundario")) {
				try {
					grados =  new ArrayList<Grados>();
					grados = asignaturaService.gradosSecundaria();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (strNivel.equals("0")){
				grados =  new ArrayList<Grados>();
			}
		
	}


}
