package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the solicitudretiro database table.
 * 
 */
@Entity
public class Solicitudretiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codsolicitudretiro;

	private Object docsustentatorio;

	private String estado;

    @Temporal( TemporalType.DATE)
	private Date fecharegistro;

	private String motivo;

	private String observacion;

	//bi-directional many-to-one association to Alumno
    @ManyToOne
	@JoinColumn(name="CODALUMNO")
	private Alumno alumno;

	//bi-directional many-to-one association to Certificadoa
    @ManyToOne
	@JoinColumn(name="CODCERTIFICADO")
	private Certificadoa certificadoa;

    public Solicitudretiro() {
    }

	public String getCodsolicitudretiro() {
		return this.codsolicitudretiro;
	}

	public void setCodsolicitudretiro(String codsolicitudretiro) {
		this.codsolicitudretiro = codsolicitudretiro;
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

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
	
	public Certificadoa getCertificadoa() {
		return this.certificadoa;
	}

	public void setCertificadoa(Certificadoa certificadoa) {
		this.certificadoa = certificadoa;
	}
	
}