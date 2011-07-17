package sermeden.java.service;

import java.util.List;

import sermeden.java.bean.MenuDTO;
import sermeden.java.bean.UsuarioDTO;

public interface MenuService_I {

	List<MenuDTO> obtieneMenu(UsuarioDTO usuario);

}
