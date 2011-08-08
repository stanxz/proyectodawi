package sermeden.java.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.CitaService_I;
import sermeden.java.service.PaqueteBusinessDelegate;

import com.opensymphony.xwork2.Action;
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
	//private List<String> listahorasxfechaxmedicos;
	//private List<String> listahorasxfechaxmedicosprueba;
	private ArrayList listahorasxfechaxmedicos;
	private List<HashMap<String, Object>> temporal;
	private List<HashMap<String, Object>> horascitasalmacenadas;
	
	
	
	public ArrayList getListahorasxfechaxmedicos() {
		return listahorasxfechaxmedicos;
	}
	public void setListahorasxfechaxmedicos(ArrayList listahorasxfechaxmedicos) {
		this.listahorasxfechaxmedicos = listahorasxfechaxmedicos;
	}
	public List<HashMap<String, Object>> getHorascitasalmacenadas() {
		return horascitasalmacenadas;
	}
	public void setHorascitasalmacenadas(
			List<HashMap<String, Object>> horascitasalmacenadas) {
		this.horascitasalmacenadas = horascitasalmacenadas;
	}
	/*public List<String> getListahorasxfechaxmedicos() {
		return listahorasxfechaxmedicos;
	}
	public void setListahorasxfechaxmedicos(List<String> listahorasxfechaxmedicos) {
		this.listahorasxfechaxmedicos = listahorasxfechaxmedicos;
	}*/
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
			System.out.println("1 tamañooooooo : "+temporal.size());
			System.out.println("un elemento: "+ temporal .get(0).get("HoraInicio"));
			
			System.out.println("ahora cargaremos las horas de las citas almacenadas para comparar ....");
			horascitasalmacenadas=citaService.cargarHorariosCitasHechas(medicoCita,fechaCita);
			
			System.out.println("(tempo)horascitasalmacenadas.size(): "+horascitasalmacenadas.size());
			
			double miarreglo[]=new double[12];
			
			if (temporal.size()>0){
				
				double aux=Double.parseDouble(temporal.get(0).get("HoraInicio").toString());
				//int aux2=Integer.parseInt(temporal.get(0).get("HoraFin").toString());
				for(int pr=0;pr<miarreglo.length;pr++){
					miarreglo[pr]=aux ;
					System.out.println("miarreglo[pr]: "+miarreglo[pr]);
					aux+=0.5;
					
				}
				
				System.out.println("%%%%%%% String.valueOf(miarreglo[j]): "+String.valueOf(miarreglo[0]));
				if(horascitasalmacenadas.size()>0){
					System.out.println("%%%%%%% horascitasalmacenadas.get(j).toString(): "+horascitasalmacenadas.get(0).toString());
					
					for(int j=0;j<miarreglo.length;j++){
						if(String.valueOf(miarreglo[j]).equalsIgnoreCase(horascitasalmacenadas.get(j).toString())){
							String cadenita=String.valueOf(miarreglo[j]);
							
							if(cadenita.equalsIgnoreCase("8.0")){
								listahorasxfechaxmedicos.add("8:00 am");
							}else if(cadenita.equalsIgnoreCase("8.5")){
								listahorasxfechaxmedicos.add("8:30 am");
							}else if(cadenita.equalsIgnoreCase("9.0")){
								listahorasxfechaxmedicos.add("9:00 am");
							}else if(cadenita.equalsIgnoreCase("9.5")){
								listahorasxfechaxmedicos.add("9:30 am");
							}else if(cadenita.equalsIgnoreCase("10.0")){
								listahorasxfechaxmedicos.add("10:00 am");
							}else if(cadenita.equalsIgnoreCase("10.5")){
								listahorasxfechaxmedicos.add("10:30 am");
							}else if(cadenita.equalsIgnoreCase("11.0")){
								listahorasxfechaxmedicos.add("11:00 am");
							}else if(cadenita.equalsIgnoreCase("11.5")){
								listahorasxfechaxmedicos.add("11:30 am");
							}else if(cadenita.equalsIgnoreCase("12.0")){
								listahorasxfechaxmedicos.add("12:00 m");
							}else if(cadenita.equalsIgnoreCase("12.5")){
								listahorasxfechaxmedicos.add("12:30 pm");
							}else if(cadenita.equalsIgnoreCase("13.0")){
								listahorasxfechaxmedicos.add("1:00 pm");
							}else if(cadenita.equalsIgnoreCase("13.5")){
								listahorasxfechaxmedicos.add("1:30 pm");
							}else if(cadenita.equalsIgnoreCase("14.0")){
								listahorasxfechaxmedicos.add("2:00 pm");
							}else if(cadenita.equalsIgnoreCase("14.5")){
								listahorasxfechaxmedicos.add("2:30 pm");
							}else if(cadenita.equalsIgnoreCase("15.0")){
								listahorasxfechaxmedicos.add("3:00 pm");
							}else if(cadenita.equalsIgnoreCase("15.5")){
								listahorasxfechaxmedicos.add("3:30 pm");
							}else if(cadenita.equalsIgnoreCase("16.0")){
								listahorasxfechaxmedicos.add("4:00 pm");
							}else if(cadenita.equalsIgnoreCase("16.5")){
								listahorasxfechaxmedicos.add("4:30 pm");
							}else if(cadenita.equalsIgnoreCase("17.0")){
								listahorasxfechaxmedicos.add("5:00 pm");
							}else if(cadenita.equalsIgnoreCase("17.5")){
								listahorasxfechaxmedicos.add("5:30 pm");
							}else if(cadenita.equalsIgnoreCase("18.0")){
								listahorasxfechaxmedicos.add("6:00 pm");
							}else if(cadenita.equalsIgnoreCase("18.5")){
								listahorasxfechaxmedicos.add("6:30 pm");
							}else if(cadenita.equalsIgnoreCase("19.0")){
								listahorasxfechaxmedicos.add("7:00 pm");
							}else if(cadenita.equalsIgnoreCase("19.5")){
								listahorasxfechaxmedicos.add("7:30 pm");
							}else if(cadenita.equalsIgnoreCase("20.0")){
								listahorasxfechaxmedicos.add("8:00 pm");
							}

							//listahorasxfechaxmedicos.add(String.valueOf(miarreglo[j]));
							System.out.println("Se agrego el elemento: "+String.valueOf(miarreglo[j]));
						}
						else{
							System.out.println("Ya contiene este elemento: "+String.valueOf(miarreglo[j]));
						}
						
					}
					System.out.println("++++++ listahorasxfechaxmedicos.size: "+listahorasxfechaxmedicos .size());
				}else{
					System.out.println("****** horascitasalmacenadas esta vacia");
					System.out.println("miarreglo.length: "+miarreglo.length);
					try {
						listahorasxfechaxmedicos=new ArrayList();
						for(int j=0;j<miarreglo.length;j++){
							
							System.out.println("aaaaa");
							//listahorasxfechaxmedicos.add(""+String.valueOf(miarreglo[j]));
							String cadenita=String.valueOf(miarreglo[j]);
							//inicio if
							if(cadenita.equalsIgnoreCase("8.0")){
								listahorasxfechaxmedicos.add("8:00 am");
							}else if(cadenita.equalsIgnoreCase("8.5")){
								listahorasxfechaxmedicos.add("8:30 am");
							}else if(cadenita.equalsIgnoreCase("9.0")){
								listahorasxfechaxmedicos.add("9:00 am");
							}else if(cadenita.equalsIgnoreCase("9.5")){
								listahorasxfechaxmedicos.add("9:30 am");
							}else if(cadenita.equalsIgnoreCase("10.0")){
								listahorasxfechaxmedicos.add("10:00 am");
							}else if(cadenita.equalsIgnoreCase("10.5")){
								listahorasxfechaxmedicos.add("10:30 am");
							}else if(cadenita.equalsIgnoreCase("11.0")){
								listahorasxfechaxmedicos.add("11:00 am");
							}else if(cadenita.equalsIgnoreCase("11.5")){
								listahorasxfechaxmedicos.add("11:30 am");
							}else if(cadenita.equalsIgnoreCase("12.0")){
								listahorasxfechaxmedicos.add("12:00 m");
							}else if(cadenita.equalsIgnoreCase("12.5")){
								listahorasxfechaxmedicos.add("12:30 pm");
							}else if(cadenita.equalsIgnoreCase("13.0")){
								listahorasxfechaxmedicos.add("1:00 pm");
							}else if(cadenita.equalsIgnoreCase("13.5")){
								listahorasxfechaxmedicos.add("1:30 pm");
							}else if(cadenita.equalsIgnoreCase("14.0")){
								listahorasxfechaxmedicos.add("2:00 pm");
							}else if(cadenita.equalsIgnoreCase("14.5")){
								listahorasxfechaxmedicos.add("2:30 pm");
							}else if(cadenita.equalsIgnoreCase("15.0")){
								listahorasxfechaxmedicos.add("3:00 pm");
							}else if(cadenita.equalsIgnoreCase("15.5")){
								listahorasxfechaxmedicos.add("3:30 pm");
							}else if(cadenita.equalsIgnoreCase("16.0")){
								listahorasxfechaxmedicos.add("4:00 pm");
							}else if(cadenita.equalsIgnoreCase("16.5")){
								listahorasxfechaxmedicos.add("4:30 pm");
							}else if(cadenita.equalsIgnoreCase("17.0")){
								listahorasxfechaxmedicos.add("5:00 pm");
							}else if(cadenita.equalsIgnoreCase("17.5")){
								listahorasxfechaxmedicos.add("5:30 pm");
							}else if(cadenita.equalsIgnoreCase("18.0")){
								listahorasxfechaxmedicos.add("6:00 pm");
							}else if(cadenita.equalsIgnoreCase("18.5")){
								listahorasxfechaxmedicos.add("6:30 pm");
							}else if(cadenita.equalsIgnoreCase("19.0")){
								listahorasxfechaxmedicos.add("7:00 pm");
							}else if(cadenita.equalsIgnoreCase("19.5")){
								listahorasxfechaxmedicos.add("7:30 pm");
							}else if(cadenita.equalsIgnoreCase("20.0")){
								listahorasxfechaxmedicos.add("8:00 pm");
							}
							//fin if
							
							System.out.println("bbbbb");
							//listahorasxfechaxmedicos.add(""+String.valueOf(miarreglo[j]));
							System.out.println("Se agrego el elemento: "+String.valueOf(miarreglo[j]));						
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(""+e.getMessage());
					}
					
					
				}
					
			}
			
			System.out.println("++++++ listahorasxfechaxmedicos.size: "+listahorasxfechaxmedicos .size());
			
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
	
	/*private List<HashMap<String, Object>> cargarFechasXMedico(String medicoCita2) {
		
		System.out.println("Dentro del metodo cargarFechasXMedicos");

		
		List<HashMap<String, Object>> lista1;
		
		try {
			lista1 = citaService.cargarFechasXMedicos(medicoCita2);
			
			if( lista1!=null && lista1.size()>0)
				System.out.println("fechas en listado : " + lista1.size());
			else
				System.out.println("Lista de fechas x medico vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}*
		List lista11=null;
		return lista11;
		
	}
	*/
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
