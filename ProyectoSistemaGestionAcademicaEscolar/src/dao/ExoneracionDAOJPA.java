package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import entidades.Actividad;

public class ExoneracionDAOJPA implements ExoneracionDAO{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	public boolean CumpleCalendarioExoneracion(int codigoCalendario) throws Exception {
		
		em = emf.createEntityManager();
		
		Actividad actividad = null;
		
		boolean resultado = false;
		
		Query q = em.createQuery("SELECT a FROM Actividad a WHERE a.calendarioacademico.strCodcalendario=?1 " +
				                 "and a.intCodigoActividad=?2 and (now() between a.fechaini and a.fechafin)");
		q.setParameter(1, codigoCalendario);
		q.setParameter(2, 1);
		
		actividad = (Actividad) q.getSingleResult();
		
		em.close();
		
		if(actividad!=null){
			resultado = true;
		}else{
			resultado = false;
		}
		
		
		return resultado;
	}
	
	public boolean NoExisteDeudas(int codigoApoderado){
		
		em = emf.createEntityManager();
		
		Actividad actividad = null;
		
		boolean resultado = false;
		
		Query q = em.createQuery("");
		q.setParameter(1, codigoApoderado);
		
		actividad = (Actividad) q.getSingleResult();
		
		em.close();
		
		if(actividad!=null){
			resultado = true;
		}else{
			resultado = false;
		}
		
		return resultado;
	}
	
	

}
