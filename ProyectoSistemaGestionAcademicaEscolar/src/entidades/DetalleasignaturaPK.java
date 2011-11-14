package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalleasignatura database table.
 * 
 */
@Embeddable
public class DetalleasignaturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int codasignatura;

	private int codalumno;

    public DetalleasignaturaPK() {
    }
	public int getCodasignatura() {
		return this.codasignatura;
	}
	public void setCodasignatura(int codasignatura) {
		this.codasignatura = codasignatura;
	}
	public int getCodalumno() {
		return this.codalumno;
	}
	public void setCodalumno(int codalumno) {
		this.codalumno = codalumno;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleasignaturaPK)) {
			return false;
		}
		DetalleasignaturaPK castOther = (DetalleasignaturaPK)other;
		return 
			(this.codasignatura == castOther.codasignatura)
			&& (this.codalumno == castOther.codalumno);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codasignatura;
		hash = hash * prime + this.codalumno;
		
		return hash;
    }
}