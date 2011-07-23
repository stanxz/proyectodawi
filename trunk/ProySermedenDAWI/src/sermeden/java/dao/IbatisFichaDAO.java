package sermeden.java.dao;

import org.apache.ibatis.session.SqlSession;

import sermeden.java.bean.FichaDTO;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisFichaDAO implements FichaDAO {

	@Override
	public int registrarFicha(FichaDTO ficha) throws Exception {
		int resultado =-1;
		
		System.out.println("insertamos la ficha con el mybatis");
		
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
			resultado=sesion.insert("insertFichaNueva", ficha);
		sesion.close();
		System.out.println("Registro de una ficha por mybatis: "+resultado);
		return resultado;
	
	}

	public int cambiarEstadoFichaActual(int idPersona) {
		System.out.println("Dentro del cambiarEstadoFichaActual con Mybatis");
		
		int resultado = -1;
		System.out.println("...");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.update("cambiarEstadoFichaActual",idPersona);
		sesion.close();
		
		System.out.println("Cambiar el estado del usuario en mybatis");
		return resultado;
	}

}
