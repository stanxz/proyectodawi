package dao;

import entidades.Boleta;

public interface SolicitudExoneracionDAO {
	
	
	public boolean CumpleCalendarioExoneracion(int codigoCalendario) throws Exception;
	public boolean NoExisteDeudas(Boleta boleta) throws Exception;
}
