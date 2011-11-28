package dao;

import java.util.ArrayList;

import entidades.Asignatura;

public interface AsignaturaDAO {
	
	public ArrayList<Asignatura> obtenerTodos() throws Exception;
	public void insertar(Asignatura asignatura) throws Exception;
	public void actualizar(Asignatura asignatura) throws Exception;
}
