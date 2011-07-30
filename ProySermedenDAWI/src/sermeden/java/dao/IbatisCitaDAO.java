package sermeden.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisCitaDAO implements CitaDAO {

	@Override
	public ArrayList<HashMap<String, Object>> listarTurnosMT() {
		// TODO Auto-generated method stub
		System.out.println("Cargando turnos con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		 ArrayList<HashMap<String, Object>>  hashTurnos=(ArrayList<HashMap<String,Object>>) sesion.selectList("cargarTurnosMT");

		sesion.close();
		return hashTurnos;
	}

}
