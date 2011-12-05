package dao;

import entidades.Apoderado;
import entidades.Persona;
import entidades.Usuario;

public interface PersonaDAO {

	public Persona consultarPersona(Usuario u) throws Exception;

	public void registrarPersona(Persona nueva) throws Exception;

	public void guardaApoderado(Apoderado apo) throws Exception;
}
