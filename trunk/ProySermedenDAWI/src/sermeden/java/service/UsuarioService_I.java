package sermeden.java.service;

import java.util.List;

import sermeden.java.bean.UsuarioDTO;

public interface UsuarioService_I {

	UsuarioDTO validarUsuario(UsuarioDTO clienteAux) throws Exception;

	List<UsuarioDTO> listadoUsuariosXDNI(String filtro);

	List<UsuarioDTO> listadoUsuariosXApellido(String filtro);

}
