package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	private String estado;

	//bi-directional many-to-one association to Asistentasocial
    @ManyToOne
	@JoinColumn(name="CODASISTENTASOCIAL")
	private AsistentaSocial asistentasocial;

	//bi-directional many-to-one association to Disponibilidadasistentasocial
    /*@ManyToOne
	@JoinColumn(name="CODDISPONIBILIDADAS")
	private Disponibilidadasistentasocial disponibilidadasistentasocial;
*/
    
    private String CODDISPONIBILIDADAS;
    
    
    public Horario() {
    }

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public AsistentaSocial getAsistentasocial() {
		return asistentasocial;
	}

	public void setAsistentasocial(AsistentaSocial asistentasocial) {
		this.asistentasocial = asistentasocial;
	}

	public String getCODDISPONIBILIDADAS() {
		return CODDISPONIBILIDADAS;
	}

	public void setCODDISPONIBILIDADAS(String cODDISPONIBILIDADAS) {
		CODDISPONIBILIDADAS = cODDISPONIBILIDADAS;
	}


}