package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="matricula")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idmatricula")
	private int intIdMatricula;

    @ManyToOne
	@JoinColumn(name="codalumno")
	private Alumno alumno = new Alumno();

    @ManyToOne
	@JoinColumn(name="idseccionprogramada")
	private Seccionprogramada seccionprogramada = new Seccionprogramada();

    @ManyToOne
	@JoinColumn(name="CODCALENDARIO")
	private Calendarioacademico calendarioacademico = new Calendarioacademico();
    
    @Column(name="fechamat")
    private java.sql.Date dtFecMat;
    
    @Transient
    private Date fechaMatricula;
    
    @Column(name="noReligion")
    private int intEstadoReligion;
    
    @Column(name="noEF")
    private int intEstadoEF;

    public Matricula() {
    }

	public int getIntIdMatricula() {
		return intIdMatricula;
	}

	public void setIntIdMatricula(int intIdMatricula) {
		this.intIdMatricula = intIdMatricula;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Seccionprogramada getSeccionprogramada() {
		return seccionprogramada;
	}

	public void setSeccionprogramada(Seccionprogramada seccionprogramada) {
		this.seccionprogramada = seccionprogramada;
	}

	public Calendarioacademico getCalendarioacademico() {
		return calendarioacademico;
	}

	public void setCalendarioacademico(Calendarioacademico calendarioacademico) {
		this.calendarioacademico = calendarioacademico;
	}

	public java.sql.Date getDtFecMat() {
		return dtFecMat;
	}

	public void setDtFecMat(java.sql.Date dtFecMat) {
		this.dtFecMat = dtFecMat;
	}

	public Date getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public int getIntEstadoReligion() {
		return intEstadoReligion;
	}

	public void setIntEstadoReligion(int intEstadoReligion) {
		this.intEstadoReligion = intEstadoReligion;
	}

	public int getIntEstadoEF() {
		return intEstadoEF;
	}

	public void setIntEstadoEF(int intEstadoEF) {
		this.intEstadoEF = intEstadoEF;
	}
	
}