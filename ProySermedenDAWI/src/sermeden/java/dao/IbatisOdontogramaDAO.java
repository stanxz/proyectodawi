package sermeden.java.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sermeden.java.bean.OdontogramaDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisOdontogramaDAO implements OdontogramaDAO {

	
	public int generarOdontograma(OdontogramaDTO odontograma) throws Exception{

		int resultado =-1;
		
		System.out.println("Generamos odontograma con mybatis");
		
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);

			resultado=sesion.insert("insertOdontograma", odontograma);

		//	resultado=sesion.insert("insertCliente2", usuario);
		sesion.close();
		
		System.out.println("Generar odontograma - resultado: "+resultado);
		
		return resultado;
	
	}

	@Override
	public List<OdontogramaDTO> listadoOdontogramaXDNI(String filtro) {
		System.out.println("Listando odontograma x DNI con Mybatis");
		System.out.println("----> filtro dni: "+filtro);
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<OdontogramaDTO> usuarios =
			sesion.selectList("selectOdontogramaxDNI", filtro);
		
		sesion.close();
			
		return usuarios;
	}
}

