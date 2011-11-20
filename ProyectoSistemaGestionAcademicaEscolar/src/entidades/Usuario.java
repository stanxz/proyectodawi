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
	private int idlogin;

	private String contrasena;


	private String codperfil;

	private String codpersona;

	public int getIdlogin() {
		return idlogin;
	}

	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCodperfil() {
		return codperfil;
	}

	public void setCodperfil(String codperfil) {
		this.codperfil = codperfil;
	}

	public String getCodpersona() {
		return codpersona;
	}

	public void setCodpersona(String codpersona) {
		this.codpersona = codpersona;
	}


	
}