package servicios;

import java.util.ArrayList;

import entidades.Asignatura;

public interface AsignaturaService {
	
	public ArrayList<Asignatura> obtenerTodosAsignaturas() throws Exception;
	public void actualizarAsignatura(Asignatura asignatura) throws Exception;
	public void insertarAsignatura(Asignatura asignatura) throws Exception;
}
