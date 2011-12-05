package servicios;

import entidades.Persona;
import entidades.Usuario;

public interface PersonaService {

	public Persona consultaPersona(Usuario u) throws Exception;
	public void registrarPersona(Persona nueva) throws Exception;
	
}
