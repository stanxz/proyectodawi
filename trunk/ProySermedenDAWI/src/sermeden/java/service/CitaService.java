package sermeden.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sermeden.java.bean.UsuarioDTO;
import sermeden.java.dao.CitaDAO;
import sermeden.java.dao.DAOFactory;


public class CitaService implements CitaService_I {
	DAOFactory fabrica = 
			DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	
	CitaDAO objcitaDAO=fabrica.getCitaDAO();

	@Override
	public ArrayList<HashMap<String, Object>> listadoTurnos() {
		// TODO Auto-generated method stub
		return objcitaDAO.listarTurnosMT();
	}

	@Override
	public List<UsuarioDTO> cargarMedicos() {
		// TODO Auto-generated method stub
		return objcitaDAO.cargarMedicos();
	}

	@Override
	public List<HashMap<String, Object>> cargarHorasDispXFechaXMedico(String medicoCita,
			String fechaCita) {
		// TODO Auto-generated method stub
		return objcitaDAO.cargarHorasDispXFechaXMedico(medicoCita,
				fechaCita);
	}

	@Override
	public List<Integer> cargarHorariosCitasHechas(String medicoCita,
			String fechaCita) {
		// TODO Auto-generated method stub
		return objcitaDAO.cargarHorariosCitasHechas(medicoCita,
				fechaCita);
	}
	
}
