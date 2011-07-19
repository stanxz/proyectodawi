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

	@Override
	public boolean validarUsuarioRegistrado(UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return objUsuarioDAO.validarUsuarioRegistrado(usuario);
	}

	@Override
	public int registrarUsuario(UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return objUsuarioDAO.registrarUsuario(usuario);
	}

	@Override
	public int registrarUsuarioxPersona(UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return objUsuarioDAO.registrarUsuarioxPersona(usuario);
	}

	@Override
	public UsuarioDTO buscarUsuario(String idBuscar) {
		// TODO Auto-generated method stub
		return objUsuarioDAO.buscaUsuarioCargar(idBuscar);
	}

	@Override
	public int modificarPersona(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return objUsuarioDAO.modificarPersona(usuario);
	}

	@Override
	public int modificarUsuarioxPersona(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return objUsuarioDAO.modificarUsuarioxPersona(usuario);
	}

	@Override
	public int cambiarEstadoUsuario(UsuarioDTO auxiliar) {
		// TODO Auto-generated method stub
		return objUsuarioDAO.cambiarEstadoUsuario(auxiliar);
	}

	@Override
	public String recuperaPassUser(String dniBuscado) {
		// TODO Auto-generated method stub
		return objUsuarioDAO.recuperaPassUser(dniBuscado);
	}

}
