package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ada")
public class AsistenteDireccionAcademica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="codada")
	private Persona personas = new Persona();

	public Persona getPersonas() {
		return personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}
	
	
}
