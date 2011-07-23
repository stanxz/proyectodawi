package sermeden.java.service;

import sermeden.java.bean.FichaDTO;
import sermeden.java.bean.UsuarioDTO;



public interface FichaService_I {
	
		//registra la  ficha
		int registrarFicha(FichaDTO ficha) throws Exception;
		
		//para versionar las fichas
		int cambiarEstadoFichaActual(int idPersona);
		
		//para buscar las fichas actuales
		FichaDTO buscarFichaActualxPersona(String dniBuscado);
}
