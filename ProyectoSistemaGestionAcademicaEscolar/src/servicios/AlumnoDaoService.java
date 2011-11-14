package servicios;

import dao.AlumnoDAO;
import dao.DAOFactory;

public class AlumnoDaoService implements AlumnoService {
	private DAOFactory fabrica = null;
	private AlumnoDAO alumnodao;
	
	public AlumnoDaoService(int whichFactory) {
		// TODO Auto-generated constructor stub
		fabrica = DAOFactory.getDAOFactory(whichFactory);
        this.alumnodao = fabrica.getAlumnoDAO();
	}

}
