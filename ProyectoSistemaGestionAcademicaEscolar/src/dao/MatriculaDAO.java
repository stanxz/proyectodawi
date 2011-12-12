package dao;


import entidades.Alumno;
import entidades.Matricula;
import entidades.Seccionprogramada;

public interface MatriculaDAO {
	
	public Matricula obtenerMatriculaAlumno(Alumno alumno) throws Exception;
	public Seccionprogramada obtenerSecProAlumno(Matricula matricula) throws Exception;
}
