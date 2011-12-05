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
	public Usuario validarUsuario(Usuario elusuario) throws Exception{
		
		em = emf.createEntityManager();
		
		Usuario entidadUsuario = null;
		
		Query q =  em.createQuery("SELECT u FROM Usuario u WHERE u.personas.strCodigoPersona=?1 and u.strContrasena=?2",Usuario.class);
		q.setParameter(1, elusuario.getPersonas().getStrCodigoPersona());
		q.setParameter(2, elusuario.getStrContrasena());
		
		System.out.println(elusuario.getPersonas().getStrCodigoPersona());
		
		entidadUsuario =(Usuario)q.getSingleResult();

		em.close();
		
		if(entidadUsuario!=null){
			return entidadUsuario;
		}else{
			return null;
		}
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList<Permiso> listarMenus(Usuario elusuario) throws Exception {

		em=emf.createEntityManager();

		ArrayList<Permiso> permisosUser = new ArrayList<Permiso>();
		 
		Query q =  em.createQuery("SELECT c1 FROM Permiso c1 INNER JOIN c1.tbPerfiles c2 where c2.strCodigoPerfil=?1" );
		q.setParameter(1, elusuario.getPerfiles().getStrCodigoPerfil());

		List l=q.getResultList();
		if(l.size()>0){
			for ( int i=0; i < l.size(); i++ ) {
				Permiso entidad = (Permiso)l.get(i);
				System.out.println("permiso: "+l.get(i));
				permisosUser.add(entidad);
			}
		}
		
		em.close();

		return permisosUser;
	
	}

	@Override
	public Usuario buscaContrasena(Usuario elusuario) throws Exception {

		em=emf.createEntityManager();
		Query q =  em.createQuery("SELECT u FROM Usuario u WHERE u.personas.strCodigoPersona=?1");
		q.setParameter(1, elusuario.getPersonas().getStrCodigoPersona());
		
			Usuario entidadUsuario =(Usuario)q.getSingleResult();
			em.close();
			if(entidadUsuario!=null){
				return entidadUsuario;
			}else{
				return null;
			}
	
	}

	@Override
	public void registrarUsuario(Usuario nuevo) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2.ejecuta las operaciones
		em.persist(nuevo);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

}
