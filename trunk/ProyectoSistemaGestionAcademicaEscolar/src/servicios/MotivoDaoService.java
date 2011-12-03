package servicios;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.MotivoDAO;
import entidades.Motivo;

public class MotivoDaoService implements MotivoService {
	private DAOFactory fabrica = null;
	private MotivoDAO motivodao;
	
	public MotivoDaoService(int whichFactory) {
		// TODO Auto-generated constructor stub
		fabrica = DAOFactory.getDAOFactory(whichFactory);
        this.motivodao = fabrica.getMotivoDAO();
	}

	@Override
	public ArrayList<Motivo> obtenerTodosMotivos() throws Exception {
		return motivodao.obtenerTodos();
	}
	
}
