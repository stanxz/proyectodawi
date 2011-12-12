package servicios;


import dao.DAOFactory;
import dao.MatriculaDAO;

import entidades.Alumno;
import entidades.Matricula;
import entidades.Seccionprogramada;

public class MatriculaDaoService implements MatriculaService{
	private DAOFactory fabrica = null;
	private MatriculaDAO matriculadao;
	
	public MatriculaDaoService(int whichFactory){
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.matriculadao = fabrica.getMatriculaDAO();
	}
	
	@Override
	public Matricula obtenerMatriculaAlumno(Alumno alumno)throws Exception {
		// TODO Auto-generated method stub
		return matriculadao.obtenerMatriculaAlumno(alumno);
	}

	@Override
	public Seccionprogramada obtenerSecProAlumno(Matricula matricula)
			throws Exception {
		// TODO Auto-generated method stub
		return matriculadao.obtenerSecProAlumno(matricula);
	}
	
	
}
