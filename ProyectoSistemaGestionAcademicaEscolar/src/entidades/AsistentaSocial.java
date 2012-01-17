package entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;



/**
 * The persistent class for the apoderado database table.
 * 
 */
@Entity
@Table(name="asistentasocial")
public class AsistentaSocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="codasistentasocial")
	private Persona personas = new Persona();
	
	@Column(name="CONSULTORIO")
	private String strConsultorio;
	
/*	@OneToMany(targetEntity=Horario.class,mappedBy="asistentasocial")
	private Collection<Horario> tbHorarios;*/
	
	@ManyToMany
	@JoinTable(name="horario",
			joinColumns={@JoinColumn(name="codasistentasocial")},
			inverseJoinColumns={@JoinColumn(name="CODDISPONIBILIDADAS")}
	)
	private Collection<Perfil> tbDisponibilidadesAsistenta;
	
    public AsistentaSocial() {
    }

	public Persona getPersonas() {
		return personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	public String getStrConsultorio() {
		return strConsultorio;
	}

	public void setStrConsultorio(String strConsultorio) {
		this.strConsultorio = strConsultorio;
	}

	public Collection<Perfil> getTbDisponibilidadesAsistenta() {
		return tbDisponibilidadesAsistenta;
	}

	public void setTbDisponibilidadesAsistenta(
			Collection<Perfil> tbDisponibilidadesAsistenta) {
		this.tbDisponibilidadesAsistenta = tbDisponibilidadesAsistenta;
	}

	/*public Collection<Horario> getTbHorarios() {
		return tbHorarios;
	}

	public void setTbHorarios(Collection<Horario> tbHorarios) {
		this.tbHorarios = tbHorarios;
	}
	*/
    
}