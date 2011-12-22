package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="boletapago")
public class Boleta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codboleta")
	private String strCodigoBoleta;
	
	@ManyToOne
	@JoinColumn(name="codapoderado")
	private Apoderado apoderados = new Apoderado();
	
	@Column(name="fecharegistro")
	private java.sql.Date dtFechaRegistro;
	
	@Column(name="monto")
	private Double monto;
	
	@Transient
	private Date fechaRegistro;
	
	@Column(name="estado")
	private String strEstado;

	public String getStrCodigoBoleta() {
		return strCodigoBoleta;
	}

	public void setStrCodigoBoleta(String strCodigoBoleta) {
		this.strCodigoBoleta = strCodigoBoleta;
	}

	public Apoderado getApoderados() {
		return apoderados;
	}

	public void setApoderados(Apoderado apoderados) {
		this.apoderados = apoderados;
	}

	public java.sql.Date getDtFechaRegistro() {
		return dtFechaRegistro;
	}

	public void setDtFechaRegistro(java.sql.Date dtFechaRegistro) {
		this.dtFechaRegistro = dtFechaRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getStrEstado() {
		return strEstado;
	}

	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
}
