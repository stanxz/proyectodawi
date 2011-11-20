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
		this.emf=emf;
	}
	
	@Override
	public Usuario validarUsuario(Usuario elusuario) throws Exception {
		em=emf.createEntityManager();
		Query q =  em.createQuery("SELECT u FROM Usuario u WHERE u.getStrCodigoPersona=?1");
		q.setParameter(1, elusuario.getStrCodigoPersona());
		
		Usuario entidadUsuario=(Usuario)q.getSingleResult();
		em.close();
		if(entidadUsuario!=null)
			return entidadUsuario;
		else
			return null;
	}

	@Override
	public ArrayList<Permiso> listarMenus(Usuario elusuario) throws Exception {

		em=emf.createEntityManager();

		ArrayList<Permiso> permisosUser = new ArrayList<Permiso>();
		 
		Query q =  em.createQuery("SELECT p FROM Permiso p JOIN p.detalleperfil d where d.codpermiso=p.codpermiso and dp.codperfil=?1" );
		q.setParameter(1, elusuario.getStrCodigoPerfil());

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
