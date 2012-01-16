package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import entidades.Disponibilidadasistentasocial;

public class DisponibilidadAsistentaJPADAO implements
		DisponibilidadAsistentaDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.emf=emf;
	}

	@Override
	public Disponibilidadasistentasocial obtenerDisponibilidad(
			String codAsistenta) throws Exception {

		
		em = emf.createEntityManager();
		
		System.out.println("codAsistentaq llega al jpadao: " +codAsistenta);
		
		//ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		Query q = em.createQuery("SELECT d FROM Disponibilidadasistentasocial d where d.coddisponibilidadas=?1");
		q.setParameter(1, codAsistenta);
		
		Disponibilidadasistentasocial entidad = (Disponibilidadasistentasocial)q.getSingleResult();
		
		 /*List lista = q.getResultList();
		 
		 if(lista.size()>0){
				for ( int i=0; i < lista.size(); i++ ) {
					Alumno entidad = (Alumno)lista.get(i);
					System.out.println("alumno: " + lista.get(i));
					alumnos.add(entidad);
				}
		 }*/
		 
		em.close();
		
		return entidad;
	
	}
	
	
	
	
	
	
}
