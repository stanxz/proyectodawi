package sermeden.java.dao;

import java.util.List;

import sermeden.java.bean.MenuDTO;
import sermeden.java.bean.UsuarioDTO;

public interface MenuDAO {

	public List<MenuDTO> obtieneMenu(UsuarioDTO usuario);
	
}
