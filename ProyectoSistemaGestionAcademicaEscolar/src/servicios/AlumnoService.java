package servicios;

import java.util.List;

import entidades.Alumno;

public interface AlumnoService {

	  public List<Alumno> obtenerTodosAlumnos() throws Exception;
	  public void registrarAlumno(Alumno alumno) throws Exception;
	  public void actualizarAlumno(Alumno alumno) throws Exception;
	  public void inhabilitarAlumno(Alumno alumno) throws Exception;
	  public Alumno obtenerAlumno(Alumno alumno) throws Exception;
	
}
