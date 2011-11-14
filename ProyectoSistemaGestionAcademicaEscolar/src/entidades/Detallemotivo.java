package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallemotivo database table.
 * 
 */
@Entity
public class Detallemotivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallemotivoPK id;

	private String descotros;

	//bi-directional many-to-one association to Certificadoa
    @ManyToOne
	@JoinColumn(name="CODCERTIFICADO")
	private Certificadoa certificadoa;

	//bi-directional many-to-one association to Motivo
    @ManyToOne
	@JoinColumn(name="CODMOTIVO")
	private Motivo motivo;

    public Detallemotivo() {
    }

	public DetallemotivoPK getId() {
		return this.id;
	}

	public void setId(DetallemotivoPK id) {
		this.id = id;
	}
	
	public String getDescotros() {
		return this.descotros;
	}

	public void setDescotros(String descotros) {
		this.descotros = descotros;
	}

	public Certificadoa getCertificadoa() {
		return this.certificadoa;
	}

	public void setCertificadoa(Certificadoa certificadoa) {
		this.certificadoa = certificadoa;
	}
	
	public Motivo getMotivo() {
		return this.motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}
	
}