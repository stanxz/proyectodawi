package entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.primefaces.model.StreamedContent;


@Entity
@Table(name="persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codpersona")
	private String strCodigoPersona;
	
	@Column(name="nombres")
	private String strNombre;
	
	@Column(name="apellidopat")
	private String strApellidoPaterno;
	
	@Column(name="apellidomat")
	private String strApellidoMaterno;
	
	@Column(name="direccion")
	private String strDireccion;
	
	@Column(name="email")
	private String strMail;
	
	@Column(name="telefono")
	private String strTelefono;
	
	@Column(name="celular")
	private String strCelular;
	
	@Column(name="sexo")
	private String strSexo;
	
	@Column(name="dni")
	private int intDNI;
	
	@ManyToOne
	@JoinColumn(name="iddistrito")
	private Distrito distritos = new Distrito();
	
	@Transient
	private Perfil perfil = new Perfil();
	
	@Transient
	private StreamedContent scImagen;
	
	@Column(name="foto",columnDefinition="MEDIUMBLOB")
	private byte[] fotobin;
	
	@OneToMany(targetEntity=Usuario.class,mappedBy="personas")
	private Collection<Usuario> tbUsuarios;
	
	@OneToOne(targetEntity=Apoderado.class,mappedBy="personas")
	private Collection<Apoderado> tbApoderados;

	@OneToOne(targetEntity=AsistenteCoordinacionAcademica.class,mappedBy="personas")
	private Collection<AsistenteCoordinacionAcademica> tbAsistenteCoordinacionAcademica;
	
	@OneToOne(targetEntity=AsistenteDireccionAcademica.class,mappedBy="personas")
	private Collection<AsistenteDireccionAcademica> tbAsistenteDireccionAcademica;
	
	public Persona(){
		
	}
	
	public int getIntDNI() {
		return intDNI;
	}

	public void setIntDNI(int intDNI) {
		this.intDNI = intDNI;
	}

	public Distrito getDistritos() {
		return distritos;
	}

	public void setDistritos(Distrito distritos) {
		this.distritos = distritos;
	}

	public String getStrCodigoPersona() {
		return strCodigoPersona;
	}

	public void setStrCodigoPersona(String strCodigoPersona) {
		this.strCodigoPersona = strCodigoPersona;
	}

	public String getStrNombre() {
		return strNombre;
	}

	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}

	public String getStrApellidoPaterno() {
		return strApellidoPaterno;
	}

	public void setStrApellidoPaterno(String strApellidoPaterno) {
		this.strApellidoPaterno = strApellidoPaterno;
	}

	public String getStrApellidoMaterno() {
		return strApellidoMaterno;
	}

	public void setStrApellidoMaterno(String strApellidoMaterno) {
		this.strApellidoMaterno = strApellidoMaterno;
	}

	public String getStrDireccion() {
		return strDireccion;
	}

	public void setStrDireccion(String strDireccion) {
		this.strDireccion = strDireccion;
	}

	public String getStrMail() {
		return strMail;
	}

	public void setStrMail(String strMail) {
		this.strMail = strMail;
	}

	public String getStrTelefono() {
		return strTelefono;
	}

	public void setStrTelefono(String strTelefono) {
		this.strTelefono = strTelefono;
	}

	public String getStrCelular() {
		return strCelular;
	}

	public void setStrCelular(String strCelular) {
		this.strCelular = strCelular;
	}

	public String getStrSexo() {
		return strSexo;
	}

	public void setStrSexo(String strSexo) {
		this.strSexo = strSexo;
	}

	public Collection<Usuario> getTbUsuarios() {
		return tbUsuarios;
	}


	public void setTbUsuarios(Collection<Usuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public Collection<Apoderado> getTbApoderados() {
		return tbApoderados;
	}

	public void setTbApoderados(Collection<Apoderado> tbApoderados) {
		this.tbApoderados = tbApoderados;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Collection<AsistenteCoordinacionAcademica> getTbAsistenteCoordinacionAcademica() {
		return tbAsistenteCoordinacionAcademica;
	}

	public void setTbAsistenteCoordinacionAcademica(
			Collection<AsistenteCoordinacionAcademica> tbAsistenteCoordinacionAcademica) {
		this.tbAsistenteCoordinacionAcademica = tbAsistenteCoordinacionAcademica;
	}

	public Collection<AsistenteDireccionAcademica> getTbAsistenteDireccionAcademica() {
		return tbAsistenteDireccionAcademica;
	}

	public void setTbAsistenteDireccionAcademica(
			Collection<AsistenteDireccionAcademica> tbAsistenteDireccionAcademica) {
		this.tbAsistenteDireccionAcademica = tbAsistenteDireccionAcademica;
	}

	public StreamedContent getScImagen() {
		return scImagen;
	}

	public void setScImagen(StreamedContent scImagen) {
		this.scImagen = scImagen;
	}

	public byte[] getFotobin() {
		return fotobin;
	}

	public void setFotobin(byte[] fotobin) {
		this.fotobin = fotobin;
	}
	
	
	
}