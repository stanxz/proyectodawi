package entidades;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the apoderado database table.
 * 
 */
@Entity
@Table(name="secretaria")
public class SecretariaAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="codsecretaria")
	private Persona personas = new Persona();
	

    public SecretariaAcademica() {
    }

	public Persona getPersonas() {
		return personas;
	}



	public void setPersonas(Persona personas) {
		this.personas = personas;
	}
    
}