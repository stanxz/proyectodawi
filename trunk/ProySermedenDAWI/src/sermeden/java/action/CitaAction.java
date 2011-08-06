package sermeden.java.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.CitaService_I;
import sermeden.java.service.PaqueteBusinessDelegate;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CitaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<HashMap<String, Object>> listadoTurnos;
	private String dnibuscado;
	
	private List<UsuarioDTO> listamedicos;
	private String medicoCita;
	private String fechaCita;
	//private List<String> listafechaxmedicos;
	private List<String> listahorasxfechaxmedicos;
	private List<HashMap<String, Object>> temporal;
	private List<Integer> horascitasalmacenadas;
	
	
	
	public List<Integer> getHorascitasalmacenadas() {
		return horascitasalmacenadas;
	}
	public void setHorascitasalmacenadas(List<Integer> horascitasalmacenadas) {
		this.horascitasalmacenadas = horascitasalmacenadas;
	}
	public List<String> getListahorasxfechaxmedicos() {
		return listahorasxfechaxmedicos;
	}
	public void setListahorasxfechaxmedicos(List<String> listahorasxfechaxmedicos) {
		this.listahorasxfechaxmedicos = listahorasxfechaxmedicos;
	}
	public String getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}
	/*public List<String> getListafechaxmedicos() {
		return listafechaxmedicos;
	}
	public void setListafechaxmedicos(List<String> listafechaxmedicos) {
		this.listafechaxmedicos = listafechaxmedicos;
	}*/

	public String getMedicoCita() {
		return medicoCita;
	}

	public void setMedicoCita(String medicoCita) {
		this.medicoCita = medicoCita;
	}
	public List<UsuarioDTO> getListamedicos() {
		return listamedicos;
	}
	public void setListamedicos(List<UsuarioDTO> listamedicos) {
		this.listamedicos = listamedicos;
	}
	public ArrayList<HashMap<String, Object>> getListadoTurnos() {
		return listadoTurnos;
	}
	public void setListadoTurnos(ArrayList<HashMap<String, Object>> listadoTurnos) {
		this.listadoTurnos = listadoTurnos;
	}
	
	public String getDnibuscado() {
		return dnibuscado;
	}
	public void setDnibuscado(String dnibuscado) {
		this.dnibuscado = dnibuscado;
	}

	CitaService_I citaService = 
			PaqueteBusinessDelegate.getCitaService();
	
	public String listarTurnos(){
		
		String vista="exito";
		
		System.out.println("Dentro del metodo listarPacientes - Struts 2");
		
		//Logica de listado de turnos
		
		try {
				listadoTurnos = citaService.listadoTurnos();
			
			if( listadoTurnos!=null && listadoTurnos.size()>0)
				System.out.println("turnos en listado : " + listadoTurnos.size());
			else
				System.out.println("Lista de turnos vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return vista;
	}

	public String execute(){
		System.out.println("entraaaaaaaa .... ");
		listamedicos = cargarMedicos();
		System.out.println("tamaño listamedicos : " + listamedicos.size());
		System.out.println("medicoCita: "+medicoCita);
		System.out.println("fechaCita: "+fechaCita);
		
		
		
		
		
		if(medicoCita != null && fechaCita!=null ){
			System.out.println("cargando horasdisp x fecha x medico");
			temporal=citaService.cargarHorasDispXFechaXMedico(medicoCita,fechaCita);
			System.out.println("tamañooooooo : "+temporal.size());
			System.out.println("un elemento: "+ temporal .get(0).get("HoraInicio"));
			
			
			horascitasalmacenadas=citaService.cargarHorariosCitasHechas(medicoCita,fechaCita);
			
			
			
			
			
			if (temporal.size()>0){
				double miarreglo[]=new double[12];
				double aux=Double.parseDouble(temporal.get(0).get("HoraInicio").toString());
				//int aux2=Integer.parseInt(temporal.get(0).get("HoraFin").toString());
				for(int pr=0;pr<miarreglo.length;pr++){
					miarreglo[pr]=aux ;
					System.out.println("miarreglo[pr]: "+miarreglo[pr]);
					aux+=0.5;
					
				}
				
			}
			
			
			
			System.out.println("otraaaaaaa :p : "+listahorasxfechaxmedicos.size());
			/*listafechaxmedicos = new ArrayList<String>();
			
			if(medicoCita.equals("1")){
				
				listafechaxmedicos.add("Struts 2");
				listafechaxmedicos.add("Myibatis");
				listafechaxmedicos.add("JQuery");
				
			}else if(medicoCita.equals("2")){
				
				listafechaxmedicos.add("Java Server Faces");
				listafechaxmedicos.add("JPA");
	
			}*/
			//listafechaxmedicos=cargarFechasXMedico(medicoCita);
			
			
		}
		
		return Action.SUCCESS;
	
	}
	
	private List<HashMap<String, Object>> cargarFechasXMedico(String medicoCita2) {
		
		System.out.println("Dentro del metodo cargarFechasXMedicos");

		
		List<HashMap<String, Object>> lista1;
		
		/*try {
			lista1 = citaService.cargarFechasXMedicos(medicoCita2);
			
			if( lista1!=null && lista1.size()>0)
				System.out.println("fechas en listado : " + lista1.size());
			else
				System.out.println("Lista de fechas x medico vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}**/
		List lista11=null;
		return lista11;
		
	}
	
	private List<UsuarioDTO> cargarMedicos() {
		
		System.out.println("Dentro del metodo cargarMedicos");
		
		//Logica de listado de turnos
		
		List<UsuarioDTO> lista1 = new ArrayList<UsuarioDTO>();
		
		try {
			lista1 = citaService.cargarMedicos();
			
			if( lista1!=null && lista1.size()>0)
				System.out.println("medicos en listado : " + lista1.size());
			else
				System.out.println("Lista de medicos vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return lista1;
	
	}

}
