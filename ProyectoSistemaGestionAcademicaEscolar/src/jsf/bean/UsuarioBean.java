package jsf.bean;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import entidades.Permiso;
//import entidades.Persona;
import entidades.Usuario;

import servicios.ApplicationBusinessDelegate;
import servicios.UsuarioService;

@ManagedBean
public class UsuarioBean {

	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	//@ManagedProperty(value="#{userService}")
	private static UsuarioService userService = abd.getUsuarioService();
	
	private ArrayList<Permiso> funcionalidades;
	private Permiso funcionalidad;
	private Usuario usuario1;
	//private Persona persona1;
	
	private String cadenausuario,cadenapassword;
	
	
	public UsuarioBean(){
		System.out.println("Creando UsuarioBean...");
		//funcionalidad= new Permiso();
		usuario1= new Usuario();
		//persona1= new Persona();
	}

	public String loguearUsuario(){
		System.out.println("En el loguear usuario - UsuarioBean");
		//Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		//String cadenausuario = params.get("usuario");
		//String cadenapassword = params.get("password");
		System.out.println("el usuario: "+cadenausuario);
		System.out.println("el pass : "+cadenapassword);
		
		usuario1.setCodpersona(cadenausuario);
		usuario1.setContrasena(cadenapassword);
		
		//persona1.setCodpersona(cadenausuario);
	//	usuario1.setPersona(persona1);
	//	usuario1.setContrasena(cadenapassword);
		
		
		Usuario userauxi;
		try {
			userauxi = userService.validarUsuarioEntrada(usuario1);
			if(userauxi!=null){
				//userService.listarMenusCorresp(usuario1);
				System.out.println("usuario OK");
			}else{
				System.out.println("usuario nulo");
			}
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "bienvenida";
	}

	//getters y setter
	
	public static UsuarioService getUserService() {
		return userService;
	}

	public static void setUserService(UsuarioService userService) {
		UsuarioBean.userService = userService;
	}

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

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	/*public Persona getPersona1() {
		return persona1;
	}

	public void setPersona1(Persona persona1) {
		this.persona1 = persona1;
	}*/

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
	
	
	
}
