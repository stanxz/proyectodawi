package dao;

import java.util.ArrayList;
import entidades.Permiso;
import entidades.Persona;
import entidades.Usuario;

public interface UsuarioDAO {
	
	public Usuario validarUsuario(Usuario elusuario) throws Exception;
	public ArrayList<Permiso> listarMenus(Usuario elusuario) throws Exception;
	public void actualizarPerfil(Usuario usuario) throws Exception;
	public Usuario buscaContrasena(Persona persona) throws Exception;
	public void registrarUsuario(Usuario nuevo) throws Exception;
	
}
