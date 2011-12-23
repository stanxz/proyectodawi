package servicios;

import dao.BoletaDAO;
import dao.DAOFactory;
import entidades.Boleta;


public class BoletaDaoService implements BoletaService {
	private DAOFactory fabrica = null;
	private BoletaDAO boletadao;
	
	
	public BoletaDaoService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
        this.boletadao = fabrica.getBoletaDAO();
	}


	@Override
	public Boleta obtenerBoleta(Boleta temporal) throws Exception {
		// TODO Auto-generated method stub
		return boletadao.obtenerBoleta(temporal);
	}


	@Override
	public void registrarBoleta(Boleta laboleta) throws Exception {
		// TODO Auto-generated method stub
		boletadao.registrarBoleta(laboleta);
	}
	
	
}
