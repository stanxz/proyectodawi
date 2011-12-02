package servicios;

import java.util.ArrayList;

import dao.AlumnoDAO;
import dao.DAOFactory;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Calendarioacademico;

public class AlumnoDaoService implements AlumnoService {
	private DAOFactory fabrica = null;
	private AlumnoDAO alumnodao;
	
	public AlumnoDaoService(int whichFactory) {
		// TODO Auto-generated constructor stub
		fabrica = DAOFactory.getDAOFactory(whichFactory);
        this.alumnodao = fabrica.getAlumnoDAO();
	}

	@Override
	public ArrayList<Alumno> obtenerTodosAlumnos() throws Exception {
		// TODO Auto-generated method stub
		return alumnodao.obtenerTodos();
	}
	
	@Override
	public ArrayList<Alumno> obtenerTodosAlumnosXApoderado(Apoderado apoderado) throws Exception {
		// TODO Auto-generated method stub
		return alumnodao.obtenerTodosAlumnoXApoderado(apoderado);
	}

	@Override
	public void registrarAlumno(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		alumnodao.insertar(alumno);
	}

	@Override
	public void actualizarAlumno(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		alumnodao.actualizar(alumno);
	}

	@Override
	public void inhabilitarAlumno(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		alumnodao.inhabilitar(alumno);
	}

	@Override
	public Alumno obtenerAlumno(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		return alumnodao.obtenerAlumno(alumno);
	}

	@Override
	public ArrayList<Calendarioacademico> getListaAniosAcademicos() throws Exception {
		// TODO Auto-generated method stub
		return alumnodao.listarAniosAcademicos();
	}

}
