package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalleasignatura database table.
 * 
 */
@Entity
public class Detalleasignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleasignaturaPK id;

	private String estado;

	//bi-directional many-to-one association to Alumno
    @ManyToOne
	@JoinColumn(name="CODALUMNO")
	private Alumno alumno;

	//bi-directional many-to-one association to Asignatura
    @ManyToOne
	@JoinColumn(name="CODASIGNATURA")
	private Asignatura asignatura;

    public Detalleasignatura() {
    }

	public DetalleasignaturaPK getId() {
		return this.id;
	}

	public void setId(DetalleasignaturaPK id) {
		this.id = id;
	}
	
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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