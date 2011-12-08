package servicios;

import java.util.ArrayList;

import entidades.Apoderado;
import entidades.Persona;
import entidades.Usuario;

public interface PersonaService {

	public ArrayList<Persona> obtenerTodosEmpleados()throws Exception;
	public Persona consultaPersona(Persona p) throws Exception;
	public void registrarPersona(Persona nueva) throws Exception;
	public void guardaApoderado(Apoderado apotempo) throws Exception;
	
}
