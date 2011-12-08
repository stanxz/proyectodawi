package servicios;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.UsuarioDAO;

import entidades.Permiso;
import entidades.Persona;
import entidades.Usuario;

public class UsuarioDaoService implements UsuarioService {

	private DAOFactory fabrica = null;
	private UsuarioDAO usuariodao;
	
	public UsuarioDaoService(int jpa) {
		fabrica = DAOFactory.getDAOFactory(jpa);
        this.usuariodao = fabrica.getUsuarioDAO();
	}

	@Override
	public Usuario validarUsuarioEntrada(Usuario elusuario) throws Exception {
		return usuariodao.validarUsuario(elusuario);
	}

	@Override
	public ArrayList<Permiso> listarMenusCorresp(Usuario elusuario)
			throws Exception {
		return usuariodao.listarMenus(elusuario);
	}

	@Override
	public Usuario consultaPass(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		return usuariodao.buscaContrasena(persona);
	}

	@Override
	public void registrarUsuario(Usuario nuevo) throws Exception {
		// TODO Auto-generated method stub
		usuariodao.registrarUsuario(nuevo);
	}

}
