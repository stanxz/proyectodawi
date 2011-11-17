package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the asistentasocial database table.
 * 
 */
@Entity
public class Asistentasocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codasistentasocial;

	private String consultorio;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="CODASISTENTASOCIAL")
	private Persona persona;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="asistentasocial")
	private Set<Horario> horarios;

    public Asistentasocial() {
    }

	public int getCodasistentasocial() {
		return this.codasistentasocial;
	}

	public void setCodasistentasocial(int codasistentasocial) {
		this.codasistentasocial = codasistentasocial;
	}

	public String getConsultorio() {
		return this.consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public Set<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}
	
}