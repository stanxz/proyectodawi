package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import servicios.AlumnoService;
import servicios.ApplicationBusinessDelegate;
import servicios.AsignaturaService;
import servicios.MatriculaService;
import servicios.MotivoService;
import servicios.SolicitudExoneracionService;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Asignatura;
import entidades.Boleta;
import entidades.Matricula;
import entidades.Motivo;
import entidades.Persona;
import entidades.Seccionprogramada;
import entidades.SolicitudExoneracion;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class GenerarExoneracionBean implements Serializable{
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AlumnoService alumnoService = abd.getAlumnoService();
	private static MotivoService motivoService = abd.getMotivoService();
	private static MatriculaService matriculaService = abd.getMatriculaService();
	private static AsignaturaService asignaturaService = abd.getAsignaturaService();
	private static SolicitudExoneracionService exoneracionService = abd.getExoneracionService();
	
	private Alumno alumno;
	private Seccionprogramada seccionProgramada;
	private Persona persona;
	private Apoderado apoderado;
	private ArrayList<Alumno> alumnosXapoderado;
	private ArrayList<Asignatura> asignaturasXgrado;
	private ArrayList<Motivo> motivos;
	private Motivo motivo = new Motivo();
	private SolicitudExoneracion exoneracion = new SolicitudExoneracion();
	private Boleta boleta = new Boleta();
	
	private Boolean btnAdjuntar;
	private Boolean btnCita;

	private Alumno exoneracionAlumno = new Alumno();
	
	private StreamedContent image; 
	
	private String valor;
	
	
	public GenerarExoneracionBean() {
		System.out.println("Creado AlumnoRetiroBean...");
		CargaMotivos();
	}
	
	 public void CargaExoneracionAlumno(){  
		 System.out.println(exoneracionAlumno.getStrCodigoAlumno());
	        try {
	        	
	        	//exoneracionService.CumpleCalendarioExoneracion(2011);
	        		
	        	System.out.println("Cumple");
	        	
	        	valor = "";
	        	
	        	alumno = alumnoService.obtenerAlumno(exoneracionAlumno);
					
				Matricula matricula =  matriculaService.obtenerMatriculaAlumno(alumno);
					
				seccionProgramada = matriculaService.obtenerSecProAlumno(matricula);
				
				asignaturasXgrado = asignaturaService.obtenerAsignaturasXGradoRetiro(seccionProgramada);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}  
	 
	 public void registraSolicitud(){
		 System.out.println("--------------------------------------");
		 System.out.println("------Registra Solicitud---------------");
		 System.out.println("--------------------------------------");
		 
		 
		 System.out.println(alumno.getStrCodigoAlumno());
		 System.out.println(exoneracion.getAsignaturas().getIntCodigoAsignatura());
		 
		 Alumno entidadAlumno = new Alumno();
		 entidadAlumno.setStrCodigoAlumno(alumno.getStrCodigoAlumno());
		 
		 Asignatura entidadAsignatura = new Asignatura();
		 entidadAsignatura.setIntCodigoAsignatura(exoneracion.getAsignaturas().getIntCodigoAsignatura());
		 
		 exoneracion.setAlumno(entidadAlumno);
		 
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Solicitud de Exoneracion","Solicitud registrada correctamente"));
		 
		 try {
			exoneracionService.registrarSolictud(exoneracion);
		} catch (Exception e) {
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
	 
	 public void cargarImagen(FileUploadEvent event) {  
	    	System.out.println("XD " + event.getFile().getFileName());
	    	
	    	try {
	    	    image = new DefaultStreamedContent(event.getFile().getInputstream());
	    	    
	    	    System.out.println("XD2 " + event.getFile().getFileName());
	    	    
	    	    byte[] foto = event.getFile().getContents();
	    	    exoneracion.setFotobin(foto);
	    	    
	    	    valor = "OK";
	    	    
	    	    FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	    	    FacesContext.getCurrentInstance().addMessage(null, msg);
	    	  } catch (Exception ex) {
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

	public SolicitudExoneracion getExoneracion() {
		return exoneracion;
	}

	public void setExoneracion(SolicitudExoneracion exoneracion) {
		this.exoneracion = exoneracion;
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


	public ArrayList<Asignatura> getAsignaturasXgrado() {
		return asignaturasXgrado;
	}

	public void setAsignaturasXgrado(ArrayList<Asignatura> asignaturasXgrado) {
		this.asignaturasXgrado = asignaturasXgrado;
	}

	public StreamedContent getImage() {
		return image;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	
	
	
}
