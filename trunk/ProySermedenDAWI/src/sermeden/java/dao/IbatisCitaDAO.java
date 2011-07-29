package sermeden.java.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisCitaDAO implements CitaDAO {

	@Override
	public Map<String, Object> listarTurnosMT() {
		// TODO Auto-generated method stub
		System.out.println("Cargando turnos con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		Map<String, Object> hashTurnos=(Map) sesion.selectMap("buscarFichaxDNIPaciente",null);
		sesion.close();
		return hashTurnos;
	}

}
