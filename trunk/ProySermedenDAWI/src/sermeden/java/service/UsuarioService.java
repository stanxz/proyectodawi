package sermeden.java.service;

import java.util.List;

import sermeden.java.bean.UsuarioDTO;
import sermeden.java.dao.DAOFactory;
import sermeden.java.dao.UsuarioDAO;

public class UsuarioService implements UsuarioService_I {

	DAOFactory fabrica = 
		DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	
	UsuarioDAO objUsuarioDAO=fabrica.getUsuarioDAO();
	
	@Override
	public UsuarioDTO validarUsuario(UsuarioDTO elusuario) throws Exception{
		// TODO Auto-generated method stub
		return objUsuarioDAO.buscaPorUsuario(elusuario);
	}

	@Override
	public List<UsuarioDTO> listadoUsuariosXDNI(String filtro) {
		// TODO Auto-generated method stub
		return objUsuarioDAO.listadoUsuariosXDNI(filtro);
	}

	@Override
	public List<UsuarioDTO> listadoUsuariosXApellido(String filtro) {
		// TODO Auto-generated method stub
		return objUsuarioDAO.listadoUsuariosXApellido(filtro);
	}

}
