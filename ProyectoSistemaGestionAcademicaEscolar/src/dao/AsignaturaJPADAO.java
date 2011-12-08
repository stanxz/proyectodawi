package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entidades.Asignatura;

public class AsignaturaJPADAO implements AsignaturaDAO{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Asignatura> obtenerTodos() throws Exception{
		
		em = emf.createEntityManager();
		
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		
		List lista = em.createQuery("SELECT a FROM Asignatura a where a.strEstado = 'Habilitado'").getResultList();
		
		if (lista.size()>0) {
			for (int i = 0; i < lista.size(); i++) {
				asignaturas.add((Asignatura)lista.get(i));
			}
		}
		
		for (Asignatura x : asignaturas) {
			if(x.getIntGrado() > 0 && x.getIntGrado() <=6){
				x.setStrNivel("Primario");
			}else{
				x.setStrNivel("Secundario");
			}
		}
		
		return asignaturas;
		
	}
	
	
	public void actualizar(Asignatura asignatura) throws Exception{
		
		System.out.println(asignatura.getIntCodigoAsignatura());
		System.out.println(asignatura.getStrNombreAsignatura());
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Asignatura entidadAsignatura = em.find(Asignatura.class, asignatura.getIntCodigoAsignatura());
		
		entidadAsignatura.setStrNombreAsignatura(asignatura.getStrNombreAsignatura());
		
		em.merge(entidadAsignatura);
		em.flush();
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Asignatura obtenerAsignatura(Asignatura asignatura) throws Exception {
		
		em = emf.createEntityManager();
		
		Asignatura entidadAsignatura = (Asignatura)em.find(Asignatura.class,asignatura.getIntCodigoAsignatura());
	
		return entidadAsignatura;
	}
	
	public void insertar(Asignatura asignatura) throws Exception {
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		asignatura.setStrEstado("Habilitado");
		
		em.persist(asignatura);
		em.flush();
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void inhabilitar(Asignatura asignatura) throws Exception {
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Asignatura entidadAsignatura = em.find(Asignatura.class, asignatura.getIntCodigoAsignatura());
		
		entidadAsignatura.setStrNombreAsignatura(asignatura.getStrNombreAsignatura());
		entidadAsignatura.setStrEstado("Deshabilitado");
		
		em.merge(entidadAsignatura);
		em.flush();
		
		em.getTransaction().commit();
		em.close();
	}

}
