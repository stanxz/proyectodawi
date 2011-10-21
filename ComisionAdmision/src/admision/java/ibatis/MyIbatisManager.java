package admision.java.ibatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyIbatisManager {
	
	private static SqlSessionFactory sqlFactory;
	
	static String resource = "sermeden/java/ibatis/SqlMapConfig.xml";
	
	static {
		
		try {
			//Leemos el archivo de configuracion de Mybatis
			Reader reader = 
				Resources.getResourceAsReader(resource);
			
			//Configuramos el framework		
			sqlFactory = 
				new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//metodo de acceso al factory
	public static SqlSessionFactory getSqlSessionFactory(){
		
		return sqlFactory;
	}

}
