package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entidades.Certificadoa;

public class CertificadoJPADAO implements CertificadoDAO {
	
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}

	@Override
	public void insertarCertificado(Certificadoa certificado) throws Exception {
		em=emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(certificado);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}

}
