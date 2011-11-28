package servicios;

import java.util.ArrayList;

import entidades.Asignatura;

public interface AsignaturaService {
	
	public ArrayList<Asignatura> obtenerTodosAsignaturas() throws Exception;
}
