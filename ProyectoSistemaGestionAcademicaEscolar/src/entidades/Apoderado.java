package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collection;


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
	
	@OneToMany(targetEntity=Boleta.class,mappedBy="apoderados",cascade = CascadeType.PERSIST)
	private Collection<Boleta> tbBoletas;

	
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

	public Collection<Boleta> getTbBoletas() {
		return tbBoletas;
	}

	public void setTbBoletas(Collection<Boleta> tbBoletas) {
		this.tbBoletas = tbBoletas;
	}


	
	
    
}