package sermeden.java.dao;

import java.util.List;

import sermeden.java.bean.UsuarioDTO;

public interface UsuarioDAO {

	public UsuarioDTO buscaPorUsuario(UsuarioDTO elusuario) throws Exception;

	public List<UsuarioDTO> listadoUsuariosXDNI(String filtro);

	public List<UsuarioDTO> listadoUsuariosXApellido(String filtro);
	
}
