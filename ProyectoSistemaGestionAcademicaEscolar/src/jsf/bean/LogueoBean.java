package jsf.bean;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import entidades.Permiso;
import entidades.Persona;
import entidades.Usuario;
import servicios.ApplicationBusinessDelegate;
import servicios.PersonaService;
import servicios.UsuarioService;
import utiles.EnviaMail;

@ManagedBean
@RequestScoped
public class LogueoBean {

	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static UsuarioService userService = abd.getUsuarioService();
	private static PersonaService personaService=abd.getPersonaService();
	
	private ArrayList<Permiso> funcionalidades;
	private Permiso funcionalidad;
	private Persona persona;
	private Usuario usuario; 
	public Map<String, Object> lasession;
	private String cadenausuario,cadenapassword,mensaje,mensaje2,dni;
	
	
	public LogueoBean(){
		System.out.println("Creando LogueoBean...");
	}

	public String loguearUsuario(){
		System.out.println("En el loguear usuario - UsuarioBean");

		System.out.println("el usuario: "+cadenausuario);
		System.out.println("el pass : "+cadenapassword);
		
		persona = new Persona();
		persona.setStrCodigoPersona(cadenausuario);
		
		usuario =  new Usuario();
		usuario.setPersonas(persona);
		usuario.setStrContrasena(cadenapassword);

		try {
			Usuario userauxi = userService.validarUsuarioEntrada(usuario);
			if(userauxi!=null){
				//ponemos al usuario en sesion
				lasession=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				lasession.put("b_usuario", userauxi);
				
				for (Permiso x : funcionalidades) {
					System.out.println("funcionalidad: "+x.getStrDescripcion());
				};
				
				//ponemos el menu en sesion
				funcionalidades = userService.listarMenusCorresp(userauxi);
				lasession.put("b_menu",funcionalidades);
				
				

				System.out.println("Usuario OK: " + userauxi.getPersonas().getStrCodigoPersona());
				return "bienvenida";
				
			}else{
				System.out.println("Usuario Nulo");
				mensaje="Usuario o Password incorrecto !! ";
				System.out.println("" + mensaje);
				return "error";
			}
				
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("error: " + e1.getMessage());
			mensaje="Usuario o Password incorrecto !! ";
			return "error";
		}

		
	}

	public String recuperarPass(){
		System.out.println("En el recuperarPass - UsuarioBean");

		System.out.println("el DNI: "+dni);		
		
		persona = new Persona();
		persona.setStrCodigoPersona(dni);
		
		usuario =  new Usuario();
		
		usuario.setPersonas(persona);

		if(!dni.isEmpty()){
			try {
				Usuario uauxi=userService.consultaPass(usuario);
				if(uauxi!=null){
						System.out.println("Enviando mail al usuario ... ");
						Persona pauxi=personaService.consultaPersona(uauxi);
						
						if(pauxi!=null){
							System.out.println("Persona encontrada: "+pauxi.getStrNombre()+ " "+pauxi.getStrApellidoPaterno()+ " "+pauxi.getStrApellidoMaterno());
							mensaje2="Enviando mensaje al usuario con DNI: "+uauxi.getPersonas().getStrCodigoPersona();
							//logica envio de correos
							EnviaMail enviador=new EnviaMail();
							enviador.EnviadorMailContrasena(pauxi.getStrMail(), pauxi.getStrNombre()+ " "+pauxi.getStrApellidoPaterno()+ " "+pauxi.getStrApellidoMaterno(), uauxi);
							return "index";
						}else{
							System.out.println("Persona no encontrada en la BD con ese dni !");
							mensaje2="Usuario No Registrado";
							return "error";
						}
						
				}else{
					System.out.println("Usuario No Registrado !! ");
					mensaje2="Usuario No Registrado";
					return "error";
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				mensaje2="Usuario No Registrado";
				e.printStackTrace();
				return "error";
			}
		}else{
			System.out.println("DNI vacio");
			mensaje2="Usuario No Registrado";
			return "error";
		}
	}
	
	
	public String regresar(){
		System.out.println("por regresar al index");
		return "index";
	}
	
	//getters y setter

	public ArrayList<Permiso> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(ArrayList<Permiso> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	public Permiso getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(Permiso funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCadenausuario() {
		return cadenausuario;
	}

	public void setCadenausuario(String cadenausuario) {
		this.cadenausuario = cadenausuario;
	}

	public String getCadenapassword() {
		return cadenapassword;
	}

	public void setCadenapassword(String cadenapassword) {
		this.cadenapassword = cadenapassword;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Map<String, Object> getLasession() {
		return lasession;
	}

	public void setLasession(Map<String, Object> lasession) {
		this.lasession = lasession;
	}

	public String getMensaje2() {
		return mensaje2;
	}

	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
