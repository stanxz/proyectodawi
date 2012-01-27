package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import utiles.Constantes;

import entidades.AsistenteDireccionAcademica;
import entidades.Boleta;
import entidades.Certificadoa;
import entidades.Cita;
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

	@SuppressWarnings("rawtypes")
	@Override
	public SolicitudRetiro buscarSolicitudXAlumnoXAño(SolicitudRetiro sr)
			throws Exception {
		System.out.println("Codigo de alumno q llega: "+sr.getAlumno().getStrCodigoAlumno());
		SolicitudRetiro entidadSR=new SolicitudRetiro();
		em = emf.createEntityManager();
		
		Query q=em.createQuery("SELECT sr FROM SolicitudRetiro sr " +
				"WHERE sr.strEstado='PENDIENTE' AND sr.alumno.strCodigoAlumno=?1");
		q.setParameter(1, sr.getAlumno().getStrCodigoAlumno());
		//q.setParameter(2, fechamayor);
		//q.setParameter(3,fechamenor);
		List lista=q.getResultList();
		 if(lista.size()>0){
			 System.out.println("id sr: "+lista.get(lista.size()-1));
			 entidadSR= (SolicitudRetiro)lista.get(lista.size()-1);
		 }else
			 entidadSR=null;

		em.close();
		return entidadSR;
	
	}

	@Override
	public void registrarSolictud(SolicitudRetiro sr) throws Exception {
		// TODO Auto-generated method stub

		em=emf.createEntityManager();
		em.getTransaction().begin();
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

	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList<SolicitudRetiro> obtenerSRxADA(
			AsistenteDireccionAcademica ada) throws Exception {
		System.out.println("leyendo SRxADA");
		em = emf.createEntityManager();
		ArrayList<SolicitudRetiro> solicitudesRetiro = new ArrayList<SolicitudRetiro>();
		Query q=em.createQuery("SELECT sr FROM SolicitudRetiro sr WHERE sr.strEstado = 'PENDIENTE' OR sr.asistenteDireccion.personas.strCodigoPersona=?1");
		q.setParameter(1, ada.getPersonas().getStrCodigoPersona());
		
		List lista = q.getResultList();
		 
		 if(lista.size()>0){
				for ( int i=0; i < lista.size(); i++ ) {
					SolicitudRetiro entidad = (SolicitudRetiro)lista.get(i);
					solicitudesRetiro.add(entidad);
				}
		 }

		em.close();
		return solicitudesRetiro;
	}

	@Override
	public Cita cargaDatosCitaxEvaluar(SolicitudRetiro selectedSolicitud)
			throws Exception {
		System.out.println("cargando Cita Evaluada");
		em = emf.createEntityManager();
		//ArrayList<Cita> solicitudesRetiro = new ArrayList<Cita>();
		Query q=em.createQuery("SELECT c FROM Cita c WHERE c.strestado = 'ATENDIDO' AND c.alumno.strCodigoAlumno=?1");
		q.setParameter(1, selectedSolicitud.getAlumno().getStrCodigoAlumno());
		
		List lista = q.getResultList();
		 Cita entidad=new Cita();
		 if(lista.size()>0){
				//for ( int i=0; i < lista.size(); i++ ) {
					 entidad = (Cita)lista.get(0);
				//	solicitudesRetiro.add(entidad);
				//}
		 }

		em.close();
		return entidad;
	}

	@Override
	public void apruebaSR(SolicitudRetiro selectedSolicitud) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2. ejecuta las operaciones 
		//2.1 busca Empleado por llave primaria
		SolicitudRetiro entidadSR = em.find(SolicitudRetiro.class, selectedSolicitud.getIntIdCodigoSolicitudRetiro());
		entidadSR.setStrEstado(Constantes.ESTADOSR_APROBADO);
		//2.3 actualiza Empleado
		em.merge(entidadSR);
		em.flush();
				
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void desapruebaSR(SolicitudRetiro selectedSolicitud)
			throws Exception {
		// TODO Auto-generated method stub

		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2. ejecuta las operaciones 
		//2.1 busca Empleado por llave primaria
		SolicitudRetiro entidadSR = em.find(SolicitudRetiro.class, selectedSolicitud.getIntIdCodigoSolicitudRetiro());
		entidadSR.setStrEstado(Constantes.ESTADOSR_RECHAZADO);
		//2.3 actualiza Empleado
		em.merge(entidadSR);
		em.flush();
				
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Certificadoa> obtenerCertificadosXAlumno(String elfiltro)
			throws Exception {

		System.out.println("leyendo elfiltro: "+elfiltro);
		em = emf.createEntityManager();
		//ArrayList<SolicitudRetiro> solicitudesRetiro = new ArrayList<SolicitudRetiro>();
		Query q=em.createQuery("SELECT c FROM Cita c WHERE c.alumno.strCodigoAlumno=?1 AND c.strestado='ATENDIDO'");
		q.setParameter(1, elfiltro);
		
		List lista = q.getResultList();
		List listatemp;
		ArrayList<Certificadoa> lista2 = new ArrayList<Certificadoa>();
		 if(lista.size()>0){
			 System.out.println("lista de citas relacionadas tiene "+lista.size()+" items");
				for ( int i=0; i < lista.size(); i++ ) {
					Query query=em.createQuery("SELECT ca FROM Certificadoa ca WHERE ca.intCodcita=?1");
					query.setParameter(1, ((Cita)(lista.get(i))).getIntcodcita());
					listatemp=query.getResultList();
					if(listatemp.size()>0){
						System.out.println("agregando "+listatemp.size()+" items de la listatemp");
						for(int j=0;j<listatemp.size();j++){
							lista2.add((Certificadoa) listatemp.get(j));
						}
						System.out.println("tamaño de lista2: "+lista2.size());
						//lista2.addAll(listatemp);
					}
					else{
						lista2=null;
						System.out.println("listatemp vacia - iteracion: "+i);
					}
				}
		 }else{
			 lista2=null;
			 System.out.println("lista de citas relacionadas, vacia");
		 }

		em.close();
		
		if(lista2.size()>0)
			return lista2;
		else
			return null;
	
	}

}
