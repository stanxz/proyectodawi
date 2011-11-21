package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entidades.Persona;

public class PersonaJPADAO implements PersonaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf=emf;
	}
	
	@Override
	public Persona consultarPersona() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
