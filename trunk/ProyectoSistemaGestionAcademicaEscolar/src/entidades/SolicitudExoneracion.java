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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.primefaces.model.StreamedContent;


@Entity
@Table(name="solicitudexoneracion")
public class SolicitudExoneracion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codsolicitudexoneracion")
	private int intIdCodigoSolicitudExoneracion;
	
	@ManyToOne
	@JoinColumn(name="codalumno")
	private Alumno alumno = new Alumno();
	
	/*
	@Transient
	private File foto;
	@Transient
	private String fotoContentType;
	@Transient
	private String fotoFileName;
	@Transient
	private InputStream isFot;
	*/
	
	@Transient
	private StreamedContent scImagen;
	
	@Column(name="DOCSUSTENTATORIO",columnDefinition="MEDIUMBLOB")
	private byte[] fotobin;
	
	@Column(name="estado")
	private String strEstado;
	
	@Column(name="fecharegistro")
	private java.sql.Date dtFecReg;
	
	@Transient
	private Date fechaRegistro;
	
	@OneToOne
	@JoinColumn(name="codasignatura")
	private Asignatura asignaturas = new Asignatura();
	
	@Column(name="observacion")
	private String strObservacion;
	
	@Column(name="flagprocesado")
	private int intFlagProcesado;
	
	@ManyToOne
	@JoinColumn(name="codaca")
	private AsistenteCoordinacionAcademica asistenteCoordinacion = new AsistenteCoordinacionAcademica();

	public int getIntIdCodigoSolicitudExoneracion() {
		return intIdCodigoSolicitudExoneracion;
	}

	public void setIntIdCodigoSolicitudExoneracion(
			int intIdCodigoSolicitudExoneracion) {
		this.intIdCodigoSolicitudExoneracion = intIdCodigoSolicitudExoneracion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
/*
	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public String getFotoContentType() {
		return fotoContentType;
	}

	public void setFotoContentType(String fotoContentType) {
		this.fotoContentType = fotoContentType;
	}

	public String getFotoFileName() {
		return fotoFileName;
	}

	public void setFotoFileName(String fotoFileName) {
		this.fotoFileName = fotoFileName;
	}

	public InputStream getIsFot() {
		return isFot;
	}

	public void setIsFot(InputStream isFot) {
		this.isFot = isFot;
	}
*/
	public byte[] getFotobin() {
		return fotobin;
	}

	public void setFotobin(byte[] fotobin) {
		this.fotobin = fotobin;
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

	public Asignatura getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Asignatura asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getStrObservacion() {
		return strObservacion;
	}

	public void setStrObservacion(String strObservacion) {
		this.strObservacion = strObservacion;
	}

	public int getIntFlagProcesado() {
		return intFlagProcesado;
	}

	public void setIntFlagProcesado(int intFlagProcesado) {
		this.intFlagProcesado = intFlagProcesado;
	}

	public AsistenteCoordinacionAcademica getAsistenteCoordinacion() {
		return asistenteCoordinacion;
	}

	public void setAsistenteCoordinacion(
			AsistenteCoordinacionAcademica asistenteCoordinacion) {
		this.asistenteCoordinacion = asistenteCoordinacion;
	}

	public java.sql.Date getDtFecReg() {
		return dtFecReg;
	}

	public void setDtFecReg(java.sql.Date dtFecReg) {
		this.dtFecReg = dtFecReg;
	}

	public StreamedContent getScImagen() {
		return scImagen;
	}

	public void setScImagen(StreamedContent scImagen) {
		this.scImagen = scImagen;
	}
	
	

}
