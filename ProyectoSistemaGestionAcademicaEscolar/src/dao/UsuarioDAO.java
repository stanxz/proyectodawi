package dao;

import java.util.ArrayList;


import entidades.Permiso;
import entidades.Usuario;

public interface UsuarioDAO {
	
	public boolean validarUsuario(Usuario elusuario) throws Exception;
	public ArrayList<Permiso> listarMenus(Usuario elusuario) throws Exception;
	
}
