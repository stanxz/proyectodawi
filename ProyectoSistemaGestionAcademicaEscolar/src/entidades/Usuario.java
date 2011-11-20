package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idlogin")
	private int intIdLogin;
	
	@Column(name="contrasena")
	private String strContrasena;
	
	@Column(name="codperfil")
	private String strCodigoPerfil;
	
	@Column(name="codpersona")
	private String strCodigoPersona;
	
	public String getStrContrasena() {
		return strContrasena;
	}
	public void setStrContrasena(String strContrasena) {
		this.strContrasena = strContrasena;
	}
	public String getStrCodigoPerfil() {
		return strCodigoPerfil;
	}
	public int getIntIdLogin() {
		return intIdLogin;
	}
	public void setIntIdLogin(int intIdLogin) {
		this.intIdLogin = intIdLogin;
	}
	public void setStrCodigoPerfil(String strCodigoPerfil) {
		this.strCodigoPerfil = strCodigoPerfil;
	}
	public String getStrCodigoPersona() {
		return strCodigoPersona;
	}
	public void setStrCodigoPersona(String strCodigoPersona) {
		this.strCodigoPersona = strCodigoPersona;
	}
	
}