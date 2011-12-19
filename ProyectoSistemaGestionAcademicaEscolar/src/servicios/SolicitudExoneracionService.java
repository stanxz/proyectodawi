package servicios;

import entidades.Boleta;


public interface SolicitudExoneracionService {

	public boolean CumpleCalendarioExoneracion(int codigoCalendario) throws Exception;
	public boolean NoExisteDeudas(Boleta boleta) throws Exception;
}
