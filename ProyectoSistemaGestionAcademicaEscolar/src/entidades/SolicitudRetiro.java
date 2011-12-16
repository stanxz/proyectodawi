package entidades;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="solicitudretiro")
public class SolicitudRetiro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codsolicitudretiro")
	private int intIdCodigoSolicitudRetiro;
	
	@Column(name="codalumno")
	private Alumno alumno = new Alumno();
	
	@Transient
	private File foto;
	@Transient
	private String fotoContentType;
	@Transient
	private String fotoFileName;
	@Transient
	private InputStream isFot;
	
	@Column(name="docsustentario",columnDefinition="LONGBLOB")
	private byte[] fotobin;
	
	@Column(name="motivo")
	private String strMotivo;
	
	@Column(name="estado")
	private String strEstado;
	
	@Transient
	private Date fechaRegistro;
	
	@Column(name="fecharegistro")
	private java.sql.Date dtFecNac;
	

	
	

	
	

}
