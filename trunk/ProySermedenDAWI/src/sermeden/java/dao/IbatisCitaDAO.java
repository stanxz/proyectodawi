package sermeden.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sermeden.java.bean.UsuarioDTO;
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

	@Override
	public List<UsuarioDTO> cargarMedicos() {
		// TODO Auto-generated method stub
		System.out.println("Cargando medicos con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<UsuarioDTO>  medicos= sesion.selectList("cargarMedicos");
		sesion.close();
		return medicos;
	}

	@Override
	public List<HashMap<String, Object>> cargarHorasDispXFechaXMedico(String medicoCita,
			String fechaCita) {
		// TODO Auto-generated method stub
		System.out.println("Cargando Horas Disp x Medico x fecha con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<HashMap<String, Object>>  milista= sesion.selectList("cargarHorasxFechaxMedico");
		sesion.close();
		return milista;
	}

	@Override
	public List<Integer> cargarHorariosCitasHechas(String medicoCita,
			String fechaCita) {
		// TODO Auto-generated method stub
		System.out.println("Cargando Horas de " +
				"citas guardadas en BD con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Integer>  milista= sesion.selectList("cargarHorasxCitasxFecha");
		sesion.close();
		return milista;
	}

}
