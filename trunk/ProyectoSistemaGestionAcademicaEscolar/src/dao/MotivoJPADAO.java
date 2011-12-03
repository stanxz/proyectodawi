package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entidades.Motivo;

public class MotivoJPADAO implements MotivoDAO{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Motivo> obtenerTodos() throws Exception{
		
		em = emf.createEntityManager();
		
		ArrayList<Motivo> motivos = new ArrayList<Motivo>();
		
		List lista = em.createQuery("SELECT m FROM Motivo m").getResultList();
		
		if (lista.size()>0) {
			for (int i = 0; i < lista.size(); i++) {
				motivos.add((Motivo)lista.get(i));
			}
		}
		
		return motivos;
		
	}

}
