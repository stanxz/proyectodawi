package jsf.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.eclipse.persistence.exceptions.DatabaseException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import servicios.AlumnoService;
import servicios.ApplicationBusinessDelegate;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Calendarioacademico;
import entidades.Persona;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class AlumnoBean implements Serializable{
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AlumnoService alumnoService=abd.getAlumnoService();
	
	private Alumno alumno,selectedAlumno;
	private Persona persona;
	private Apoderado apoderado;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Calendarioacademico> anosAcademicos;
	private boolean editMode;
	private String strCodigoApoderado,mensaje;
	
	private Alumno nuevoAlumno =  new Alumno();
	
	
	public AlumnoBean() {
		System.out.println("Creado AlumnoBean...");
		CargarAniosAcademicos();
	}
	
	public void registraAlumno(ActionEvent ae) {  
		System.out.println("insertando alumno");
		
		Date auxi = new Date(nuevoAlumno.getFechaNacimiento().getTime());
		nuevoAlumno.setDtFecNac(auxi);
		
		Calendarioacademico entidadCalendario = new Calendarioacademico();
		entidadCalendario.setStrCodcalendario(nuevoAlumno.getStrAnioAcademico());
		
		nuevoAlumno.setCalendarioacademico(entidadCalendario);
		
		System.out.println(nuevoAlumno.getStrCodigoAlumno() );
		System.out.println(nuevoAlumno.getApoderados().getPersonas().getStrCodigoPersona());
		System.out.println(nuevoAlumno.getStrNombres());
		System.out.println(nuevoAlumno.getStrApellidoPaterno());
		System.out.println(nuevoAlumno.getStrApellidoMaterno());
		System.out.println(nuevoAlumno.getDtFecNac());
		
		
		try {
			alumnoService.registrarAlumno(nuevoAlumno);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno Insertado correctamente: " + nuevoAlumno.getStrNombres() + " " + nuevoAlumno.getStrApellidoPaterno()));
			System.out.println("Se registro el Alumno con exito");
			nuevoAlumno =  new Alumno();
		}catch(DatabaseException dbe){
			System.out.println("Error registrando el alumno: "+dbe.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: Ese codigo de alumno ya se encuentra registrado","No se insertó el alumno: "+dbe.getMessage()));
			nuevoAlumno =  new Alumno();
		}
		catch(MySQLIntegrityConstraintViolationException micve){
			System.out.println("Error registrando el alumno: "+micve.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: Ese codigo de alumno ya se encuentra registrado","No se insertó el alumno: "+micve.getMessage()));
			nuevoAlumno =  new Alumno();
		} 
		catch (Exception e) {
			System.out.println("Error registrando el alumno: "+e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó al alumno","No se insertó el alumno: "+e.getMessage()));
			nuevoAlumno =  new Alumno();
			//e.printStackTrace();
		}
    }
	
	public void actualizaAlumno(ActionEvent ae){
		System.out.println("Actualizando alumno ... ");
		System.out.println(selectedAlumno.getStrNombres());
		try {
			Date auxi=new Date(selectedAlumno.getFecha().getTime());
			selectedAlumno.setDtFecNac(auxi);
			
			Calendarioacademico entidadCalendario = new Calendarioacademico();
			entidadCalendario.setStrCodcalendario(selectedAlumno.getStrAnioAcademico());
			
			nuevoAlumno.setCalendarioacademico(entidadCalendario);

			alumnoService.actualizarAlumno(selectedAlumno);
			System.out.println("alumno actualizado con exito ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void CargarAniosAcademicos(){
		try {
			this.anosAcademicos=alumnoService.getListaAniosAcademicos();
			System.out.println("Cantidad Años cargados: " + anosAcademicos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public ArrayList<Alumno> getAlumnos() {
		try {
			System.out.println("entro a listar todos ....");
			alumnos = alumnoService.obtenerTodosAlumnos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno getSelectedAlumno() {
		return selectedAlumno;
	}

	public void setSelectedAlumno(Alumno selectedAlumno) {
		this.selectedAlumno = selectedAlumno;
	}


	public boolean isEditMode() {
		return editMode;
	}


	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public ArrayList<Calendarioacademico> getAnosAcademicos() {
		return anosAcademicos;
	}

	public void setAnosAcademicos(ArrayList<Calendarioacademico> anosAcademicos) {
		this.anosAcademicos = anosAcademicos;
	}

	public Alumno getNuevoAlumno() {
		return nuevoAlumno;
	}

	public void setNuevoAlumno(Alumno nuevoAlumno) {
		this.nuevoAlumno = nuevoAlumno;
	}

	public String getStrCodigoApoderado() {
		return strCodigoApoderado;
	}

	public void setStrCodigoApoderado(String strCodigoApoderado) {
		this.strCodigoApoderado = strCodigoApoderado;
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
