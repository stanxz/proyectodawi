package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codactividad;

    @Temporal( TemporalType.DATE)
	private Date fechafin;

    @Temporal( TemporalType.DATE)
	private Date fechaini;

	private String nombreactividad;

	//bi-directional many-to-one association to Calendarioacademico
    @ManyToOne
	@JoinColumn(name="CODCALENDARIO")
	private Calendarioacademico calendarioacademico;

    public Actividad() {
    }

	public int getCodactividad() {
		return this.codactividad;
	}

	public void setCodactividad(int codactividad) {
		this.codactividad = codactividad;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public String getNombreactividad() {
		return this.nombreactividad;
	}

	public void setNombreactividad(String nombreactividad) {
		this.nombreactividad = nombreactividad;
	}

	public Calendarioacademico getCalendarioacademico() {
		return this.calendarioacademico;
	}

	public void setCalendarioacademico(Calendarioacademico calendarioacademico) {
		this.calendarioacademico = calendarioacademico;
	}
	
}