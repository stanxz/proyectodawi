package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HorarioPK id;

	private String estado;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="horario")
	private Set<Cita> citas;

	//bi-directional many-to-one association to Asistentasocial
    @ManyToOne
	@JoinColumn(name="CODASISTENTASOCIAL")
	private Asistentasocial asistentasocial;

	//bi-directional many-to-one association to Disponibilidadasistentasocial
    @ManyToOne
	@JoinColumn(name="CODDISPONIBILIDADAS")
	private Disponibilidadasistentasocial disponibilidadasistentasocial;

    public Horario() {
    }

	public HorarioPK getId() {
		return this.id;
	}

	public void setId(HorarioPK id) {
		this.id = id;
	}
	
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
	
	public Asistentasocial getAsistentasocial() {
		return this.asistentasocial;
	}

	public void setAsistentasocial(Asistentasocial asistentasocial) {
		this.asistentasocial = asistentasocial;
	}
	
	public Disponibilidadasistentasocial getDisponibilidadasistentasocial() {
		return this.disponibilidadasistentasocial;
	}

	public void setDisponibilidadasistentasocial(Disponibilidadasistentasocial disponibilidadasistentasocial) {
		this.disponibilidadasistentasocial = disponibilidadasistentasocial;
	}
	
}