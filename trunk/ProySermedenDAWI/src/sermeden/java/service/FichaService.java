package sermeden.java.service;

import sermeden.java.bean.FichaDTO;
import sermeden.java.dao.DAOFactory;
import sermeden.java.dao.FichaDAO;

public class FichaService implements FichaService_I {

	DAOFactory fabrica = 
			DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	
	FichaDAO objfichaDAO=fabrica.getFichaDAO();
	
	@Override
	public int registrarFicha(FichaDTO ficha) throws Exception {
		// TODO Auto-generated method stub
		return objfichaDAO.registrarFicha(ficha);
	}

	@Override
	public int cambiarEstadoFichaActual(int idPersona) {
		// TODO Auto-generated method stub
		return objfichaDAO.cambiarEstadoFichaActual(idPersona);
	}

}
