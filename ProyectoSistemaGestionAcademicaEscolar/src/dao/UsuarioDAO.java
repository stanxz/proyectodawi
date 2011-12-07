package dao;

import java.util.ArrayList;
import entidades.Permiso;
import entidades.Usuario;

public interface UsuarioDAO {
	
	public Usuario validarUsuario(Usuario elusuario) throws Exception;
	public ArrayList<Permiso> listarMenus(Usuario elusuario) throws Exception;
	public Usuario buscaContrasena(Usuario elusuario) throws Exception;
	public void registrarUsuario(Usuario nuevo) throws Exception;
	
}
