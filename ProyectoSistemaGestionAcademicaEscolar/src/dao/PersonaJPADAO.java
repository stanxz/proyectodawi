package dao;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import entidades.Alumno;
import entidades.Apoderado;
import entidades.AsistentaSocial;
import entidades.AsistenteCoordinacionAcademica;
import entidades.AsistenteDireccionAcademica;
import entidades.Distrito;
import entidades.Perfil;
import entidades.Persona;
import entidades.SecretariaAcademica;

public class PersonaJPADAO implements PersonaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf=emf;
	}
	
	//Este metodo lista a todos los Empleados de la tabla Persona(NO APODERADOS)
	@SuppressWarnings("rawtypes")
	public ArrayList<Persona> obtenerTodosEmpleados()throws Exception {
		
	    em = emf.createEntityManager();
		
		ArrayList<Persona> empleados = new ArrayList<Persona>();
			
		 List lista = em.createQuery("SELECT p FROM Persona p " +
				                     "inner join p.tbUsuarios u " +
				                     "where u.perfiles.strCodigoPerfil <> 'pf01' " +
				                     "order by p.strApellidoPaterno").getResultList();
		 
		 if(lista.size()>0){
				for ( int i=0; i < lista.size(); i++ ) {
					Persona entidad = (Persona)lista.get(i);
					empleados.add(entidad);
				}
		 }
		 
		 
		 for (Persona x : empleados) {	 
			x.setPerfil(obtienePerfilPersona(x.getStrCodigoPersona()));
			
			StreamedContent image;
			
			 if(x.getFotobin()!=null){
				 image = new DefaultStreamedContent(new ByteArrayInputStream(x.getFotobin()));
				 
				 x.setScImagen(image);
			 }
		 }
		

		em.close();
		
		return empleados;
		
	}
	
	public Perfil obtienePerfilPersona(String codigoPersona){
		Query q =  em.createQuery("SELECT p FROM Perfil p " +
								  "inner join p.tbUsuarios u " +
								  "where u.personas.strCodigoPersona = ?1");
		q.setParameter(1, codigoPersona);
		
		try {
			Perfil entidadPerfil =(Perfil)q.getSingleResult();
			if(entidadPerfil!=null)
				return entidadPerfil;
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Persona consultarPersona(Persona p) throws Exception {
		em=emf.createEntityManager();
		Query q =  em.createQuery("SELECT p FROM Persona p WHERE p.intDNI=?1");
		q.setParameter(1, p.getIntDNI());
		
		try {
			Persona entidadPersona =(Persona)q.getSingleResult();
			em.close();
			if(entidadPersona!=null)
				return entidadPersona;
			else
				return null;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public void registrarPersona(Persona nueva) throws Exception {
		em=emf.createEntityManager();
		
		System.out.println("xxxxxx  " + nueva.getIntDNI());
		
		nueva.setStrCodigoPersona("PE-" + nueva.getIntDNI());

		//1.inicia la transacción
		em.getTransaction().begin();

		//2.ejecuta las operaciones
		em.persist(nueva);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	//Este metodo guarda al apoderado en su tabla Apoderado
	@Override
	public void guardaApoderado(Apoderado apo) throws Exception {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2.ejecuta las operaciones
		em.persist(apo);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}
	
	//Este metodo guarda a la asistentadocial en su tabla AsistentaSocial
	@Override
	public void guardaAsistentaSocial(AsistentaSocial asistenta) throws Exception {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();
		
		System.out.println("Codigo Asistenta Social " + asistenta.getPersonas().getStrCodigoPersona());
		
		asistenta.setStrConsultorio("A-101");

		//1.inicia la transacción
		em.getTransaction().begin();
	

		//2.ejecuta las operaciones
		em.persist(asistenta);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}
	
	//Este metodo guarda a la SecretariaAcademica en su tabla Secretaria
	@Override
	public void guardaSecretaria(SecretariaAcademica secretaria) throws Exception {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();
		
		System.out.println("Codigo Secretaria " + secretaria.getPersonas().getStrCodigoPersona());

		//1.inicia la transacción
		em.getTransaction().begin();

		//2.ejecuta las operaciones
		em.persist(secretaria);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}
	
	//Este metodo guarda a la Asitente de Coordinacion Academica en su tabla 
	@Override
	public void guardaACA(AsistenteCoordinacionAcademica aca) throws Exception {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();
		
		System.out.println("Codigo ACA " + aca.getPersonas().getStrCodigoPersona());

		//1.inicia la transacción
		em.getTransaction().begin();

		//2.ejecuta las operaciones
		em.persist(aca);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}
	
	//Este metodo guarda a la Asitente de Direccion Academica en su tabla 
	@Override
	public void guardaADA(AsistenteDireccionAcademica ada) throws Exception {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();
		
		System.out.println("Codigo ADA " + ada.getPersonas().getStrCodigoPersona());

		//1.inicia la transacción
		em.getTransaction().begin();

		//2.ejecuta las operaciones
		em.persist(ada);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actulizarPersona(Persona persona) throws Exception {
		System.out.println(persona.getStrCodigoPersona());
		
		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		System.out.println("1");
		Persona entidadPersona = em.find(Persona.class, persona.getStrCodigoPersona());
		System.out.println("2");
		
		entidadPersona.setStrNombre(persona.getStrNombre());
		entidadPersona.setStrApellidoPaterno(persona.getStrApellidoPaterno());
		entidadPersona.setStrApellidoMaterno(persona.getStrApellidoMaterno());
		entidadPersona.setIntDNI(persona.getIntDNI());
		entidadPersona.setFotobin(persona.getFotobin());
		
		Distrito entidadDistrito = new Distrito();
		entidadDistrito.setIntIdDistrito(persona.getDistritos().getIntIdDistrito());
		entidadPersona.setDistritos(entidadDistrito);
		
		entidadPersona.setStrDireccion(persona.getStrDireccion());
		entidadPersona.setStrMail(persona.getStrMail());
		entidadPersona.setStrTelefono(persona.getStrTelefono());
		entidadPersona.setStrCelular(persona.getStrCelular());
		entidadPersona.setStrSexo(persona.getStrSexo());
		
		em.merge(entidadPersona);
		em.flush();
				
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Persona consultaApoderado(Persona p) throws Exception {
		em=emf.createEntityManager();
		Query q =  em.createQuery("SELECT p FROM Persona p " +
				                     "inner join p.tbUsuarios u " +
				                     "where u.perfiles.strCodigoPerfil='pf01' and p.intDNI=?1 " +
				                     "order by p.strApellidoPaterno");
		q.setParameter(1, p.getIntDNI());
		
		try {
			Persona entidadPersona =(Persona)q.getSingleResult();
			em.close();
			if(entidadPersona!=null){
				System.out.println("la bd devolvio una persona: "+entidadPersona.getStrCodigoPersona());
				return entidadPersona;
			}
			else{
				System.out.println("la bd devolvio nulo");
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Persona consultaApoderadoxAlumno(Alumno a) throws Exception {
		em=emf.createEntityManager();
		Query q =  em.createQuery("SELECT p FROM Persona p " +
				                     "inner join p.tbUsuarios u " +
				                     "where u.perfiles.strCodigoPerfil='pf01' and p.strCodigoPersona=?1 " +
				                     "order by p.strApellidoPaterno");
		q.setParameter(1, a.getApoderados().getPersonas().getStrCodigoPersona());
		
		try {
			Persona entidadPersona =(Persona)q.getSingleResult();
			em.close();
			if(entidadPersona!=null){
				System.out.println("la bd devolvio una persona: "+entidadPersona.getStrCodigoPersona());
				return entidadPersona;
			}
			else{
				System.out.println("la bd devolvio nulo");
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}


}
