package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.primefaces.model.StreamedContent;


@Entity
@Table(name="solicitudretiro")
public class SolicitudRetiro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codsolicitudretiro")
	private int intIdCodigoSolicitudRetiro;
	
	//@Column(name="codalumno")
	//private Alumno alumno = new Alumno();
	
	/*@Transient
	private File certificado;
	@Transient
	private String certificadoContentType;
	@Transient
	private String certificadoFileName;
	@Transient
	private InputStream isCertificado;*/
	@Transient
	private StreamedContent scImagen;
	
	@Column(name="DOCSUSTENTATORIO",columnDefinition="MEDIUMBLOB")
	private byte[] certificadobin;
	
	@Column(name="motivo")
	private String strMotivo;
	
	@Column(name="estado")
	private String strEstado;
	
	@Transient
	private Date fechaRegistro;
	
	@Column(name="fecharegistro")
	private java.sql.Date dtFecNac;
	
	@Column(name="observacion")
	private String strObservacion;

	@Column(name="flagprocesado")
	private int intFlagprocesado;

	@ManyToOne
	@JoinColumn(name="codalumno")
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="codada")
	private AsistenteDireccionAcademica asistenteDireccion = new AsistenteDireccionAcademica();
	
	public int getIntIdCodigoSolicitudRetiro() {
		return intIdCodigoSolicitudRetiro;
	}

	public void setIntIdCodigoSolicitudRetiro(int intIdCodigoSolicitudRetiro) {
		this.intIdCodigoSolicitudRetiro = intIdCodigoSolicitudRetiro;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/*public File getCertificado() {
		return certificado;
	}

	public void setCertificado(File certificado) {
		this.certificado = certificado;
	}

	public String getCertificadoContentType() {
		return certificadoContentType;
	}

	public void setCertificadoContentType(String certificadoContentType) {
		this.certificadoContentType = certificadoContentType;
	}

	public String getCertificadoFileName() {
		return certificadoFileName;
	}

	public void setCertificadoFileName(String certificadoFileName) {
		this.certificadoFileName = certificadoFileName;
	}

	public InputStream getIsCertificado() {
		return isCertificado;
	}

	public void setIsCertificado(InputStream isCertificado) {
		this.isCertificado = isCertificado;
	}
*/
	public byte[] getCertificadobin() {
		return certificadobin;
	}

	public void setCertificadobin(byte[] certificadobin) {
		this.certificadobin = certificadobin;
	}

	public String getStrMotivo() {
		return strMotivo;
	}

	public void setStrMotivo(String strMotivo) {
		this.strMotivo = strMotivo;
	}

	public String getStrEstado() {
		return strEstado;
	}

	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.sql.Date getDtFecNac() {
		return dtFecNac;
	}

	public void setDtFecNac(java.sql.Date dtFecNac) {
		this.dtFecNac = dtFecNac;
	}

	public String getStrObservacion() {
		return strObservacion;
	}

	public void setStrObservacion(String strObservacion) {
		this.strObservacion = strObservacion;
	}

	public int getIntFlagprocesado() {
		return intFlagprocesado;
	}

	public void setIntFlagprocesado(int intFlagprocesado) {
		this.intFlagprocesado = intFlagprocesado;
	}

	public AsistenteDireccionAcademica getAsistenteDireccion() {
		return asistenteDireccion;
	}

	public void setAsistenteDireccion(AsistenteDireccionAcademica asistenteDireccion) {
		this.asistenteDireccion = asistenteDireccion;
	}

	public StreamedContent getScImagen() {
		return scImagen;
	}

	public void setScImagen(StreamedContent scImagen) {
		this.scImagen = scImagen;
	}
	
	
 
	
	

}
