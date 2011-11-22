package servicios;

import dao.DAOFactory;
import dao.PersonaDAO;
import entidades.Persona;
import entidades.Usuario;

public class PersonaDaoService implements PersonaService {

	private DAOFactory fabrica = null;
	private PersonaDAO personadao;
	
	public PersonaDaoService(int jpa) {
		fabrica = DAOFactory.getDAOFactory(jpa);
        this.personadao = fabrica.getPersonaDAO();
	}

	@Override
	public Persona consultaPersona(Usuario u) throws Exception {
		// TODO Auto-generated method stub
		return personadao.consultarPersona(u);
	}

}
