package dao;

import java.util.ArrayList;

import entidades.Alumno;
import entidades.Apoderado;
import entidades.AsistentaSocial;
import entidades.AsistenteCoordinacionAcademica;
import entidades.AsistenteDireccionAcademica;
import entidades.Persona;
import entidades.SecretariaAcademica;

public interface PersonaDAO {
	
	public ArrayList<Persona> obtenerTodosEmpleados()throws Exception;

	public Persona consultarPersona(Persona p) throws Exception;

	public Persona consultaApoderado(Persona p) throws Exception;
	
	public void registrarPersona(Persona nueva) throws Exception;
	
	public void actulizarPersona(Persona persona) throws Exception;

	public void guardaApoderado(Apoderado apo) throws Exception;
	
	public void guardaAsistentaSocial(AsistentaSocial asistenta) throws Exception;
	
	public void guardaSecretaria(SecretariaAcademica secretaria) throws Exception;

	public Persona consultaApoderadoxAlumno(Alumno a) throws Exception;

	public void guardaACA(AsistenteCoordinacionAcademica aca) throws Exception;
	
	public void guardaADA(AsistenteDireccionAcademica ada) throws Exception;

	public ArrayList<Persona> obtenerTodosEmpleadosXTipo(String tipo)throws Exception;

}
