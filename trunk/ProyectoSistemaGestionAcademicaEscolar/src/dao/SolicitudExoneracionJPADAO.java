package dao;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import entidades.Actividad;
import entidades.Boleta;
import entidades.SolicitudExoneracion;

public class SolicitudExoneracionJPADAO implements SolicitudExoneracionDAO{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	public boolean CumpleCalendarioExoneracion(int codigoCalendario) throws Exception {
		boolean resultado = false;
		
		try {
			em = emf.createEntityManager();
			
			Actividad actividad = null;
			
			Query q = em.createQuery("SELECT a FROM Actividad a WHERE a.calendarioacademico.strCodcalendario='2011' " +
					                 "and a.intCodigoActividad=1 and (CURRENT_DATE between a.dtFecIni and a.dtFecFin)");
			//q.setParameter(1, codigoCalendario);
			//q.setParameter(2, 1);
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
	
	public boolean NoExisteDeudas(Boleta boleta) throws Exception{
		
		boolean resultado = false;
		
		System.out.println("NUMERO BOLETA    --->" + boleta.getStrCodigoBoleta());
		System.out.println("CODIGO APODERADO --->" + boleta.getApoderados().getPersonas().getStrCodigoPersona());
		System.out.println("TIPO SOLICITUD   --->" + boleta.getStrTipo());
		
		try {
			
			em = emf.createEntityManager();
			
			Boleta objBoleta = null;
			
			Query q = em.createQuery("select b from Boleta b where b.apoderados.personas.strCodigoPersona=?1 " +
					                 "and b.strTipo=?2 " +
					                 "and b.strCodigoBoleta=?3 " +
					                 "and b.strEstado='CANCELADO'");
			q.setParameter(1, boleta.getApoderados().getPersonas().getStrCodigoPersona());
			q.setParameter(2, boleta.getStrTipo());
			q.setParameter(3, boleta.getStrCodigoBoleta());
			
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
	
	public SolicitudExoneracion buscarSolicitudXAsignatura(SolicitudExoneracion exoneracion) throws Exception{
			
		try {
			
			em = emf.createEntityManager();
			
			SolicitudExoneracion objExoneracion = null;
			
			Query q = em.createQuery("select se from SolicitudExoneracion se " +
					                 "where se.asignaturas.intCodigoAsignatura=?1 " +
					                 "and substring(se.dtFecReg,1,4)=substring(CURRENT_DATE,1,4) " +
					                 "and (se.strEstado='Pendiente' or se.strEstado='Aprobado')");
			q.setParameter(1, exoneracion.getAsignaturas().getIntCodigoAsignatura());
			objExoneracion = (SolicitudExoneracion) q.getSingleResult();
			
			em.close();
			
			if(objExoneracion!=null){
				return objExoneracion;
			}else{
				return null;
			}

		} catch (Exception e) {
			return null;
		}

	
	}
	
	@Override
	public void registrarSolictud(SolicitudExoneracion exoneracion) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		
		exoneracion.setStrEstado("Pendiente");
		exoneracion.setDtFecReg(new java.sql.Date(new java.util.Date().getTime()));
		exoneracion.setAsistenteCoordinacion(null);	

		//2.ejecuta las operaciones
		em.persist(exoneracion);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList<SolicitudExoneracion> obtenerSolicitudes() throws Exception {
		
		     em = emf.createEntityManager();
			
			ArrayList<SolicitudExoneracion> solicitudesExoneracion = new ArrayList<SolicitudExoneracion>();
			  
			List lista = em.createQuery("SELECT se FROM SolicitudExoneracion se " +
                						"WHERE se.strEstado = 'Pendiente'").getResultList();
			 
			 if(lista.size()>0){
					for ( int i=0; i < lista.size(); i++ ) {
						SolicitudExoneracion entidad = (SolicitudExoneracion)lista.get(i);
						solicitudesExoneracion.add(entidad);
					}
			 }
			 
			 for (SolicitudExoneracion x : solicitudesExoneracion) {
				 StreamedContent image;
				 
				 image = new DefaultStreamedContent(new ByteArrayInputStream(x.getFotobin()));
				 
				 x.setScImagen(image);
			}
			 
			 

			em.close();
			
			return solicitudesExoneracion;
	}
	
	public void apruebaSolicitudExoneracion(SolicitudExoneracion exoneracion) throws Exception {
		
		System.out.println("Codigo Solictud ---> " + exoneracion.getIntIdCodigoSolicitudExoneracion());
		System.out.println("Codigo ACA ---> " + exoneracion.getAsistenteCoordinacion().getPersonas().getStrCodigoPersona());

		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		SolicitudExoneracion entidadExoneracion = em.find(SolicitudExoneracion.class, exoneracion.getIntIdCodigoSolicitudExoneracion());
		
		entidadExoneracion.setStrEstado("Aprobado");
		entidadExoneracion.setAsistenteCoordinacion(exoneracion.getAsistenteCoordinacion());

		em.merge(entidadExoneracion);
		em.flush();
				
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void desapruebaSolicitudExoneracion(SolicitudExoneracion exoneracion) throws Exception {
		System.out.println("Codigo Solictud ---> " + exoneracion.getIntIdCodigoSolicitudExoneracion());
		System.out.println("Codigo ACA ---> " + exoneracion.getAsistenteCoordinacion().getPersonas().getStrCodigoPersona());

		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		SolicitudExoneracion entidadExoneracion = em.find(SolicitudExoneracion.class, exoneracion.getIntIdCodigoSolicitudExoneracion());
		
		entidadExoneracion.setStrEstado("Desaprobado");
		entidadExoneracion.setAsistenteCoordinacion(exoneracion.getAsistenteCoordinacion());

		em.merge(entidadExoneracion);
		em.flush();
				
		em.getTransaction().commit();
		em.close();
		
	}

}
