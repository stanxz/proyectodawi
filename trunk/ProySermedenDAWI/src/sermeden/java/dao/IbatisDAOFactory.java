package sermeden.java.dao;

public class IbatisDAOFactory extends DAOFactory {
	
	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new IbatisUsuarioDAO();
	}
	
	public MenuDAO getMenuDAO() {
		// TODO Auto-generated method stub
		return new IbatisMenuDAO();
	}

	@Override
	public FichaDAO getFichaDAO() {
		// TODO Auto-generated method stub
		return new IbatisFichaDAO();
	}

	@Override
	public CitaDAO getCitaDAO() {
		// TODO Auto-generated method stub
		return new IbatisCitaDAO();
	}

	@Override
	public OdontogramaDAO getOdontogramaDAO() {
		// TODO Auto-generated method stub
		return new IbatisOdontogramaDAO();
	}
}
