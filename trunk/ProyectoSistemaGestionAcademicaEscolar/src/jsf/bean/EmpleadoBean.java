package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import servicios.ApplicationBusinessDelegate; 
import servicios.DistritoService;
import servicios.PerfilService;
import servicios.PersonaService;
import entidades.Distrito;
import entidades.Perfil;
import entidades.Persona;
import entidades.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class EmpleadoBean implements Serializable{
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	public static PerfilService perfilService = abd.getPerfilService();
	public static PersonaService personaService = abd.getPersonaService();
	public static DistritoService distritoService = abd.getDistritoService();
	
	private Persona empleado,selectedEmpleado;
	private Perfil perfil;
	private ArrayList<Persona> empleados;
	private ArrayList<Perfil> perfiles;
	private ArrayList<Distrito> distritos;
	
	private boolean editMode;
	
	private Persona nuevoEmpleado =  new Persona();
	private Usuario nuevoUsuario =  new Usuario();
	

	public EmpleadoBean(){
		System.out.println("Creando EmpleadoBean...");
		CargarPerfiles();
	}
	
	public void registraEmpleado(){
		System.out.println("---------------------------------------------------------------");
		System.out.println("--------------------------Registro Empleado---------------------");
		System.out.println("---------------------------------------------------------------");
		
		System.out.println(nuevoEmpleado.getStrNombre());
		System.out.println(nuevoEmpleado.getStrApellidoPaterno());
		System.out.println(nuevoEmpleado.getStrApellidoMaterno());
		System.out.println(nuevoEmpleado.getIntDNI());
		System.out.println(nuevoEmpleado.getDistritos().getIntIdDistrito());
		System.out.println(nuevoEmpleado.getStrDireccion());
		System.out.println(nuevoEmpleado.getStrMail());
		System.out.println(nuevoEmpleado.getStrTelefono());
		System.out.println(nuevoEmpleado.getStrCelular());
		System.out.println(nuevoEmpleado.getPerfil().getStrCodigoPerfil());
		System.out.println(nuevoEmpleado.getStrSexo());
	}
	
	public void CargarPerfiles(){
		try {
			perfiles = perfilService.listarPerfiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public ArrayList<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(ArrayList<Perfil> perfiles) {
		this.perfiles = perfiles;
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

	public ArrayList<Distrito> getDistritos() {		
		try {
			distritos = distritoService.obtenerTodosDistritos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return distritos;
	}

	public void setDistritos(ArrayList<Distrito> distritos) {
		this.distritos = distritos;
	}
	
	
}
