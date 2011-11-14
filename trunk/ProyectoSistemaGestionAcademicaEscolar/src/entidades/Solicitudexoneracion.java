package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the solicitudexoneracion database table.
 * 
 */
@Entity
public class Solicitudexoneracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codsolicitudexoneracion;

	private Object docsustentatorio;

	private String estado;

    @Temporal( TemporalType.DATE)
	private Date fecharegistro;

	private String observacion;

	//bi-directional many-to-one association to Alumno
    @ManyToOne
	@JoinColumn(name="CODALUMNO")
	private Alumno alumno;

	//bi-directional many-to-one association to Asignatura
    @ManyToOne
	@JoinColumn(name="CODASIGNATURA")
	private Asignatura asignatura;

    public Solicitudexoneracion() {
    }

	public String getCodsolicitudexoneracion() {
		return this.codsolicitudexoneracion;
	}

	public void setCodsolicitudexoneracion(String codsolicitudexoneracion) {
		this.codsolicitudexoneracion = codsolicitudexoneracion;
	}

	public Object getDocsustentatorio() {
		return this.docsustentatorio;
	}

	public void setDocsustentatorio(Object docsustentatorio) {
		this.docsustentatorio = docsustentatorio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
}