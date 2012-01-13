package servicios;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.PersonaDAO;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.AsistentaSocial;
import entidades.AsistenteCoordinacionAcademica;
import entidades.AsistenteDireccionAcademica;
import entidades.Persona;
import entidades.SecretariaAcademica;

public class PersonaDaoService implements PersonaService {

	private DAOFactory fabrica = null;
	private PersonaDAO personadao;
	
	public PersonaDaoService(int jpa) {
		fabrica = DAOFactory.getDAOFactory(jpa);
        this.personadao = fabrica.getPersonaDAO();
	}

	@Override
	public Persona consultaPersona(Persona p) throws Exception {
		// TODO Auto-generated method stub
		return personadao.consultarPersona(p);
	}

	@Override
	public void registrarPersona(Persona nueva) throws Exception {
		// TODO Auto-generated method stub
		personadao.registrarPersona(nueva);
	}

	@Override
	public void guardaApoderado(Apoderado apo) throws Exception {
		// TODO Auto-generated method stub
		personadao.guardaApoderado(apo);
	}

	@Override
	public ArrayList<Persona> obtenerTodosEmpleados() throws Exception {
		// TODO Auto-generated method stub
		return personadao.obtenerTodosEmpleados();
	}

	@Override
	public void actulizarPersona(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		personadao.actulizarPersona(persona);
	}

	@Override
	public Persona consultaApoderado(Persona p) throws Exception {
		// TODO Auto-generated method stub
		return personadao.consultaApoderado(p);
	}

	@Override
	public void guardaADA(AsistenteDireccionAcademica ada) throws Exception {
		// TODO Auto-generated method stub
		personadao.guardaADA(ada);
	}

	@Override
	public void guardaACA(AsistenteCoordinacionAcademica aca) throws Exception {
		// TODO Auto-generated method stub
		personadao.guardaACA(aca);
	}

	@Override
	public void guardaSecretaria(SecretariaAcademica secretaria)
			throws Exception {
		// TODO Auto-generated method stub
		personadao.guardaSecretaria(secretaria);
	}

	@Override
	public void guardaAsistentaSocial(AsistentaSocial asistenta)
			throws Exception {
		// TODO Auto-generated method stub
		personadao.guardaAsistentaSocial(asistenta);
	}

	@Override
	public Persona consultaApoderadoxAlumno(Alumno a) throws Exception {
		// TODO Auto-generated method stub
		return personadao.consultaApoderadoxAlumno(a);
	}

	@Override
	public ArrayList<Persona> obtenerTodosEmpleadosXTipo(String tipo)
			throws Exception {
		// TODO Auto-generated method stub
		return personadao.obtenerTodosEmpleadosXTipo(tipo);
	}

}
