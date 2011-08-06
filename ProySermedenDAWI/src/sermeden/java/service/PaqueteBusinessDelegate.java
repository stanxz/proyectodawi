package sermeden.java.service;

public class PaqueteBusinessDelegate {

	private PaqueteBusinessDelegate(){
		
	}
	
	public static UsuarioService_I getUsuarioService() {
		// TODO Auto-generated method stub
		return new UsuarioService();
	}
	
	public static MenuService_I getMenuService() {
		// TODO Auto-generated method stub
		return new MenuService();
	}
	
	public static FichaService_I getFichaService(){
		return new FichaService();
	}

	public static CitaService_I getCitaService() {
		// TODO Auto-generated method stub
		return new CitaService();
	}
	
	public static OdontogramaService_I getOdontogramaService() {
		// TODO Auto-generated method stub
		return new OdontogramaService();
	}

}
