package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import entidades.Persona;
import entidades.Usuario;
import servicios.ApplicationBusinessDelegate;
import servicios.PersonaService;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class ApoderadoBean implements Serializable{

	 private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	 private static PersonaService apoderadoService=abd.getPersonaService();
	 private ArrayList<Persona> apoderados;
	 private Persona apoderado,apoderadoSelected;
	 private String mensaje,elcodigoApoderado;
	 
	 
	public ApoderadoBean() {
		System.out.println("Creado ApoderadoBean...");
		this.mensaje="";
	}
	 
	public void buscaApoderado(ActionEvent evento){
		try {
			System.out.println("Buscando apoderado ... ");
			Persona personatempo = new Persona();
			System.out.println("buscado: "+elcodigoApoderado);
			personatempo.setStrCodigoPersona(elcodigoApoderado);
			Usuario usuariotempo =  new Usuario();
			usuariotempo.setPersonas(personatempo);
			System.out.println("consultando");
			System.out.println("codigo:"+usuariotempo.getPersonas().getStrCodigoPersona());
			apoderado=new Persona();
			apoderado=apoderadoService.consultaPersona(usuariotempo);
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

	public String getElcodigoApoderado() {
		return elcodigoApoderado;
	}

	public void setElcodigoApoderado(String elcodigoApoderado) {
		this.elcodigoApoderado = elcodigoApoderado;
	}

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
	
	
	 
}
