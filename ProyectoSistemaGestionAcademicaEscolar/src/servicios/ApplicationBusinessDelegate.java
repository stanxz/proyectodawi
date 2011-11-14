package servicios;

import dao.DAOFactory;

public class ApplicationBusinessDelegate {

	public AlumnoService getAlumnoService(){
		return new AlumnoDaoService(DAOFactory.JPA);
	}
	
}
