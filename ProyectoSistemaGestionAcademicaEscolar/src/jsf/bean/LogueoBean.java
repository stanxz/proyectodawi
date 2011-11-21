package jsf.bean;

import java.util.ArrayList;

//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;

import entidades.Permiso;
import entidades.Usuario;

import servicios.ApplicationBusinessDelegate;
import servicios.UsuarioService;

@ManagedBean
@RequestScoped
public class LogueoBean {

	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static UsuarioService userService = abd.getUsuarioService();
	
	private ArrayList<Permiso> funcionalidades;
	private Permiso funcionalidad;
	private Usuario usuario;
	//private Persona persona;
	
	private String cadenausuario,cadenapassword,mensaje;
	
	
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

		try {
			Usuario userauxi = userService.validarUsuarioEntrada(usuario);
			if(userauxi!=null){
				//userService.listarMenusCorresp(usuario1);
				System.out.println("usuario OK: "+userauxi.getStrCodigoPersona());
				return "bienvenida";
			}else{
				//FacesMessage mif=new FacesMessage();
			//	mif.setDetail("Mal");
				//FacesContext.getCurrentInstance().addMessage("Invalid login !! ",mif);
				System.out.println("usuario nulo");
				mensaje="Usuario o Password incorrecto !! ";
				System.out.println(""+mensaje);
				return "error";
			}
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(""+e1.getMessage());
			//FacesMessage mif=new FacesMessage();
			//mif.setDetail("Mal");
			//mif.setSeverity(null);
			//FacesContext.getCurrentInstance().addMessage("Invalid login !! ",mif);
			return "error";
		}

		
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
