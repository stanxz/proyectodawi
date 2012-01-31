package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import utiles.Helper;

public class ConexionBD {
	    public static String user;
	    public static String password;
	    public static String driver;
	    public static String url;
	    //public static String schema;
	    public static boolean isConnected = false;
	    
	    static Logger log = Logger.getLogger(ConexionBD.class);
	    
	    static {
	        try {
	            user = Helper.user;
	            password = Helper.password;
	            driver = Helper.driver;
	            url = Helper.fuente;
	           // schema = Helper.schema;
	            Class.forName(driver);
	        } catch (Exception e) {
	            log.info("Error en conectar driver " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	    public synchronized static void closeConnection() throws SQLException {
	        ConexionBD.getConnection().close();
	    }
	    
	    public synchronized static Connection getConnection() throws SQLException {
	       // String suje="";
	       //  String mensa="";
	        Connection connection = null;
	       // byte tryCount = 0;
	        while (connection == null) {
	            try {
	                connection = DriverManager.getConnection(url, user, password);
	                connection.setAutoCommit(false);
	                isConnected = true;
	        //        contaCorreos=5;
	            } catch (SQLException ex) {
	                isConnected = false;
	             //   if (++tryCount > contaCorreos) {
	                   // log.info("Error " + ex.getMessage(),ex);
	                 //   tryCount = 0;
	                 //   log.info("contaCorreos : "+contaCorreos);
	                   // contaCorreos=contaCorreos*10;
	             //       log.info("No se pudo conectar a la BD ..... );
	                   
	                    //throw ex;
	              //  } else {
	                    connection = null;
	                    ex.printStackTrace();
	                    log.info("Esperando 5 segundos para volver a conectar");
	                    try {
	                        Thread.sleep(5000);
	                    } catch (InterruptedException iex) {
	                        log.info("Error " + iex.getMessage());
	                    }
	                //}
	            }
	        }
	        return connection;
	    }
	    
}
