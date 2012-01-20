package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import servicios.AlumnoService;
import servicios.ApplicationBusinessDelegate;
import servicios.BoletaService;
import servicios.MatriculaService;
import servicios.MotivoService;
import servicios.PersonaService;
import servicios.SolicitudRetiroService;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Boleta;
import entidades.Matricula;
import entidades.Motivo;
import entidades.Persona;
import entidades.Seccionprogramada;
import entidades.SolicitudRetiro;
import entidades.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class AlumnoRetiroBean implements Serializable{
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AlumnoService alumnoService = abd.getAlumnoService();
	private static MotivoService motivoService = abd.getMotivoService();
	private static MatriculaService matriculaoService = abd.getMatriculaService();
	private static PersonaService personaService = abd.getPersonaService();
	private static BoletaService boletaService = abd.getBoletaService();
	private static SolicitudRetiroService retiroService = abd.getRetiroService();
	
	private Alumno alumno;
	private Seccionprogramada seccionProgramada;
	private Persona persona;
	private Apoderado apoderado;
	private ArrayList<Alumno> alumnosXapoderado;
	private ArrayList<Motivo> motivos;
	private String prueba;
	private Motivo motivo = new Motivo();
	private Boleta boleta = new Boleta();
	private Boolean btnAdjuntar;
	private Boolean btnCita=false;
	private Boolean txtBoleta;
	private Boolean txtObservacion;
	private String observacion;
	private StreamedContent documento;
	private SolicitudRetiro misolicitud=new SolicitudRetiro();
	private Map<String, Object> misesion;

	private String valor="";
	private Alumno retiroAlumno = new Alumno();
		
	public AlumnoRetiroBean() {
		System.out.println("Creado AlumnoRetiroBean...");
		CargaMotivos();
	}
	
	public void generaSolicitud(){
		SolicitudRetiro sr=new SolicitudRetiro();
		sr.setAlumno(alumno);
		sr.setIntFlagprocesado(0);
		sr.setDtFecNac(new java.sql.Date(new java.util.Date().getTime()));
		sr.setStrEstado("PENDIENTE");
		sr.setStrMotivo(""+motivo.getIntCodigoMotivo());
		sr.setStrObservacion(observacion);
		sr.setAsistenteDireccion(null);
		if(misolicitud.getCertificadobin()!=null){
			System.out.println("certificadobin lleno ... ");
			sr.setCertificadobin(misolicitud.getCertificadobin());
		}else{
			System.out.println("certificadobin vacio");
		}
		
		Apoderado tempoapo=new Apoderado();
		Persona tempopersona=new Persona();
		try {
			System.out.println("consultando apoderado del alumno ... ");
			tempopersona=personaService.consultaApoderadoxAlumno(alumno);
			if(tempopersona!=null){
				System.out.println("Apoderado encontrado: "+tempopersona.getStrCodigoPersona());
				tempoapo.setPersonas(tempopersona);
				
				System.out.println("Ahora se consultara la boleta: "+boleta.getStrCodigoBoleta());
				Boleta boletempo=new Boleta();
				Boleta miboleta=new Boleta();
				boletempo.setStrCodigoBoleta(boleta.getStrCodigoBoleta());
				Apoderado apotempo=new Apoderado();
				Persona persotempo=new Persona();
				misesion=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				int numero=((Usuario)misesion.get("b_usuario")).getPersonas().getIntDNI();
				System.out.println("numerooooo de DNI del apoderado: "+numero);
				persotempo.setIntDNI(numero);
				apotempo.setPersonas(persotempo);
				boletempo.setApoderados(apotempo);

				miboleta=boletaService.obtenerBoleta(boletempo);
				if(miboleta!=null){
					System.out.println("Boleta encontrada, se va a consultar si existe alguna solicitud pendiente ... ");
					SolicitudRetiro temposr=retiroService.buscarSolicitudXAlumnoXAño(sr);
					if(temposr!=null){
						System.out.println("Ya existe una solicitud de retiro pendiente");
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Solicitud de Retiro","El Alumno "+ sr.getAlumno().getStrCodigoAlumno()+" ya tiene una solicitud de retiro registrada !" ));
					}else{
						System.out.println("registrando Solicitud de Retiro ... ");
						retiroService.registrarSolictud(sr);
						System.out.println("actualizando estado de Boleta ... ");
						boletaService.actualizaCierredeBoleta(miboleta);
						FacesMessage msg = new FacesMessage("Solicitud de Retiro Registrada","Se guardó Solicitud de Retiro del Alumno "+sr.getAlumno().getStrCodigoAlumno());
			    	    FacesContext.getCurrentInstance().addMessage(null, msg);
					}
					
				}else{
					System.out.println("No se encontro la boleta ... ");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Solicitud de Retiro","Boleta de Pago No Encontrada" ));
				}
				
			}else{
				System.out.println("No existe apoderado para el alumno: "+alumno.getIntDni());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Solicitud de Retiro","No existe apoderado para el alumno "+sr.getAlumno().getStrCodigoAlumno() ));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Solicitud de Retiro","Error General: "+e.getMessage()));
			e.printStackTrace();
			
		}
		
	}
	
	 public void CargaRetiroAlumno() {  
		 System.out.println(retiroAlumno.getStrCodigoAlumno());
	        try {
				alumno = alumnoService.obtenerAlumno(retiroAlumno);
				
				Matricula matricula =  matriculaoService.obtenerMatriculaAlumno(alumno);
				
				seccionProgramada = matriculaoService.obtenerSecProAlumno(matricula);
				
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
	 
	 public void cargarDocumentoInsertar(FileUploadEvent event) {  
		    System.out.println("en cargarDocumentoInsertar ... ");
	    	System.out.println("Nombre archivo: " + event.getFile().getFileName());
	    	
	    	try {
	    	    documento = new DefaultStreamedContent(event.getFile().getInputstream());
	    	    
	    	    System.out.println("otra vez el nombre: " + event.getFile().getFileName());
	    	  
	    	    byte[] foto = event.getFile().getContents();
	    	    misolicitud.setCertificadobin(foto);
	    	    valor = "OK";
	    	    FacesMessage msg = new FacesMessage("Acción Completada!!!", event.getFile().getFileName() + " se cargó.");
	    	    FacesContext.getCurrentInstance().addMessage(null, msg);
	    	  } catch (Exception ex) {
	    		  ex.printStackTrace();
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

	public Alumno getRetiroAlumno() {
		return retiroAlumno;
	}

	public void setRetiroAlumno(Alumno retiroAlumno) {
		this.retiroAlumno = retiroAlumno;
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
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Usuario usuario = (Usuario)session.getAttribute("b_usuario");
			System.out.println("codigo Persona: "+usuario.getPersonas().getStrCodigoPersona());
			
			persona = new Persona();
			persona.setStrCodigoPersona(usuario.getPersonas().getStrCodigoPersona());
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

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Boolean getTxtBoleta() {
		return txtBoleta;
	}

	public void setTxtBoleta(Boolean txtBoleta) {
		this.txtBoleta = txtBoleta;
	}

	public Boolean getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(Boolean txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public StreamedContent getDocumento() {
		return documento;
	}

	public void setDocumento(StreamedContent documento) {
		this.documento = documento;
	}

	public SolicitudRetiro getMisolicitud() {
		return misolicitud;
	}

	public void setMisolicitud(SolicitudRetiro misolicitud) {
		this.misolicitud = misolicitud;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
