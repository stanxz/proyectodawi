package servicios;

import java.util.ArrayList;

import entidades.Permiso;
import entidades.Usuario;

public interface UsuarioService {

	public boolean validarUsuarioEntrada(Usuario elusuario) throws Exception;
	public ArrayList<Permiso> listarMenusCorresp(Usuario elusuario) throws Exception;
	
}
