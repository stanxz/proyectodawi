package sermeden.java.dao;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
	public static final int IBATIS = 6;
	
	 public abstract UsuarioDAO getUsuarioDAO();
	 public abstract MenuDAO getMenuDAO(); 
	 public abstract FichaDAO getFichaDAO();
	 public abstract CitaDAO getCitaDAO();
	
	 public static DAOFactory getDAOFactory(int whichFactory){
	       switch(whichFactory){
	      	/*case MYSQL:
	       	    return new MySqlDAOFactory();
	       	case XML:
	       	    return new XmlDAOFactory();
	       	case ORACLE:
	       	    return new OracleDAOFactory();*/
	       	    
	       	case IBATIS:
	       	    return new IbatisDAOFactory();
	       	/*case DB2:
	       	    return new Db2DAOFactory();
	       	case SQLSERVER:
	       	    return new SqlServerDAOFactory();
	       	case XML:
	       	    return new XmlDAOFactory();*/
	       	default:
	       	    return null;
	       }
	    }
}
