package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collection;


/**
 * The persistent class for the apoderado database table.
 * 
 */
@Entity
@Table(name="apoderado")
public class Apoderado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="codapoderado")
	private Persona personas = new Persona();
	
	@OneToMany(targetEntity=Alumno.class,mappedBy="apoderados",cascade = CascadeType.PERSIST)
	private Collection<Alumno> tbAlumnos;

	
    public Apoderado() {
    }
    
	public Collection<Alumno> getTbAlumnos() {
		return tbAlumnos;
	}

	public Persona getPersonas() {
		return personas;
	}



	public void setPersonas(Persona personas) {
		this.personas = personas;
	}



	public void setTbAlumnos(Collection<Alumno> tbAlumnos) {
		this.tbAlumnos = tbAlumnos;
	}
    
}