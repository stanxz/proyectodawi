package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the certificadoas database table.
 * 
 */
@Entity
@Table(name="certificadoas")
public class Certificadoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int intCodcertificado;

	@Column(name="codcita")
	private int intCodcita;
	
	@Column(name="observacion")
	private String strObservacion;
	
	@Column(name="estado")
	private String strEstado;
	
	@Column(name="contenidodoccert")
	private byte[] contenidodoccertbin;

	@Column(name="docenviado")
	private int docenviado;

	@Column(name="codmotivo")
	private int codmotivo;

	

	//bi-directional many-to-one association to Cita
   // @ManyToOne
	//@JoinColumn(name="CODCITA")
	//private Cita cita;

	//bi-directional many-to-one association to Motivo
    //@ManyToOne
	//private Motivo motivo;

	//bi-directional many-to-one association to Solicitudretiro
	//@OneToMany(mappedBy="certificadoa")
	//private Set<SolicitudRetiro> solicitudretiros;

    public Certificadoa() {
    	
    }

	public int getIntCodcertificado() {
		return intCodcertificado;
	}

	public void setIntCodcertificado(int intCodcertificado) {
		this.intCodcertificado = intCodcertificado;
	}

	public int getIntCodcita() {
		return intCodcita;
	}

	public void setIntCodcita(int intCodcita) {
		this.intCodcita = intCodcita;
	}

	public String getStrObservacion() {
		return strObservacion;
	}

	public void setStrObservacion(String strObservacion) {
		this.strObservacion = strObservacion;
	}

	public String getStrEstado() {
		return strEstado;
	}

	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}

	public byte[] getContenidodoccertbin() {
		return contenidodoccertbin;
	}

	public void setContenidodoccertbin(byte[] contenidodoccertbin) {
		this.contenidodoccertbin = contenidodoccertbin;
	}

	public int getDocenviado() {
		return docenviado;
	}
	
	public void setDocenviado(int docenviado) {
		this.docenviado = docenviado;
	}

	public int getCodmotivo() {
		return codmotivo;
	}

	public void setCodmotivo(int codmotivo) {
		this.codmotivo = codmotivo;
	}

    
}