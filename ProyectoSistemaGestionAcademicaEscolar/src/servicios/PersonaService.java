package servicios;

import entidades.Apoderado;
import entidades.Persona;
import entidades.Usuario;

public interface PersonaService {

	public Persona consultaPersona(Usuario u) throws Exception;
	public void registrarPersona(Persona nueva) throws Exception;
	public void guardaApoderado(Apoderado apotempo) throws Exception;
	
}
