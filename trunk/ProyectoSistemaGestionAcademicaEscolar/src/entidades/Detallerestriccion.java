package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detallerestriccion database table.
 * 
 */
@Entity
public class Detallerestriccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallerestriccionPK id;

	private String estado;

    @Temporal( TemporalType.DATE)
	private Date fechafin;

    @Temporal( TemporalType.DATE)
	private Date fechaini;

	//bi-directional many-to-one association to Alumno
    @ManyToOne
	@JoinColumn(name="CODALUMNO")
	private Alumno alumno;

	//bi-directional many-to-one association to Restriccion
    @ManyToOne
	@JoinColumn(name="CODRESTRICION")
	private Restriccion restriccion;

    public Detallerestriccion() {
    }

	public DetallerestriccionPK getId() {
		return this.id;
	}

	public void setId(DetallerestriccionPK id) {
		this.id = id;
	}
	
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Restriccion getRestriccion() {
		return this.restriccion;
	}

	public void setRestriccion(Restriccion restriccion) {
		this.restriccion = restriccion;
	}
	
}