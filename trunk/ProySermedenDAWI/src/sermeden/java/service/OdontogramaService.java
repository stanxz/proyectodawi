package sermeden.java.service;


import sermeden.java.bean.OdontogramaDTO;
import sermeden.java.dao.DAOFactory;
import sermeden.java.dao.OdontogramaDAO;

public class OdontogramaService implements OdontogramaService_I {

	DAOFactory fabrica = 
		DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	
	OdontogramaDAO objOdontogramaDAO = fabrica.getOdontogramaDAO();
	

	public int generarOdontograma(OdontogramaDTO odontograma) throws Exception {
		// TODO Auto-generated method stub
		return objOdontogramaDAO.generarOdontograma(odontograma);
	}

}
