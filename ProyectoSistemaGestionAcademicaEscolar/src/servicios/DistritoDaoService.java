package servicios;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.DistritoDAO;
import entidades.Distrito;

public class DistritoDaoService implements DistritoService{
	private DAOFactory fabrica = null;
	private DistritoDAO distritodao;
	
	public DistritoDaoService(int whichFactory){
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.distritodao = fabrica.getDistritoDAO();
	}
	
	public ArrayList<Distrito> obtenerTodosDistritos() throws Exception {
		return distritodao.obtenerTodos();
	}

}
