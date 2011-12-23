package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import entidades.Boleta;
import entidades.SolicitudRetiro;

public class SolicitudRetiroJPADAO implements SolicitudRetiroDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.emf = emf;
	}

	@Override
	public boolean NoExisteDeudas(Boleta boleta) throws Exception {
		
		boolean resultado = false;
		try {
			em = emf.createEntityManager();
			Boleta objBoleta = null;
			Query q = em.createQuery("select b from Boleta b where b.apoderados.personas.strCodigoPersona=?1 and " +
					                 "b.strEstado='Cancelado'");
			q.setParameter(1, boleta.getApoderados().getPersonas().getStrCodigoPersona());
			objBoleta = (Boleta) q.getSingleResult();
			em.close();
			if(objBoleta!=null){
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

	@Override
	public SolicitudRetiro buscarSolicitudXAlumnoXAño(SolicitudRetiro sr)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarSolictud(SolicitudRetiro sr) throws Exception {
		// TODO Auto-generated method stub

		em=emf.createEntityManager();
		em.getTransaction().begin();
		//sr.setStrEstado("Pendiente");
		//sr.setDtFecReg(new java.sql.Date(new java.util.Date().getTime()));
		//sr.setAsistenteCoordinacion(null);
		em.persist(sr);
		em.flush();

		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<SolicitudRetiro> obtenerTodasSolicitudes()
			throws Exception {
		em = emf.createEntityManager();
		ArrayList<SolicitudRetiro> solicitudesRetiro = new ArrayList<SolicitudRetiro>();
		List lista = em.createQuery("SELECT sr FROM SolicitudRetiro sr ").getResultList();	 
		 if(lista.size()>0){
				for ( int i=0; i < lista.size(); i++ ) {
					SolicitudRetiro entidad = (SolicitudRetiro)lista.get(i);
					solicitudesRetiro.add(entidad);
				}
		 }
		em.close();
		return solicitudesRetiro;
	
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<SolicitudRetiro> obtenerSolicitudesPendientes()
			throws Exception {
		em = emf.createEntityManager();
		ArrayList<SolicitudRetiro> solicitudesRetiro = new ArrayList<SolicitudRetiro>();
		  
		List lista = em.createQuery("SELECT sr FROM SolicitudRetiro sr " +
            						"WHERE sr.strEstado = 'Pendiente'").getResultList();
		 
		 if(lista.size()>0){
				for ( int i=0; i < lista.size(); i++ ) {
					SolicitudRetiro entidad = (SolicitudRetiro)lista.get(i);
					solicitudesRetiro.add(entidad);
				}
		 }

		em.close();
		return solicitudesRetiro;
	}

}
