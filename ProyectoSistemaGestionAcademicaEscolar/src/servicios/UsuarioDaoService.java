package servicios;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.UsuarioDAO;
import entidades.Permiso;
import entidades.Usuario;

public class UsuarioDaoService implements UsuarioService {

	private DAOFactory fabrica = null;
	private UsuarioDAO usuariodao;
	
	public UsuarioDaoService(int jpa) {
		fabrica = DAOFactory.getDAOFactory(jpa);
        this.usuariodao = fabrica.getUsuarioDAO();
	}

	@Override
	public boolean validarUsuarioEntrada(Usuario elusuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Permiso> listarMenusCorresp() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
