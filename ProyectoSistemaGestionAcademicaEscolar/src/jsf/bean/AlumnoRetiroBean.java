package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import servicios.AlumnoService;
import servicios.ApplicationBusinessDelegate;
import servicios.MotivoService;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Motivo;
import entidades.Persona;
import entidades.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class AlumnoRetiroBean implements Serializable{
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AlumnoService alumnoService = abd.getAlumnoService();
	private static MotivoService motivoService = abd.getMotivoService();
	
	private Alumno alumno;
	private Persona persona;
	private Apoderado apoderado;
	private ArrayList<Alumno> alumnosXapoderado;
	private ArrayList<Motivo> motivos;

	private Alumno retiroAlumno = new Alumno();
	
	
	public AlumnoRetiroBean() {
		System.out.println("Creado AlumnoRetiroBean...");
		CargaMotivos();
	}
	
	 public void CargaRetiroAlumno() {  
		 System.out.println(retiroAlumno.getStrCodigoAlumno());
	        try {
				alumno = alumnoService.obtenerAlumno(retiroAlumno);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}  
	 
	 public void CargaMotivos(){
		 System.out.println("Cargando Motivos ...");
		 try {
			motivos = motivoService.obtenerTodosMotivos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 }
	

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public Alumno getRetiroAlumno() {
		return retiroAlumno;
	}

	public void setRetiroAlumno(Alumno retiroAlumno) {
		this.retiroAlumno = retiroAlumno;
	}

	public ArrayList<Motivo> getMotivos() {
		return motivos;
	}

	public void setMotivos(ArrayList<Motivo> motivos) {
		this.motivos = motivos;
	}

	public ArrayList<Alumno> getAlumnosXapoderado() {
		try {
			
			//HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			
			//Usuario usuario = (Usuario)session.getAttribute("b_usuario");
			
			
			//System.out.println(usuario.getPersonas().getStrCodigoPersona());
			
			persona = new Persona();
			//persona.setStrCodigoPersona(usuario.getPersonas().getStrCodigoPersona());
			persona.setStrCodigoPersona("18181818");
			
			apoderado = new Apoderado();
			apoderado.setPersonas(persona);
			
			
			alumnosXapoderado = alumnoService.obtenerTodosAlumnosXApoderado(apoderado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumnosXapoderado;
	}

	public void setAlumnosXapoderado(ArrayList<Alumno> alumnosXapoderado) {
		this.alumnosXapoderado = alumnosXapoderado;
	}

}
