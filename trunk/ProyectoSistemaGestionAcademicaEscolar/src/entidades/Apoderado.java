package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


/**
 * The persistent class for the apoderado database table.
 * 
 */
@Entity
public class Apoderado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="codapoderado")
	private Persona personas = new Persona();
	
	/*
	@ManyToOne
	@JoinColumn(name="codpersona")
	private Persona personas;
	*/
	@OneToMany(targetEntity=Alumno.class,mappedBy="apoderados",cascade = CascadeType.PERSIST)
	private Collection<Alumno> tbAlumnos;

	/*public void addAlumno(Alumno alumno) {
	    if (tbAlumnos == null) {
	    	tbAlumnos = new ArrayList<Alumno>();
	    }
	    alumno.setApoderados(apoderados);
	    tbAlumnos.add(alumno);
	}*/
	
	
    public Apoderado() {
    }
/*
	public String getStrCodigoApoderado() {
		return strCodigoApoderado;
	}

	public void setStrCodigoApoderado(String strCodigoApoderado) {
		this.strCodigoApoderado = strCodigoApoderado;
	}
*/
    
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