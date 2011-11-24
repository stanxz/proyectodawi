package entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codalumno")
	private int strCodigoAlumno;
	
	@Column(name="anoacademico")
	private String strAnioAcademico;

	@Column(name="apellidomat")
	private String strApellidoMaterno;

	@Column(name="apellidopat")
	private String strApellidoPaterno;

	@Column(name="edad")
	private int intEdad;

	@Column(name="estado")
	private String strEstado;

	@Column(name="grado")
	private int intGrado;

	@Column(name="nombres")
	private String strNombres;

	@Column(name="seccion")
	private String strSeccion;
	
	@Column(name="sexo")
	private int intSeccion;
	
	@ManyToOne
	@JoinColumn(name="codapoderado")
	private Apoderado apoderados;


    public Alumno() {
    }

	public int getStrCodigoAlumno() {
		return strCodigoAlumno;
	}

	public void setStrCodigoAlumno(int strCodigoAlumno) {
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

	public int getIntEdad() {
		return intEdad;
	}

	public void setIntEdad(int intEdad) {
		this.intEdad = intEdad;
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

	public void setApoderados(Apoderado apoderados) {
		this.apoderados = apoderados;
	}

	public int getIntSeccion() {
		return intSeccion;
	}

	public void setIntSeccion(int intSeccion) {
		this.intSeccion = intSeccion;
	}


    
	
}