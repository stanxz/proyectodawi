package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the boletapago database table.
 * 
 */
@Entity
public class Boletapago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codboleta;

	private String estado;

    @Temporal( TemporalType.DATE)
	private Date fecharegistro;

	private double monto;

	//bi-directional many-to-one association to Apoderado
    @ManyToOne
	@JoinColumn(name="CODAPODERADO")
	private Apoderado apoderado;

    public Boletapago() {
    }

	public String getCodboleta() {
		return this.codboleta;
	}

	public void setCodboleta(String codboleta) {
		this.codboleta = codboleta;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Apoderado getApoderado() {
		return this.apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}
	
}