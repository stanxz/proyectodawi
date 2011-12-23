package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entidades.Boleta;

public class BoletaJPADAO implements BoletaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.emf=emf;
	}

	@Override
	public Boleta obtenerBoleta(Boleta temporal) throws Exception {
		em=emf.createEntityManager();
		System.out.println("codigo del temporal: "+temporal.getStrCodigoBoleta());
		Boleta entidadBoleta=(Boleta)em.find(Boleta.class,temporal.getStrCodigoBoleta());
		
		return entidadBoleta;
	}

	@Override
	public void registrarBoleta(Boleta laboleta) throws Exception {
		em=emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(laboleta);
		em.flush();

		em.getTransaction().commit();
		em.close();
	}

}
