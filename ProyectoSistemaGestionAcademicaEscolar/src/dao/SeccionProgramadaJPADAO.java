package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import entidades.Seccionprogramada;

public class SeccionProgramadaJPADAO implements SeccionProgramadaDAO{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	@Override
	public ArrayList<Seccionprogramada> obtenerListaGrados(
			String nivelelegidocombo) throws Exception {

		
		em = emf.createEntityManager();
		
		System.out.println("cargando los grados de "+nivelelegidocombo);
		
		ArrayList<Seccionprogramada> secciones = new ArrayList<Seccionprogramada>();
		
		Query q = em.createQuery("SELECT s FROM Seccionprogramada s where s.strNivel=?1");
		q.setParameter(1,nivelelegidocombo);
		
		 List lista = q.getResultList();
		 
		 if(lista.size()>0){
				for ( int i=0; i < lista.size(); i++ ) {
					Seccionprogramada entidad = (Seccionprogramada)lista.get(i);
					System.out.println("tamaño de secciones: " + lista.get(i));
					secciones.add(entidad);
				}
		 }
		 
		em.close();
		
		return secciones;
	
	}

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.emf=emf;
	}

	@Override
	public Seccionprogramada obtenerSP(Seccionprogramada temporal)
			throws Exception {
		em=emf.createEntityManager();
		Query q =  em.createQuery("SELECT p FROM Seccionprogramada p WHERE p.strNivel=?1 AND p.intGrado=?2 AND p.strSeccion=?3");
		q.setParameter(1, temporal.getStrNivel());
		q.setParameter(2, temporal.getIntGrado());
		q.setParameter(3, temporal.getStrSeccion());
		
		try {
			Seccionprogramada entidadsp =(Seccionprogramada)q.getSingleResult();
			em.close();
			if(entidadsp!=null)
				return entidadsp;
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	
	}

}
