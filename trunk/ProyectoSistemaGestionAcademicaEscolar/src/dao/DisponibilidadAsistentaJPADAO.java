package dao;

import java.util.List;

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
			String codAsistenta, int eldia) throws Exception {
		 Disponibilidadasistentasocial entidad=new Disponibilidadasistentasocial();
		
		em = emf.createEntityManager();
		
		System.out.println("codAsistentaq llega al jpadao: " +codAsistenta);

		Query q = em.createQuery("SELECT d FROM Disponibilidadasistentasocial d INNER JOIN d.tbAsistentas ta where ta.personas.strCodigoPersona=?1 and d.dia=?2");
		q.setParameter(1, codAsistenta);
		q.setParameter(2, eldia);
		
		List lista = q.getResultList();
		//Disponibilidadasistentasocial entidad = (Disponibilidadasistentasocial)q.getSingleResult();
		System.out.println("lista de disponibilidades en JPA: "+lista.size());
		 if(lista.size()>0){
			  entidad = (Disponibilidadasistentasocial)lista.get(0);
				/*for ( int i=0; i < lista.size(); i++ ) {
					Disponibilidadasistentasocial entidad = (Disponibilidadasistentasocial)lista.get(i);
					System.out.println("codigo Disponibilidadasistentasocial: " + entidad.getCoddisponibilidadas());
				//	alumnos.add(entidad);
				}*/
		 }else {
			entidad=null;
		 }
		 
		em.close();
		
		return entidad;
	
	}
	
	
	
	
	
	
}
