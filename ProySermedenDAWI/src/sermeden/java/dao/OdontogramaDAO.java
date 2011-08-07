package sermeden.java.dao;


import java.util.List;

import sermeden.java.bean.OdontogramaDTO;

public interface OdontogramaDAO {

	public int generarOdontograma(OdontogramaDTO odontograma) throws Exception;

	public List<OdontogramaDTO> listadoOdontogramaXDNI(String filtro);
	
}
