package jsf.bean;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.ApplicationBusinessDelegate;
import servicios.PersonaService;
import utiles.Constantes;
import entidades.Alumno;
import entidades.Cita;
import entidades.Persona;


@SessionScoped
@ManagedBean 
public class CitaBean implements Serializable {

	 private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
		
	 private static PersonaService asistentaService = abd.getPersonaService();
		
	private static final long serialVersionUID = 1L;
	private String includedPage;
	private int intCodigoAlumno;
	private Alumno alumnoElegido=new Alumno();
	private Persona asistentaElegida=new Persona();
	private ArrayList<Persona> listaAsistentas;
	private Cita nuevaCita;
	private String fechaCita, horaCita;
	
	
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

	public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}
	
	
}
