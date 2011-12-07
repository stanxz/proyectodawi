package jsf.bean;



import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import entidades.Perfil;
import entidades.Persona;
import entidades.Usuario;

import servicios.ApplicationBusinessDelegate;
import servicios.PerfilService;
import servicios.PersonaService;


@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class EmpleadoBean implements Serializable{
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	public static PerfilService perfilService = abd.getPerfilService();
	public static PersonaService personaService = abd.getPersonaService();
	
	private Persona empleado,selectedEmpleado;
	private Perfil perfil;
	private ArrayList<Perfil> perfiles;
	private ArrayList<Persona> empleados;
	
	private boolean editMode;
	
	private Persona nuevoEmpleado =  new Persona();
	private Usuario nuevoUsuario =  new Usuario();
	

	public EmpleadoBean(){
		System.out.println("Creando EmpleadoBean...");
		//CargarPerfiles();
	}
	
	public void CargarPerfiles(){
		try {
			perfiles = perfilService.listarPerfiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registraEmpleado(){
		System.out.println("Registro Empleado");
	}

	public ArrayList<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(ArrayList<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public ArrayList<Persona> getEmpleados() {
		try {
			empleados = personaService.obtenerTodosEmpleados();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empleados;
	}

	public void setEmpleados(ArrayList<Persona> empleados) {
		this.empleados = empleados;
	}

	public Persona getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Persona empleado) {
		this.empleado = empleado;
	}

	public Persona getSelectedEmpleado() {
		return selectedEmpleado;
	}

	public void setSelectedEmpleado(Persona selectedEmpleado) {
		this.selectedEmpleado = selectedEmpleado;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public Persona getNuevoEmpleado() {
		return nuevoEmpleado;
	}

	public void setNuevoEmpleado(Persona nuevoEmpleado) {
		this.nuevoEmpleado = nuevoEmpleado;
	}

	public Usuario getNuevoUsuario() {
		return nuevoUsuario;
	}

	public void setNuevoUsuario(Usuario nuevoUsuario) {
		this.nuevoUsuario = nuevoUsuario;
	}

}
