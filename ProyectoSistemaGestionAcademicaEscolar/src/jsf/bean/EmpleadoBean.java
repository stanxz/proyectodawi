package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import servicios.ApplicationBusinessDelegate; 
import servicios.DistritoService;
import servicios.PerfilService;
import servicios.PersonaService;
import servicios.UsuarioService;
import utiles.EnviaMail;
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
	public static UsuarioService usuarioService = abd.getUsuarioService();
	
	private Persona empleado,selectedEmpleado;
	private Perfil perfil;
	private ArrayList<Persona> empleados;
	private ArrayList<Perfil> perfiles;
	private ArrayList<Distrito> distritos;
	
	private boolean editMode;
	
	private Persona nuevoEmpleado =  new Persona();
	private Usuario nuevoUsuario =  new Usuario();
	
	private String mensaje;
	

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
		
		
		try {
			Persona tmpPersona = personaService.consultaPersona(nuevoEmpleado);
			
			if(tmpPersona!=null){
				System.out.println("Empleado " + tmpPersona.getStrCodigoPersona()+"("+tmpPersona.getStrNombre()+" "+tmpPersona.getStrApellidoPaterno()+") ya existe !!");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado ya se encuentra registrado: " + tmpPersona.getStrNombre() + " " + tmpPersona.getStrApellidoPaterno()));
			}else{
				
					System.out.println("Insertando Empleado y Usuario");
					personaService.registrarPersona(nuevoEmpleado);
					
					Perfil perfil = new Perfil();
					perfil.setStrCodigoPerfil(nuevoEmpleado.getPerfil().getStrCodigoPerfil());
					
					Persona persona = new Persona();	
					persona.setStrCodigoPersona(String.valueOf(nuevoEmpleado.getIntDNI()));
					
					Usuario tmpUsuario = new Usuario();
					
					tmpUsuario.setPerfiles(perfil);
					tmpUsuario.setPersonas(persona);
					tmpUsuario.setStrContrasena(String.valueOf(nuevoEmpleado.getIntDNI()));
					
					usuarioService.registrarUsuario(tmpUsuario);
					
					EnviaMail enviaEMail = new EnviaMail();
					enviaEMail.EnviadorMailContrasena("registro",nuevoEmpleado.getStrMail(), nuevoEmpleado.getStrNombre()+ " "+nuevoEmpleado.getStrApellidoPaterno()+ " "+nuevoEmpleado.getStrApellidoMaterno(), tmpUsuario);
					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro de Empleado","Empleado se registró correctamente. Se ha enviado un notificación a su correo"));
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
