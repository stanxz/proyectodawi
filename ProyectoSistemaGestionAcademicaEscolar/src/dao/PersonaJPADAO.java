package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import entidades.Persona;
import entidades.Usuario;

public class PersonaJPADAO implements PersonaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf=emf;
	}
	
	@Override
	public Persona consultarPersona(Usuario u) throws Exception {
		em=emf.createEntityManager();
		Query q =  em.createQuery("SELECT p FROM Persona p WHERE p.strCodigoPersona=?1");
		q.setParameter(1, u.getPersonas().getStrCodigoPersona());
		
		try {
			Persona entidadPersona =(Persona)q.getSingleResult();
			em.close();
			if(entidadPersona!=null)
				return entidadPersona;
			else
				return null;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
		
	}

}
