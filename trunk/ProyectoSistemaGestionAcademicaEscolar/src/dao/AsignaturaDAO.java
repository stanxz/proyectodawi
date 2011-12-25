package dao;

import java.util.ArrayList;

import entidades.Asignatura;
import entidades.Grados;
import entidades.Seccionprogramada;

public interface AsignaturaDAO {
	
	public ArrayList<Asignatura> obtenerTodos() throws Exception;
	public void insertar(Asignatura asignatura) throws Exception;
	public void actualizar(Asignatura asignatura) throws Exception;
	public void inhabilitar(Asignatura asignatura) throws Exception;
	public ArrayList<Grados> obtenerGradoPrimaria() throws Exception;
	public ArrayList<Grados> obtenerGradoSecundaria() throws Exception;
	public ArrayList<Asignatura> obtenerAsignaturasXGrado(Seccionprogramada seccion) throws Exception;
	public ArrayList<Asignatura> obtenerAsignaturasXGradoRetiro(Seccionprogramada seccion) throws Exception;
	public Asignatura consultarAsignatura(Asignatura asignatura) throws Exception ;
}
