package sermeden.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import sermeden.java.action.UsuarioAction;
import sermeden.java.bean.CitaDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisCitaDAO implements CitaDAO {
	static private Logger log = Logger.getLogger(IbatisCitaDAO.class);
	@Override
	public ArrayList<HashMap<String, Object>> listarTurnosMT() {
		// TODO Auto-generated method stub
		log.debug("Cargando turnos con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		 ArrayList<HashMap<String, Object>>  hashTurnos=(ArrayList<HashMap<String,Object>>) sesion.selectList("cargarTurnosMT");
		sesion.close();
		return hashTurnos;
	}

	@Override
	public List<UsuarioDTO> cargarMedicos() {
		// TODO Auto-generated method stub
		log.debug("Cargando medicos con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<UsuarioDTO>  medicos= sesion.selectList("cargarMedicos");
		sesion.close();
		return medicos;
	}

	@Override
	public List<HashMap<String, Object>> cargarHorasDispXFechaXMedico(String medicoCita,
			String fechaCita) {
		// TODO Auto-generated method stub
		log.debug("Cargando Horas Disp x Medico x fecha con MyBatis");
		log.debug("medicoCita: "+medicoCita);
		log.debug("fechaCita: "+fechaCita);
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		HashMap<String, Object> mimapita=new HashMap<String, Object>();
		mimapita.put("medicoCita", medicoCita);
		mimapita.put("fechaCita", fechaCita);
		
		
		List<HashMap<String, Object>>  milista= sesion.selectList("cargarHorasxFechaxMedico",mimapita);
		sesion.close();
		log.debug("xxx milista:"+milista.size());
		return milista;
	}

	@Override
	public List<HashMap<String, Object>> cargarHorariosCitasHechas(String medicoCita,
			String fechaCita) {
		// TODO Auto-generated method stub
		HashMap<String, Object> mimapita2=new HashMap<String, Object>();
		mimapita2.put("medicoCita", medicoCita);
		mimapita2.put("fechaCita", fechaCita);
		
		log.debug("Cargando Horas de citas guardadas en BD con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<HashMap<String, Object>>  milista= sesion.selectList("cargarHorasxCitasxFecha",mimapita2);
		sesion.close();
		log.debug("yyy milista:"+milista.size());
		return milista;
	}

	@Override
	public List<HashMap<String, Object>> cargarSemanaCita(CitaDTO cita) {
		log.debug("Verificando citas durante semana con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		 List<HashMap<String, Object>>  mishashmaps = sesion.selectList ("cargarCitaparaSemana", cita);
		log.debug("en ibatiscitadao>>>lallave: "+mishashmaps.size());
		sesion.close();
		return mishashmaps;
	}

	@Override
	public int registrarNuevaCita(CitaDTO cita) throws Exception{
		int resultado =-1;
		log.debug("insertamos la cita con el mybatis");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.insert("insertCitaNueva", cita);
		sesion.close();
		log.debug("Registro de una cita por mybatis: "+resultado);
		return resultado;
	}

}
