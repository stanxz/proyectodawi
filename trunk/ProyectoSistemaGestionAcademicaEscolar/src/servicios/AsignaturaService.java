package servicios;

import java.util.ArrayList;

import entidades.Asignatura;
import entidades.Grados;

public interface AsignaturaService {
	
	public ArrayList<Asignatura> obtenerTodosAsignaturas() throws Exception;
	public void actualizarAsignatura(Asignatura asignatura) throws Exception;
	public void insertarAsignatura(Asignatura asignatura) throws Exception;
	public void inhabilitarAsignatura(Asignatura asignatura) throws Exception;
	public ArrayList<Grados> gradosPrimaria() throws Exception;
	public ArrayList<Grados> gradosSecundaria() throws Exception;
}
