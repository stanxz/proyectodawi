package jsf.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import entidades.Permiso;
//import entidades.Persona;
import entidades.Usuario;

import servicios.ApplicationBusinessDelegate;
import servicios.UsuarioService;

@ManagedBean
public class LogueoBean {

	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static UsuarioService userService = abd.getUsuarioService();
	
	private ArrayList<Permiso> funcionalidades;
	private Permiso funcionalidad;
	private Usuario usuario;
	
	private String cadenausuario,cadenapassword;
	
	
	public LogueoBean(){
		System.out.println("Creando LogueoBean...");
	}

	public String loguearUsuario(){
		System.out.println("En el loguear usuario - UsuarioBean");

		System.out.println("el usuario: "+cadenausuario);
		System.out.println("el pass : "+cadenapassword);
		
		usuario =  new Usuario();
		
		usuario.setStrCodigoPersona(cadenausuario);
		usuario.setStrContrasena(cadenapassword);
		
		
		Usuario userauxi;
		
		try {
			userauxi = userService.validarUsuarioEntrada(usuario);
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
		LogueoBean.userService = userService;
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
	
	
	
}
