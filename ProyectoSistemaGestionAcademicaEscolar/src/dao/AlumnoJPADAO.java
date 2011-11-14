package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AlumnoJPADAO implements AlumnoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.emf=emf;
	}
	


}
