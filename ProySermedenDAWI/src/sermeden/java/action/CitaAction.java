package sermeden.java.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import sermeden.java.bean.CitaDTO;
import sermeden.java.bean.FichaDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.CitaService_I;
import sermeden.java.service.FichaService_I;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CitaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<HashMap<String, Object>> listadoTurnos;
	private String dnibuscado;
	private UsuarioDTO paciente;
	private FichaDTO ficha;
	private List<UsuarioDTO> listamedicos;
	private String medicoCita;
	private String fechaCita;
	private String horaCita;
	private CitaDTO cita;
	private String mensaje;
	
	static private Logger log = Logger.getLogger(CitaAction.class);
	
	private ArrayList listahorasxfechaxmedicos;
	private List<HashMap<String, Object>> temporal;
	private List<HashMap<String, Object>> horascitasalmacenadas;

	
	public FichaDTO getFicha() {
		return ficha;
	}
	public void setFicha(FichaDTO ficha) {
		this.ficha = ficha;
	}
	public String getHoraCita() {
		return horaCita;
	}
	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}
	public CitaDTO getCita() {
		return cita;
	}
	public void setCita(CitaDTO cita) {
		this.cita = cita;
	}
	public UsuarioDTO getPaciente() {
		return paciente;
	}
	public void setPaciente(UsuarioDTO paciente) {
		this.paciente = paciente;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
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

	public String getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
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
	
	UsuarioService_I pacienteService=
			PaqueteBusinessDelegate.getUsuarioService();
	
	FichaService_I fichaService=PaqueteBusinessDelegate.getFichaService();
	
	public String listarTurnos(){
		
		String vista="exito";
		
		log.debug("Dentro del metodo listarPacientes - Struts 2");
		
		//Logica de listado de turnos
		
		try {
				listadoTurnos = citaService.listadoTurnos();
			
			if( listadoTurnos!=null && listadoTurnos.size()>0)
				log.debug("turnos en listado : " + listadoTurnos.size());
			else
				log.debug("Lista de turnos vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return vista;
	}

	public String execute(){
		log.debug("entraaaaaaaa .... ");
		listamedicos = cargarMedicos();
		log.debug("tamaño listamedicos : " + listamedicos.size());
		log.debug("medicoCita: "+medicoCita);
		log.debug("fechaCita: "+fechaCita);

		if(medicoCita != null && fechaCita!=null ){
			log.debug("cargando horasdisp x fecha x medico");
			temporal=citaService.cargarHorasDispXFechaXMedico(medicoCita,fechaCita);
			log.debug("1 tamañooooooo : "+temporal.size());
			if(temporal.size()>0)
				log.debug("un elemento: "+ temporal .get(0).get("HoraInicio"));
			else
				log.debug("No hay ningun elemento en 'temporal'");
			
			log.debug("ahora cargaremos las horas de las citas almacenadas para comparar ....");
			horascitasalmacenadas=citaService.cargarHorariosCitasHechas(medicoCita,fechaCita);
			
			log.debug("(tempo)horascitasalmacenadas.size(): "+horascitasalmacenadas.size());
			
			double miarreglo[]=new double[12];
			
			if (temporal.size()>0){
				
				double aux=Double.parseDouble(temporal.get(0).get("HoraInicio").toString());
				//int aux2=Integer.parseInt(temporal.get(0).get("HoraFin").toString());
				for(int pr=0;pr<miarreglo.length;pr++){
					miarreglo[pr]=aux ;
					log.debug("miarreglo[pr]: "+miarreglo[pr]);
					aux+=0.5;
					
				}
				
				log.debug("%%%%%%% String.valueOf(miarreglo[j]): "+String.valueOf(miarreglo[0]));
				if(horascitasalmacenadas.size()>0){
					
					String cadenita;
					for(int j=0;j<miarreglo.length;j++){
						cadenita=String.valueOf(miarreglo[j]);
						log.debug("cadenita vale: "+cadenita);
						log.debug("%%%%%%% horascitasalmacenadas.get(j).toString(): "+horascitasalmacenadas.get(j).toString());
						if(cadenita.equalsIgnoreCase(horascitasalmacenadas.get(j).get("HoraCita").toString())){

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
							log.debug("Se agrego el elemento: "+String.valueOf(miarreglo[j]));
						}
						else{
							log.debug("Ya contiene este elemento: "+String.valueOf(miarreglo[j]));
						}
					}
					log.debug("++++++ listahorasxfechaxmedicos.size: "+listahorasxfechaxmedicos .size());
				}else{
					log.debug("****** horascitasalmacenadas esta vacia");
					log.debug("miarreglo.length: "+miarreglo.length);
					try {
						listahorasxfechaxmedicos=new ArrayList();
						for(int j=0;j<miarreglo.length;j++){
							
							log.debug("aaaaa");
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
							
							log.debug("bbbbb");
							//listahorasxfechaxmedicos.add(""+String.valueOf(miarreglo[j]));
							log.debug("Se agrego el elemento: "+String.valueOf(miarreglo[j]));						
						}
					} catch (Exception e) {
						// TODO: handle exception
						log.debug(""+e.getMessage());
					}
				}	
			}
			log.debug("++++++ listahorasxfechaxmedicos.size: "+listahorasxfechaxmedicos .size());
			log.debug("otraaaaaaa :p : "+listahorasxfechaxmedicos.size());
		}
		
		return Action.SUCCESS;
	
	}
	
	private List<UsuarioDTO> cargarMedicos() {
		
		log.debug("Dentro del metodo cargarMedicos");
		
		//Logica de listado de turnos
		
		List<UsuarioDTO> lista1 = new ArrayList<UsuarioDTO>();
		
		try {
			lista1 = citaService.cargarMedicos();
			
			if( lista1!=null && lista1.size()>0)
				log.debug("medicos en listado : " + lista1.size());
			else
				log.debug("Lista de medicos vacia");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return lista1;
	
	}
	
	public String registrarCita(){
		int idnuevacita=-1;
		int resultinsert=-1;
		String vista = "exito";
		log.debug("Dentro del metodo registrar Paciente- Struts 2 ");
		log.debug("dniBuscado: " +dnibuscado);

		//Invocamos al servicio requerido para registrar cliente
		try {
			paciente=(UsuarioDTO) pacienteService.pacienteXDNI(dnibuscado);
			if(paciente!=null){
				
				log.debug("paciente se encuentra en la BD: "+paciente.getNombre()+" "+paciente.getApepat());
				log.debug("aaaa "+paciente.getIdPersona());
				
				ficha=fichaService.buscarFichaActualxPersona(dnibuscado);
				
				if(ficha!=null){

					int verificarCita=-1;
					
					
					cita=new CitaDTO();
					SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
					cita.setIdFicha(ficha.getIdFicha());
					cita.setFechaCita(sd.parse(fechaCita));
					cita.setHoraCita(numerHora(horaCita));
					cita.setIdMedico(Integer.parseInt(medicoCita));
					//nulo aca no se por ke
					//cita.setNroConsultorio(Integer.parseInt(temporal.get(0).get("NroConsultorio").toString()));
					
					Calendar mica=Calendar.getInstance();
					mica.setFirstDayOfWeek(Calendar.MONDAY);
					mica.setTime(cita.getFechaCita());
					int numerosemanadado=mica.get(Calendar.WEEK_OF_YEAR);
					log.debug("week of year mandado: "+numerosemanadado);
					
					
					List<HashMap<String, Object>> hashmapsencontrados=citaService.cargarSemanaCita(cita);
					
					if(hashmapsencontrados.size()>0){
						Date fechaaux=(Date) hashmapsencontrados.get(0).get("fechaCita");
						mica.setTime(fechaaux);
						int numerosemanaencontrado=mica.get(Calendar.WEEK_OF_YEAR);
						log.debug("week of year encontrado: "+numerosemanaencontrado);
						
						if(numerosemanadado!=numerosemanaencontrado){
							verificarCita=1;
						}else{
							verificarCita=-1;
						}
						
					}
					
					log.debug("Verificando si hay citas durante esa semana: "+verificarCita);
					
					if(verificarCita<0){
						log.debug("registrando nueva cita ... ");
						resultinsert=fichaService.cambiarEstadoFichaActual(paciente.getIdPersona());
						log.debug("registrando ficha ... :"+resultinsert);
						idnuevacita=citaService.registrarNuevaCita(cita);
						
						
						if(idnuevacita>0){
							log.debug(" idnuevacita: "+idnuevacita+" registrado en la BD");
							mensaje="La cita del paciente con DNI "+paciente .getDni()+" se registró con exito ! (id Ficha: "+idnuevacita+")";
							vista = "exito";
						}
						else{
							mensaje="No se registró la Cita";
							listadoTurnos = citaService.listadoTurnos();
							vista = "error";
						}
					}else{
						log.debug("El paciente con DNI "+dnibuscado+" ya tiene una cita durante la semana de la fecha elegida !");
						mensaje="El paciente con DNI "+dnibuscado+" ya tiene una cita durante la semana de la fecha elegida !";
						listadoTurnos = citaService.listadoTurnos();
						vista = "error";
					}
					
				}else{
					log.debug("El paciente con DNI "+dnibuscado+" no tiene una ficha Activa en el sistema !");
					mensaje="El paciente con DNI "+dnibuscado+" no tiene una ficha Activa en el sistema !";
					listadoTurnos = citaService.listadoTurnos();
					vista = "error";
				}
				
			}
			else{
				log.debug("El paciente con DNI "+dnibuscado+" no se encuentra registrado en el Sistema !");
				mensaje="El paciente con DNI "+dnibuscado+" no se encuentra registrado en el Sistema !";
				listadoTurnos = citaService.listadoTurnos();
				vista = "error";
			}
		} catch (Exception e) {
			vista = "error";
			mensaje="Errores al procesar: "+e.getMessage();
			listadoTurnos = citaService.listadoTurnos();
			e.printStackTrace();
		}
		return vista;
	}
	
	private double numerHora(String horacia) {
		// TODO Auto-generated method stub
		if(horacia.equalsIgnoreCase("8:00 am")){
			return 8.0;
		}else if(horacia.equalsIgnoreCase("8:30 am")){
			return 8.5;
		}else if(horacia.equalsIgnoreCase("9:00 am")){
			return 9.0;
		}else if(horacia.equalsIgnoreCase("9:30 am")){
			return 9.5;
		}else if(horacia.equalsIgnoreCase("10:00 am")){
			return 10.0;
		}else if(horacia.equalsIgnoreCase("10:30 am")){
				return 10.5;
		}else if(horacia.equalsIgnoreCase("11:00 am")){
				return 11.0;
		}else if(horacia.equalsIgnoreCase("11:30 am")){
					return 11.5;
		}else if(horacia.equalsIgnoreCase("12:00 m")){
			return 12.0;
		}else if(horacia.equalsIgnoreCase("12:30 pm")){
					return 12.5;
		}else if(horacia.equalsIgnoreCase("1:00 pm")){
				return 13.0;
		}else if(horacia.equalsIgnoreCase("1:30 pm")){
					return 13.5;
		}else if(horacia.equalsIgnoreCase("2:00 pm")){
			return 14.0;
		}else if(horacia.equalsIgnoreCase("2:30 pm")){
			return 14.5;
		}else if(horacia.equalsIgnoreCase("3:00 pm")){
				return 15.0;
		}else if(horacia.equalsIgnoreCase("3:30 pm")){
			return 15.5;
		}else if(horacia.equalsIgnoreCase("4:00 pm")){
			return 16.0;
		}else if(horacia.equalsIgnoreCase("4:30 pm")){
			return 16.5;
		}else if(horacia.equalsIgnoreCase("5:00 pm")){
				return 17.0;
		}else if(horacia.equalsIgnoreCase("5:30 pm")){
			return 17.5;
		}else if(horacia.equalsIgnoreCase("6:00 pm")){
			return 18.0;
		}else if(horacia.equalsIgnoreCase("6:30 pm")){
			return 18.5;
		}else if(horacia.equalsIgnoreCase("7:00 pm")){
				return 19.0;
		}else if(horacia.equalsIgnoreCase("7:30 pm")){
			return 19.5;
		}else{
			return 20.0;
		}
	}
	
	public void validate(){
		if(dnibuscado==null){
			//addFieldError(fieldName, errorMessage)
		}
	}

}
