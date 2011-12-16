package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import servicios.AlumnoService;
import servicios.ApplicationBusinessDelegate;
import servicios.MatriculaService;
import servicios.MotivoService;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Matricula;
import entidades.Motivo;
import entidades.Persona;
import entidades.Seccionprogramada;
import entidades.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class AlumnoExoneracionBean implements Serializable{
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AlumnoService alumnoService = abd.getAlumnoService();
	private static MotivoService motivoService = abd.getMotivoService();
	private static MatriculaService matriculaoService = abd.getMatriculaService();
	
	private Alumno alumno;
	private Seccionprogramada seccionProgramada;
	private Persona persona;
	private Apoderado apoderado;
	private ArrayList<Alumno> alumnosXapoderado;
	private ArrayList<Motivo> motivos;
	private String prueba;
	private Motivo motivo = new Motivo();
	
	private Boolean btnAdjuntar;
	private Boolean btnCita;

	private Alumno exoneracionAlumno = new Alumno();
	
	
	public AlumnoExoneracionBean() {
		System.out.println("Creado AlumnoRetiroBean...");
		CargaMotivos();
	}
	
	 public void CargaExoneracionAlumno() {  
		 System.out.println(exoneracionAlumno.getStrCodigoAlumno());
	        try {
	        	
				alumno = alumnoService.obtenerAlumno(exoneracionAlumno);
				
				Matricula matricula =  matriculaoService.obtenerMatriculaAlumno(alumno);
				
				seccionProgramada = matriculaoService.obtenerSecProAlumno(matricula);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}  
	 
	 public void registraSolicitud(){
		 System.out.println("--------------------------------------");
		 System.out.println("------Registra Solictud---------------");
		 System.out.println("--------------------------------------");
		 
		 
		 System.out.println(alumno.getStrCodigoAlumno());
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
	 
	 public void motivoChange(){
		 System.out.println("Llego Aqui");
		 System.out.println(motivo.getIntCodigoMotivo());
		 
		 if (motivo.getIntCodigoMotivo() == 1) {
			btnAdjuntar = true;
			btnCita = false;
		}else if(motivo.getIntCodigoMotivo() == 2 || motivo.getIntCodigoMotivo() == 3){
			btnAdjuntar = false;
			btnCita = true;
		}
	 }
	 
	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
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

	public Alumno getExoneracionAlumno() {
		return exoneracionAlumno;
	}

	public void setExoneracionAlumno(Alumno exoneracionAlumno) {
		this.exoneracionAlumno = exoneracionAlumno;
	}

	public Boolean getBtnAdjuntar() {
		return btnAdjuntar;
	}

	public void setBtnAdjuntar(Boolean btnAdjuntar) {
		this.btnAdjuntar = btnAdjuntar;
	}

	public Boolean getBtnCita() {
		return btnCita;
	}

	public void setBtnCita(Boolean btnCita) {
		this.btnCita = btnCita;
	}

	public ArrayList<Motivo> getMotivos() {
		return motivos;
	}

	public void setMotivos(ArrayList<Motivo> motivos) {
		this.motivos = motivos;
	}
	

	public Seccionprogramada getSeccionProgramada() {
		return seccionProgramada;
	}

	public void setSeccionProgramada(Seccionprogramada seccionProgramada) {
		this.seccionProgramada = seccionProgramada;
	}

	public ArrayList<Alumno> getAlumnosXapoderado() {
		try {
			
			//NO BORRAR 
			//HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			
			//Usuario usuario = (Usuario)session.getAttribute("b_usuario");
			
			
			//System.out.println(usuario.getPersonas().getStrCodigoPersona());
			
			persona = new Persona();
			//persona.setStrCodigoPersona(usuario.getPersonas().getStrCodigoPersona());
			persona.setStrCodigoPersona("PE-18181818");
			
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

	public String getPrueba() {
		return prueba;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}
	
	

}
