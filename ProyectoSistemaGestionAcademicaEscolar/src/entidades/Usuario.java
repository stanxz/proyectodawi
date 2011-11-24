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

	@ManyToOne
	@JoinColumn(name="codpersona")
	private Persona personas;
	
	@ManyToOne
	@JoinColumn(name="codperfil")
	private Perfil perfiles;
	
	public String getStrContrasena() {
		return strContrasena;
	}
	public void setStrContrasena(String strContrasena) {
		this.strContrasena = strContrasena;
	}
	/*
	public String getStrCodigoPerfil() {
		return strCodigoPerfil;
	}
	public void setStrCodigoPerfil(String strCodigoPerfil) {
		this.strCodigoPerfil = strCodigoPerfil;
	}
	*/
	/*
	public String getStrCodigoPersona() {
		return strCodigoPersona;
	}
	public void setStrCodigoPersona(String strCodigoPersona) {
		this.strCodigoPersona = strCodigoPersona;
	}
	*/
	public int getIntIdLogin() {
		return intIdLogin;
	}
	public void setIntIdLogin(int intIdLogin) {
		this.intIdLogin = intIdLogin;
	}
	
	public Perfil getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(Perfil perfiles) {
		this.perfiles = perfiles;
	}
	public Persona getPersonas() {
		return personas;
	}
	public void setPersonas(Persona personas) {
		this.personas = personas;
	}
	
}