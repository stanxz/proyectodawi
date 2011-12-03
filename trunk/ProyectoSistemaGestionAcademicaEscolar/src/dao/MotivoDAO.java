package dao;

import java.util.ArrayList;

import entidades.Motivo;

public interface MotivoDAO {
	
	public ArrayList<Motivo> obtenerTodos() throws Exception;
}
