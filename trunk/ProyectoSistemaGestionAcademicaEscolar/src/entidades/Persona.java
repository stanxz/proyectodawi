package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	
	
}