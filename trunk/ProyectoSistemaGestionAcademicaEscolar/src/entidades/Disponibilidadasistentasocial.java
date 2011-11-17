package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the disponibilidadasistentasocial database table.
 * 
 */
@Entity
public class Disponibilidadasistentasocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String coddisponibilidadas;

    @Temporal( TemporalType.DATE)
	private Date fecharegistro;

	private String horafin;

	private String horainicio;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="disponibilidadasistentasocial")
	private Set<Horario> horarios;

    public Disponibilidadasistentasocial() {
    }

	public String getCoddisponibilidadas() {
		return this.coddisponibilidadas;
	}

	public void setCoddisponibilidadas(String coddisponibilidadas) {
		this.coddisponibilidadas = coddisponibilidadas;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getHorafin() {
		return this.horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public String getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}

	public Set<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}
	
}