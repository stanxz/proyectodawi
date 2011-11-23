package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entidades.Alumno;

public class AlumnoJPADAO implements AlumnoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.emf=emf;
	}

	@Override
	public List<Alumno> obtenerTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno obtenerAlumno(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inhabilitar(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		
	}
	


}
