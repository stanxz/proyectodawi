package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import com.sun.org.apache.bcel.internal.generic.NEW;


@Entity
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codalumno")
	private String strCodigoAlumno;
	
	@Column(name="anoacademico") 
	private String strAnioAcademico;

	@Column(name="apellidomat")
	private String strApellidoMaterno;

	@Column(name="apellidopat")
	private String strApellidoPaterno;
	
	@Column(name="fecnac")
	private java.sql.Date dtFecNac;

	@Column(name="estado")
	private String strEstado;

	@Column(name="grado")
	private int intGrado;

	@Column(name="nombres")
	private String strNombres;

	@Column(name="seccion")
	private String strSeccion;
	
	@Column(name="sexo")
	private int intSexo;
	
	@ManyToOne
	@JoinColumn(name="codapoderado")
	private Apoderado apoderados = new Apoderado();
	
	@ManyToOne
	@JoinColumn(name="codcalendario")
	private Calendarioacademico calendarioacademico = new Calendarioacademico();
	
	@Transient
	private Date fecha;
	
	@Transient
	private Date fechaNacimiento;
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Transient
	private Persona personas;
	
	@ManyToMany
	@JoinTable(name="detalleasignatura",
			joinColumns={@JoinColumn(name="codalumno")},
			inverseJoinColumns={@JoinColumn(name="codasignatura")}
	)
	private Collection<Alumno> tbAsignaturas;


    public Alumno() {
    }

	public String getStrCodigoAlumno() {
		return strCodigoAlumno;
	}

	public void setStrCodigoAlumno(String strCodigoAlumno) {
		this.strCodigoAlumno = strCodigoAlumno;
	}

	public String getStrAnioAcademico() {
		return strAnioAcademico;
	}

	public void setStrAnioAcademico(String strAnioAcademico) {
		this.strAnioAcademico = strAnioAcademico;
	}

	public String getStrApellidoMaterno() {
		return strApellidoMaterno;
	}

	public void setStrApellidoMaterno(String strApellidoMaterno) {
		this.strApellidoMaterno = strApellidoMaterno;
	}

	public String getStrApellidoPaterno() {
		return strApellidoPaterno;
	}

	public void setStrApellidoPaterno(String strApellidoPaterno) {
		this.strApellidoPaterno = strApellidoPaterno;
	}

	/*public void setDtFecNac(java.util.Date dtFecNac) {
		System.out.println("fecha q llega: "+dtFecNac.toString());
		System.out.println(" a long: "+dtFecNac.getTime());
		//SimpleDateFormat miformateador=new SimpleDateFormat();
		Date objfecha= new Date(dtFecNac.getTime());
		System.out.println("objFecha: "+objfecha.toString());
		this.dtFecNac = objfecha;
	}*/

	public Date getFecha() {
		return new Date(this.dtFecNac.getTime());
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public java.sql.Date getDtFecNac() {
		return dtFecNac;
	}

	public void setDtFecNac(java.sql.Date dtFecNac) {
		this.dtFecNac = dtFecNac;
	}

	public String getStrEstado() {
		return strEstado;
	}

	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}

	public int getIntGrado() {
		return intGrado;
	}

	public void setIntGrado(int intGrado) {
		this.intGrado = intGrado;
	}

	public String getStrNombres() {
		return strNombres;
	}

	public void setStrNombres(String strNombres) {
		this.strNombres = strNombres;
	}

	public String getStrSeccion() {
		return strSeccion;
	}

	public void setStrSeccion(String strSeccion) {
		this.strSeccion = strSeccion;
	}

	public Apoderado getApoderados() {
		return apoderados;
	}
	
	public Persona getPersonas() {
		return personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	public void setApoderados(Apoderado apoderados) {
		this.apoderados = apoderados;
	}

	public int getIntSexo() {
		return intSexo;
	}

	public void setIntSexo(int intSexo) {
		this.intSexo = intSexo;
	}

	public Collection<Alumno> getTbAsignaturas() {
		return tbAsignaturas;
	}

	public void setTbAsignaturas(Collection<Alumno> tbAsignaturas) {
		this.tbAsignaturas = tbAsignaturas;
	}

	public Calendarioacademico getCalendarioacademico() {
		return calendarioacademico;
	}

	public void setCalendarioacademico(Calendarioacademico calendarioacademico) {
		this.calendarioacademico = calendarioacademico;
	}

}