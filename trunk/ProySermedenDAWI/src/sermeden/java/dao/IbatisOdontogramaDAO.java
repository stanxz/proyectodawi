package sermeden.java.dao;


import org.apache.ibatis.session.SqlSession;

import sermeden.java.bean.OdontogramaDTO;
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

}
