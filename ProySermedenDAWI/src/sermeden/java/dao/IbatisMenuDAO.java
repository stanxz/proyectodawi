package sermeden.java.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sermeden.java.bean.MenuDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.ibatis.MyIbatisManager;

public class IbatisMenuDAO implements MenuDAO{
	
	public List<MenuDTO> obtieneMenu(UsuarioDTO usuario){
		System.out.println("Buscando menu con MyBatis");
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<MenuDTO> menu=  sesion.selectList("traeMenu",usuario);
		sesion.close();
		return menu;
	}

	
}
