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
	public ArrayList<Alumno> obtenerTodos() throws Exception {
		
		em = emf.createEntityManager();
		
		ArrayList<Alumno> students = new ArrayList<Alumno>();
		
		 List l = em.createQuery("SELECT a FROM Alumno a").getResultList();
		
		 if(l.size()>0){
				for ( int i=0; i < l.size(); i++ ) {
					Alumno entidad = (Alumno)l.get(i);
					System.out.println("alumno: "+l.get(i));
					students.add(entidad);
				}
		 }
		 
		em.close();
		
		return students;
	}

	@Override
	public void insertar(Alumno alumno) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2.ejecuta las operaciones
		em.persist(alumno);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Alumno alumno) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2. ejecuta las operaciones 
		//2.1 busca Empleado por llave primaria
		Alumno entidadAlumno = em.find(Alumno.class, alumno.getStrCodigoAlumno());
	
		//2.3 actualiza Empleado
		em.merge(entidadAlumno);
		em.flush();
				
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Alumno obtenerAlumno(Alumno alumno) throws Exception {
		em=emf.createEntityManager();
		
		Alumno entidadCargo=(Alumno)em.find(Alumno.class,alumno.getStrCodigoAlumno());
		
		return entidadCargo;
	}

	@Override
	public void inhabilitar(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2. ejecuta las operaciones 
		//2.1 busca Empleado por llave primaria
		Alumno entidadAlumno = em.find(Alumno.class, alumno.getStrCodigoAlumno());
	
		//2.3 actualiza Empleado
		em.merge(entidadAlumno);
		em.flush();
				
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}
	


}
