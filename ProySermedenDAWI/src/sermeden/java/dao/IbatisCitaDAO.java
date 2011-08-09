package sermeden.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sermeden.java.bean.CitaDTO;
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
		System.out.println("medicoCita: "+medicoCita);
		System.out.println("fechaCita: "+fechaCita);
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		
		HashMap<String, Object> mimapita=new HashMap<String, Object>();
		mimapita.put("medicoCita", medicoCita);
		mimapita.put("fechaCita", fechaCita);
		
		
		List<HashMap<String, Object>>  milista= sesion.selectList("cargarHorasxFechaxMedico",mimapita);
		sesion.close();
		System.out.println("xxx milista:"+milista.size());
		return milista;
	}

	@Override
	public List<HashMap<String, Object>> cargarHorariosCitasHechas(String medicoCita,
			String fechaCita) {
		// TODO Auto-generated method stub
		HashMap<String, Object> mimapita2=new HashMap<String, Object>();
		mimapita2.put("medicoCita", medicoCita);
		mimapita2.put("fechaCita", fechaCita);
		
		System.out.println("Cargando Horas de citas guardadas en BD con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<HashMap<String, Object>>  milista= sesion.selectList("cargarHorasxCitasxFecha",mimapita2);
		sesion.close();
		System.out.println("yyy milista:"+milista.size());
		return milista;
	}

	@Override
	public List<HashMap<String, Object>> cargarSemanaCita(CitaDTO cita) {
		System.out.println("Verificando citas durante semana con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		 List<HashMap<String, Object>>  mishashmaps = sesion.selectList ("cargarCitaparaSemana", cita);
		System.out.println("en ibatiscitadao>>>lallave: "+mishashmaps.size());
		sesion.close();
		return mishashmaps;
	}

	@Override
	public int registrarNuevaCita(CitaDTO cita) throws Exception{
		int resultado =-1;
		System.out.println("insertamos la cita con el mybatis");
		SqlSession sesion =MyIbatisManager.getSqlSessionFactory().openSession(true);
		resultado=sesion.insert("insertCitaNueva", cita);
		sesion.close();
		System.out.println("Registro de una cita por mybatis: "+resultado);
		return resultado;
	}

}
