package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detallerestriccion database table.
 * 
 */
@Embeddable
public class DetallerestriccionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int codalumno;

	private int codrestricion;

    public DetallerestriccionPK() {
    }
	public int getCodalumno() {
		return this.codalumno;
	}
	public void setCodalumno(int codalumno) {
		this.codalumno = codalumno;
	}
	public int getCodrestricion() {
		return this.codrestricion;
	}
	public void setCodrestricion(int codrestricion) {
		this.codrestricion = codrestricion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallerestriccionPK)) {
			return false;
		}
		DetallerestriccionPK castOther = (DetallerestriccionPK)other;
		return 
			(this.codalumno == castOther.codalumno)
			&& (this.codrestricion == castOther.codrestricion);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codalumno;
		hash = hash * prime + this.codrestricion;
		
		return hash;
    }
}