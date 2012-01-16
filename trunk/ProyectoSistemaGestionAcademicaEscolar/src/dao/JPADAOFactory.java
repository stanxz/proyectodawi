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


	@Override
	public SeccionProgramadaDAO getSeccionProgramadaDAO() {
		// TODO Auto-generated method stub
		SeccionProgramadaJPADAO ed =  new SeccionProgramadaJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (SeccionProgramadaDAO)ed;
	}


	@Override
	public SolicitudExoneracionDAO getSolicitudExoneracionDAO() {
		// TODO Auto-generated method stub
		SolicitudExoneracionJPADAO ed = new SolicitudExoneracionJPADAO();
		ed.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - ed en memoria: "+ed.toString());
		return (SolicitudExoneracionDAO)ed;
	}


	@Override
	public BoletaDAO getBoletaDAO() {
		BoletaJPADAO bd=new BoletaJPADAO();
		bd.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - bod en memoria: "+bd.toString());
		return (BoletaJPADAO)bd;
	}


	@Override
	public SolicitudRetiroDAO getSolicitudRetiroDAO() {
		SolicitudRetiroJPADAO srd=new SolicitudRetiroJPADAO();
		srd.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - bod en memoria: "+srd.toString());
		return (SolicitudRetiroJPADAO)srd;
	}


	@Override
	public CitaDAO getCitaDAO() {
		// TODO Auto-generated method stub
		CitaJPADAO srd=new CitaJPADAO();
		srd.setEntityManagerFactory(emf);
		
		return(CitaJPADAO)srd;
	}


	@Override
	public DisponibilidadAsistentaDAO getDisponibilidadAsistentaDAO() {
		DisponibilidadAsistentaJPADAO srd=new DisponibilidadAsistentaJPADAO();
		srd.setEntityManagerFactory(emf);
		System.out.println("JPADAOFactory - bod en memoria: "+srd.toString());
		return (DisponibilidadAsistentaJPADAO)srd;
	}


}
