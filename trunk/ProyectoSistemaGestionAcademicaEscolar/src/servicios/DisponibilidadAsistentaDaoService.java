package servicios;

import dao.DAOFactory;
import dao.DisponibilidadAsistentaDAO;
import entidades.Disponibilidadasistentasocial;

public class DisponibilidadAsistentaDaoService implements
		DisponibilidadAsistentaService {

	private DAOFactory fabrica = null;
	private DisponibilidadAsistentaDAO dadao;
	
	
	public DisponibilidadAsistentaDaoService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
        this.dadao = fabrica.getDisponibilidadAsistentaDAO();
	}


	@Override
	public Disponibilidadasistentasocial obtenerDisponibilidad(
			String codAsistenta) throws Exception {
		// TODO Auto-generated method stub
		return dadao.obtenerDisponibilidad(codAsistenta);
	}

}
