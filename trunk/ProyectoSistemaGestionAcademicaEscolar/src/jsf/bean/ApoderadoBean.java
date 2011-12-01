package jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Persona;
import servicios.ApplicationBusinessDelegate;
import servicios.PersonaService;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class ApoderadoBean implements Serializable{

	 private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	 private static PersonaService apoderadoService=abd.getPersonaService();
	 
	 private Persona apoderado;
	 
	 
	public ApoderadoBean() {
		System.out.println("Creado ApoderadoBean...");
	}
	 
	public void buscaApoderado(){
		try {
			System.out.println("Buscando apoderado ... ");
			//this.apoderado=apoderadoService.getListaAniosAcademicos();
			//System.out.println("Cantidad Anios cargados: "+anosAcademicos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Persona getApoderado() {
		return apoderado;
	}

	public void setApoderado(Persona apoderado) {
		this.apoderado = apoderado;
	}
	
	
	 
}
