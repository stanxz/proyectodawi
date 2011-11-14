package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the horario database table.
 * 
 */
@Embeddable
public class HorarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int codasistentasocial;

	private String coddisponibilidadas;

    public HorarioPK() {
    }
	public int getCodasistentasocial() {
		return this.codasistentasocial;
	}
	public void setCodasistentasocial(int codasistentasocial) {
		this.codasistentasocial = codasistentasocial;
	}
	public String getCoddisponibilidadas() {
		return this.coddisponibilidadas;
	}
	public void setCoddisponibilidadas(String coddisponibilidadas) {
		this.coddisponibilidadas = coddisponibilidadas;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HorarioPK)) {
			return false;
		}
		HorarioPK castOther = (HorarioPK)other;
		return 
			(this.codasistentasocial == castOther.codasistentasocial)
			&& this.coddisponibilidadas.equals(castOther.coddisponibilidadas);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codasistentasocial;
		hash = hash * prime + this.coddisponibilidadas.hashCode();
		
		return hash;
    }
}