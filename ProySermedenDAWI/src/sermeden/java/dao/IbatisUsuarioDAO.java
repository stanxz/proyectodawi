package sermeden.java.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import sermeden.java.bean.DMPacienteDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisUsuarioDAO implements UsuarioDAO {
	static private Logger log = Logger.getLogger(IbatisUsuarioDAO.class);
	@Override
	public UsuarioDTO buscaPorUsuario(UsuarioDTO elusuario) throws Exception {
		log.debug("Buscando usuario con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		UsuarioDTO cliente=(UsuarioDTO) sesion.selectOne("buscarUsuario", elusuario);
		sesion.close();
		return cliente;
	}

	@Override
	public List<UsuarioDTO> listadoUsuariosXDNI(String filtro) {
		log.debug("Listando usuarios x DNI con Mybatis");
		log.debug("---- filtro dni: "+filtro);
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<UsuarioDTO> usuarios =
			sesion.selectList("selectUserxDNI", filtro);
		
		sesion.close();
			
		return usuarios;
	}

	@Override
	public List<UsuarioDTO> listadoUsuariosXApellido(String filtro) {
		log.debug("Listando usuarios x Apellido con Mybatis");
		
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<UsuarioDTO> usuarios =
			sesion.selectList("selectUserxApellido", "%"+filtro+"%");
		
		sesion.close();
			
		return usuarios;
	}

	@Override
	public boolean validarUsuarioRegistrado(UsuarioDTO usuario) throws Exception{
		UsuarioDTO uauxi=null;
		log.debug("validamos con el mybatis si ya esta registrado ... ");
		
		try {
			SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
			//sqlFactory.openSession(true);
			
			uauxi=(UsuarioDTO) sesion.selectOne("validarUsuario", usuario);
			sesion.close();
			log.debug("es un nuevo usuario ... ");
		} catch (Exception e) {
			log.debug("error: "+e.getCause());
			log.debug("error: "+e.getMessage());
			log.debug("error: "+e.getStackTrace());
			e.printStackTrace();
		}
		
		if (uauxi==null){
			return false;
		}else
			return true;

	}

	@Override
	public int registrarUsuario(UsuarioDTO usuario) throws Exception{

		int resultado =-1;
		
		log.debug("insertamos la persona con el mybatis");
		
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);

			resultado=sesion.insert("insertUsuarioNuevo", usuario);

		//	resultado=sesion.insert("insertCliente2", usuario);
		sesion.close();
		log.debug("Registro de una persona por mybatis: "+resultado);
		return resultado;
	
	}

	@Override
	public int registrarUsuarioxPersona(UsuarioDTO usuario) {
		int resultado =-1;
		log.debug("insertamos el usuario para la persona registrada con el mybatis");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
			resultado=sesion.insert("insertUsuarioxPersona", usuario);
		sesion.close();
		log.debug("Registro de un usuario para la persona por mybatis: "+resultado);
		return resultado;
	}

	@Override
	public UsuarioDTO buscaUsuarioCargar(String idBuscar) {
		// TODO Auto-generated method stub
		log.debug("Cargando usuario a modificar con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		UsuarioDTO usuario=(UsuarioDTO) sesion.selectOne("cargarUsuario", idBuscar);
		sesion.close();
		return usuario;
	}

	@Override
	public int modificarPersona(UsuarioDTO usuario) {
		log.debug("Dentro del modificarPersona");
		
		int resultado = -1;
		log.debug("...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("actualizarPersona", usuario);
		sesion.close();
		
		log.debug("Modificar persona en mybatis");
		return resultado;
	}

	@Override
	public int modificarUsuarioxPersona(UsuarioDTO usuario) {
		log.debug("Dentro del modificarUsuarioxPersona");
		
		int resultado = -1;
		log.debug("...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("actualizarUsuarioxPersona", usuario);
		sesion.close();
		
		log.debug("Modificar usuario de la persona en mybatis");
		return resultado;
	}

	@Override
	public int cambiarEstadoUsuario(UsuarioDTO auxiliar) {
		log.debug("Dentro del cambiarEstadoUsuario");
		
		int resultado = -1;
		log.debug("...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("cambiarEstadoUser", auxiliar);
		sesion.close();
		
		log.debug("Cambiar el estado del usuario en mybatis");
		return resultado;
	}

	@Override
	public String recuperaPassUser(String dniBuscado) {
		log.debug("recuperando pass con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		String elpass=(String) sesion.selectOne("buscarPass", dniBuscado);
		sesion.close();
		return elpass;
	}

	@Override
	public UsuarioDTO pacienteXDNI(String dniBuscado) {
		log.debug("Buscando paciente x DNI con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		UsuarioDTO cliente=(UsuarioDTO) sesion.selectOne("buscarPacientexDNI", dniBuscado);
		sesion.close();
		return cliente;
	}
	
	@Override
	public UsuarioDTO usuarioXDNI(String dniBuscado) {
		log.debug("Buscando paciente x DNI con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		UsuarioDTO cliente=(UsuarioDTO) sesion.selectOne("buscarUsuarioxDNI", dniBuscado);
		sesion.close();
		return cliente;
	}

	@Override
	public List<UsuarioDTO> listadoPacienteXApellido(String filtro) {
		log.debug("Listando SOLO pacientes x Apellido con Mybatis");
		
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<UsuarioDTO> usuarios =
			sesion.selectList("selectPacientexApellido", "%"+filtro+"%");
		
		sesion.close();
			
		return usuarios;
	}

	@Override
	public List<UsuarioDTO> listadoPacienteXDNI(String filtro) {
		log.debug("Listando SOLO pacientes x DNI con Mybatis");
		log.debug("---- filtro dni: "+filtro);
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<UsuarioDTO> usuarios =
			sesion.selectList("selectPacientexDNI", filtro);
		
		sesion.close();
			
		return usuarios;
	}


	@Override
	public int registrarDMPaciente(DMPacienteDTO dmpaciente) {
		int resultado =-1;
		
		log.debug("insertamos los DM del Paciente Nuevo con el mybatis");
		
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);

			resultado=sesion.insert("insertaDMPaciente", dmpaciente);

		sesion.close();
		log.debug("Registro de DM de Nuevo Paciente por mybatis: "+resultado);
		return resultado;
	}

	@Override
	public DMPacienteDTO DMxIdPaciente(String idBuscar) {
		// TODO Auto-generated method stub
		log.debug("Cargando DM del paciente con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		DMPacienteDTO dmpaciente=(DMPacienteDTO) sesion.selectOne("cargarDMPaciente", idBuscar);
		sesion.close();
		return dmpaciente;
	}

	@Override
	public int modificarDMPaciente(DMPacienteDTO dmpaciente) {
		log.debug("Dentro del modificarDMPaciente");
		
		int resultado = -1;
		log.debug("actualizando ...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("actualizarDMPaciente", dmpaciente);
		sesion.close();
		
		log.debug("Modificar DM de paciente en mybatis");
		return resultado;
	}

	

}
