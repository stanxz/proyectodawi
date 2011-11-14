package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the asignatura database table.
 * 
 */
@Entity
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codasignatura;

	private String nombre;

	//bi-directional many-to-one association to Detalleasignatura
	@OneToMany(mappedBy="asignatura")
	private Set<Detalleasignatura> detalleasignaturas;

	//bi-directional many-to-one association to Solicitudexoneracion
	@OneToMany(mappedBy="asignatura")
	private Set<Solicitudexoneracion> solicitudexoneracions;

    public Asignatura() {
    }

	public int getCodasignatura() {
		return this.codasignatura;
	}

	public void setCodasignatura(int codasignatura) {
		this.codasignatura = codasignatura;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Detalleasignatura> getDetalleasignaturas() {
		return this.detalleasignaturas;
	}

	public void setDetalleasignaturas(Set<Detalleasignatura> detalleasignaturas) {
		this.detalleasignaturas = detalleasignaturas;
	}
	
	public Set<Solicitudexoneracion> getSolicitudexoneracions() {
		return this.solicitudexoneracions;
	}

	public void setSolicitudexoneracions(Set<Solicitudexoneracion> solicitudexoneracions) {
		this.solicitudexoneracions = solicitudexoneracions;
	}
	
}