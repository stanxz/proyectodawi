package jsf.bean;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import entidades.Apoderado;
import entidades.Perfil;
import entidades.Persona;
import entidades.Usuario;
import servicios.ApplicationBusinessDelegate;
import servicios.PersonaService;
import servicios.UsuarioService;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class ApoderadoBean implements Serializable{

	 private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	 private static PersonaService apoderadoService=abd.getPersonaService();
	 private static UsuarioService userapoderadoService=abd.getUsuarioService();
	 private ArrayList<Persona> apoderados;
	 private Persona apoderado,apoderadoSelected,nuevoApoderado;
	 private String mensaje,usuarioapoderado,passapoderado;
	 private Usuario nuevousuario;
	 private int eldniApoderado;
	 
	public ApoderadoBean() {
		System.out.println("Creado ApoderadoBean...");
		this.mensaje="";
		nuevoApoderado=new Persona();
	}
	 
	public void buscaApoderado(ActionEvent evento){
		try {
			System.out.println("Buscando apoderado ... ");
			Persona personatempo = new Persona();
			System.out.println("buscado: "+eldniApoderado);
			personatempo.setIntDNI(eldniApoderado);
			apoderado=new Persona();
			apoderado=apoderadoService.consultaPersona(personatempo);
			System.out.println("consulta hecha ...");
			if(apoderado!=null){
				System.out.println("Apoderado encontrado: "+apoderado.getStrNombre()+" "+apoderado.getStrApellidoPaterno());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Apoderado Encontrado: " + apoderado.getStrNombre() + " " + apoderado.getStrApellidoPaterno()));
				apoderados=new ArrayList<Persona>();
				apoderados.add(apoderado);
				this.mensaje="";
			}else{
				System.out.println("No se encontro el apoderado");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se encontró el apoderado","No se encontró el apoderado"));
				apoderados=new ArrayList<Persona>();
				apoderado=new Persona();
				this.mensaje="No se encuentra el apoderado";
			}		
			//this.apoderado=apoderadoService.getListaAniosAcademicos();
			//System.out.println("Cantidad Anios cargados: "+anosAcademicos.size());
		} catch (Exception e) {
			apoderados=new ArrayList<Persona>();
			apoderado=new Persona();
			e.printStackTrace();
		}
	}
	
	public void seteaApoderado(){
		System.out.println("seteando el apoderado ... ");
		System.out.println("apoderado mandado: "+apoderado.getStrNombre()+" "+apoderado.getStrApellidoPaterno());
	}

	
	public void registraApoderado() {  
		System.out.println("en el registraApoderado");
		Persona auxitemporal = null;
		
		//Llena datos que iran a la tabla usuario
		Perfil p = new Perfil();
		p.setStrCodigoPerfil("pf01");

		nuevousuario = new Usuario();
		nuevousuario.setPersonas(nuevoApoderado);
		nuevousuario.setStrContrasena(passapoderado);
		nuevousuario.setPerfiles(p);
		
		try {
			//reflex. se invocando los emtodos 
			for (Method m : nuevoApoderado.getClass().getMethods()){
				if(m.getName().startsWith("get"))
				System.out.println("nuevo Apoderado - " + m.getName() + " : " +  m.invoke(nuevoApoderado));
			}
			
			for (Method m : nuevousuario.getClass().getMethods()){
				if(m.getName().startsWith("get"))
				System.out.println("nuevo Usuario - "+m.getName() + " : " +  m.invoke(nuevousuario));
			}
			
			System.out.println("consultando apoderado ... ");
			
			auxitemporal = apoderadoService.consultaPersona(nuevoApoderado);
			
		} catch (Exception e) {
			System.out.println("error: "+e.getMessage());
		}

		if(auxitemporal!=null){
			System.out.println("Apoderado "+auxitemporal.getStrCodigoPersona()+"("+auxitemporal.getStrNombre()+" "+auxitemporal.getStrApellidoPaterno()+") ya existe !!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Apoderado ya se encuentra registrado: " + nuevoApoderado.getStrNombre() + " " + nuevoApoderado.getStrApellidoPaterno()));
		}else{
			System.out.println("se va a insertar el apoderado y su usuario");
			try {
				System.out.println("insertando apoderado y su usuario ... ");
				apoderadoService.registrarPersona(nuevoApoderado);
				userapoderadoService.registrarUsuario(nuevousuario);
				
				Apoderado apotempo = new Apoderado();
				apotempo.setPersonas(nuevoApoderado);
				apoderadoService.guardaApoderado(apotempo);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Apoderado Insertado correctamente: " + nuevoApoderado.getStrNombre() + " " + nuevoApoderado.getStrApellidoPaterno()));
				//nuevousuario =  new Usuario();
				//nuevoApoderado = new Persona();
				System.out.println("insertados correctamente ... ");
			} catch (Exception e) {
				System.out.println("Hubo un error insertando ...");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó al apoderado","No se insertó el apoderado"));
				nuevousuario =  new Usuario();
				nuevoApoderado = new Persona();
				e.printStackTrace();
			}
		}
    }
	
	public Persona getApoderado() {
		return apoderado;
	}

	public void setApoderado(Persona apoderado) {
		this.apoderado = apoderado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/*public String getElcodigoApoderado() {
		return elcodigoApoderado;
	}

	public void setElcodigoApoderado(String elcodigoApoderado) {
		this.elcodigoApoderado = elcodigoApoderado;
	}*/

	public ArrayList<Persona> getApoderados() {
		return apoderados;
	}

	public void setApoderados(ArrayList<Persona> apoderados) {
		this.apoderados = apoderados;
	}

	public Persona getApoderadoSelected() {
		return apoderadoSelected;
	}

	public void setApoderadoSelected(Persona apoderadoSelected) {
		this.apoderadoSelected = apoderadoSelected;
	}

	public Persona getNuevoApoderado() {
		return nuevoApoderado;
	}

	public void setNuevoApoderado(Persona nuevoApoderado) {
		this.nuevoApoderado = nuevoApoderado;
	}

	public Usuario getNuevousuario() {
		return nuevousuario;
	}

	public void setNuevousuario(Usuario nuevousuario) {
		this.nuevousuario = nuevousuario;
	}

	public String getUsuarioapoderado() {
		return usuarioapoderado;
	}

	public void setUsuarioapoderado(String usuarioapoderado) {
		this.usuarioapoderado = usuarioapoderado;
	}

	public String getPassapoderado() {
		return passapoderado;
	}

	public void setPassapoderado(String passapoderado) {
		this.passapoderado = passapoderado;
	}

	public int getEldniApoderado() {
		return eldniApoderado;
	}

	public void setEldniApoderado(int eldniApoderado) {
		this.eldniApoderado = eldniApoderado;
	}
	
	
	 
}
