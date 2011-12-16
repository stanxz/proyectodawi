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
	
	public DistritoService getDistritoService(){
		return new DistritoDaoService(DAOFactory.JPA);
	}
	
	public MatriculaService getMatriculaService(){
		return new MatriculaDaoService(DAOFactory.JPA);
	}
	
	public SeccionprogramadaService getSeccionprogramadaService(){
		return new SeccionprogramadaDaoService(DAOFactory.JPA);
	}
	
	public SolicitudExoneracionService getExoneracionService(){
		return new SolicitudExoneracionDaoService(DAOFactory.JPA);
	}
	
}
