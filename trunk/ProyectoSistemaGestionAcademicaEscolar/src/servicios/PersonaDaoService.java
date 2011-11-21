package servicios;

import dao.DAOFactory;
import dao.PersonaDAO;

public class PersonaDaoService implements PersonaService {

	private DAOFactory fabrica = null;
	private PersonaDAO personadao;
	
	public PersonaDaoService(int jpa) {
		fabrica = DAOFactory.getDAOFactory(jpa);
        this.personadao = fabrica.getPersonaDAO();
	}

}
