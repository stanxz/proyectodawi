package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Asignatura;

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
	
	public AsignaturaBean(){
		System.out.println("Creando AsignaturaBean...");
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

}
