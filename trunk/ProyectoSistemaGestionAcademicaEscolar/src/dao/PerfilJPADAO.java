package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import entidades.Perfil;

public class PerfilJPADAO implements PerfilDAO {


	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf=emf;
	}
	

	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList<Perfil> listarPerfiles() throws Exception {

		em=emf.createEntityManager();

		ArrayList<Perfil> perfiles = new ArrayList<Perfil>();
		 
		Query q =  em.createQuery("SELECT p FROM Perfil p where p.strCodigoPerfil <> 'pf01'" );

		List l=q.getResultList();
		if(l.size()>0){
			for ( int i=0; i < l.size(); i++ ) {
				Perfil entidad = (Perfil)l.get(i);
				System.out.println("permiso: "+l.get(i));
				perfiles.add(entidad);
			}
		}
		
		em.close();

		return perfiles;
	
	}


}
