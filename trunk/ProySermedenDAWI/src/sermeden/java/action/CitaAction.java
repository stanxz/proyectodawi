package sermeden.java.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	//private List<CursoDTO> listafechaxmedicos;
	private List<String> listahorasxfechaxmedicos;
	
	
	
	public List<String> getListahorasxfechaxmedicos() {
		return listahorasxfechaxmedicos;
	}
	public void setListahorasxfechaxmedicos(List<String> listahorasxfechaxmedicos) {
		this.listahorasxfechaxmedicos = listahorasxfechaxmedicos;
	}
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
		/*if(cursoFavorito != null){
			
			System.out.println("Listando Frameworks");
			
			listaFrameworks = new ArrayList<String>();
			
			if(cursoFavorito.equals("01")){
				
				listaFrameworks.add("Struts 2");
				listaFrameworks.add("Myibatis");
				listaFrameworks.add("JQuery");
				
			}else if(cursoFavorito.equals("02")){
				
				listaFrameworks.add("Java Server Faces");
				listaFrameworks.add("JPA");
	
			}
			
			
		}*/
		
		return Action.SUCCESS;
	
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
