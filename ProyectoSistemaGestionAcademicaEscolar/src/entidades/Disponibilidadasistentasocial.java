package entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


/**
 * The persistent class for the disponibilidadasistentasocial database table.
 * 
 */
@Entity
public class Disponibilidadasistentasocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODDISPONIBILIDADAS")
	private String coddisponibilidadas;

	@Column(name="DIA")
	private int dia;

	@Column(name="HORAFIN")
	private String horafin;

	@Column(name="HORAINICIO")
	private String horainicio;

	//bi-directional many-to-one association to Horario
	//@OneToMany(targetEntity=Horario.class,mappedBy="disponibilidadasistentasocial")
	//private Set<Horario> horarios;

	@ManyToMany
	@JoinTable(name="horario",
			joinColumns={@JoinColumn(name="CODDISPONIBILIDADAS")},
			inverseJoinColumns={@JoinColumn(name="codasistentasocial")}
	)
	private Collection<AsistentaSocial> tbAsistentas;
	
    public Disponibilidadasistentasocial() {
    }

	public String getCoddisponibilidadas() {
		return this.coddisponibilidadas;
	}

	public void setCoddisponibilidadas(String coddisponibilidadas) {
		this.coddisponibilidadas = coddisponibilidadas;
	}

	public int getDia() {
		return this.dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
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

	public Collection<AsistentaSocial> getTbAsistentas() {
		return tbAsistentas;
	}

	public void setTbAsistentas(Collection<AsistentaSocial> tbAsistentas) {
		this.tbAsistentas = tbAsistentas;
	}

	/*public Collection<Permiso> getTbAsistentas() {
		return tbAsistentas;
	}

	public void setTbAsistentas(Collection<Permiso> tbAsistentas) {
		this.tbAsistentas = tbAsistentas;
	}*/
	
}