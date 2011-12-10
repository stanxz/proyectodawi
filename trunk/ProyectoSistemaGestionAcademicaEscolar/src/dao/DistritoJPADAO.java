package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entidades.Distrito;

public class DistritoJPADAO implements DistritoDAO{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Distrito> obtenerTodos() throws Exception{
		
		em = emf.createEntityManager();
		
		ArrayList<Distrito> distritos = new ArrayList<Distrito>();
		
		List lista = em.createQuery("SELECT d FROM Distrito d ORDER BY d.strNombreDistrito").getResultList();
		
		if (lista.size()>0) {
			for (int i = 0; i < lista.size(); i++) {
				distritos.add((Distrito)lista.get(i));
			}
		}
		
		return distritos;
		
	}
	
}
