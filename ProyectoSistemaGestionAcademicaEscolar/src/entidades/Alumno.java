package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codalumno;

	private String anoacademico;

	private String apellidomat;

	private String apellidopat;

	private int edad;

	private String estado;

	private int grado;

	private String nombres;

	private String seccion;

	//bi-directional many-to-one association to Apoderado
    @ManyToOne
	@JoinColumn(name="CODAPODERADO")
	private Apoderado apoderado;

	//bi-directional many-to-one association to Calendarioacademico
    @ManyToOne
	@JoinColumn(name="CODCALENDARIO")
	private Calendarioacademico calendarioacademico;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="alumno")
	private Set<Cita> citas;

	//bi-directional many-to-one association to Detalleasignatura
	@OneToMany(mappedBy="alumno")
	private Set<Detalleasignatura> detalleasignaturas;

	//bi-directional many-to-one association to Detallerestriccion
	@OneToMany(mappedBy="alumno")
	private Set<Detallerestriccion> detallerestriccions;

	//bi-directional many-to-one association to Solicitudexoneracion
	@OneToMany(mappedBy="alumno")
	private Set<Solicitudexoneracion> solicitudexoneracions;

	//bi-directional many-to-one association to Solicitudretiro
	@OneToMany(mappedBy="alumno")
	private Set<Solicitudretiro> solicitudretiros;

    public Alumno() {
    }

	public int getCodalumno() {
		return this.codalumno;
	}

	public void setCodalumno(int codalumno) {
		this.codalumno = codalumno;
	}

	public String getAnoacademico() {
		return this.anoacademico;
	}

	public void setAnoacademico(String anoacademico) {
		this.anoacademico = anoacademico;
	}

	public String getApellidomat() {
		return this.apellidomat;
	}

	public void setApellidomat(String apellidomat) {
		this.apellidomat = apellidomat;
	}

	public String getApellidopat() {
		return this.apellidopat;
	}

	public void setApellidopat(String apellidopat) {
		this.apellidopat = apellidopat;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getGrado() {
		return this.grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getSeccion() {
		return this.seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Apoderado getApoderado() {
		return this.apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}
	
	public Calendarioacademico getCalendarioacademico() {
		return this.calendarioacademico;
	}

	public void setCalendarioacademico(Calendarioacademico calendarioacademico) {
		this.calendarioacademico = calendarioacademico;
	}
	
	public Set<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
	
	public Set<Detalleasignatura> getDetalleasignaturas() {
		return this.detalleasignaturas;
	}

	public void setDetalleasignaturas(Set<Detalleasignatura> detalleasignaturas) {
		this.detalleasignaturas = detalleasignaturas;
	}
	
	public Set<Detallerestriccion> getDetallerestriccions() {
		return this.detallerestriccions;
	}

	public void setDetallerestriccions(Set<Detallerestriccion> detallerestriccions) {
		this.detallerestriccions = detallerestriccions;
	}
	
	public Set<Solicitudexoneracion> getSolicitudexoneracions() {
		return this.solicitudexoneracions;
	}

	public void setSolicitudexoneracions(Set<Solicitudexoneracion> solicitudexoneracions) {
		this.solicitudexoneracions = solicitudexoneracions;
	}
	
	public Set<Solicitudretiro> getSolicitudretiros() {
		return this.solicitudretiros;
	}

	public void setSolicitudretiros(Set<Solicitudretiro> solicitudretiros) {
		this.solicitudretiros = solicitudretiros;
	}
	
}