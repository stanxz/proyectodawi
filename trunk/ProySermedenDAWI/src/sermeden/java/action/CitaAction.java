package sermeden.java.action;

import java.util.Map;

import sermeden.java.service.CitaService_I;
import sermeden.java.service.PaqueteBusinessDelegate;

import com.opensymphony.xwork2.ActionSupport;

public class CitaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> listadoTurnos;
	
	public Map<String, Object> getListadoTurnos() {
		return listadoTurnos;
	}
	public void setListadoTurnos(Map<String, Object> listadoTurnos) {
		this.listadoTurnos = listadoTurnos;
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


}
