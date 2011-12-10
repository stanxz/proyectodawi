package servicios;

import java.util.ArrayList;

import entidades.Apoderado;
import entidades.Persona;

public interface PersonaService {

	public ArrayList<Persona> obtenerTodosEmpleados()throws Exception;
	public Persona consultaPersona(Persona p) throws Exception;
	public void registrarPersona(Persona nueva) throws Exception;
	public void actulizarPersona(Persona persona) throws Exception;
	public void guardaApoderado(Apoderado apotempo) throws Exception;
	
}
