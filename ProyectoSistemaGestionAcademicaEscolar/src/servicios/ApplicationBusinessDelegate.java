package servicios;

import dao.DAOFactory;

public class ApplicationBusinessDelegate {

	public AlumnoService getAlumnoService(){
		return new AlumnoDaoService(DAOFactory.JPA);
	}
	
	public UsuarioService getUsuarioService(){
		return new UsuarioDaoService(DAOFactory.JPA);
	}
	
	public PersonaService getPersonaService(){
		return new PersonaDaoService(DAOFactory.JPA);
	}
	
	public AsignaturaService getAsignaturaService(){
		return new AsignaturaDaoService(DAOFactory.JPA);
	}
	
	public MotivoService getMotivoService(){
		return new MotivoDaoService(DAOFactory.JPA);
	}
	
	public PerfilService getPerfilService(){
		return new PerfilDaoService(DAOFactory.JPA);
	}
	
}
