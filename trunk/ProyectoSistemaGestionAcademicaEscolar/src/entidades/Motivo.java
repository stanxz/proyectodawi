package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="motivo")
public class Motivo implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codmotivo")
	private int intCodigoMotivo;
	
	@Column(name="nombre")
	private String strDescripcion;

	public int getIntCodigoMotivo() {
		return intCodigoMotivo;
	}

	public void setIntCodigoMotivo(int intCodigoMotivo) {
		this.intCodigoMotivo = intCodigoMotivo;
	}

	public String getStrDescripcion() {
		return strDescripcion;
	}

	public void setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
	}
	
}
