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

    @Lob()
	private byte[] contenidodoccert;

	private int docenviado;

	private String estado;

	private String observacion;

	//bi-directional many-to-one association to Cita
   // @ManyToOne
	//@JoinColumn(name="CODCITA")
	//private Cita cita;

	//bi-directional many-to-one association to Motivo
    @ManyToOne
	private Motivo motivo;

	//bi-directional many-to-one association to Solicitudretiro
	@OneToMany(mappedBy="certificadoa")
	private Set<SolicitudRetiro> solicitudretiros;

    public Certificadoa() {
    }

	public int getCodcertificado() {
		return this.codcertificado;
	}

	public void setCodcertificado(int codcertificado) {
		this.codcertificado = codcertificado;
	}

	public byte[] getContenidodoccert() {
		return this.contenidodoccert;
	}

	public void setContenidodoccert(byte[] contenidodoccert) {
		this.contenidodoccert = contenidodoccert;
	}

	public int getDocenviado() {
		return this.docenviado;
	}

	public void setDocenviado(int docenviado) {
		this.docenviado = docenviado;
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

	/*public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}*/
	
	public Motivo getMotivo() {
		return this.motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}
	
	public Set<SolicitudRetiro> getSolicitudretiros() {
		return this.solicitudretiros;
	}

	public void setSolicitudretiros(Set<SolicitudRetiro> solicitudretiros) {
		this.solicitudretiros = solicitudretiros;
	}
	
}