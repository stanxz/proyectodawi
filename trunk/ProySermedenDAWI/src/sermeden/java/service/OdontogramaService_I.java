package sermeden.java.service;


import java.util.List;

import sermeden.java.bean.OdontogramaDTO;

public interface OdontogramaService_I {

	int generarOdontograma(OdontogramaDTO odontograma) throws Exception;

	List<OdontogramaDTO> listadoOdontogramaXDNI(String filtro);

}
