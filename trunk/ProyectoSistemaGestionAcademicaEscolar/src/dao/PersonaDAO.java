package dao;

import java.util.ArrayList;

import entidades.Apoderado;
import entidades.AsistentaSocial;
import entidades.Persona;
import entidades.SecretariaAcademica;

public interface PersonaDAO {
	
	public ArrayList<Persona> obtenerTodosEmpleados()throws Exception;

	public Persona consultarPersona(Persona p) throws Exception;

	public void registrarPersona(Persona nueva) throws Exception;

	public void guardaApoderado(Apoderado apo) throws Exception;
	
	public void guardaAsistentaSocial(AsistentaSocial asistenta) throws Exception;
	
	public void guardaSecretaria(SecretariaAcademica secretaria) throws Exception;
}
