package servicios;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.PerfilDAO;

import entidades.Perfil;

public class PerfilDaoService implements PerfilService {

	private DAOFactory fabrica = null;
	private PerfilDAO perfildao;
	
	public PerfilDaoService(int jpa) {
		fabrica = DAOFactory.getDAOFactory(jpa);
        this.perfildao = fabrica.getPerfilDAO();
	}

	
	@Override
	public ArrayList<Perfil> listarPerfiles()throws Exception {
		return perfildao.listarPerfiles();
	}


}
