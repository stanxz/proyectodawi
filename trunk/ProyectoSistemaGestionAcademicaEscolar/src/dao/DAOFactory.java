package dao;


public abstract class DAOFactory {

	public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    public static final int MEMORY = 6;
    public static final int JPA = 7;
    
    //aca faltan declararse los daos por entidad q se van a usar
    public abstract AlumnoDAO getAlumnoDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract PersonaDAO getPersonaDAO();
    public abstract AsignaturaDAO getAsignaturaDAO();
    public abstract MotivoDAO getMotivoDAO();
    public abstract PerfilDAO getPerfilDAO();
    public abstract DistritoDAO getDistritoDAO();
    public abstract MatriculaDAO getMatriculaDAO();
    public abstract SeccionProgramadaDAO getSeccionProgramadaDAO();
    public abstract SolicitudExoneracionDAO getSolicitudExoneracionDAO();
    public abstract SolicitudRetiroDAO getSolicitudRetiroDAO();
    public abstract BoletaDAO getBoletaDAO();
    
    public static DAOFactory getDAOFactory(int whichFactory) {
        switch(whichFactory){
       	case JPA:
        	    return new JPADAOFactory();
        default:
        	    return null;
        }
     }
    
}
