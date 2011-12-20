package servicios;

import java.util.ArrayList;

import dao.AsignaturaDAO;
import dao.DAOFactory;
import entidades.Asignatura;
import entidades.Grados;
import entidades.Seccionprogramada;

public class AsignaturaDaoService implements AsignaturaService{
	private DAOFactory fabrica = null;
	private AsignaturaDAO asignaturadao;
	
	public AsignaturaDaoService(int whichFactory){
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.asignaturadao = fabrica.getAsignaturaDAO();
	}
	
	public ArrayList<Asignatura> obtenerTodosAsignaturas() throws Exception {
		return asignaturadao.obtenerTodos();
	}
	
	public void actualizarAsignatura(Asignatura asignatura) throws Exception {
		asignaturadao.actualizar(asignatura);
	}
	
	public void insertarAsignatura(Asignatura asignatura) throws Exception {
		asignaturadao.insertar(asignatura);
	}
	
	public void inhabilitarAsignatura(Asignatura asignatura) throws Exception {
		asignaturadao.inhabilitar(asignatura);
	}
	
	public ArrayList<Grados> gradosPrimaria() throws Exception {
		return asignaturadao.obtenerGradoPrimaria();
	}
	
	public ArrayList<Grados> gradosSecundaria() throws Exception {
		return asignaturadao.obtenerGradoSecundaria();
	}

	@Override
	public ArrayList<Asignatura> obtenerAsignaturasXGrado(
			Seccionprogramada seccion) throws Exception {
		return asignaturadao.obtenerAsignaturasXGrado(seccion);
	}

	@Override
	public Asignatura consultarAsignatura(Asignatura asignatura)
			throws Exception {
		// TODO Auto-generated method stub
		return asignaturadao.consultarAsignatura(asignatura);
	}
}
