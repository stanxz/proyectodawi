package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADAOFactory extends DAOFactory {
	private EntityManagerFactory emf;
	
	
	public JPADAOFactory (){
		emf=Persistence.createEntityManagerFactory("JPA-Web");
	}
	
	//aca falta las implementaciones de los dao q se va
	//a usar
	
	
}
