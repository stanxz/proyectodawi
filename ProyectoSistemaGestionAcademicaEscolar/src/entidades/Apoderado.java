package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the apoderado database table.
 * 
 */
@Entity
public class Apoderado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codapoderado;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="apoderado")
	private Set<Alumno> alumnos;

	//bi-directional one-to-one association to Persona
	/*@OneToOne
	@JoinColumn(name="CODAPODERADO")
	private Persona persona;*/

	//bi-directional many-to-one association to Boletapago
	/*@OneToMany(mappedBy="apoderado")
	private Set<Boletapago> boletapagos;
	 */
    public Apoderado() {
    }

	public int getCodapoderado() {
		return this.codapoderado;
	}

	public void setCodapoderado(int codapoderado) {
		this.codapoderado = codapoderado;
	}

	public Set<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	/*
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}*/
	/*
	public Set<Boletapago> getBoletapagos() {
		return this.boletapagos;
	}

	public void setBoletapagos(Set<Boletapago> boletapagos) {
		this.boletapagos = boletapagos;
	}
	*/
}