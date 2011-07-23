package sermeden.java.service;

import java.util.List;

import sermeden.java.bean.UsuarioDTO;

public interface UsuarioService_I {

	//para el loggeo
	UsuarioDTO validarUsuario(UsuarioDTO clienteAux) throws Exception;

	List<UsuarioDTO> listadoUsuariosXDNI(String filtro);
	
	//lista x Apellido Paterno
	List<UsuarioDTO> listadoUsuariosXApellido(String filtro);

	//registra la persona
	int registrarUsuario(UsuarioDTO usuario) throws Exception;

	//valida si ya existe la persona en la BD
	boolean validarUsuarioRegistrado(UsuarioDTO usuario) throws Exception;

	//registra el usuario de la persona
	int registrarUsuarioxPersona(UsuarioDTO usuario) throws Exception;

	//para cargar datos de la persona a modificar
	UsuarioDTO buscarUsuario(String idBuscar);

	//para actualizar los datos de la Persona
	int modificarPersona(UsuarioDTO usuario);
	//para actuaizar los datos del Usuario x Persona
	int modificarUsuarioxPersona(UsuarioDTO usuario);
	
	//para activar o desactivar un usuario
	int cambiarEstadoUsuario(UsuarioDTO auxiliar);

	//para enviar mail con el pass
	String recuperaPassUser(String dniBuscado);

	//busca SOLO a pacientes x DNI
	UsuarioDTO pacienteXDNI(String dniBuscado);

	//lista SOLO pacientes por apellido paterno
	List<UsuarioDTO> listadoPacienteXApellido(String filtro);

	List<UsuarioDTO> listadoPacienteXDNI(String filtro);

	//para Cargar los Datos Medicos del Paciente
	UsuarioDTO buscarDMPaciente(String idBuscar);

}
