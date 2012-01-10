package dao;
import java.util.ArrayList;


import entidades.Cita;


public interface CitaDAO {
	
	public ArrayList<Cita> obtenercitas() throws Exception;
	public void actualizarEstadoCita(Cita cita) throws Exception;

}
