package sermeden.java.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import sermeden.java.bean.OdontogramaDTO;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisOdontogramaDAO implements OdontogramaDAO {

	static private Logger log = Logger.getLogger(IbatisOdontogramaDAO.class);
	public int generarOdontograma(OdontogramaDTO odontograma) throws Exception{

		int resultado =-1;
		
		log.debug("Generamos odontograma con mybatis");
		
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);

			resultado=sesion.insert("insertOdontograma", odontograma);

		//	resultado=sesion.insert("insertCliente2", usuario);
		sesion.close();
		
		log.debug("Generar odontograma - resultado: "+resultado);
		
		return resultado;
	
	}

	@Override
	public List<OdontogramaDTO> listadoOdontogramaXDNI(String filtro) {
		log.debug("Listando odontograma x DNI con Mybatis");
		log.debug("----> filtro dni: "+filtro);
		SqlSession sesion = 
			MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		List<OdontogramaDTO> odontograma =
			sesion.selectList("selectOdontogramaxDNI", filtro);
		
		sesion.close();
			
		return odontograma;
	}
}

