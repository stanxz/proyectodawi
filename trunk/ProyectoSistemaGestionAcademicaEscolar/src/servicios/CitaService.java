package servicios;
import java.util.ArrayList;

import entidades.Cita;


public interface CitaService {
	
	public ArrayList<Cita> obtenercitas() throws Exception;
	public void actualizarEstadoCita(Cita cita) throws Exception;

}
