package sermeden.java.service;

import java.util.List;

import sermeden.java.bean.MenuDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.dao.DAOFactory;
import sermeden.java.dao.MenuDAO;

public class MenuService implements MenuService_I {

	DAOFactory fabrica = 
		DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	
	MenuDAO objMenuDAO=fabrica.getMenuDAO();

	@Override
	public List<MenuDTO> obtieneMenu(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return objMenuDAO.obtieneMenu(usuario);
	}

}
