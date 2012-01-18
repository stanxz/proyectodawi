package jsf.bean;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DateSelectEvent;

import servicios.ApplicationBusinessDelegate;
import servicios.BoletaService;
import servicios.CitaService;
import servicios.DisponibilidadAsistentaService;
import servicios.PersonaService;
import servicios.SolicitudRetiroService;
import utiles.Constantes;
import utiles.EnviaMail;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Boleta;
import entidades.Cita;
import entidades.Disponibilidadasistentasocial;
import entidades.Motivo;
import entidades.Persona;
import entidades.SolicitudRetiro;
import entidades.Usuario;


@SessionScoped
@ManagedBean 
public class CitaBean implements Serializable {

	 private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
		
	 private static PersonaService asistentaService = abd.getPersonaService();
	 private static CitaService citaService = abd.getCitaService();
	 private static SolicitudRetiroService retiroService = abd.getRetiroService();
	 private static PersonaService personaService = abd.getPersonaService();
	 private static BoletaService boletaService = abd.getBoletaService();
	 private static DisponibilidadAsistentaService daservice=abd.getDisponibilidadAsistentaService();
	 
	private static final long serialVersionUID = 1L;
	private String includedPage;
	private int intCodigoAlumno;
	private Alumno alumnoElegido=new Alumno();
	private Persona asistentaElegida=new Persona();
	private ArrayList<Persona> listaAsistentas;
	private Cita nuevaCita;
	private Date fechaCita;
	private String horaCita;
	private ArrayList<String> listaHorasDisponibles;	
	private String observacion;
	private Motivo motivo=new Motivo();
	private SolicitudRetiro misolicitud=new SolicitudRetiro();
	private Boleta boleta = new Boleta();
	private Map<String, Object> misesion;
	
	public CitaBean(){
		System.out.println("Creando CitaBean...");
		intCodigoAlumno = 0;		
	}
	
	public String redericcionaCita(){
		
		System.out.println("---------------Redireccionando------------------------");
		for (Method m : alumnoElegido.getClass().getMethods()){
			if((m.getName().startsWith("getStr"))||(m.getName().startsWith("getInt"))){
				try {
					System.out.println("Alumno Elegido para generacion de Cita - "+m.getName().substring(6).toUpperCase() + " : " +  m.invoke(alumnoElegido));
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return "/citas/generarCita.xhtml";
	}
	
	public void cargaComboListadoHorasDisponibles(DateSelectEvent event){
		System.out.println("-------Cargando horas disponibles------");
		Date date=event.getDate();
		if(date!=null)
		System.out.println("fecha q llega: "+date.toString());
		if(this.asistentaElegida.getStrCodigoPersona()!=null)
		System.out.println("asistenta: "+this.asistentaElegida.getStrCodigoPersona());
		//if(this.horaCita!=null)
		//System.out.println("hora q llega: "+this.horaCita);
		if(this.fechaCita!=null && this.asistentaElegida.getStrCodigoPersona()!=null)
			cargaArregloHD2(this.asistentaElegida,date);
		else{
			this.horaCita="";
			System.out.println("Seleccione fecha, hora y asistenta");
		}
		
	}

	public void cargaComboListadoHorasDisponibles2(){
		System.out.println("-------Cargando horas disponibles 2------");
		//hacemos nula la hora
		this.horaCita=null;
		//------
		if(this.fechaCita!=null)
		System.out.println("fecha q llega: "+this.fechaCita);
		if(this.asistentaElegida.getStrCodigoPersona()!=null)
		System.out.println("asistenta: "+this.asistentaElegida.getStrCodigoPersona());
		//if(this.horaCita!=null)
		//System.out.println("hora q llega: "+this.horaCita);
		if(this.fechaCita!=null && this.asistentaElegida.getStrCodigoPersona()!=null)
			//cargaArregloCombo();
			//cargaArregloHD(this.asistentaElegida,this.fechaCita);
			cargaArregloHD2(this.asistentaElegida,this.fechaCita);
		else{
			System.out.println("Seleccione fecha, hora y asistenta");
		}
		
	}
	
	/*private void cargaArregloHD(Persona asistentaElegida2, Date date) {
		// TODO Auto-generated method stub
		int eldia=date.getDay();
		if(asistentaElegida2.getStrCodigoPersona().equalsIgnoreCase("PE-13131313")){
			if(eldia==1 || eldia==3 || eldia==5){
				listaHorasDisponibles=new ArrayList<String>();
				listaHorasDisponibles.add("09:00:00");
				listaHorasDisponibles.add("09:30:00");
				listaHorasDisponibles.add("10:00:00");
				listaHorasDisponibles.add("10:30:00");
				listaHorasDisponibles.add("11:00:00");
				listaHorasDisponibles.add("11:30:00");
				listaHorasDisponibles.add("12:00:00");
				listaHorasDisponibles.add("12:30:00");
			}else{
				listaHorasDisponibles=new ArrayList<String>();
			}
			
		}else if(asistentaElegida2.getStrCodigoPersona().equalsIgnoreCase("PE-14141414")){
			if(eldia==1 || eldia==3 || eldia==5){
				listaHorasDisponibles=new ArrayList<String>();
				listaHorasDisponibles.add("14:00:00");
				listaHorasDisponibles.add("14:30:00");
				listaHorasDisponibles.add("15:00:00");
				listaHorasDisponibles.add("15:30:00");
				listaHorasDisponibles.add("16:00:00");
				listaHorasDisponibles.add("16:30:00");
				listaHorasDisponibles.add("17:00:00");
				listaHorasDisponibles.add("17:30:00");
			}else{
				listaHorasDisponibles=new ArrayList<String>();
			}
			
		}else if(asistentaElegida2.getStrCodigoPersona().equalsIgnoreCase("PE-55555555")){
			if(eldia==2 || eldia==4 || eldia==6){
				listaHorasDisponibles=new ArrayList<String>();
				listaHorasDisponibles.add("09:00:00");
				listaHorasDisponibles.add("09:30:00");
				listaHorasDisponibles.add("10:00:00");
				listaHorasDisponibles.add("10:30:00");
				listaHorasDisponibles.add("11:00:00");
				listaHorasDisponibles.add("11:30:00");
				listaHorasDisponibles.add("12:00:00");
				listaHorasDisponibles.add("12:30:00");
			}else{
				listaHorasDisponibles=new ArrayList<String>();
			}
			
		}else if(asistentaElegida2.getStrCodigoPersona().equalsIgnoreCase("PE-66666666")){
			if(eldia==2 || eldia==4 || eldia==6){
				listaHorasDisponibles=new ArrayList<String>();
				listaHorasDisponibles.add("14:00:00");
				listaHorasDisponibles.add("14:30:00");
				listaHorasDisponibles.add("15:00:00");
				listaHorasDisponibles.add("15:30:00");
				listaHorasDisponibles.add("16:00:00");
				listaHorasDisponibles.add("16:30:00");
				listaHorasDisponibles.add("17:00:00");
				listaHorasDisponibles.add("17:30:00");
			}else{
				listaHorasDisponibles=new ArrayList<String>();
			}
			
		}
		else
			System.out.println("Asistenta incorrecta ! : "+asistentaElegida2.getStrCodigoPersona());
	}*/
	
	private void cargaArregloHD2(Persona asistentaElegida2, Date date) {
		// TODO Auto-generated method stub
		int eldia=date.getDay();
		System.out.println("cargaArregloHD2 - asistonta: "+asistentaElegida2.getStrCodigoPersona());
		System.out.println("cargaArregloHD2 - eldia: "+eldia);
		try {
			Disponibilidadasistentasocial midas=daservice.obtenerDisponibilidad(asistentaElegida2.getStrCodigoPersona(),eldia);
			listaHorasDisponibles=new ArrayList<String>();
			
			if(midas!=null){
				for(int i=Integer.parseInt(midas.getHorainicio());i<Integer.parseInt(midas.getHorafin());i++){
					if(i<10){
						listaHorasDisponibles.add("0"+i+":00:00");
						listaHorasDisponibles.add("0"+i+":30:00");
					}else {
						listaHorasDisponibles.add(""+i+":00:00");
						listaHorasDisponibles.add(""+i+":30:00");
					}
				}
			}else{
				System.out.println("La disponibilidad no fue encontrada en la BD");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*if(asistentaElegida2.getStrCodigoPersona().equalsIgnoreCase("PE-13131313")){
			if(eldia==1 || eldia==3 || eldia==5){
				listaHorasDisponibles=new ArrayList<String>();
				listaHorasDisponibles.add("09:00:00");
				listaHorasDisponibles.add("09:30:00");
				listaHorasDisponibles.add("10:00:00");
				listaHorasDisponibles.add("10:30:00");
				listaHorasDisponibles.add("11:00:00");
				listaHorasDisponibles.add("11:30:00");
				listaHorasDisponibles.add("12:00:00");
				listaHorasDisponibles.add("12:30:00");
			}else{
				listaHorasDisponibles=new ArrayList<String>();
			}
			
		}else if(asistentaElegida2.getStrCodigoPersona().equalsIgnoreCase("PE-14141414")){
			if(eldia==1 || eldia==3 || eldia==5){
				listaHorasDisponibles=new ArrayList<String>();
				listaHorasDisponibles.add("14:00:00");
				listaHorasDisponibles.add("14:30:00");
				listaHorasDisponibles.add("15:00:00");
				listaHorasDisponibles.add("15:30:00");
				listaHorasDisponibles.add("16:00:00");
				listaHorasDisponibles.add("16:30:00");
				listaHorasDisponibles.add("17:00:00");
				listaHorasDisponibles.add("17:30:00");
			}else{
				listaHorasDisponibles=new ArrayList<String>();
			}
			
		}else if(asistentaElegida2.getStrCodigoPersona().equalsIgnoreCase("PE-55555555")){
			if(eldia==2 || eldia==4 || eldia==6){
				listaHorasDisponibles=new ArrayList<String>();
				listaHorasDisponibles.add("09:00:00");
				listaHorasDisponibles.add("09:30:00");
				listaHorasDisponibles.add("10:00:00");
				listaHorasDisponibles.add("10:30:00");
				listaHorasDisponibles.add("11:00:00");
				listaHorasDisponibles.add("11:30:00");
				listaHorasDisponibles.add("12:00:00");
				listaHorasDisponibles.add("12:30:00");
			}else{
				listaHorasDisponibles=new ArrayList<String>();
			}
			
		}else if(asistentaElegida2.getStrCodigoPersona().equalsIgnoreCase("PE-66666666")){
			if(eldia==2 || eldia==4 || eldia==6){
				listaHorasDisponibles=new ArrayList<String>();
				listaHorasDisponibles.add("14:00:00");
				listaHorasDisponibles.add("14:30:00");
				listaHorasDisponibles.add("15:00:00");
				listaHorasDisponibles.add("15:30:00");
				listaHorasDisponibles.add("16:00:00");
				listaHorasDisponibles.add("16:30:00");
				listaHorasDisponibles.add("17:00:00");
				listaHorasDisponibles.add("17:30:00");
			}else{
				listaHorasDisponibles=new ArrayList<String>();
			}
			
		}
		else
			System.out.println("Asistenta incorrecta ! : "+asistentaElegida2.getStrCodigoPersona());*/
	}
	
	public void guardaCita(){
		System.out.println("guardando cita ... ");
		System.out.println("fechaCita: "+this.fechaCita);
		System.out.println("horaCita: "+this.horaCita);
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String lafecha=sd.format(this.fechaCita);
		System.out.println("lafecha: "+lafecha);
		System.out.println("lahora: "+this.horaCita);
		
		
		try {
			SimpleDateFormat sd2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String cadenafechahora=lafecha+" "+this.horaCita;
			System.out.println("cadenafechahora: "+cadenafechahora);
			Date temporal=sd2.parse(cadenafechahora);
			System.out.println("***temporal: "+temporal);
			Long tiempoexacto=temporal.getTime();
			//System.out.println("tiempoexacto:"+tiempoexacto);
			
			Cita miciCita=new Cita();
			miciCita.setAlumno(this.alumnoElegido);
			miciCita.setDtfecharegistro(new java.sql.Timestamp(tiempoexacto));
			System.out.println("fecha para el mysql:"+miciCita.getDtfecharegistro());
			miciCita.setIntcodtiposervicio(Constantes.TIPOSERVICIO_RETIRO);
			miciCita.setStrcodasistentasocial(this.asistentaElegida.getStrCodigoPersona());
			miciCita.setStrcoddisponibilidadas(obtieneCodDA(this.fechaCita,this.horaCita));
			miciCita.setStrestado(Constantes.CITA_PENDIENTE);
			miciCita.setStrMail(this.alumnoElegido.getApoderados().getPersonas().getStrMail());
			miciCita.setStrtlffijo(this.alumnoElegido.getApoderados().getPersonas().getStrTelefono());
			miciCita.setTlfcelular(this.alumnoElegido.getApoderados().getPersonas().getStrCelular());
			
			System.out.println("consultando citas pendientes para alumno: "+alumnoElegido.getIntDni());
			Cita citapendiente=citaService.consultaCitaPendiente(this.alumnoElegido.getStrCodigoAlumno());
			if(citapendiente!=null){
				System.out.println("Existe una cita pendiente para este alumno el dia "+citapendiente.getDtfecharegistro());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Cita","El Alumno ya presenta una cita pendiente para el dia "+citapendiente.getDtfecharegistro() ));
			}else{
				System.out.println("insertando Solicitud de Retiro ... ");
				if(guardaSR()==true){
					System.out.println("insertando cita ... ");
					citaService.registrarCita(miciCita);
					System.out.println("cita insertada ... ");
					System.out.println("enviando correo ... ");
					EnviaMail enviador=new EnviaMail();
					enviador.enviarCorreoRegistroCita(miciCita);
					FacesMessage msg = new FacesMessage("Cita Registrada","Se guardó Cita del Alumno "+miciCita.getAlumno().getStrCodigoAlumno()+" para el dia "+miciCita.getDtfecharegistro());
		    	    FacesContext.getCurrentInstance().addMessage(null, msg);
				}else{
					System.out.println("No se inserta la SR ... no se insertara nada mas ... ");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Cita","Previamente no se pudo insertar la Solicitud de Retiro" ));
				}
				
				
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Cita","Error: "+e.getMessage() ));
			e.printStackTrace();
		}
		
	}
	
	private boolean guardaSR(){
		boolean flagssss=false;
		SolicitudRetiro sr=new SolicitudRetiro();
		sr.setAlumno(alumnoElegido);
		sr.setIntFlagprocesado(0);
		sr.setDtFecNac(new java.sql.Date(new java.util.Date().getTime()));
		sr.setStrEstado("PENDIENTE");
		sr.setStrMotivo(""+motivo.getIntCodigoMotivo());
		sr.setStrObservacion(observacion);
		sr.setAsistenteDireccion(null);
		if(misolicitud.getCertificadobin()!=null)
			sr.setCertificadobin(misolicitud.getCertificadobin());
		
		Apoderado tempoapo=new Apoderado();
		Persona tempopersona=new Persona();
		try {
			System.out.println("consultando apoderado del alumno ... ");
			tempopersona=personaService.consultaApoderadoxAlumno(alumnoElegido);
			if(tempopersona!=null){
				System.out.println("Apoderado encontrado: "+tempopersona.getStrCodigoPersona());
				tempoapo.setPersonas(tempopersona);
				
				System.out.println("Ahora se consultara la boleta: "+boleta.getStrCodigoBoleta());
				Boleta boletempo=new Boleta();
				Boleta miboleta=new Boleta();
				boletempo.setStrCodigoBoleta(boleta.getStrCodigoBoleta());
				Apoderado apotempo=new Apoderado();
				Persona persotempo=new Persona();
				misesion=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				int numero=((Usuario)misesion.get("b_usuario")).getPersonas().getIntDNI();
				System.out.println("numerooooo de DNI del apoderado: "+numero);
				persotempo.setIntDNI(numero);
				apotempo.setPersonas(persotempo);
				boletempo.setApoderados(apotempo);

				miboleta=boletaService.obtenerBoleta(boletempo);
				if(miboleta!=null){
					System.out.println("Boleta encontrada, se va a consultar si existe alguna solicitud pendiente ... ");
					SolicitudRetiro temposr=retiroService.buscarSolicitudXAlumnoXAño(sr);
					if(temposr!=null){
						System.out.println("Ya existe una solicitud de retiro pendiente");
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Solicitud de Retiro","El Alumno "+ sr.getAlumno().getStrCodigoAlumno()+" ya tiene una solicitud de retiro registrada !" ));
					}else{
						System.out.println("registrando Solicitud de Retiro ... ");
						retiroService.registrarSolictud(sr);
						System.out.println("actualizando estado de Boleta ... ");
						boletaService.actualizaCierredeBoleta(miboleta);
						FacesMessage msg = new FacesMessage("Solicitud de Retiro Registrada","Se guardó Solicitud de Retiro del Alumno "+sr.getAlumno().getStrCodigoAlumno());
			    	    FacesContext.getCurrentInstance().addMessage(null, msg);
			    	    flagssss=true;
					}
					
				}else{
					System.out.println("No se encontro la boleta ... ");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Solicitud de Retiro","Boleta de Pago No Encontrada" ));
				}
				
			}else{
				System.out.println("No existe apoderado para el alumno: "+alumnoElegido.getIntDni());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Solicitud de Retiro","No existe apoderado para el alumno "+sr.getAlumno().getStrCodigoAlumno() ));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó la Solicitud de Retiro","Error General: "+e.getMessage()));
			e.printStackTrace();
			
		}
		
		return flagssss;
	}
	

	private String obtieneCodDA(Date fechaCita2, String horaCita2) {
		// TODO Auto-generated method stub
		int diadelasemana=fechaCita2.getDay();
		System.out.println("diadelasemana : "+diadelasemana);
		int mihora=-1;
		if(horaCita2.startsWith("0")){
			mihora=Integer.parseInt(horaCita2.substring(1,2));
			System.out.println("horadeldia : "+mihora);
		}
		else if(horaCita2.startsWith("1")){
			mihora=Integer.parseInt(horaCita2.substring(0,2));
			System.out.println("horadeldia : "+mihora);
		}
		
		switch (diadelasemana) {
		case 1:
				if(mihora<13)
					return ""+1;
				else
					return ""+2;
		case 2:
			if(mihora<13)
				return ""+3;
			else
				return ""+4;
		case 3:
			if(mihora<13)
				return ""+5;
			else
				return ""+6;
		case 4:
			if(mihora<13)
				return ""+7;
			else
				return ""+8;
		case 5:
			if(mihora<13)
				return ""+9;
			else
				return ""+10;
		case 6:
			if(mihora<13)
				return ""+11;
			else
				return ""+12;
		default:
			return null;
		}

	}

	public int getIntCodigoAlumno() {
		return intCodigoAlumno;
	}

	public void setIntCodigoAlumno(int intCodigoAlumno) {
		this.intCodigoAlumno = intCodigoAlumno;
	}

	public String getIncludedPage() {
		return includedPage;
	}

	public void setIncludedPage(String includedPage) {
		this.includedPage = includedPage;
	}

	public Persona getAsistentaElegida() {
		return asistentaElegida;
	}

	public void setAsistentaElegida(Persona asistentaElegida) {
		this.asistentaElegida = asistentaElegida;
	}

	public ArrayList<Persona> getListaAsistentas() {
		try {
			System.out.println("cargando asistentas ... ");
			listaAsistentas = asistentaService.obtenerTodosEmpleadosXTipo(Constantes.EMPLEADO_ASISTENTASOCIAL);
			System.out.println(listaAsistentas.size()+" asistentas cargadas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAsistentas;
	}

	public void setListaAsistentas(ArrayList<Persona> listaAsistentas) {
		this.listaAsistentas = listaAsistentas;
	}

	public Alumno getAlumnoElegido() {
		return alumnoElegido;
	}

	public void setAlumnoElegido(Alumno alumnoElegido) {
		this.alumnoElegido = alumnoElegido;
	}

	public Cita getNuevaCita() {
		return nuevaCita;
	}

	public void setNuevaCita(Cita nuevaCita) {
		this.nuevaCita = nuevaCita;
	}

	/*public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}*/

	public String getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	public ArrayList<String> getListaHorasDisponibles() {
		return listaHorasDisponibles;
	}

	public void setListaHorasDisponibles(ArrayList<String> listaHorasDisponibles) {
		this.listaHorasDisponibles = listaHorasDisponibles;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public SolicitudRetiro getMisolicitud() {
		return misolicitud;
	}

	public void setMisolicitud(SolicitudRetiro misolicitud) {
		this.misolicitud = misolicitud;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
	
	
}
