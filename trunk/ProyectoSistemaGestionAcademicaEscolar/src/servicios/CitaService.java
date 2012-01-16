package servicios;
import java.util.ArrayList;

import entidades.Cita;


public interface CitaService {
	
	public ArrayList<Cita> obtenercitas() throws Exception;
	public void actualizarEstadoCita(Cita cita) throws Exception;
	public void registrarCita(Cita miciCita)throws Exception;
	public Cita consultaCitaPendiente(String strCodigoAlumno)throws Exception;

}
