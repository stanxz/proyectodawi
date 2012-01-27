package dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


import entidades.Cita;


public class CitaJPADAO implements CitaDAO {
	
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Cita> obtenercitas() throws Exception {
	     em = emf.createEntityManager();
			
			ArrayList<Cita> lista = new ArrayList<Cita>();
			
		List coleccion = em.createQuery("SELECT d FROM Cita  d where d.strestado='PENDIENTE' ORDER BY d.intcodcita").getResultList();
/*			List coleccion = em.createQuery("SELECT d FROM Cita  d INNER JOIN d.alumno c  where   c.strCodigoAlumno = d.strCodigoAlumno and " +
					" d.strestado='1' ORDER BY d.intcodcita").getResultList();	*/
			if (coleccion.size()>0) {
				for (int i = 0; i < coleccion.size(); i++) {
					lista.add((Cita)coleccion.get(i));
					System.out.println(lista.get(i).getIntcodcita());
				}
			}
			
			return lista;
		}
	
	
	@Override
	public void actualizarEstadoCita(Cita cita) throws Exception {
		System.out.println("CitaJPADAO.codCita()"+cita.getIntcodcita());
		System.out.println("CitaJPADAO.codalunno"+cita.getAlumno().getStrCodigoAlumno());
		System.out.println("CitaJPADAO.codper()"+cita.getAlumno().getApoderados().getPersonas().getStrCodigoPersona());
		System.out.println("CitaJPADAO.servcio()"+cita.getIntcodtiposervicio());
		System.out.println("CitaJPADAO.codasist"+cita.getStrcodasistentasocial());
		
		
		
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Cita entidadCita = em.find(Cita.class, cita.getIntcodcita());
		
		entidadCita.setStrestado("ATENDIDO");
		
		
		em.merge(entidadCita);
		em.flush();
		
		em.getTransaction().commit();
		em.close();
		
	}



	@Override
	public void insertarCita(Cita cita) throws Exception {
		
		em=emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(cita);
		em.flush();
		em.getTransaction().commit();
		em.close();
			
	}



	@Override
	public void registrarCita(Cita miciCita) throws Exception {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(miciCita);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}


	@SuppressWarnings("rawtypes")
	@Override
	public Cita consultaCitaPendiente(String strCodigoAlumno) throws Exception {
		em = emf.createEntityManager();
		System.out.println("strCodigoAlumno llega al jpadao: " +strCodigoAlumno);
		List coleccion = new ArrayList<Cita>();
		Query q = em.createQuery("SELECT c FROM Cita c where c.alumno.strCodigoAlumno=?1 and c.strestado='PENDIENTE' ");
		q.setParameter(1, strCodigoAlumno);
		
		coleccion = q.getResultList();
		em.close();
		
		if (coleccion.size()>0) {
			return (Cita) coleccion.get(0);
		}else
			return null;
		
	}

	
	
	
	

}
