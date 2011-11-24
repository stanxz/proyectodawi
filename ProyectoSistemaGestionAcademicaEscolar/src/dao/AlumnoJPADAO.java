package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entidades.Alumno;

public class AlumnoJPADAO implements AlumnoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf=emf;
	}

	@Override
	public List<Alumno> obtenerTodos() throws Exception {
		
		em = emf.createEntityManager();
		
		List<Alumno> alumnos = em.createQuery("SELECT a FROM Alumno a").getResultList();
		
		em.close();
		
		return alumnos;
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
