package dao;

import java.util.ArrayList;

import entidades.Asignatura;

public interface AsignaturaDAO {
	
	public ArrayList<Asignatura> obtenerTodos() throws Exception;
}
