package jsf.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;

import servicios.ApplicationBusinessDelegate; 
import servicios.DistritoService;
import servicios.PerfilService;
import servicios.PersonaService;
import servicios.UsuarioService;
import utiles.EnviaMail;
import entidades.AsistentaSocial;
import entidades.AsistenteCoordinacionAcademica;
import entidades.AsistenteDireccionAcademica;
import entidades.Distrito;
import entidades.Perfil;
import entidades.Persona;
import entidades.SecretariaAcademica;
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
	private AsistentaSocial nuevoAsistentaSocial;
	private SecretariaAcademica nuevoSecretariaAcademica;
	private AsistenteCoordinacionAcademica nuevoACA;
	private AsistenteDireccionAcademica nuevoADA;
	
	
	private String mensaje;
	

	public EmpleadoBean(){
		System.out.println("Creando EmpleadoBean...");
		nuevoAsistentaSocial = new AsistentaSocial();
		nuevoSecretariaAcademica = new SecretariaAcademica();
		nuevoACA = new AsistenteCoordinacionAcademica();
		nuevoADA = new AsistenteDireccionAcademica();
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
					InputStream stream = 
						((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/images/noDisponible.jpg");
					byte[] foto;
						try {
							foto = IOUtils.toByteArray(stream);
							nuevoEmpleado.setFotobin(foto);
						} catch (IOException e) {
							e.printStackTrace();
						}  		
					
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
					
					if(nuevoEmpleado.getPerfil().getStrCodigoPerfil().equalsIgnoreCase("pf03")){
						nuevoSecretariaAcademica.setPersonas(nuevoEmpleado);
						personaService.guardaSecretaria(nuevoSecretariaAcademica);
						
					}else if (nuevoEmpleado.getPerfil().getStrCodigoPerfil().equalsIgnoreCase("pf02")) {
						nuevoAsistentaSocial.setPersonas(nuevoEmpleado);
						personaService.guardaAsistentaSocial(nuevoAsistentaSocial);
					}else if (nuevoEmpleado.getPerfil().getStrCodigoPerfil().equalsIgnoreCase("pf07")) {
						nuevoACA.setPersonas(nuevoEmpleado);
						personaService.guardaACA(nuevoACA);
					}else if (nuevoEmpleado.getPerfil().getStrCodigoPerfil().equalsIgnoreCase("pf08")) {
						nuevoADA.setPersonas(nuevoEmpleado);
						personaService.guardaADA(nuevoADA);		
					}
					
					EnviaMail enviaEMail = new EnviaMail();
					enviaEMail.EnviadorMailContrasena("registro",nuevoEmpleado.getStrMail(), nuevoEmpleado.getStrNombre()+ " "+nuevoEmpleado.getStrApellidoPaterno()+ " "+nuevoEmpleado.getStrApellidoMaterno(), tmpUsuario);
					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro de Empleado","Empleado se registró correctamente. Se ha enviado un notificación a su correo"));
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizaEmpleado(){
		System.out.println("---------------------------------------------------------------");
		System.out.println("--------------------------Actualiza Empleado---------------------");
		System.out.println("---------------------------------------------------------------");
		
		System.out.println(selectedEmpleado.getStrCodigoPersona());
		
		try {
			personaService.actulizarPersona(selectedEmpleado);
			
			Persona tmpPersona = new Persona();
			tmpPersona.setStrCodigoPersona(selectedEmpleado.getStrCodigoPersona());
			
			Perfil tmpPerfil = new Perfil();
			tmpPerfil.setStrCodigoPerfil(selectedEmpleado.getPerfil().getStrCodigoPerfil());
			
			Usuario tmpUsuario = new Usuario();
			tmpUsuario.setPersonas(tmpPersona);
			tmpUsuario.setPerfiles(tmpPerfil);
			
			usuarioService.actualizarPerfil(tmpUsuario);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Actulización de Empleado","Se actualizaron los datos del empleado"));
			
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

	public AsistentaSocial getNuevoAsistentaSocial() {
		return nuevoAsistentaSocial;
	}

	public void setNuevoAsistentaSocial(AsistentaSocial nuevoAsistentaSocial) {
		this.nuevoAsistentaSocial = nuevoAsistentaSocial;
	}

	public SecretariaAcademica getNuevoSecretariaAcademica() {
		return nuevoSecretariaAcademica;
	}

	public void setNuevoSecretariaAcademica(
			SecretariaAcademica nuevoSecretariaAcademica) {
		this.nuevoSecretariaAcademica = nuevoSecretariaAcademica;
	}

	public AsistenteCoordinacionAcademica getNuevoACA() {
		return nuevoACA;
	}

	public void setNuevoACA(AsistenteCoordinacionAcademica nuevoACA) {
		this.nuevoACA = nuevoACA;
	}

	public AsistenteDireccionAcademica getNuevoADA() {
		return nuevoADA;
	}

	public void setNuevoADA(AsistenteDireccionAcademica nuevoADA) {
		this.nuevoADA = nuevoADA;
	}
	
	
}
