package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADAOFactory extends DAOFactory {
	private EntityManagerFactory emf;
	
	
	public JPADAOFactory (){
		emf=Persistence.createEntityManagerFactory("JPADemo");
	}


	@Override
	public AlumnoDAO getAlumnoDAO() {
		AlumnoJPADAO ed =  new AlumnoJPADAO();
		ed.setEntityManagerFactory(emf);
		return (AlumnoDAO)ed;
	}


	@Override
	public UsuarioDAO getUsuarioDAO() {
		UsuarioJPADAO ed =  new UsuarioJPADAO();
		ed.setEntityManagerFactory(emf);
		return (UsuarioDAO)ed;
	}
	
	//aca falta las implementaciones de los dao q se va
	//a usar
	
	
}
