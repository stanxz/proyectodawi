package jsf.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import servicios.AlumnoService;
import servicios.ApplicationBusinessDelegate;
import entidades.Alumno;
import entidades.Apoderado;

@ManagedBean
@RequestScoped
public class AlumnoBean {
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AlumnoService alumnoService=abd.getAlumnoService();
	
	private Alumno alumno,selectedAlumno;
	private Apoderado apoderado; 
	private ArrayList<Alumno> alumnos;
	private boolean editMode;  
	
	public AlumnoBean() {
		System.out.println("Creado AlumnoBean...");
		//alumno=new Alumno();
		//selectedAlumno=new Alumno();
	}

	public String inhabilitarAlumno() {  
		System.out.println("dizke deleteando");
		System.out.println("Nombre selected: "+selectedAlumno.getStrNombres());
		System.out.println("Apellidos selected: "+selectedAlumno.getStrApellidoPaterno()+" "+selectedAlumno.getStrApellidoMaterno());
		System.out.println("Nombre alumno: "+alumno.getStrNombres());
		System.out.println("Apellidos alumno: "+alumno.getStrApellidoPaterno()+" "+alumno.getStrApellidoMaterno());
		//alumnos.remove(selectedAlumno);
		try {
			alumnoService.inhabilitarAlumno(alumno);
			System.out.println("dizke se inhabilito");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listadoAlumnos";
    }
	
	public String actualizaAlumno(){
		System.out.println("Hola madafaka !!!");
		try {
			alumnoService.actualizarAlumno(selectedAlumno);
			System.out.println("dizke se actualizo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public ArrayList<Alumno> getAlumnos() {
		try {
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
	
}
