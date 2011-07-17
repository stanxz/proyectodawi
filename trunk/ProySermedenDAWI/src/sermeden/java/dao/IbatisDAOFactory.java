package sermeden.java.dao;


public class IbatisDAOFactory extends DAOFactory {
	
	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new IbatisUsuarioDAO();
	}

	@Override
	public MenuDAO getMenuDAO() {
		// TODO Auto-generated method stub
		return new IbatisMenuDAO();
	}

}
