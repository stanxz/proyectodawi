package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collection;


/**
 * The persistent class for the apoderado database table.
 * 
 */
@Entity
public class Apoderado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codapoderado")
	private int StrCodigoApoderado;
	
	@ManyToOne
	@JoinColumn(name="codpersona")
	private Persona personas;
	
	@OneToMany(targetEntity=Alumno.class,mappedBy="apoderados")
	private Collection<Alumno> tbAlumnos;

    public Apoderado() {
    }

	public int getStrCodigoApoderado() {
		return StrCodigoApoderado;
	}

	public void setStrCodigoApoderado(int strCodigoApoderado) {
		StrCodigoApoderado = strCodigoApoderado;
	}

	public Persona getPersonas() {
		return personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	public Collection<Alumno> getTbAlumnos() {
		return tbAlumnos;
	}

	public void setTbAlumnos(Collection<Alumno> tbAlumnos) {
		this.tbAlumnos = tbAlumnos;
	}

    
    
}