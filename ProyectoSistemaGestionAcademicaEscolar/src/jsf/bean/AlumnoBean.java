package jsf.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import servicios.AlumnoService;
import servicios.ApplicationBusinessDelegate;
import servicios.DistritoService;
import servicios.PersonaService;
import utiles.EnviaMail;
import entidades.Alumno;
import entidades.Apoderado;
import entidades.Distrito;
import entidades.Persona;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class AlumnoBean implements Serializable{
	
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
    private static PersonaService apoderadoService=abd.getPersonaService();
	private static AlumnoService alumnoService=abd.getAlumnoService();
	private static DistritoService distritoService=abd.getDistritoService();
	
	private Alumno alumno,selectedAlumno;
	private Persona persona;
	private Apoderado apoderado;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Distrito> listadistritos;
	private boolean editMode;
	private String strCodigoApoderado,mensaje;
	private int codigoDistrito;
	
	private Alumno nuevoAlumno =  new Alumno();

	public AlumnoBean() {
		System.out.println("Creado AlumnoBean...");
		CargarDistritos();
	}
	
	public void registraAlumno(ActionEvent ae) {  
		System.out.println("insertando alumno");
		
		Date auxi = new Date(nuevoAlumno.getFechaNacimiento().getTime());
		nuevoAlumno.setDtFecNac(auxi);
		String dniingresado=""+nuevoAlumno.getIntDni();
		System.out.println("dni del alumno: "+dniingresado);
		nuevoAlumno.setStrCodigoAlumno("AL-"+dniingresado);
		Distrito tempodis=new Distrito();
		tempodis.setIntIdDistrito(codigoDistrito);
		nuevoAlumno.setDistritos(tempodis);

		System.out.println(nuevoAlumno.getStrCodigoAlumno() );
		System.out.println(nuevoAlumno.getApoderados().getPersonas().getStrCodigoPersona());
		System.out.println(nuevoAlumno.getStrNombres());
		System.out.println(nuevoAlumno.getStrApellidoPaterno());
		System.out.println(nuevoAlumno.getStrApellidoMaterno());
		System.out.println(nuevoAlumno.getDtFecNac());
		System.out.println(nuevoAlumno.getDistritos().getIntIdDistrito());
		
		try {
			Alumno tempoalumno=new Alumno();
			tempoalumno=alumnoService.obtenerAlumno(nuevoAlumno);
			if(tempoalumno!=null){
				System.out.println("Alumno "+tempoalumno.getStrCodigoAlumno()+"("+tempoalumno.getStrNombres()+" "+tempoalumno.getStrApellidoPaterno()+") ya existe !!");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno ya se encuentra registrado: " + tempoalumno.getStrNombres() + " " + tempoalumno.getStrApellidoPaterno()));
			}else{
				alumnoService.registrarAlumno(nuevoAlumno);
				System.out.println("Se registro al alumno .... cargando apoderado ... ");
				String cadena= nuevoAlumno.getApoderados().getPersonas().getStrCodigoPersona().substring(3);
				System.out.println("cadena: "+cadena);
				Persona temporal=new Persona();
				Persona apoderadobuscado=new Persona();
				temporal.setIntDNI(Integer.parseInt(cadena));
				apoderadobuscado=apoderadoService.consultaApoderado(apoderadobuscado);
				System.out.println("enviando correo al apoderado ... ");
				EnviaMail enviador=new EnviaMail();				
				enviador.enviarCorreoRegisroAl(nuevoAlumno,apoderadobuscado);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno Insertado correctamente: " + nuevoAlumno.getStrNombres() + " " + nuevoAlumno.getStrApellidoPaterno()));
				System.out.println("Se registro el Alumno con exito");
				nuevoAlumno =  new Alumno();
			}
			
			
		} catch (Exception e) {
			System.out.println("Error registrando el alumno: "+e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó al alumno","No se insertó el apoderado: "+e.getMessage()));
			nuevoAlumno =  new Alumno();
			e.printStackTrace();
		}
    }
	
	public void actualizaAlumno(ActionEvent ae){
		System.out.println("Actualizando alumno ... ");
		System.out.println(selectedAlumno.getStrNombres());
		try {
			Date auxi=new Date(selectedAlumno.getFecha().getTime());
			selectedAlumno.setDtFecNac(auxi);

			alumnoService.actualizarAlumno(selectedAlumno);
			System.out.println("alumno actualizado con exito ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void CargarDistritos(){
		try {
			this.listadistritos=distritoService.obtenerTodosDistritos();
			System.out.println("Cantidad distritos cargados: " + listadistritos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public ArrayList<Alumno> getAlumnos() {
		try {
			System.out.println("entro a listar todos ....");
			alumnos = alumnoService.obtenerTodosAlumnos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno getSelectedAlumno() {
		return selectedAlumno;
	}

	public void setSelectedAlumno(Alumno selectedAlumno) {
		this.selectedAlumno = selectedAlumno;
	}


	public boolean isEditMode() {
		return editMode;
	}


	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public Alumno getNuevoAlumno() {
		return nuevoAlumno;
	}

	public void setNuevoAlumno(Alumno nuevoAlumno) {
		this.nuevoAlumno = nuevoAlumno;
	}

	public String getStrCodigoApoderado() {
		return strCodigoApoderado;
	}

	public void setStrCodigoApoderado(String strCodigoApoderado) {
		this.strCodigoApoderado = strCodigoApoderado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ArrayList<Distrito> getListadistritos() {
		return listadistritos;
	}

	public void setListadistritos(ArrayList<Distrito> listadistritos) {
		this.listadistritos = listadistritos;
	}

	public int getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(int codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

}
