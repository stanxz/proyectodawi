package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import entidades.Actividad;

public class SolicitudExoneracionJPADAO implements SolicitudExoneracionDAO{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	public boolean CumpleCalendarioExoneracion(int codigoCalendario) throws Exception {
		
		em = emf.createEntityManager();
		
		Actividad actividad = null;
		
		boolean resultado = false;
		
		Query q = em.createQuery("SELECT a FROM Actividad a WHERE a.calendarioacademico.strCodcalendario='2011' " +
				                 "and a.intCodigoActividad=1 and (CURRENT_DATE between a.dtFecIni and a.dtFecFin)");
		//q.setParameter(1, codigoCalendario);
		//q.setParameter(2, 1);
		
		try {
			actividad = (Actividad) q.getSingleResult();
			
			em.close();
			
			if(actividad!=null){
				resultado = true;
				return resultado;
			}else{
				resultado = false;
				return resultado;
			}
		} catch (Exception e) {
			resultado = false;
			return resultado;
		}
		
		
		
		
	}
	
	public boolean NoExisteDeudas(int codigoApoderado){
		
		em = emf.createEntityManager();
		
		Actividad actividad = null;
		
		boolean resultado = false;
		
		Query q = em.createQuery("select b from Boleta b where ");
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
