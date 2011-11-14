package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlogin;

	private String contrasena;

	//bi-directional many-to-one association to Perfil
    @ManyToOne
	@JoinColumn(name="CODPERFIL")
	private Perfil perfil;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	@JoinColumn(name="CODPERSONA")
	private Persona persona;

    public Usuario() {
    }

	public int getIdlogin() {
		return this.idlogin;
	}

	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}