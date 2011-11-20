package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import entidades.Permiso;
import entidades.Usuario;

public class UsuarioJPADAO implements UsuarioDAO {


	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.emf=emf;
	}
	
	@Override
	public Usuario validarUsuario(Usuario elusuario) throws Exception {
		System.out.println("En validar usuario - USuarioJPADAO");
		em=emf.createEntityManager();
		
		Usuario entidadUsuario=em.find(Usuario.class, elusuario.getPersona().getCodpersona());
		
		if(entidadUsuario!=null)
			return entidadUsuario;
		else
			return null;
	}

	@Override
	public ArrayList<Permiso> listarMenus(Usuario elusuario) throws Exception {

		em=emf.createEntityManager();

		ArrayList<Permiso> permisosUser = new ArrayList<Permiso>();
		 
		Query q =  em.createQuery( "SELECT p FROM Permiso p JOIN p.detalleperfil d where d.codpermiso=p.codpermiso and dp.codperfil=?1" );
		q.setParameter(1, elusuario.getPerfil().getCodperfil());

		List l=q.getResultList();
		// 2. Copiar los datos de cada entidad a 
		for ( int i=0; i < l.size(); i++ ) {
			Permiso entidad = (Permiso)l.get(i);
			permisosUser.add(entidad);
		}

		em.close();

		return permisosUser;
	
	}

}
