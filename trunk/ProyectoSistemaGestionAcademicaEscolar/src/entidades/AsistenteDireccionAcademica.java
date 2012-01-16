package entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@OneToMany(targetEntity=SolicitudRetiro.class,mappedBy="asistenteDireccion",cascade = CascadeType.PERSIST)
	private Collection<SolicitudRetiro> tbSolicitudRetiro;
	
	public Persona getPersonas() {
		return personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	public Collection<SolicitudRetiro> getTbSolicitudRetiro() {
		return tbSolicitudRetiro;
	}

	public void setTbSolicitudRetiro(Collection<SolicitudRetiro> tbSolicitudRetiro) {
		this.tbSolicitudRetiro = tbSolicitudRetiro;
	}
	
	
}
