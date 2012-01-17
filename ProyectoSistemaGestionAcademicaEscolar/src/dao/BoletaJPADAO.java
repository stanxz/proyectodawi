package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import utiles.Constantes;

import entidades.Boleta;

public class BoletaJPADAO implements BoletaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.emf=emf;
	}

	@Override
	public Boleta obtenerBoleta(Boleta temporal) throws Exception {
		em=emf.createEntityManager();
		System.out.println("dni q llegaaa: "+temporal.getApoderados().getPersonas().getIntDNI());
		//Boleta entidadBoleta=(Boleta)em.find(Boleta.class,temporal.getStrCodigoBoleta());
		//return entidadBoleta;
		Query q =  em.createQuery("SELECT b FROM Boleta b " +
                "WHERE b.apoderados.personas.intDNI=?1 AND b.strEstado='CANCELADO' AND b.strTipo='RETIRO' AND b.strCodigoBoleta=?2" +
                "ORDER BY b.strCodigoBoleta");
		q.setParameter(1,temporal.getApoderados().getPersonas().getIntDNI());
		q.setParameter(2,temporal.getStrCodigoBoleta());
		try {
			System.out.println("+++++++");
			Boleta entidadBoleta=new Boleta();
			if(q.getResultList().size()>0){
			 entidadBoleta =(Boleta) q.getResultList().get(0);
			}else
				entidadBoleta=null;
			System.out.println("-------");
			em.close();
			if(entidadBoleta!=null){
				System.out.println("aaaaaaaa: "+entidadBoleta.getStrCodigoBoleta());
				return entidadBoleta;
			}
			else{
				System.out.println("bbbbbbbb");
				return null;
			}
				
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public void registrarBoleta(Boleta laboleta) throws Exception {
		em=emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(laboleta);
		em.flush();

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizaCierredeBoleta(Boleta miboleta) throws Exception {
		// TODO Auto-generated method stub
		//miboleta.setStrEstado(Constantes.ESTADOBOLETA_CERRADO);
		// TODO Auto-generated method stub
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();

		//2. ejecuta las operaciones 
		//2.1 busca Empleado por llave primaria
		Boleta entidadBoleta = em.find(Boleta.class, miboleta.getStrCodigoBoleta());
		entidadBoleta.setStrEstado(Constantes.ESTADOBOLETA_CERRADO);
		//2.3 actualiza Empleado
		em.merge(entidadBoleta);
		em.flush();
				
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	
	}

}
