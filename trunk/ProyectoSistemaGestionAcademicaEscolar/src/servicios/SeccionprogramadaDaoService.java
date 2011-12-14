package servicios;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.SeccionProgramadaDAO;

import entidades.Seccionprogramada;

public class SeccionprogramadaDaoService implements SeccionprogramadaService {

	private DAOFactory fabrica = null;
	private SeccionProgramadaDAO spdao;
	
	public SeccionprogramadaDaoService(int jpa) {
		fabrica = DAOFactory.getDAOFactory(jpa);
		this.spdao = fabrica.getSeccionProgramadaDAO();
	}

	@Override
	public ArrayList<Seccionprogramada> obtenerListaGrados(
			String nivelelegidocombo) throws Exception {
		// TODO Auto-generated method stub
		return spdao.obtenerListaGrados(nivelelegidocombo);
	}

	@Override
	public Seccionprogramada obtenerSP(Seccionprogramada temporal)
			throws Exception {
		// TODO Auto-generated method stub
		return spdao.obtenerSP(temporal);
	}

}
