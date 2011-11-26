package servicios;

import java.util.ArrayList;

import entidades.Alumno;
import entidades.Calendarioacademico;

public interface AlumnoService {

	  public ArrayList<Alumno> obtenerTodosAlumnos() throws Exception;
	  public void registrarAlumno(Alumno alumno) throws Exception;
	  public void actualizarAlumno(Alumno alumno) throws Exception;
	  public void inhabilitarAlumno(Alumno alumno) throws Exception;
	  public Alumno obtenerAlumno(Alumno alumno) throws Exception;
	  public ArrayList<Calendarioacademico> getListaAniosAcademicos() throws Exception;
	
}
