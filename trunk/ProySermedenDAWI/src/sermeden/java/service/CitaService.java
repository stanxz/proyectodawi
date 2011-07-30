package sermeden.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
}
