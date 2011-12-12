package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADAOFactory extends DAOFactory {
	private EntityManagerFactory emf;
	
	
	public JPADAOFactory (){
		System.out.println("Cargando JPADAOFactory");
		emf=Persistence.createEntityManagerFactory("JPADemo");
		System.out.println("JPADAOFactory - emf en memoria: " + emf.toString());
	}


	@Override
	public AlumnoDAO getAlumnoDAO() {
		AlumnoJPADAO ed =  new AlumnoJPADAO();
		ed.setEntityManagerFactory(emf);
		return (AlumnoDAO)ed;
	}


	@Override
	public UsuarioDAO getUsuarioDAO() {
		UsuarioJPADAO ed =  new UsuarioJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (UsuarioDAO)ed;
	}


	@Override
	public PersonaDAO getPersonaDAO() {
		PersonaJPADAO ed =  new PersonaJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (PersonaDAO)ed;
	}
	
	public AsignaturaDAO getAsignaturaDAO() {
		AsignaturaJPADAO ed =  new AsignaturaJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (AsignaturaDAO)ed;
	}
	
	public MotivoDAO getMotivoDAO() {
		MotivoJPADAO ed =  new MotivoJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (MotivoDAO)ed;
	}


	@Override
	public PerfilDAO getPerfilDAO() {
		PerfilJPADAO ed =  new PerfilJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (PerfilDAO)ed;
	}
	
	@Override
	public DistritoDAO getDistritoDAO() {
		DistritoJPADAO ed =  new DistritoJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (DistritoDAO)ed;
	}


	@Override
	public MatriculaDAO getMatriculaDAO() {
		MatriculaJPADAO ed =  new MatriculaJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (MatriculaDAO)ed;
	}


	//aca falta las implementaciones de los dao q se va
	//a usar
	
	
}
