package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codpersona;

	private String apellidomat;

	private String apellidopat;

	private String celular;

	private String direccion;

	private String email;

	private String nombres;

	private int sexo;

	private String telefono;

	//bi-directional one-to-one association to Apoderado
	@OneToOne(mappedBy="persona")
	private Apoderado apoderado;

	//bi-directional one-to-one association to Asistentasocial
	@OneToOne(mappedBy="persona")
	private Asistentasocial asistentasocial;

	//bi-directional one-to-one association to Secretaria
	@OneToOne(mappedBy="persona")
	private Secretaria secretaria;

    public Persona() {
    }

	public int getCodpersona() {
		return this.codpersona;
	}

	public void setCodpersona(int codpersona) {
		this.codpersona = codpersona;
	}

	public String getApellidomat() {
		return this.apellidomat;
	}

	public void setApellidomat(String apellidomat) {
		this.apellidomat = apellidomat;
	}

	public String getApellidopat() {
		return this.apellidopat;
	}

	public void setApellidopat(String apellidopat) {
		this.apellidopat = apellidopat;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getSexo() {
		return this.sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Apoderado getApoderado() {
		return this.apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}
	
	public Asistentasocial getAsistentasocial() {
		return this.asistentasocial;
	}

	public void setAsistentasocial(Asistentasocial asistentasocial) {
		this.asistentasocial = asistentasocial;
	}
	
	public Secretaria getSecretaria() {
		return this.secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}
	
}