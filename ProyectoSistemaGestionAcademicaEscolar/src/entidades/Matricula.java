package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matricula database table.
 * 
 */
@Entity
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	//@EmbeddedId
	//private MatriculaPK id;

	private String fechamat;

	//bi-directional many-to-one association to Alumno
    @ManyToOne
	@JoinColumn(name="CODALUMNO")
	private Alumno alumno;

	//bi-directional many-to-one association to Seccionprogramada
    @ManyToOne
	@JoinColumn(name="idseccionprogramada")
	private Seccionprogramada seccionprogramada;

	//bi-directional many-to-one association to Calendarioacademico
    @ManyToOne
	@JoinColumn(name="CODCALENDARIO")
	private Calendarioacademico calendarioacademico;

    public Matricula() {
    }

	/*public MatriculaPK getId() {
		return this.id;
	}

	public void setId(MatriculaPK id) {
		this.id = id;
	}*/
	
	public String getFechamat() {
		return this.fechamat;
	}

	public void setFechamat(String fechamat) {
		this.fechamat = fechamat;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Seccionprogramada getSeccionprogramada() {
		return this.seccionprogramada;
	}

	public void setSeccionprogramada(Seccionprogramada seccionprogramada) {
		this.seccionprogramada = seccionprogramada;
	}
	
	public Calendarioacademico getCalendarioacademico() {
		return this.calendarioacademico;
	}

	public void setCalendarioacademico(Calendarioacademico calendarioacademico) {
		this.calendarioacademico = calendarioacademico;
	}
	
}