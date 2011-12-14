package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import entidades.Alumno;
import entidades.Matricula;
import entidades.Seccionprogramada;

public class MatriculaJPADAO implements MatriculaDAO{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	

	public Matricula obtenerMatriculaAlumno(Alumno alumno) throws Exception{
		
		System.out.println("Codigo Alumno" + alumno.getStrCodigoAlumno());
		
		em = emf.createEntityManager();
		
		Matricula matricula = null;

		Query q = em.createQuery("SELECT m FROM Matricula m WHERE m.alumno.strCodigoAlumno = ?1");
		q.setParameter(1, alumno.getStrCodigoAlumno());
		
		matricula = (Matricula) q.getSingleResult();
		
		em.close();
		
		if(matricula!=null){
			System.out.println("Codigo Matricula :" + matricula.getIntIdMatricula());
			return matricula;
		}else{
			return null;
		}
		
	}
	
	public Seccionprogramada obtenerSecProAlumno(Matricula matricula) throws Exception {
		
		System.out.println("Codigo Seccion Programada : " + matricula.getSeccionprogramada().getIntIdSeccionProgramada());
		
		em = emf.createEntityManager();

		Query q = em.createQuery("SELECT sp FROM Seccionprogramada sp where sp.intIdSeccionProgramada = ?1");
		q.setParameter(1, matricula.getSeccionprogramada().getIntIdSeccionProgramada());
		
		Seccionprogramada seccionProgramada = (Seccionprogramada)q.getSingleResult();
		
		em.close();
		
		if(seccionProgramada!=null){
			return seccionProgramada;
		}else{
			return null;
		}
	}


	@Override
	public void registrarMatricula(Matricula matricula) throws Exception {
		// TODO Auto-generated method stub

		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2.ejecuta las operaciones
		em.persist(matricula);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	
	}
	
	

}
