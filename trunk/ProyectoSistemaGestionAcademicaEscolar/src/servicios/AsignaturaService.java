package servicios;

import java.util.ArrayList;

import entidades.Asignatura;
import entidades.Grados;
import entidades.Seccionprogramada;

public interface AsignaturaService {
	
	public ArrayList<Asignatura> obtenerTodosAsignaturas() throws Exception;
	public void actualizarAsignatura(Asignatura asignatura) throws Exception;
	public void insertarAsignatura(Asignatura asignatura) throws Exception;
	public void inhabilitarAsignatura(Asignatura asignatura) throws Exception;
	public ArrayList<Grados> gradosPrimaria() throws Exception;
	public ArrayList<Grados> gradosSecundaria() throws Exception;
	public ArrayList<Asignatura> obtenerAsignaturasXGrado(Seccionprogramada seccion) throws Exception;
	public ArrayList<Asignatura> obtenerAsignaturasXGradoRetiro(Seccionprogramada seccion) throws Exception;
	public Asignatura consultarAsignatura(Asignatura asignatura) throws Exception ;
}
