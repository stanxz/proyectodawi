package sermeden.java.dao;

import sermeden.java.bean.FichaDTO;

public interface FichaDAO {

	public int registrarFicha(FichaDTO ficha) throws Exception;
	
	int cambiarEstadoFichaActual(FichaDTO ficha);
}
