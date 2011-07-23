package sermeden.java.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sermeden.java.bean.UsuarioDTO;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisUsuarioDAO implements UsuarioDAO {

	@Override
	public UsuarioDTO buscaPorUsuario(UsuarioDTO elusuario) throws Exception {
		System.out.println("Buscando usuario con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		UsuarioDTO cliente=(UsuarioDTO) sesion.selectOne("buscarUsuario", elusuario);
		sesion.close();
		return cliente;
	}

	@Override
	public List<UsuarioDTO> listadoUsuariosXDNI(String filtro) {
		System.out.println("Listando usuarios x DNI con Mybatis");
		System.out.println("---- filtro dni: "+filtro);
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<UsuarioDTO> usuarios =
			sesion.selectList("selectUserxDNI", filtro);
		
		sesion.close();
			
		return usuarios;
	}

	@Override
	public List<UsuarioDTO> listadoUsuariosXApellido(String filtro) {
		System.out.println("Listando usuarios x Apellido con Mybatis");
		
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
		System.out.println("validamos con el mybatis si ya esta registrado ... ");
		
		try {
			SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
			//sqlFactory.openSession(true);
			
			uauxi=(UsuarioDTO) sesion.selectOne("validarUsuario", usuario);
			sesion.close();
			System.out.println("es un nuevo usuario ... ");
		} catch (Exception e) {
			System.out.println("error: "+e.getCause());
			System.out.println("error: "+e.getMessage());
			System.out.println("error: "+e.getStackTrace());
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
		
		System.out.println("insertamos la persona con el mybatis");
		
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);

			resultado=sesion.insert("insertUsuarioNuevo", usuario);

		//	resultado=sesion.insert("insertCliente2", usuario);
		sesion.close();
		System.out.println("Registro de una persona por mybatis: "+resultado);
		return resultado;
	
	}

	@Override
	public int registrarUsuarioxPersona(UsuarioDTO usuario) {
		int resultado =-1;
		System.out.println("insertamos el usuario para la persona registrada con el mybatis");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
			resultado=sesion.insert("insertUsuarioxPersona", usuario);
		sesion.close();
		System.out.println("Registro de un usuario para la persona por mybatis: "+resultado);
		return resultado;
	}

	@Override
	public UsuarioDTO buscaUsuarioCargar(String idBuscar) {
		// TODO Auto-generated method stub
		System.out.println("Cargando usuario a modificar con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		UsuarioDTO usuario=(UsuarioDTO) sesion.selectOne("cargarUsuario", idBuscar);
		sesion.close();
		return usuario;
	}

	@Override
	public int modificarPersona(UsuarioDTO usuario) {
		System.out.println("Dentro del modificarPersona");
		
		int resultado = -1;
		System.out.println("...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("actualizarPersona", usuario);
		sesion.close();
		
		System.out.println("Modificar persona en mybatis");
		return resultado;
	}

	@Override
	public int modificarUsuarioxPersona(UsuarioDTO usuario) {
		System.out.println("Dentro del modificarUsuarioxPersona");
		
		int resultado = -1;
		System.out.println("...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("actualizarUsuarioxPersona", usuario);
		sesion.close();
		
		System.out.println("Modificar usuario de la persona en mybatis");
		return resultado;
	}

	@Override
	public int cambiarEstadoUsuario(UsuarioDTO auxiliar) {
		System.out.println("Dentro del cambiarEstadoUsuario");
		
		int resultado = -1;
		System.out.println("...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("cambiarEstadoUser", auxiliar);
		sesion.close();
		
		System.out.println("Cambiar el estado del usuario en mybatis");
		return resultado;
	}

	@Override
	public String recuperaPassUser(String dniBuscado) {
		System.out.println("recuperando pass con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		String elpass=(String) sesion.selectOne("buscarPass", dniBuscado);
		sesion.close();
		return elpass;
	}

	@Override
	public UsuarioDTO pacienteXDNI(String dniBuscado) {
		System.out.println("Buscando paciente x DNI con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		UsuarioDTO cliente=(UsuarioDTO) sesion.selectOne("buscarPacientexDNI", dniBuscado);
		sesion.close();
		return cliente;
	}

	@Override
	public List<UsuarioDTO> listadoPacienteXApellido(String filtro) {
		System.out.println("Listando SOLO pacientes x Apellido con Mybatis");
		
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<UsuarioDTO> usuarios =
			sesion.selectList("selectPacientexApellido", "%"+filtro+"%");
		
		sesion.close();
			
		return usuarios;
	}

	@Override
	public List<UsuarioDTO> listadoPacienteXDNI(String filtro) {
		System.out.println("Listando SOLO pacientes x DNI con Mybatis");
		System.out.println("---- filtro dni: "+filtro);
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<UsuarioDTO> usuarios =
			sesion.selectList("selectPacientexDNI", filtro);
		
		sesion.close();
			
		return usuarios;
	}

	@Override
	public UsuarioDTO buscarDMPaciente(String idBuscar) {
		// TODO Auto-generated method stub
				System.out.println("Cargando Datos Medicos de Paciente con MyBatis");
				SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
				UsuarioDTO usuario=(UsuarioDTO) sesion.selectOne("cargarDMPaciente", idBuscar);
				sesion.close();
				return usuario;
	}

}
