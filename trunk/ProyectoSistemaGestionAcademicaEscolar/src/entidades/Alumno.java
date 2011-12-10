package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="alumno")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codalumno")
	private String strCodigoAlumno;
	
	@Column(name="dni") 
	private int intDni;

	@Column(name="apellidomat")
	private String strApellidoMaterno;

	@Column(name="apellidopat")
	private String strApellidoPaterno;
	
	@Column(name="fecnac")
	private java.sql.Date dtFecNac;

	@Column(name="estado")
	private String strEstado;

	@Column(name="nombres")
	private String strNombres;

	@Column(name="sexo")
	private int intSexo;
	
	@ManyToOne
	@JoinColumn(name="codapoderado")
	private Apoderado apoderados = new Apoderado();
	
	@SuppressWarnings("unused")
	@Transient
	private Date fecha;
	
	@Transient
	private Date fechaNacimiento;
	
    @ManyToOne
	@JoinColumn(name="iddistrito")
	private Distrito distritos;
    
    @OneToMany(targetEntity=Matricula.class,mappedBy="alumno")
	private Collection<Matricula> tbMatriculas;
	 
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
		
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

    public Alumno() {
    	
    }

	public String getStrCodigoAlumno() {
		return strCodigoAlumno;
	}

	public void setStrCodigoAlumno(String strCodigoAlumno) {
		this.strCodigoAlumno = strCodigoAlumno;
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

	public String getStrNombres() {
		return strNombres;
	}

	public void setStrNombres(String strNombres) {
		this.strNombres = strNombres;
	}

	public Apoderado getApoderados() {
		return apoderados;
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

	/*public Calendarioacademico getCalendarioacademico() {
		return calendarioacademico;
	}

	public void setCalendarioacademico(Calendarioacademico calendarioacademico) {
		this.calendarioacademico = calendarioacademico;
	}*/

	public int getIntDni() {
		return intDni;
	}

	public void setIntDni(int intDni) {
		this.intDni = intDni;
	}

	public Distrito getDistritos() {
		return distritos;
	}

	public void setDistritos(Distrito distritos) {
		this.distritos = distritos;
	}

	public Collection<Matricula> getTbMatriculas() {
		return tbMatriculas;
	}

	public void setTbMatriculas(Collection<Matricula> tbMatriculas) {
		this.tbMatriculas = tbMatriculas;
	}

}