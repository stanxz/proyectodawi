package dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import entidades.Cita;


public class CitaJPADAO implements CitaDAO {
	
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	
	public ArrayList<Cita> obtenercitas() throws Exception {
	     em = emf.createEntityManager();
			
			ArrayList<Cita> lista = new ArrayList<Cita>();
			
		List coleccion = em.createQuery("SELECT d FROM Cita  d where d.strestado='1' ORDER BY d.intcodcita").getResultList();
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
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Cita entidadCita = em.find(Cita.class, cita.getIntcodcita());
		
		entidadCita.setStrestado("2");
		
		
		em.merge(entidadCita);
		em.flush();
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	

}
