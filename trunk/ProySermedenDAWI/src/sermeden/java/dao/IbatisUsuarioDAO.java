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
		
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<UsuarioDTO> usuarios =
			sesion.selectList("selectUserxDNI", "%"+filtro+"%");
		
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

}
