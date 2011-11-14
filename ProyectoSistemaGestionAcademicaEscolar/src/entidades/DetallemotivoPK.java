package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detallemotivo database table.
 * 
 */
@Embeddable
public class DetallemotivoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int codmotivo;

	private int codcertificado;

    public DetallemotivoPK() {
    }
	public int getCodmotivo() {
		return this.codmotivo;
	}
	public void setCodmotivo(int codmotivo) {
		this.codmotivo = codmotivo;
	}
	public int getCodcertificado() {
		return this.codcertificado;
	}
	public void setCodcertificado(int codcertificado) {
		this.codcertificado = codcertificado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallemotivoPK)) {
			return false;
		}
		DetallemotivoPK castOther = (DetallemotivoPK)other;
		return 
			(this.codmotivo == castOther.codmotivo)
			&& (this.codcertificado == castOther.codcertificado);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codmotivo;
		hash = hash * prime + this.codcertificado;
		
		return hash;
    }
}