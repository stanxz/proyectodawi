package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the certificadoas database table.
 * 
 */
@Entity
@Table(name="certificadoas")
public class Certificadoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codcertificado;

	private String estado;

	private String observacion;

	//bi-directional many-to-one association to Cita
    @ManyToOne
	@JoinColumn(name="CODCITA")
	private Cita cita;

	//bi-directional many-to-one association to Detallemotivo
	@OneToMany(mappedBy="certificadoa")
	private Set<Detallemotivo> detallemotivos;

	//bi-directional many-to-one association to Solicitudretiro
	@OneToMany(mappedBy="certificadoa")
	private Set<Solicitudretiro> solicitudretiros;

    public Certificadoa() {
    }

	public int getCodcertificado() {
		return this.codcertificado;
	}

	public void setCodcertificado(int codcertificado) {
		this.codcertificado = codcertificado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	public Set<Detallemotivo> getDetallemotivos() {
		return this.detallemotivos;
	}

	public void setDetallemotivos(Set<Detallemotivo> detallemotivos) {
		this.detallemotivos = detallemotivos;
	}
	
	public Set<Solicitudretiro> getSolicitudretiros() {
		return this.solicitudretiros;
	}

	public void setSolicitudretiros(Set<Solicitudretiro> solicitudretiros) {
		this.solicitudretiros = solicitudretiros;
	}
	
}