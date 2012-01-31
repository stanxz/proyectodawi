package utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class Helper {
	private static String fileName = System.getProperty("user.dir") + "\\properties.ini";
	private static Properties file;
	private static InputStream stream;
	public static String log4jError;
	public static String log4jNotificador;
	public static String schema;
	public static String fuente;
	public static String driver;
	public static String user;
	public static String password;
	public static String diasFaltantes;
	
	static{
		 
         try {
        	 stream = new FileInputStream(fileName);
             file = new Properties();
			file.load(stream);
			log4jError = file.getProperty("log4jError");
			log4jNotificador = file.getProperty("log4jNotificador");
			
			schema=file.getProperty("schema");
			fuente=file.getProperty("fuente");
			driver=file.getProperty("driver");
			user=file.getProperty("user");
			password=file.getProperty("password");
			diasFaltantes=file.getProperty("diasFaltantes");
			
			 PropertyConfigurator.configure(Helper.log4jError);
		} catch (IOException e) {
			System.out.println("Error cargando archivo de propiedades en Helper " + e.getMessage());
			e.printStackTrace();
		}
	}
}
