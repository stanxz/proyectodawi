package entidades;

import java.io.Serializable;
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
	
	@Column(name="consultorio")
	private String strConsultorio;
	
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
	
    
}