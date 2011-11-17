package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the secretaria database table.
 * 
 */
@Entity
public class Secretaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codsecretaria;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="CODSECRETARIA")
	private Persona persona;

    public Secretaria() {
    }

	public int getCodsecretaria() {
		return this.codsecretaria;
	}

	public void setCodsecretaria(int codsecretaria) {
		this.codsecretaria = codsecretaria;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}