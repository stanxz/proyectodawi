package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="actividad")
public class Actividad implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codactividad")
	private int intCodigoActividad;
	
	@ManyToOne
	@JoinColumn(name="CODCALENDARIO")
	private Calendarioacademico calendarioacademico = new Calendarioacademico();
	
	@Column(name="nombreactividad")
	private String strNombreActividad;
	
	@Column(name="fechaini")
	private java.sql.Date dtFecIni;
	
	@Column(name="fechafin")
	private java.sql.Date dtFecFin;

	public int getIntCodigoActividad() {
		return intCodigoActividad;
	}

	public void setIntCodigoActividad(int intCodigoActividad) {
		this.intCodigoActividad = intCodigoActividad;
	}

	public Calendarioacademico getCalendarioacademico() {
		return calendarioacademico;
	}

	public void setCalendarioacademico(Calendarioacademico calendarioacademico) {
		this.calendarioacademico = calendarioacademico;
	}

	public String getStrNombreActividad() {
		return strNombreActividad;
	}

	public void setStrNombreActividad(String strNombreActividad) {
		this.strNombreActividad = strNombreActividad;
	}

	public java.sql.Date getDtFecIni() {
		return dtFecIni;
	}

	public void setDtFecIni(java.sql.Date dtFecIni) {
		this.dtFecIni = dtFecIni;
	}

	public java.sql.Date getDtFecFin() {
		return dtFecFin;
	}

	public void setDtFecFin(java.sql.Date dtFecFin) {
		this.dtFecFin = dtFecFin;
	}

}
