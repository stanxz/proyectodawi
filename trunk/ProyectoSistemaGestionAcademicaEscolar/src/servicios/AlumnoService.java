package servicios;

import java.util.ArrayList;

import entidades.Alumno;
import entidades.Apoderado;
import entidades.Calendarioacademico;
import entidades.Distrito;

public interface AlumnoService {

	  public ArrayList<Alumno> obtenerTodosAlumnos() throws Exception;
	  public ArrayList<Alumno> obtenerTodosAlumnosXApoderado(Apoderado apoderado) throws Exception;
	  public void registrarAlumno(Alumno alumno) throws Exception;
	  public void actualizarAlumno(Alumno alumno) throws Exception;
	  public void inhabilitarAlumno(Alumno alumno) throws Exception;
	  public Alumno obtenerAlumno(Alumno alumno) throws Exception;
	  
	  public ArrayList<Calendarioacademico> getListaAniosAcademicos() throws Exception;
	
}
