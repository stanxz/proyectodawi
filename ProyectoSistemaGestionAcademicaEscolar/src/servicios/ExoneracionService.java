package servicios;


import entidades.Alumno;
import entidades.Matricula;
import entidades.Seccionprogramada;

public interface ExoneracionService {

	public Matricula obtenerMatriculaAlumno(Alumno alumno) throws Exception;
	public Seccionprogramada obtenerSecProAlumno(Matricula matricula) throws Exception;
	public void registrarMatricula(Matricula matricula) throws Exception;
}
