package jsf.bean;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import servicios.AlumnoService;
import servicios.ApplicationBusinessDelegate;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Calendarioacademico;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class AlumnoBean implements Serializable{
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AlumnoService alumnoService=abd.getAlumnoService();
	
	private Alumno alumno,selectedAlumno,nuevoAlumno;
	private Apoderado apoderado; 
	private ArrayList<Alumno> alumnos;
	private ArrayList<Calendarioacademico> anosAcademicos;
	private boolean editMode;  


	public AlumnoBean() {
		System.out.println("Creado AlumnoBean...");
		try {
			this.anosAcademicos=alumnoService.getListaAniosAcademicos();
			System.out.println("Cantidad Anios cargados: "+anosAcademicos.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registraAlumno(ActionEvent ae) {  
		System.out.println("dizke insertando");
		
		
		//System.out.println("Nombre selected: "+selectedAlumno.getStrNombres());
		//System.out.println("Apellidos selected: "+selectedAlumno.getStrApellidoPaterno()+" "+selectedAlumno.getStrApellidoMaterno());
		System.out.println("Nombre alumno nuevo: " + nuevoAlumno.getStrNombres());
		System.out.println("Apellidos alumno nuevo: " + nuevoAlumno.getStrApellidoPaterno()+" "+nuevoAlumno.getStrApellidoMaterno());
		
		try {
			//alumnoService.inhabilitarAlumno(alumno);
			System.out.println("dizke se registro");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void actualizaAlumno(ActionEvent ae){
		System.out.println("Hola madafaka !!!");
		System.out.println(selectedAlumno.getStrNombres());
		try {
			Date auxi=new Date(selectedAlumno.getFecha().getTime());
			selectedAlumno.setDtFecNac(auxi);
			
			for (Method m : selectedAlumno.getClass().getMethods()){
				if(m.getName().startsWith("get"))
				System.out.println("xD: "+m.getName() + " : " +  m.invoke(selectedAlumno));
			}
			
			
			alumnoService.actualizarAlumno(selectedAlumno);
			System.out.println("dizke se actualizo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "listadoAlumnos.xhtml";
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


	
}
