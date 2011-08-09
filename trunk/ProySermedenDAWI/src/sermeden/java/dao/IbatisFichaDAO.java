package sermeden.java.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import sermeden.java.bean.FichaDTO;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisFichaDAO implements FichaDAO {
	static private Logger log = Logger.getLogger(IbatisFichaDAO.class);
	@Override
	public int registrarFicha(FichaDTO ficha) throws Exception {
		int resultado =-1;
		
		log.debug("insertamos la ficha con el mybatis");
		
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
			resultado=sesion.insert("insertFichaNueva", ficha);
		sesion.close();
		log.debug("Registro de una ficha por mybatis: "+resultado);
		return resultado;
	
	}

	public int cambiarEstadoFichaActual(int idPersona) {
		log.debug("Dentro del cambiarEstadoFichaActual con Mybatis");
		
		int resultado = -1;
		log.debug("...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("cambiarEstadoFichaActual",idPersona);
		sesion.close();
		
		log.debug("Cambiar el estado del usuario en mybatis");
		return resultado;
	}

	@Override
	public FichaDTO buscarFichaActualxPersona(String dniBuscado) {
		log.debug("Buscando Ficha Actual x DNI del paciente con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		FichaDTO ficha=(FichaDTO) sesion.selectOne("buscarFichaxDNIPaciente", dniBuscado);
		sesion.close();
		return ficha;
	}

}
