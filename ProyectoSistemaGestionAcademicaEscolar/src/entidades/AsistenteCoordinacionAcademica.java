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
@Table(name="aca")
public class AsistenteCoordinacionAcademica implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="codpersona")
	private Persona personas = new Persona();
	
	@OneToMany(targetEntity=SolicitudExoneracion.class,mappedBy="asistenteCoordinacion",cascade = CascadeType.PERSIST)
	private Collection<SolicitudExoneracion> tbSolicitudExoneracion;

	public Persona getPersonas() {
		return personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	public Collection<SolicitudExoneracion> getTbSolicitudExoneracion() {
		return tbSolicitudExoneracion;
	}

	public void setTbSolicitudExoneracion(
			Collection<SolicitudExoneracion> tbSolicitudExoneracion) {
		this.tbSolicitudExoneracion = tbSolicitudExoneracion;
	}
	
}
