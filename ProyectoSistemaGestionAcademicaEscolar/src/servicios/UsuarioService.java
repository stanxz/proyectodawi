package servicios;

import java.util.ArrayList;
import entidades.Permiso;
import entidades.Persona;
import entidades.Usuario;

public interface UsuarioService {

	public Usuario validarUsuarioEntrada(Usuario elusuario) throws Exception;
	public ArrayList<Permiso> listarMenusCorresp(Usuario elusuario) throws Exception;
	public Usuario consultaPass(Persona persona) throws Exception;
	public void registrarUsuario(Usuario nuevo) throws Exception;
	public void actualizarPerfil(Usuario usuario) throws Exception;
	
}
